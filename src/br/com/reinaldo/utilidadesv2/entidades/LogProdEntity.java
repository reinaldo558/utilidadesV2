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
    public static final int TIPO_WEB_xxxxxx = 4;
    public static final int TIPO_WEB_xxx = 5;
    public static final int TIPO_WEB_xxx = 6;
    public static final int TIPO_WEB_xxx = 7;
    public static final int TIPO_WEB_xxx = 8;
    public static final int TIPO_WEB_SMSxxx = 9;
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
            case TIPO_WEB_xxxxxx:
                criarLog_webxxxxxx(cal, qtDias);
                break;
            case TIPO_WEB_xxx:
                criarLog_webxxx(cal, qtDias);
                break;
            case TIPO_WEB_xxx:
                criarLog_webxxx(cal, qtDias);
                break;
            case TIPO_WEB_xxx:
                criarLog_webxxx(cal, qtDias);
                break;
            case TIPO_WEB_xxx:
                criarLog_webxxx(cal, qtDias);
                break;
            case TIPO_WEB_SMSxxx:
                criarLog_webSmsxxx(cal, qtDias);
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

    private void criarLog_webxxxxxx(final Calendar cal, final int qtDias) {
        arquivos.add("/logs/app/xxx-xxx/xxx-xxx-messages.log");
        arquivos.add("/logs/app/xxx-xxx/xxx-xxx-to-server-messages.log");
        
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);                
                arquivos.add("/logs/app/xxx-xxx/xxx-xxx-messages.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/xxx-xxx/xxx-xxx-to-server-messages.log."+anoMesDia(cal)+".*");
            }
        }
    }

    private void criarLog_webxxx(final Calendar cal, final int qtDias) {
        arquivos.add("/logs/app/tomcat01/xxx/xxx.log");
        arquivos.add("/logs/app/tomcat01/xxx/xxx.log");
        arquivos.add("/logs/app/tomcat01/xxx/xxxTraf.log");
        arquivos.add("/logs/app/tomcat01/xxx/xxx.log");
        arquivos.add("/logs/app/tomcat01/xxx/xxx.log");
        arquivos.add("/logs/app/tomcat02/xxx/xxx.log");
        arquivos.add("/logs/app/tomcat02/xxx/xxx.log");
        arquivos.add("/logs/app/tomcat02/xxx/xxxTraf.log");
        arquivos.add("/logs/app/tomcat02/xxx/xxx.log");
        arquivos.add("/logs/app/tomcat02/xxx/xxx.log");
                
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);                
                arquivos.add("/logs/app/tomcat01/xxx/xxx.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/xxx/xxx.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/xxx/xxxTraf.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/xxx/xxx.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/xxx/xxx.log."+anoMesDia(cal)+".*");                
                arquivos.add("/logs/app/tomcat02/xxx/xxx.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/xxx/xxx.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/xxx/xxxTraf.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/xxx/xxx.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/xxx/xxx.log."+anoMesDia(cal)+".*");
            }
        }
    }

    private void criarLog_webxxx(final Calendar cal, final int qtDias) {
        arquivos.add("/logs/app/tomcat01/xxx/xxx-soap-message.log");
        arquivos.add("/logs/app/tomcat01/xxx/xxx");
        arquivos.add("/logs/app/tomcat01/xxx/xxx");
        arquivos.add("/logs/app/tomcat01/xxx/business");
        arquivos.add("/logs/app/tomcat01/xxx/xxx");        
        arquivos.add("/logs/app/tomcat02/xxx/xxx-soap-message.log");
        arquivos.add("/logs/app/tomcat02/xxx/xxx");
        arquivos.add("/logs/app/tomcat02/xxx/xxx");
        arquivos.add("/logs/app/tomcat02/xxx/business");
        arquivos.add("/logs/app/tomcat02/xxx/xxx");

        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);                
                arquivos.add("/logs/app/tomcat01/xxx/xxx."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/xxx/xxx."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/xxx/business."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/xxx/xxx-soap-message.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/xxx/xxx."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/xxx/xxx."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/xxx/xxx."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/xxx/business."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/xxx/xxx-soap-message.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/xxx/xxx."+anoMesDia(cal)+".*");                
            }
        }
    }

    private void criarLog_webxxx(final Calendar cal, final int qtDias) {
        arquivos.add("/logs/app/tomcat01/xxx/xxx.log");
        arquivos.add("/logs/app/tomcat01/xxx/xxxTraf.log");    
        arquivos.add("/logs/app/tomcat02/xxx/xxx.log");
        arquivos.add("/logs/app/tomcat02/xxx/xxxTraf.log");
        
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                arquivos.add("/logs/app/tomcat01/xxx/xxxTraf.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/xxx/xxx.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/xxx/xxxTraf.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/xxx/xxx.log."+anoMesDia(cal)+".*");
            }
        }
    }

    private void criarLog_webxxx(final Calendar cal, final int qtDias) {
        arquivos.add("/logs/app/tomcat01/xxx/xxx-soap-message.log");
        arquivos.add("/logs/app/tomcat01/xxx/xxx-root-logger.log");
        arquivos.add("/logs/app/tomcat01/xxx/xxx-billet.log");
        arquivos.add("/logs/app/tomcat02/xxx/xxx-soap-message.log");
        arquivos.add("/logs/app/tomcat02/xxx/xxx-root-logger.log");
        arquivos.add("/logs/app/tomcat02/xxx/xxx-billet.log");
        
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                arquivos.add("/logs/app/tomcat01/xxx/xxx-root-logger.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/xxx/xxx-soap-message.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat01/xxx/xxx-billet.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/xxx/xxx-root-logger.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/xxx/xxx-soap-message.log."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/xxx/xxx-billet.log."+anoMesDia(cal)+".*");
            }
        }
    }

    private void criarLog_webSmsxxx(final Calendar cal, final int qtDias) {
        arquivos.add("/logs/app/tomcat01/sms/xxx-xxx");
        arquivos.add("/logs/app/tomcat02/sms/xxx-xxx");
        if (qtDias > 0) {
            for (int i = 0 ; i < qtDias ; i++) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                arquivos.add("/logs/app/tomcat01/sms/xxx-xxx."+anoMesDia(cal)+".*");
                arquivos.add("/logs/app/tomcat02/sms/xxx-xxx."+anoMesDia(cal)+".*");
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
