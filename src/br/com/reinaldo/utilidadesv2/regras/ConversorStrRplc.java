/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2.regras;

import br.com.reinaldo.utilidadesv2.constantes.Constantes;
import br.com.reinaldo.utilidadesv2.constantes.Mapas;
import java.util.Map;

/**
 *
 * @author desenv
 */
public class ConversorStrRplc {
    
    private static Map<String, String> mapaStringHtml;
    private static Map<String, String> mapaHtmlString;
    private static Map<String, String> mapaStringUnicode;
    private static Map<String, String> mapaUnicodeString;
    private static Map<String, String> mapaStringHexa;
    private static Map<String, String> mapaHexaString;
    
    private ConversorStrRplc() {
        criarMapas();
    }
    
    
    public static String converter(final int origem, final int destino, final String texto) {
        criarMapas();
        String novaString = texto;
        
        if (destino == Constantes.BIN) {
            return new String(parseHexString(novaString));
        }
        if (origem == Constantes.BIN) {
            return stringByte(novaString);
        }
        
        
        /** - Transforma todas as origens em texto normal, acentuado **/
        if (origem == Constantes.HTML) {
            novaString = converterPorChave(mapaHtmlString, novaString);
        } else if (origem == Constantes.UNICODE) {
            novaString = converterPorChaveUnicode(mapaUnicodeString, novaString);
        } else if (origem == Constantes.HEXA && destino != Constantes.BIN) {
            novaString = converterDeHexa(mapaHexaString, novaString);
        } 
        
        /** - Transforma os textos normais em textos codificados - **/
        if (destino == Constantes.HTML) {
            novaString = converterCaractere(mapaStringHtml, novaString);
        } else if (destino == Constantes.UNICODE) {
            novaString = converterCaractere(mapaStringUnicode, novaString);
        } else if (destino == Constantes.HEXA && origem != Constantes.BIN) {
            novaString = converterCaractere(mapaStringHexa, novaString);
        } 
        return novaString;
    }
    
    private static byte[] parseHexString(final String byteString) {
        byte[] result = new byte[byteString.length()/2];
        final int size = byteString.length();
        for (int i=0; i < size; i+=2) {
            final String toParse = byteString.substring(i, i+2);
            result[i/2] = (byte) Integer.parseInt(toParse, 16);
        }
        return result;
    }
    
    private static String converterDeHexa(final Map<String, String> mapa, final String old) {
        final StringBuilder sb = new StringBuilder();
        int x = 0;
        while (x < old.length()) {
            final String tmp = old.substring(x++, ++x);
            if (mapa.containsKey(tmp.toUpperCase())) {
                sb.append(mapa.get(tmp));
            } else {
                sb.append(tmp);
            }
        }
        return sb.toString();
    }
    
    private static String converterCaractere(final Map<String, String> mapa, final String old) {
        final StringBuilder novaString = new StringBuilder();
        for (int i = 0; i < old.length(); i++) {
            final String atual = String.valueOf(old.charAt(i));
            if (mapa.containsKey(atual)) {
                novaString.append(mapa.get(atual));
            } else {
                novaString.append(atual);
            }
        }
        return novaString.toString();
    }
    
    private static String stringByte(final String param) {
        String retorno = "";
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
    
    private static String converterPorChave(final Map<String, String> mapa, final String old) {
        String novaString = old;
        final String[] chaves = (String[]) mapa.keySet().toArray(new String[0]);
        for (String atual : chaves) {
            if (novaString.contains(atual)) {
                novaString = novaString.replaceAll(atual, (String) mapa.get(atual));
            }
        }
        return novaString;
    }
    
    private static String converterPorChaveUnicode(final Map<String, String> mapa, final String old) {
        String novaString = old;
        String[] chaves = (String[]) mapa.keySet().toArray(new String[0]);
        for (String atual : chaves) {
            if (novaString.contains(atual)) {
                novaString = novaString.replaceAll("\\"+atual, (String) mapa.get(atual));
            }
        }
        return novaString;
    }
    
    private static void criarMapas() {
        if (mapaStringHtml == null) {
            mapaStringHtml = Mapas.criarMapaStringHtml();
        }
        if (mapaHtmlString == null) {
            mapaHtmlString = Mapas.criarMapaHtmlString();
        }
        if (mapaStringUnicode == null) {
            mapaStringUnicode = Mapas.criarMapaStringUnicode();
        }
        if (mapaUnicodeString == null) {
            mapaUnicodeString = Mapas.criarMapaUnicodeString();
        }
        if (mapaStringHexa == null) {
            mapaStringHexa = Mapas.criarMapaStringHexa();
        }
        if (mapaHexaString == null) {
            mapaHexaString = Mapas.criarMapaHexaString();
        }
    }
    
}
