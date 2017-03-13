/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Joao
 */
public abstract class BaseCDIBean<T> implements Serializable{
    
    //Como o CDI faz a persistencia do objetos de forma aletória, usamos esse atributo para guardar uma "versão" do objeto
    private static final long serialVersionUID = 1L;
    
    private T selectedBean;
    
    @PersistenceContext(unitName = "liquor")
    protected EntityManager em;  

    public T getSelectedBean() {
        return selectedBean;
    }

    public void setSelectedBean(T selectedBean) {
        this.selectedBean = selectedBean;
    }
    
    
    
}
