/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author desenv
 */
public class ParseDE55 {
    
     //5F2A02084082025800950500000000009A031208089C01009F02060000000037009F10120110250000044000DAC100000000000000009F1A0200769F2608C01AA8D244B2F0609F2701809F360200109F37040F9B28C09F3403410302
    private static final Map<String, String> mapa = new HashMap<>();
    
    static {
        mapa.put("9F26", "9F26");mapa.put("9F27", "9F27");mapa.put("9F10", "9F10");mapa.put("9F37", "9F37");mapa.put("9F36", "9F36");mapa.put("95", "95");mapa.put("9A", "9A");
        mapa.put("9C", "9C");mapa.put("9F02", "9F02");mapa.put("5F2A", "5F2A");mapa.put("82", "82");mapa.put("9F1A", "9F1A");mapa.put("9F34", "9F34");mapa.put("9F33", "9F33");
        mapa.put("9F1E", "9F1E");mapa.put("9F53", "9F53");mapa.put("84", "84");mapa.put("9F09", "9F09");mapa.put("9F41", "9F41");mapa.put("9F03", "9F03");
        mapa.put("91", "91");mapa.put("71", "71");mapa.put("72", "72");mapa.put("9F35", "9F35");mapa.put("9F45", "9F45");mapa.put("5F34", "5F34");mapa.put("9A03", "9A03");
    }
    
    private ParseDE55() {}
    
    /**
     * Realiza o "parse" da DE55 informada no parametro<br/>
     * Informar, por exemplo: "5F2A02098682025800950500000000009A03121101..."<br/>
     * Será retornado (com quebra de linha): <br/>
     * 5F2A - 02 - 098682025800<br/>
     * 95 - 05 - 0000000000<br/>
     * 9A - 03 - 121101<br/>
     * ...
     * <br/><br/>
     * @param de55
     * @return 
     */
    public static final String parseDe55(final String de55) {
        final StringBuilder sb = new StringBuilder();
        
        int posAtual = 0;
        boolean temTag = false;
        String tagAtual;
        
        while (posAtual + 4 < de55.length()) {
            //Pega a proxima tag da DE informada
            tagAtual = de55.substring(posAtual, posAtual + 2);
            if (mapa.containsKey(tagAtual)) {
                temTag = true;
            } else {
                tagAtual = de55.substring(posAtual, posAtual + 4);
                if (mapa.containsKey(tagAtual)) {
                    temTag = true;
                }
            }
            posAtual += tagAtual.length();
            
            //Apenas se a proxima tag for encontrada
            if (temTag) {
                try {
                    final String tamanhoTagStr = de55.substring(posAtual, posAtual + 2);
                    final int tamanhoTag = Integer.valueOf(tamanhoTagStr, 16);
                    posAtual += 2;
                    final String valor = de55.substring(posAtual, posAtual + (tamanhoTag * 2));
                    posAtual += valor.length();

                    sb.append(tagAtual);
                    sb.append(" - ");
                    sb.append(tamanhoTagStr);
                    sb.append(" - ");
                    sb.append(valor);
                    sb.append("\n");
                } catch (Exception ex) {
                    sb.append("Tag ");
                    sb.append(tagAtual);
                    sb.append(" nao encontrada e/ou erro no parse, verificar tamanho das tags anteriores (em hexa) ou se elas sao esperadas pelo hsm existem. Se ");
                }
            
            } else {
                sb.append("Tag ");
                sb.append(tagAtual);
                sb.append(" nao encontrada e/ou erro no parse, verificar tamanho das tags anteriores (em hexa) ou se elas sao esperadas pelo hsm existem.");
            }
            
        }
        
       
        return sb.toString();
    }
    
    
    /*public static void main(String[] x) {
        System.out.print(parseDe55("5F2A02098682025800950500000000009A031211019C01009F02060000000031009F10120110250000044000DAC100000000000000009F1A0200769F260807E618F31DAC96BE9F2701809F360200049F370422239E809F3403410302")); 
    }*/
}
