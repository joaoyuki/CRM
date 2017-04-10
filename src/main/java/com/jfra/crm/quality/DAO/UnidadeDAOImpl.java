/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crm.quality.DAO;

import com.jfra.crmquality.entidade.Unidade;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joaoassis
 */
@ApplicationScoped
public class UnidadeDAOImpl implements UnidadeDAO{
    
    @PersistenceContext(unitName = "liquor")
    private EntityManager em;

    @Override
    public Unidade salvarUnidade(Unidade unidade) {
        
        em.persist(unidade);
        
        return unidade;
        
    }

    @Override
    public Unidade editaUnidade(Unidade unidade) {
        
        em.merge(unidade);
        
        return unidade;
        
    }

    @Override
    public List<Unidade> listaTodasUnidades() {
        
        List<Unidade> unidades = new ArrayList<Unidade>();
        
        try{
           unidades = em.createNamedQuery("Unidade.findAll").getResultList();
        }catch(NoResultException e){
            return unidades;
        }
        
        return unidades;
        
    }

    @Override
    public Unidade buscaUnidadeID(int id) {
        
        Unidade unidade = new Unidade();
        
        try{
            unidade = (Unidade) em.createNamedQuery("Unidade.findById").setParameter("id", id).getSingleResult();
        }catch(NoResultException e){
            return unidade;
        }
        
        return unidade;
        
    }

    @Override
    public void apagaUnidade(Unidade unidade) {
        
        em.remove(em.merge(unidade));
        
    }
    
    
}
