/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces.EJB;

import com.jfra.crmquality.entidade.Dependentes;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AbadaCapoeira
 */
@Stateless
public class DependentesFacade extends AbstractFacade<Dependentes> {

    @PersistenceContext(unitName = "liquor")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DependentesFacade() {
        super(Dependentes.class);
    }

    /**
     * Metodo que salva o depende
     * @param dependentes 
     */
    public void salvarDependentes(Dependentes dependentes){
        
        dependentes.setDataHoraCriacao(new Date());
        dependentes.setDataHoraEdicao(new Date());
        dependentes.setUsuarioCriacao(1);
        dependentes.setUsuarioEdicao(1);
        em.merge(dependentes);
        
    }
    
}
