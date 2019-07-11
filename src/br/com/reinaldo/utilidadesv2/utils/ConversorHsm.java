/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2.utils;

import br.com.reinaldo.utilidadesv2.constantes.Constantes;

/**
 *
 * @author desenv
 */
public class ConversorHsm {
    
    
    /**
     * Converte uma string de binario informada no parametro para seu equivalente em hexadecimal
     * @param byteString
     * @return 
     */
    public static byte[] parseHexString(final String byteString) {
        final byte[] result = new byte[byteString.length()/2];
        final int size = byteString.length();
        for (int i=0; i < size; i+=2) {
            final String toParse = byteString.substring(i, i+2);
            result[i/2] = (byte) Integer.parseInt(toParse, 16);
        }
        return result;
    }
    
    /**
     * Converte a string informada no parametro para seus equivalentes em Binario
     * @param param
     * @return 
     */
    public static String stringByteConsole(final String param) {
        String retorno = Constantes.VAZIO;
        for (int i = 0; i < param.length(); i++) {
            final String atual = param.substring(i, i+1);
            final byte[] b = atual.getBytes();
            String temp = Integer.toHexString(b[0]);
            if (temp.length()>6) {
                if ("ffffff".equalsIgnoreCase(temp.substring(0,6))) {
                    temp = temp.substring(6);
                }
            }
            retorno += (temp+" ");
        }
        return retorno.toUpperCase();
    }
    
    /**
     * Converte a string informada no parametro para seus equivalentes em Binario
     * @param param
     * @return 
     */
    public static String stringByte(final String param) {
        String retorno = Constantes.VAZIO;
        for (int i = 0; i < param.length(); i++) {
            final String atual = param.substring(i, i+1);
            final byte[] b = atual.getBytes();
            String temp = Integer.toHexString(b[0]);
            if (temp.length()>6) {
                if ("ffffff".equalsIgnoreCase(temp.substring(0,6))) {
                    temp = temp.substring(6);
                }
            }
            retorno += temp;
        }
        return retorno.toUpperCase();
    }
    
    /**
     * Completa a string de hexadecimais informada no parametro para ateh 8 posicoes
     * Utilizado para comunicacao com HSM
     * @param atual
     * @return 
     */
    public static String completarHex(final String atual) {
        final StringBuilder novo = new StringBuilder(" ");
        int restantes = 8 - atual.length();
        for (int i = 0; i < restantes; i++) {
            novo.append("0");
        }
        novo.append(atual);
        return novo.toString();
    }
    
    /**
     * Dado um texto completo, substitui um trecho que foi selecionado por outro
     * Utilizado para funcoes no sinwg, onde um texto selecionado sera substituido 
     * por seu equivalente em outro tipo de codificacao
     * 
     * @param completo Texto completo (Ex: "Este eh um texto completo")
     * @param selecionado texto que foi selecionado e sera removido (Ex: "h um tex")
     * @param novo Texto que sera inserido (Ex: "XXXXXX")
     * @return Novo texto completo com o trecho selecionado substituido (Ex: "Este eXXXXXXto completo")
     */
    public static String replace(final String completo, final String selecionado, final String novo) {
        final int posInicial = completo.indexOf(selecionado);
        final int posFinal = posInicial + selecionado.length();
        final StringBuilder sb = new StringBuilder(completo.length());
        sb.append(completo.substring(0, posInicial));
        sb.append(novo);
        sb.append(completo.substring(posFinal));
        return sb.toString();
    }
    
    
}
