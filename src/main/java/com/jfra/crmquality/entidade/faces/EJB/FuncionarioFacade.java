/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces.EJB;

import com.jfra.crm.quality.DAO.FuncionarioDAOImpl;
import com.jfra.crmquality.entidade.Funcionario;
import com.jfra.crmquality.entidade.Unidade;

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

	@Inject
	FuncionarioDAOImpl funcionarioDAOImpl; 
    
    /**
     * M√©todo que salva um novo funcion√°rio
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
     * MÈtodo que edita um funcion·rio
     * @param funcionario
     */
    public void editarFuncionario(Funcionario funcionario){
    	
        funcionario.setDataHoraEdicao(new Date());
        funcionario.setUsuarioEdicao(1);
        funcionarioDAOImpl.editarFuncionario(funcionario);
    	
    }
    
    /**
     * MÈtodo que retorna uma lista com todos os funcion·rios
     * @return {@link List} {@link Funcionario}
     */
    public List<Funcionario> listaTodosFuncionarios(){
    	
    	return funcionarioDAOImpl.listaTodosFuncionarios();
    	
    }
    
    /**
     * MÈtodo que busca funcion·rio pelo ID
     * @param id
     * @return {@link Funcionario}
     */
    public Funcionario buscaFuncionarioID(int id){
    	
    	return funcionarioDAOImpl.buscaFuncionarioPorID(id);
    	
    }
    
    /**
     * MÈtodo que deleta um funcion·rio
     * @param funcionario
     */
    public void apagaFuncionario(Funcionario funcionario){
    	
    	funcionarioDAOImpl.deletaFuncionario(funcionario);
    	
    }
    
    
    
}
