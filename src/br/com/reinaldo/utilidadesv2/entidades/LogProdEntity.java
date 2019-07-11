/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2.entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author desenv
 */
public class LogProdEntity {
    
    public static final int TIPO_WEB_CATALINA = 1;
    public static final int TIPO_WEB_LOCALHOST = 2;
    public static final int TIPO_WEB_LOCALHOSTACCESS = 3;
    public static final int TIPO_WEB_DOITCLIENT = 4;
    public static final int TIPO_WEB_ABERTURA = 5;
    public static final int TIPO_WEB_TELEMATICA = 6;
    public static final int TIPO_WEB_WSCETELEM = 7;
    public static final int TIPO_WEB_WSTELEM = 8;
    public static final int TIPO_WEB_SMSCYBER = 9;
    public static final int TIPO_AUT_MASTER1 = 10;
    public static final int TIPO_AUT_MASTER2 = 11;
    public static final int TIPO_AUT_MASTER3 = 12;
    public static final int TIPO_AUT_MASTER4 = 13;
    public static final int TIPO_AUT_AURA = 14;
    public static final int TIPO_AUT_TECBAN = 15;
    public static final int TIPO_AUT_ITAUTEC = 16;
    
    private List<String> arquivos = new ArrayList<>();
    
    public LogProdEntity() {}
    
    public LogProdEntity(final int tipo, final int qtDias) {
        build(tipo, qtDias);
    }
    
    private void build(final int tipo, final int qtDias) {
        final Calendar cal = Calendar.getInstance();
        
        switch (tipo) {
            case TIPO_WEB_CATALINA:
                criarLog_webCatalina(cal, qtDias);
                break;
            case TIPO_WEB_LOCALHOST:
                criarLog_webLocalhost(cal, qtDias);
                break;
            case TIPO_WEB_LOCALHOSTACCESS:
                criarLog_webLocalhostAccess(cal, qtDias);
                break;
            case TIPO_WEB_DOITCLIENT:
                criarLog_webDoitClient(cal, qtDias);
                break;
            case TIPO_WEB_ABERTURA:
                criarLog_webAbertura(cal, qtDias);
                break;
            case TIPO_WEB_TELEMATICA:
                criarLog_webTelematica(cal, qtDias);
                break;
            case TIPO_WEB_WSCETELEM:
                criarLog_webWscetelem(cal, qtDias);
                break;
            case TIPO_WEB_WSTELEM:
                criarLog_webWstelem(cal, qtDias);
                break;
            case TIPO_WEB_SMSCYBER:
                criarLog_webSmsCyber(cal, qtDias);
                break;
            case TIPO_AUT_MASTER1:
                break;
            case TIPO_AUT_MASTER2:
                break;
            case TIPO_AUT_MASTER3:
                break;
            case TIPO_AUT_MASTER4:
                break;
            case TIPO_AUT_AURA:
                break;
            case TIPO_AUT_TECBAN:
                break;
            case TIPO_AUT_ITAUTEC:
                break;
        }
    }
    
    
    private void criarLog_webCatalina(final Calendar cal, final int qtDias) {
        arquivos.add("/logs/tomcat01/catalina.out");
        arquivos.add("/logs/tomcat02/catalina.out");
        
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                arquivos.add("/logs/tomcat01/catalina."+anoMesDia(cal)+".*");
                arquivos.add("/logs/tomcat02/catalina."+anoMesDia(cal)+".*");
            }
        }
        
    }

    private void criarLog_webLocalhost(final Calendar cal, final int qtDias) {
        arquivos.add("/logs/tomcat01/localhost."+anoMesDia(cal)+".log");
        arquivos.add("/logs/tomcat02/localhost."+anoMesDia(cal)+".log");
        
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                arquivos.add("/logs/tomcat01/localhost."+anoMesDia(cal)+".*");
                arquivos.add("/logs/tomcat02/localhost."+anoMesDia(cal)+".*");
            }
        }
    }

    private void criarLog_webLocalhostAccess(final Calendar cal, final int qtDias) {
        arquivos.add("/logs/tomcat01/localhost_access_log."+anoMesDia(cal)+".txt");
        arquivos.add("/logs/tomcat02/localhost_access_log."+anoMesDia(cal)+".txt");
        
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                arquivos.add("/logs/tomcat01/localhost_access_log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/tomcat02/localhost_access_log."+anoMesDia(cal)+".*");
            }
        }
        
    }

    private void criarLog_webDoitClient(final Calendar cal, final int qtDias) {
        arquivos.add("/logs/app/doit-client/doit-client-messages.log");
        arquivos.add("/logs/app/doit-client/doit-client-to-server-messages.log");
        
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);                
                arquivos.add("/logs/app/doit-client/doit-client-messages.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/doit-client/doit-client-to-server-messages.log."+anoMesDia(cal)+".*");
            }
        }
    }

    private void criarLog_webAbertura(final Calendar cal, final int qtDias) {
        arquivos.add("/logs/app/tomcat01/abertura/abertura.log");
        arquivos.add("/logs/app/tomcat01/abertura/registerCrediary.log");
        arquivos.add("/logs/app/tomcat01/abertura/aberturaTraf.log");
        arquivos.add("/logs/app/tomcat01/abertura/registerInternetExpressPlus.log");
        arquivos.add("/logs/app/tomcat01/abertura/registerElegibilidade.log");
        arquivos.add("/logs/app/tomcat02/abertura/abertura.log");
        arquivos.add("/logs/app/tomcat02/abertura/registerCrediary.log");
        arquivos.add("/logs/app/tomcat02/abertura/aberturaTraf.log");
        arquivos.add("/logs/app/tomcat02/abertura/registerInternetExpressPlus.log");
        arquivos.add("/logs/app/tomcat02/abertura/registerElegibilidade.log");
                
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);                
                arquivos.add("/logs/app/tomcat01/abertura/abertura.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/abertura/registerInternetExpressPlus.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/abertura/aberturaTraf.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/abertura/registerCrediary.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/abertura/registerElegibilidade.log."+anoMesDia(cal)+".*");                
                arquivos.add("/logs/app/tomcat02/abertura/abertura.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/abertura/registerInternetExpressPlus.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/abertura/aberturaTraf.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/abertura/registerCrediary.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/abertura/registerElegibilidade.log."+anoMesDia(cal)+".*");
            }
        }
    }

    private void criarLog_webTelematica(final Calendar cal, final int qtDias) {
        arquivos.add("/logs/app/tomcat01/cetelem/telematica-soap-message.log");
        arquivos.add("/logs/app/tomcat01/cetelem/log4jroot");
        arquivos.add("/logs/app/tomcat01/cetelem/integration");
        arquivos.add("/logs/app/tomcat01/cetelem/business");
        arquivos.add("/logs/app/tomcat01/cetelem/presentation");        
        arquivos.add("/logs/app/tomcat02/cetelem/telematica-soap-message.log");
        arquivos.add("/logs/app/tomcat02/cetelem/log4jroot");
        arquivos.add("/logs/app/tomcat02/cetelem/integration");
        arquivos.add("/logs/app/tomcat02/cetelem/business");
        arquivos.add("/logs/app/tomcat02/cetelem/presentation");

        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);                
                arquivos.add("/logs/app/tomcat01/cetelem/integration."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/cetelem/presentation."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/cetelem/business."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/cetelem/telematica-soap-message.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/cetelem/log4jroot."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/cetelem/integration."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/cetelem/presentation."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/cetelem/business."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/cetelem/telematica-soap-message.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/cetelem/log4jroot."+anoMesDia(cal)+".*");                
            }
        }
    }

    private void criarLog_webWscetelem(final Calendar cal, final int qtDias) {
        arquivos.add("/logs/app/tomcat01/wscetelem/wscetelem.log");
        arquivos.add("/logs/app/tomcat01/wscetelem/wscetelemTraf.log");    
        arquivos.add("/logs/app/tomcat02/wscetelem/wscetelem.log");
        arquivos.add("/logs/app/tomcat02/wscetelem/wscetelemTraf.log");
        
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                arquivos.add("/logs/app/tomcat01/wscetelem/wscetelemTraf.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/wscetelem/wscetelem.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/wscetelem/wscetelemTraf.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/wscetelem/wscetelem.log."+anoMesDia(cal)+".*");
            }
        }
    }

    private void criarLog_webWstelem(final Calendar cal, final int qtDias) {
        arquivos.add("/logs/app/tomcat01/wstelem/wstelem-soap-message.log");
        arquivos.add("/logs/app/tomcat01/wstelem/wstelem-root-logger.log");
        arquivos.add("/logs/app/tomcat01/wstelem/generate-billet.log");
        arquivos.add("/logs/app/tomcat02/wstelem/wstelem-soap-message.log");
        arquivos.add("/logs/app/tomcat02/wstelem/wstelem-root-logger.log");
        arquivos.add("/logs/app/tomcat02/wstelem/generate-billet.log");
        
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                arquivos.add("/logs/app/tomcat01/wstelem/wstelem-root-logger.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/wstelem/wstelem-soap-message.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/wstelem/generate-billet.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/wstelem/wstelem-root-logger.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/wstelem/wstelem-soap-message.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/wstelem/generate-billet.log."+anoMesDia(cal)+".*");
            }
        }
    }

    private void criarLog_webSmsCyber(final Calendar cal, final int qtDias) {
        arquivos.add("/logs/app/tomcat01/sms/cyber-boleto");
        arquivos.add("/logs/app/tomcat02/sms/cyber-boleto");
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                arquivos.add("/logs/app/tomcat01/sms/cyber-boleto."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/sms/cyber-boleto."+anoMesDia(cal)+".*");
            }
        }
    }

    private void criarLog_autMaster1(final Calendar cal, final int qtDias) {
        
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                
                
            }
        }
    }

    private void criarLog_autMaster2(final Calendar cal, final int qtDias) {
        
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                
                
            }
        }
    }

    private void criarLog_autMaster3(final Calendar cal, final int qtDias) {
        
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                
                
            }
        }
    }

    private void criarLog_autMaster4(final Calendar cal, final int qtDias) {
        
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                
                
            }
        }
    }

    private void criarLog_autAura(final Calendar cal, final int qtDias) {
        
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                
                
            }
        }
    }

    private void criarLog_autTecban(final Calendar cal, final int qtDias) {
        
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                
                
            }
        }
    }

    private void criarLog_autItautec(final Calendar cal, final int qtDias) {
        
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                
                
            }
        }
    }




    private String duasCasas(final int param) {
        if (param < 10) {
            return "0" + param;
        }
        return String.valueOf(param);
    }
    

    private String anoMesDia(final Calendar cal) {
        return cal.get(Calendar.YEAR)+"-"+duasCasas((cal.get(Calendar.MONTH)+1))+"-"+duasCasas(cal.get(Calendar.DAY_OF_MONTH));
    }

    public List<String> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<String> arquivos) {
        this.arquivos = arquivos;
    }
    
    
}
