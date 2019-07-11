/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2.constantes;

import java.util.Random;

/**
 *
 * @author desenv
 */
public class Constantes {
    
    private Constantes() {}
    
    public static final int HTML = 0;
    public static final int HEXA = 1;
    public static final int UNICODE = 2;
    public static final int BIN = 3;
    public static final int NORMAL = 4;   
    
    public static final String VAZIO = "";
    
    public static final String SEPARADOR_SERVER = "&";
    public static final String SEPARADOR_DEVICE = "";
    public static final String QUEBRA_LINHA = "\n";
    public static final String CHARSET = "ISO-8859-1";
    public static final String LIXO_SOCKET = "\u0000";

    
    public static final Random RANDOM = new Random();
    
}
