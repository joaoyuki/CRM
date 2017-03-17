/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces.EJB;

import com.jfra.crmquality.entidade.Unidade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AbadaCapoeira
 */
@Stateless
public class UnidadeFacade extends AbstractFacade<Unidade> {

    @PersistenceContext(unitName = "liquor")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadeFacade() {
        super(Unidade.class);
    }
    
    //Teste git
    public void salvarUnidade(Unidade unidade){
        
        em.merge(unidade);
        
    }
    
}
