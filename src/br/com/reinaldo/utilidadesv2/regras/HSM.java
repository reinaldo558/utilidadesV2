/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2.regras;

import br.com.reinaldo.utilidadesv2.constantes.Constantes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 *
 * @author desenv
 */
public class HSM {
    
    
    private static SocketChannel channel = null;
    private static final Charset charset = Charset.forName(Constantes.CHARSET);
    private static final CharsetDecoder decoder = charset.newDecoder();
    private static Socket requestSocket = null;
    private static final int MAX_BUFFER_MESSAGE = 256;
    
    public static String enviarComando(final String msg, final String ip, final String porta, final boolean isHsmDevice) {
        try {
            if (isHsmDevice) {
                return enviarMensagemHsmDevice(ip, Integer.parseInt(porta), msg);
            } else {
                return enviarMensagemHsmServer(ip, Integer.parseInt(porta), msg);
            }
        } catch (NumberFormatException nfe) {
            return "Erro ao tentar utilizar e Porta informada: " + nfe.getMessage();
        } catch (Exception ex) {
            return "Erro ao tentar enviar a mensagem: " + ex.getMessage();
        }
    }
    
    
    
    public static String enviarMensagemHsmServer(final String ip, final int porta, final String comando) throws Exception {
        String retorno;
        
        final InetSocketAddress host = new InetSocketAddress(ip, porta);
        requestSocket = new Socket();
        requestSocket.connect(host, 500);

        sendCommandToHsmServer(comando);
        retorno = readCommandFromHsmServer();

        requestSocket.close();
        
        if (retorno.contains(Constantes.LIXO_SOCKET)) {
            return retorno.substring(0, retorno.indexOf(Constantes.LIXO_SOCKET));
        } else {
            return retorno;
        }
    }
    
    
    public static String enviarMensagemHsmDevice(final String ip, final int porta, final String comando) throws Exception {
        String retorno;
        
        final InetSocketAddress host = new InetSocketAddress(ip, porta);
        channel = SocketChannel.open();
        channel.configureBlocking(true);
        channel.socket().connect(host, 500);

        sendCommandToHSMDevice(comando);
        retorno = readCommandFromHSMDevice();

        channel.close();
        
        return retorno;
    }
    
    
    
    private static void sendCommandToHsmServer(final String message) throws Exception {
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(requestSocket.getOutputStream()));
        out.write((message + Constantes.QUEBRA_LINHA).toCharArray());
        out.flush();
    }
    
    private static String readCommandFromHsmServer() throws Exception {
        final BufferedReader in  = new BufferedReader(new InputStreamReader(requestSocket.getInputStream()));
        final StringBuilder messageResponse = new StringBuilder();
        char [] cbuf = new char[MAX_BUFFER_MESSAGE];

        int caracter;
        for(int i = 0; i < MAX_BUFFER_MESSAGE; i++) {
             caracter = in.read();
             if(caracter == -1) {
                 break;
             }
             cbuf[i] = (char)caracter;
        }
        messageResponse.append(cbuf);
        return messageResponse.toString();
    }
    
    
    
    private static void sendCommandToHSMDevice(final String message) throws IOException {
        
        // Prepara commando para envio
        final byte[] bufferTmp = ("  " + message).getBytes(Constantes.CHARSET);
        bufferTmp[0] = (byte) (message.length() / MAX_BUFFER_MESSAGE);
        bufferTmp[1] = (byte) (message.length() % MAX_BUFFER_MESSAGE);
        final ByteBuffer buf = ByteBuffer.wrap(bufferTmp);
        
        // Send
        if(channel != null) {
            channel.write(buf);
        }
    }
    
    private static String readCommandFromHSMDevice() throws Exception {
        
        String retorno = null;
        final ByteBuffer buffer = ByteBuffer.allocate(MAX_BUFFER_MESSAGE);
        final CharBuffer charBuffer = CharBuffer.allocate(MAX_BUFFER_MESSAGE);
        
        if(channel != null && channel.isConnected() && channel.read(buffer) != -1) {
            final StringBuffer commandResponse = new StringBuffer(MAX_BUFFER_MESSAGE);
            buffer.flip();
            // Decode buffer
            decoder.decode(buffer, charBuffer, false);
            // Display
            charBuffer.flip();
            commandResponse.append(charBuffer);
            if(commandResponse.length() > 6) {
                retorno = commandResponse.substring(6);
            } else {
                retorno = commandResponse.toString();
            }
        }
        
        buffer.clear();
        charBuffer.clear();
        return retorno;
    }
    
    
    
}
