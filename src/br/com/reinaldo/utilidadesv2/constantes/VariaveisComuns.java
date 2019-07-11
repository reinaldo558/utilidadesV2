/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2.constantes;

import br.com.reinaldo.utilidadesv2.entidades.MaquinaEntity;
import br.com.reinaldo.utilidadesv2.view.FramePrincipal;
import java.awt.SystemTray;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 *
 * @author desenv
 */
public class VariaveisComuns {
    
    /** Timezone brasileiro */
    public static final TimeZone TIMEZONE = TimeZone.getTimeZone("GMT-3:00");
    /** Locale brasileiro */
    public static final Locale LOCALE = new Locale("pt", "BR");
    /** Formato que sera utilizado para receber e tratar a data prometida */
    public static final SimpleDateFormat SDFORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    /** Path + nome do arquivo de properties  */
    public static final String PATH_PROPERTIES = "utilidadesV2.properties";
    /** Objeto de controle e gerenciamento da area de notificacao do windows*/
    public static final SystemTray systemTray = SystemTray.getSystemTray();
    /** Mapa para gerenciamento das maquinas que serao exibidas no objeto JTree na Janela/Swing */
    public static final Map<String, List<MaquinaEntity>> MAQUINAS = new HashMap<>();
    /** Mapa para facilitar as buscas quando uma maquina eh selecionada */
    public static final Map<String, MaquinaEntity> MAQUINAS_TODAS = new HashMap<>();
    /** Variavel de apoio, utilizada para deixar em memoria a senha de acesso do aplicativo */
    public static String SENHA_APP = "";
    /** Variavel de apoio, utilizada para deixar em memoria o hash que controlara o algoritmo de criptografia */
    public static String HASH = "";
    /** Hash inicial que servira para criar um hash aleatorio, unico para o usuario */
    public static final String ALPHANUM = "0123456789aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789";
    /** Variavel de apoio, utilizado para deixar em memoria a senha aberta completa da maquina selecionada atualmente */
    public static String SENHA_SELECIONADA_COMPLETA = "...";
    /** Variavel de apoio, utilizada para deixar em memoria a senha aberta reduzida da maquina selecionada atualmente */
    public static String SENHA_SELECIONADA_ABREVIADA = "...";
    /** Variavel de apoio, utilizada para deixar em memoria o nome do servidor selecionado atualmente */
    public static String NOME_MAQUINA_SELECIONADA = "";
    /** Controla se pede ou nao uma senha ao abrir a janela do programa */
    public static boolean BLOQUEIO_COM_SENHA = true;
    /** Janela */
    public static FramePrincipal JANELA_PRINCIPAL;
    
    public static String HSM_CVC_IP = "";
    public static String HSM_CVC_PORTA = "";
    public static List<String> HISTORICO_DIRECT = new ArrayList<>();
    public static Map<String, String> EXEMPLOS_DIRECT = getExemplos();
    
    private static Map<String, String> getExemplos() {
        final Map<String, String> exemplos = new HashMap<>();

        // removed, may contain sensible information
		
        return exemplos;
    }
    
}
