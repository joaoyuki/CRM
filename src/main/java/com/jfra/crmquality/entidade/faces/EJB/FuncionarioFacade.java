/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces.EJB;

import com.jfra.crm.quality.DAO.FuncionarioDAOImpl;
import com.jfra.crmquality.entidade.Funcionario;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AbadaCapoeira
 */
@Stateless
public class FuncionarioFacade{
    
    @PersistenceContext(unitName = "liquor")
    private EntityManager em;

    //@Inject
    //FuncionarioDAOImpl funcionarioDAOImpl; 
    
    @Inject
    FuncionarioDAOImpl funcionarioDAOImpl;
    
    /**
     * Método que salva um novo funcionário
     * @param funcionario 
     */
    public void salvarFuncionario(Funcionario funcionario){
        
        funcionario.setDataHoraCriacao(new Date());
        funcionario.setDataHoraEdicao(new Date());
        funcionario.setUsuarioCriacao(1);
        funcionario.setUsuarioEdicao(1);
        funcionarioDAOImpl.salvarFuncionario(funcionario);
        
        
    }
    
    /**
     * M�todo que edita um funcion�rio
     * @param funcionario
     */
    public void editarFuncionario(Funcionario funcionario){
    	
        funcionario.setDataHoraEdicao(new Date());
        funcionario.setUsuarioEdicao(1);
        funcionarioDAOImpl.editarFuncionario(funcionario);
    	
    }
    
    /**
     * M�todo que retorna uma lista com todos os funcion�rios
     * @return {@link List} {@link Funcionario}
     */
    public List<Funcionario> listaTodosFuncionarios(){
    	
    	return funcionarioDAOImpl.listaTodosFuncionarios();
    	
    }
    
    /**
     * M�todo que busca funcion�rio pelo ID
     * @param id
     * @return {@link Funcionario}
     */
    public Funcionario buscaFuncionarioID(int id){
    	
    	return funcionarioDAOImpl.buscaFuncionarioPorID(id);
    	
    }
    
    /**
     * M�todo que deleta um funcion�rio
     * @param funcionario
     */
    public void apagaFuncionario(Funcionario funcionario){
    	
    	funcionarioDAOImpl.deletaFuncionario(funcionario);
    	
    }
    
    
    
}
