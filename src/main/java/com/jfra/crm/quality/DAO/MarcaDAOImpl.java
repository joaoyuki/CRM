/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crm.quality.DAO;

import com.jfra.crmquality.entidade.Marca;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AbadaCapoeira
 */
 @ApplicationScoped
public class MarcaDAOImpl implements MarcaDAO{
    
    @PersistenceContext(unitName = "liquor")
    private EntityManager em;

    @Override
    public Marca salvarMarca(Marca marca) {
        
        em.persist(marca);
        
        return marca;
    }

    @Override
    public Marca editarMarca(Marca marca) {
        
        return em.merge(marca);
        
    }

    @Override
    public List<Marca> listaTodasMarcas() {
        
        List<Marca> marcas = new ArrayList<Marca>();
        
        try{
            marcas = em.createNamedQuery("Marca.findAll").getResultList();
        }catch(NoResultException e){
            return marcas;
        }
        
        return marcas;
        
    }

    @Override
    public Marca buscaMarcaID(int id) {
        
        Marca marca = new Marca();
        
        try{
            marca = (Marca) em.createNamedQuery("Marca.findByIdmarca").getSingleResult();
        }catch(NoResultException e){
            return marca;
        }
        
        return marca;
        
    }

    @Override
    public void deletaMarca(Marca marca) {
        em.remove(em.merge(marca));
    }
    
}
