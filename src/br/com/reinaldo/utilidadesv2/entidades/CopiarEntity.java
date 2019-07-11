/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2.entidades;

/**
 *
 * @author desenv
 */
public class CopiarEntity {
    
    private boolean webCatalina;
    private boolean webLocalhost;
    private boolean webLocalhostAccess;
    private boolean webDoitClient;
    private boolean webAbertura;
    private boolean webTelematica;
    private boolean webWscetelem;
    private boolean webWstelem;
    private boolean webSmsCyber;
    
    private boolean autMaster1;
    private boolean autMaster2;
    private boolean autMaster3;
    private boolean autMaster4;
    private boolean autAura;
    private boolean autTecban;
    private boolean autItautec;
    
    public CopiarEntity() {}
    
    public boolean temAlgumPreenchido() {
        return (webCatalina || webLocalhost || webLocalhostAccess || webDoitClient || webAbertura || webTelematica || webWscetelem || webWstelem || webSmsCyber ||  autMaster1 || autMaster2 || autMaster3 || autMaster4 || autAura || autTecban || autItautec);
    }

    public boolean isWebCatalina() {
        return webCatalina;
    }

    public void setWebCatalina(boolean webCatalina) {
        this.webCatalina = webCatalina;
    }

    public boolean isWebLocalhost() {
        return webLocalhost;
    }

    public void setWebLocalhost(boolean webLocalhost) {
        this.webLocalhost = webLocalhost;
    }

    public boolean isWebLocalhostAccess() {
        return webLocalhostAccess;
    }

    public void setWebLocalhostAccess(boolean webLocalhostAccess) {
        this.webLocalhostAccess = webLocalhostAccess;
    }

    public boolean isWebDoitClient() {
        return webDoitClient;
    }

    public void setWebDoitClient(boolean webDoitClient) {
        this.webDoitClient = webDoitClient;
    }

    public boolean isWebAbertura() {
        return webAbertura;
    }

    public void setWebAbertura(boolean webAbertura) {
        this.webAbertura = webAbertura;
    }

    public boolean isWebTelematica() {
        return webTelematica;
    }

    public void setWebTelematica(boolean webTelematica) {
        this.webTelematica = webTelematica;
    }

    public boolean isWebWscetelem() {
        return webWscetelem;
    }

    public void setWebWscetelem(boolean webWscetelem) {
        this.webWscetelem = webWscetelem;
    }

    public boolean isWebWstelem() {
        return webWstelem;
    }

    public void setWebWstelem(boolean webWstelem) {
        this.webWstelem = webWstelem;
    }

    public boolean isWebSmsCyber() {
        return webSmsCyber;
    }

    public void setWebSmsCyber(boolean webSmsCyber) {
        this.webSmsCyber = webSmsCyber;
    }

    public boolean isAutMaster1() {
        return autMaster1;
    }

    public void setAutMaster1(boolean autMaster1) {
        this.autMaster1 = autMaster1;
    }

    public boolean isAutMaster2() {
        return autMaster2;
    }

    public void setAutMaster2(boolean autMaster2) {
        this.autMaster2 = autMaster2;
    }

    public boolean isAutMaster3() {
        return autMaster3;
    }

    public void setAutMaster3(boolean autMaster3) {
        this.autMaster3 = autMaster3;
    }

    public boolean isAutMaster4() {
        return autMaster4;
    }

    public void setAutMaster4(boolean autMaster4) {
        this.autMaster4 = autMaster4;
    }

    public boolean isAutAura() {
        return autAura;
    }

    public void setAutAura(boolean autAura) {
        this.autAura = autAura;
    }

    public boolean isAutTecban() {
        return autTecban;
    }

    public void setAutTecban(boolean autTecban) {
        this.autTecban = autTecban;
    }

    public boolean isAutItautec() {
        return autItautec;
    }

    public void setAutItautec(boolean autItautec) {
        this.autItautec = autItautec;
    }
    
}
