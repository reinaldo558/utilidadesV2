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
    
    private static final Map<String, String> mapa = new HashMap<>();
    
    static {
        
    }
    
    private ParseDE55() {}
    
    /**
     * 
     */
    public static final String parseDe55(final String de55) {
        final StringBuilder sb = new StringBuilder();
        
        int posAtual = 0;
        boolean temTag = false;
        String tagAtual;
        
		// removed, may contain sensitive information
       
        return sb.toString();
    }
    
    
    /*public static void main(String[] x) {
        System.out.print(parseDe55("")); 
    }*/
}
