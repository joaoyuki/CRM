/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces.EJB;

import com.jfra.crm.quality.DAO.UnidadeDAOImpl;
import com.jfra.crmquality.entidade.Unidade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author AbadaCapoeira
 */
@Stateless
public class UnidadeFacade{

    @Inject
    UnidadeDAOImpl unidadeDAOImpl;

    /**
     * Método que salva uma nudade
     * @param unidade
     * @return 
     */
    public Unidade salvarUnidade(Unidade unidade){
    
        unidadeDAOImpl.salvarUnidade(unidade);
        
        return unidade;
        
    }
    
    /**
     * Método que apaga uma unidade
     * @param unidade 
     */
    public void apagaUnidade(Unidade unidade){
        
        unidadeDAOImpl.apagaUnidade(unidade);
        
    }
    
    
    /**
     * Método que altera uma unidade
     * @param unidade
     * @return 
     */
    public Unidade alteraUnidade(Unidade unidade){
        
        unidadeDAOImpl.editaUnidade(unidade);
        return unidade;
        
    }
    
    /**
     * Método que lista todas as unidades
     * @return 
     */
    public List<Unidade> listaTodasUnidade(){
        
        return unidadeDAOImpl.listaTodasUnidades();
        
    }
    
    /**
     * Método que busca uma unidade por ID
     * @param id
     * @return 
     */
    public Unidade retornUnidadePorID(int id){
        
        return unidadeDAOImpl.buscaUnidadeID(id);
        
    }
    
    
    
}
