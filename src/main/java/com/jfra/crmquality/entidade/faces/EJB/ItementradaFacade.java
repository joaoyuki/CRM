/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import teste.com.Itementrada;

/**
 *
 * @author AbadaCapoeira
 */
@Stateless
public class ItementradaFacade extends AbstractFacade<Itementrada> {

    @PersistenceContext(unitName = "WebApplication1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItementradaFacade() {
        super(Itementrada.class);
    }
    
}
