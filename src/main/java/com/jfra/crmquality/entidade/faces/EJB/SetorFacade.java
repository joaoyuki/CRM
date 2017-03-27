/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces.EJB;

import com.jfra.crm.quality.DAO.SetorDAOImpl;
import com.jfra.crmquality.entidade.Setor;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author AbadaCapoeira
 */
@Stateless
public class SetorFacade{
    
    /**
     *
     */
    @Inject
    public SetorDAOImpl setorDAO;
   
    /**
     * Método que salva um novo setor
     * @param setor 
     */
    public void salvarSetor(Setor setor){
        
        setor.setDataHoraCriacao(new Date());
        setor.setDataHoraEdicao(new Date());
        setor.setUsuarioCriacao(1);
        setor.setUsuarioEdicao(1);
        setorDAO.salvarSetor(setor);
        
    }
    
    /**
     * M�todo que lista todos os setores
     * @return
     */
    public List<Setor> listaTodosSetores(){
    	
    	return setorDAO.listaTodosSetores();
    	
    }
    
    /**
     * M�todo que busca um setor por ID
     * @param id
     * @return
     */
    public Setor buscaSetorID(int id){
    	
    	return setorDAO.buscaSetorID(id);
    	
    }
    
    /**
     * M�todo que editar um setor
     * @param setor
     */
    public void editarSetor(Setor setor){
    	
    	setor.setDataHoraEdicao(new Date());
    	setor.setUsuarioEdicao(1);
    	setorDAO.editarSetor(setor);
    	
    }
    
    /**
     * M�todo que apaga um setor
     * @param setor
     */
    public void apagarSetor(Setor setor){
    	
    	setorDAO.deletaSetor(setor);
    	
    }
    
}
