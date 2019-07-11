/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2.utils;

import br.com.reinaldo.utilidadesv2.Inicio;
import br.com.reinaldo.utilidadesv2.entidades.MaquinaEntity;
import java.awt.Desktop;
import java.io.File;
import java.net.URI;

/**
 *
 * @author desenv
 */
public class TerminalUtil {
    
    public static final void executarTerminal(final MaquinaEntity maquina) throws Exception {
        if (maquina.getTipoTerminal() == MaquinaEntity.TIPO_TERMINAL_NAVEGADOR) {
            abrirNavegador(maquina);
        } else if (maquina.getTipoTerminal() == MaquinaEntity.TIPO_TERMINAL_SHELL) {
            abrirShell(maquina);
        } else if (maquina.getTipoTerminal() == MaquinaEntity.TIPO_TERMINAL_PERSONALIZADO) {
            abrirPersonalizado(maquina);
        } else {
            abrirPutty(maquina);
        }
    }
    
    
    private static void abrirPutty(final MaquinaEntity maquina) throws Exception {
        String strNomeMaquina;
        if (maquina.getDominio() != null && !"".equals(maquina.getDominio()) && !"".equals(maquina.getDominio().trim())) {
            strNomeMaquina = maquina.getDominio();
        } else if (maquina.getIp() != null && !"".equals(maquina.getIp()) && !"".equals(maquina.getIp().trim())) {
            strNomeMaquina = maquina.getIp();
        } else {
            strNomeMaquina = maquina.getNome();
        }
        
        final String putty = getPuttyJarLocation();
        
        //String.format("cmd.exe /c start putty -load \"%s\" -l \"%s\"  -pw \"%s\"", maquina.getNome(), maquina.getUsuario(), maquina.getSenhaAberta())
        final String comando = "cmd.exe /c start "+putty+" -ssh %s@%s -pw %s";
        
        Runtime.getRuntime().exec(String.format(comando, maquina.getUsuario(), strNomeMaquina, maquina.getSenhaAberta()));
    }
    
    public static String getPuttyJarLocation() {
        String path = "";
        try {
            final File f = new File(Inicio.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
            String pathTmp = f.getAbsolutePath();
            String separador = System.getProperty("file.separator");
            path = pathTmp.substring(0, pathTmp.lastIndexOf(separador)) + separador + "putty.exe";
        } catch (Exception ex) {
            System.out.println("Erro ["+ex.getMessage()+"] ao buscar onde esta o putty");
        }
        if (path == null || "".equals(path) || "".equals(path.trim())) {
            return "putty";
        }
        return path;
    }
    
    private static void abrirShell(final MaquinaEntity maquina) throws Exception {
        
        String strNomeMaquina;
        if (maquina.getDominio() != null && !"".equals(maquina.getDominio()) && !"".equals(maquina.getDominio().trim())) {
            strNomeMaquina = maquina.getDominio();
        } else if (maquina.getIp() != null && !"".equals(maquina.getIp()) && !"".equals(maquina.getIp().trim())) {
            strNomeMaquina = maquina.getIp();
        } else {
            strNomeMaquina = maquina.getNome();
        }
        
        String comando = String.format("xterm -e ssh %s@%s", maquina.getUsuario(), strNomeMaquina);
        System.out.println("Tentando abrir Shell: [" + comando + "]");
        
        Runtime.getRuntime().exec(comando);
        AcoesComuns.copiarParaAreaTransferencia(maquina.getSenhaAberta());
    }
    
    private static void abrirNavegador(final MaquinaEntity maquina) throws Exception {
        System.out.println("Tentando abrir navegador para ["+maquina.getUrl()+"]");
        if(Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI(maquina.getUrl()));
        }
    }
    
    /**
     * %PWD%
     * %USR%
     * %SSN%
     * @param maquina
     * @throws Exception 
     */
    private static void abrirPersonalizado(final MaquinaEntity maquina) throws Exception {
        String comando = maquina.getComandoPersonalizado().replaceAll("%USR%", maquina.getUsuario()).replaceAll("%PWD%", maquina.getSenhaAberta());
        if (maquina.getDominio() != null && !"".equals(maquina.getDominio()) && !"".equals(maquina.getDominio().trim())) {
            comando = comando.replaceAll("%SSN%", maquina.getDominio());
        } else if (maquina.getIp() != null && !"".equals(maquina.getIp()) && !"".equals(maquina.getIp().trim())) {
            comando = comando.replaceAll("%SSN%", maquina.getIp());
        } else {
            comando = comando.replaceAll("%SSN%", maquina.getNome());
        }
        
        Runtime.getRuntime().exec(comando);
        if (!maquina.getComandoPersonalizado().contains("%PWD%")) {
            AcoesComuns.copiarParaAreaTransferencia(maquina.getSenhaAberta());
        }
    }
    
    
}
