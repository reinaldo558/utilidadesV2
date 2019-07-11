/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.utilidadesv2.entidades;

import java.util.List;

/**
 *
 * @author desenv
 */
public class EntityCommand {
    
    
    private String description;
    @SuppressWarnings("rawtypes")
    private List header;
    @SuppressWarnings("rawtypes")
    private List fields;
    private int headerSize;
    private int fieldsSize;
    
    public EntityCommand() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @SuppressWarnings("rawtypes")
	public List getHeader() {
        return header;
    }

    @SuppressWarnings("rawtypes")
	public void setHeader(List header) {
        this.header = header;
    }

    @SuppressWarnings("rawtypes")
	public List getFields() {
        return fields;
    }

    @SuppressWarnings("rawtypes")
	public void setFields(List fields) {
        this.fields = fields;
    }

    public int getHeaderSize() {
        return headerSize;
    }

    public void setHeaderSize(int headerSize) {
        this.headerSize = headerSize;
    }

    public int getFieldsSize() {
        return fieldsSize;
    }

    public void setFieldsSize(int fieldsSize) {
        this.fieldsSize = fieldsSize;
    }
    
    
}
