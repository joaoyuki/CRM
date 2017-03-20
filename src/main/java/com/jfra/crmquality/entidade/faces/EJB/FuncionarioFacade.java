/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces.EJB;

import com.jfra.crm.quality.DAO.FuncionarioDAOImpl;
import com.jfra.crmquality.entidade.Funcionario;

import java.util.Date;

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
    
}
