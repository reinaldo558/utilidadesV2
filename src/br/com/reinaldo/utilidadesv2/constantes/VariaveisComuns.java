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

        exemplos.put("[BA] EncriptarPin / Ver modo autorizado", "BA&1234&5224990000002791");
        exemplos.put("[NG] DecriptarPin / Ver modo autorizado", "NG&5224990000002791&41363");
        exemplos.put("[CW] Gerar CVC", "CW&MC&5324730000045005&1409&101");
        exemplos.put("[CY] Validar CVC", "CY&MC&806&5224990000002791&1703&999");
        exemplos.put("[BU] Criar checkvalue", "BU&1&UCB028932B26FBB5FDB345659C30A9F04&001");
        exemplos.put("[BE] Validar Pin", "BE&MC&E8477459C4A7A9C7&5224990000002791&69358");
        exemplos.put("[02] Contar trocas de chave, tecban", "02");
        exemplos.put("[99] Ver tags cadastradas para de55", "99&MC");
        exemplos.put("[A0] Criar chave (e cadastrar como temporaria)", "A0&TB&T");
        exemplos.put("[KQ] Validar ARQC", "KQ&MC&2012-06-31&1&5324740000015197&5F2A02098682025800950500000400009A031204229C01009F02060000000010009F10120110250000044000DAC100000000000000009F1A0200769F26086922116F04A923A99F2701809F360200A09F3704262669C1&000&0028");
        exemplos.put("[GM] Encryptar senha", "GM&01&ctlm1234");
        exemplos.put("[01] Activate Key", "01&MC");
        exemplos.put("[A6] Change Key", "01&MC&D45142DAD34071213BE76D61013A3B6D&CAD6A0");
        exemplos.put("[KU] Desbloqueio de chip / Troca de senha", "KU&MC&0&5224990000002791&86068424000000&0000");
        exemplos.put("[JE] Decripta senha de transporta para passHsm", "JE&TB&5224990000002791&12345");
        exemplos.put("[GM] Gera criptografia SHA1", "GM&01&1234");
        exemplos.put("[98] Ver/Atualizar lista de chaves na memoria", "98&1");

        return exemplos;
    }
    
}
