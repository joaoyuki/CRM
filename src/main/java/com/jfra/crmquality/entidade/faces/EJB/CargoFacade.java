/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces.EJB;

import com.jfra.crmquality.entidade.Cargo;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AbadaCapoeira
 */
@Stateless
public class CargoFacade extends AbstractFacade<Cargo> {

    @PersistenceContext(unitName = "liquor")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CargoFacade() {
        super(Cargo.class);
    }
    
    /**
     * Método que salvar um novo cargo
     * @param cargo 
     */
    public void salvaCargo(final Cargo cargo){
        
        cargo.setDataHoraCriacao(new Date());
        cargo.setDataHoraEdicao(new Date());
        cargo.setUsuarioCriacao(1);
        cargo.setUsuarioEdicao(1);
        em.merge(cargo);
        
    }
    
    /**
     * Método que edita um cargo
     * @param cargo 
     */
    public void editaCargo(final Cargo cargo){
        
        cargo.setDataHoraEdicao(new Date());
        cargo.setUsuarioEdicao(1);
        em.merge(cargo);
        
    }
    
}
