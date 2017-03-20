/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces.EJB;

import com.jfra.crm.quality.DAO.SetorDAOImpl;
import com.jfra.crmquality.entidade.Setor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;

/**
 *
 * @author AbadaCapoeira
 */
@RunWith(MockitoJUnitRunner.class)
public class SetorFacadeTeste{
   
	@InjectMocks
	SetorFacade setorFacade;
	
	@Mock
	SetorDAOImpl setorDAO;
	
    public SetorFacadeTeste() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    	
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Valida se o setor a ser salvo vai ter data e hora de cria��o e edi��o
     */
    @Test
    public void salvarSetorTeste_dataHoraCriacaoEdicao(){

        Setor setorRetorno = new Setor();        
        setorFacade.salvarSetor(setorRetorno);    

        assertNotEquals(setorRetorno.getDataHoraCriacao(), null);
        assertNotEquals(setorRetorno.getDataHoraEdicao(), null);

    }
    
    /**
     * Valida se o setor a ser salvo vai ter o usu�rio de cria��o e edi��o
     */
    @Test
    public void salvarSetorTeste_usuarioCriacaoEdicao(){

        Setor setorRetorno = new Setor();        
        setorFacade.salvarSetor(setorRetorno);    

        assertNotEquals(setorRetorno.getUsuarioCriacao(), null);
        assertNotEquals(setorRetorno.getUsuarioEdicao(), null);
        assertNotEquals(setorRetorno.getUsuarioCriacao(), 0);

    }    
    
    
}
