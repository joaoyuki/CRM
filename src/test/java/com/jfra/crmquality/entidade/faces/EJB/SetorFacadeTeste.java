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
     * Valida se o setor a ser salvo vai ter data e hora de criação e edição
     */
    @Test
    public void salvarSetorTeste_dataHoraCriacaoEdicao(){

        Setor setorRetorno = new Setor();        
        setorFacade.salvarSetor(setorRetorno);    

        assertNotEquals(null, setorRetorno.getDataHoraCriacao());
        assertNotEquals(null, setorRetorno.getDataHoraEdicao());

    }
    
    /**
     * Valida se o setor a ser salvo vai ter o usuário de criação e edição
     */
    @Test
    public void salvarSetorTeste_usuarioCriacaoEdicao(){

        Setor setorRetorno = new Setor();        
        setorFacade.salvarSetor(setorRetorno);    

        assertNotEquals(null, setorRetorno.getUsuarioCriacao());
        assertNotEquals(null, setorRetorno.getUsuarioEdicao());
        assertNotEquals(0, setorRetorno.getUsuarioCriacao());

    }
    
    /**
     * Teste que valida se salvou o usuário que fez a edição do setor
     */
    @Test
    public void editaSetorTeste_usuarioEdicao(){
    	
    	Setor setor = new Setor();
    	setorFacade.editarSetor(setor);
    	
    	assertNotEquals(0, setor.getUsuarioEdicao());
    	
    }
    
    @Test
    public void editaSetorTeste_daraHoraEdicao(){
    	
    	Setor setor = new Setor();
    	setorFacade.editarSetor(setor);
    	
    	assertNotEquals(0 ,setor.getDataHoraEdicao());
    	
    }
    
    
}
