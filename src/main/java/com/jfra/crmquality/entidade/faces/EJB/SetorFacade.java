/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces.EJB;

import com.jfra.crm.quality.DAO.SetorDAOImpl;
import com.jfra.crmquality.entidade.Funcionario;
import com.jfra.crmquality.entidade.Setor;

import java.time.LocalDateTime;
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
public class SetorFacade{
    
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
    
}
