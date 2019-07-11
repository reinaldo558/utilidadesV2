/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2.regras;

import br.com.reinaldo.utilidadesv2.constantes.VariaveisComuns;
import br.com.reinaldo.utilidadesv2.entidades.CopiarEntity;
import br.com.reinaldo.utilidadesv2.entidades.LogProdEntity;
import br.com.reinaldo.utilidadesv2.entidades.MaquinaEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author desenv
 */
public class Copiar {
    
    public static void copiar(final JTextArea destinoLog, final CopiarEntity entity, final File dirDestino, final int qtDias) {
        final List<MaquinaEntity> mweb = getMaquinasWeb();
        final List<MaquinaEntity> maut = getMaquinasAut();
        
        if (entity.isWebCatalina()) {
            destinoLog.append("iniciando copia de arquivos \"catalina\"\n");
            final LogProdEntity log = new LogProdEntity(LogProdEntity.TIPO_WEB_CATALINA, qtDias);
            mweb.stream().forEach((m) -> {
                copiar(m, log.getArquivos(), dirDestino, destinoLog);
            });
        }
        
        if (entity.isWebLocalhost()) {
            destinoLog.append("iniciando copia de arquivos \"localhost\"\n");
            final LogProdEntity log = new LogProdEntity(LogProdEntity.TIPO_WEB_LOCALHOST, qtDias);
            mweb.stream().forEach((m) -> {
                copiar(m, log.getArquivos(), dirDestino, destinoLog);
            });
        }
        
        if (entity.isWebLocalhostAccess()) {
            destinoLog.append("iniciando copia de arquivos \"localhost-access\"\n");
            final LogProdEntity log = new LogProdEntity(LogProdEntity.TIPO_WEB_LOCALHOSTACCESS, qtDias);
            mweb.stream().forEach((m) -> {
                copiar(m, log.getArquivos(), dirDestino, destinoLog);
            });
        }
        
        if (entity.isWebAbertura()) {
            destinoLog.append("iniciando copia de arquivos \"abertura\"\n");
            final LogProdEntity log = new LogProdEntity(LogProdEntity.TIPO_WEB_ABERTURA, qtDias);
            mweb.stream().forEach((m) -> {
                copiar(m, log.getArquivos(), dirDestino, destinoLog);
            });
        }
        
        if (entity.isWebTelematica()) {
            destinoLog.append("iniciando copia de arquivos \"telematica\"\n");
            final LogProdEntity log = new LogProdEntity(LogProdEntity.TIPO_WEB_TELEMATICA, qtDias);
            mweb.stream().forEach((m) -> {
                copiar(m, log.getArquivos(), dirDestino, destinoLog);
            });
        }
        
        if (entity.isWebWscetelem()) {
            destinoLog.append("iniciando copia de arquivos \"wscetelem\"\n");
            final LogProdEntity log = new LogProdEntity(LogProdEntity.TIPO_WEB_WSCETELEM, qtDias);
            mweb.stream().forEach((m) -> {
                copiar(m, log.getArquivos(), dirDestino, destinoLog);
            });
        }
        
        if (entity.isWebWstelem()) {
            destinoLog.append("iniciando copia de arquivos \"wstelem\"\n");
            final LogProdEntity log = new LogProdEntity(LogProdEntity.TIPO_WEB_WSTELEM, qtDias);
            mweb.stream().forEach((m) -> {
                copiar(m, log.getArquivos(), dirDestino, destinoLog);
            });
        }
        
        if (entity.isWebDoitClient()) {
            destinoLog.append("iniciando copia de arquivos \"doit-client\"\n");
            final LogProdEntity log = new LogProdEntity(LogProdEntity.TIPO_WEB_DOITCLIENT, qtDias);
            mweb.stream().forEach((m) -> {
                copiar(m, log.getArquivos(), dirDestino, destinoLog);
            });
        }
        
        if (entity.isWebSmsCyber()) {
            destinoLog.append("iniciando copia de arquivos \"sms/cyber\"\n");
            final LogProdEntity log = new LogProdEntity(LogProdEntity.TIPO_WEB_SMSCYBER, qtDias);
            mweb.stream().forEach((m) -> {
                copiar(m, log.getArquivos(), dirDestino, destinoLog);
            });
        }
        
        
    }   
    
    
    /*  Destino = destino + maquina + pathRemoto
        Ex: Destino = /tmp
            Copiar catalina.out
            Path local final:
                /tmp/spos3078/logs/tomcat01/
                /tmp/spos3078/logs/tomcat02/
                /tmp/spos3141/logs/tomcat01/
                /tmp/spos3141/logs/tomcat02/
                etc    */
    private static void copiar(final MaquinaEntity maquina, final List<String> listaArquivos, final File destino, final JTextArea destinoLog) {
        final String pathLocal = destino.getAbsolutePath() + "/" + maquina.getNome();
        
        for (String atual : listaArquivos) {
            destinoLog.append("Copiando ["+maquina.getNome()+":"+atual+"]");
            try {
                final String pathLocalFinal = pathLocal + "/" + atual.substring(0, atual.lastIndexOf("/"));
                final File dirDestino = new File(pathLocalFinal);
                dirDestino.mkdirs();
                
                // ############################################
                // TODO: Chamar a copia aqui, para "dirDestino"
                // ############################################
                
                destinoLog.append("OK para ["+dirDestino.getAbsolutePath()+"] \n");
            } catch (Exception ex) {
                destinoLog.append("ERRO ["+ex.getMessage()+"]");
            }
        }
        
        
    }
    
    
    private static List<MaquinaEntity> getMaquinasWeb() {
        final List<MaquinaEntity> m = new ArrayList<>();
        
        m.add(VariaveisComuns.MAQUINAS_TODAS.get("spos3078"));
        m.add(VariaveisComuns.MAQUINAS_TODAS.get("spos3141"));
        m.add(VariaveisComuns.MAQUINAS_TODAS.get("spos3171"));
        m.add(VariaveisComuns.MAQUINAS_TODAS.get("spos3174"));
            
        return m;
    }
    
    private static List<MaquinaEntity> getMaquinasAut() {
        final List<MaquinaEntity> m = new ArrayList<>();
        
        m.add(VariaveisComuns.MAQUINAS_TODAS.get("spos3088"));
        m.add(VariaveisComuns.MAQUINAS_TODAS.get("spos3089"));
            
        return m;
    }
    
}
