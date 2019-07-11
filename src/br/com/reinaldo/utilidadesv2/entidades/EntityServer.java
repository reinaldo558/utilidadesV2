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
public class EntityServer {
    
    private String ip;
    private String port;
    private String online;
    private String authorized;
    private String keys;

    
    public EntityServer() {}
    
    public EntityServer(final String pIp, final String pPorta) {
        this.ip = pIp;
        this.port = pPorta;
    }
    
    public EntityServer(final String pHost, final String pPorta, 
            final String pOnline, final String pAutorizado, final String pChaves) {
        this.ip = pHost;
        this.port = pPorta;
        this.online = pOnline;
        this.authorized = pAutorizado;
        this.keys = pChaves;
    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getAuthorized() {
        return authorized;
    }

    public void setAuthorized(String authorized) {
        this.authorized = authorized;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    @Override
    public boolean equals(Object objParam) {
        if (!(objParam instanceof EntityServer)) return false;
        
        final EntityServer obj = (EntityServer) objParam;
        
        if (getIp() == null || obj.getIp() == null) return false;
        
        if (getPort() == null || obj.getPort() == null)  return false;
        
        return getIp().equals(obj.getIp()) && getPort().equals(obj.getPort());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.ip != null ? this.ip.hashCode() : 0);
        hash = 29 * hash + (this.port != null ? this.port.hashCode() : 0);
        return hash;
    }
    
    
}
