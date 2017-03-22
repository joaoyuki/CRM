package com.jfra.crmquality.entidade.faces.EJB;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jfra.crm.quality.DAO.FuncionarioDAOImpl;
import com.jfra.crmquality.entidade.Funcionario;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FuncionarioFacadeTeste {
	
	@InjectMocks
	FuncionarioFacade funcionarioFacade;
	
	@Mock
	FuncionarioDAOImpl funcionarioDAOImpl; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Teste que verifica se um novo funcionário vai ter data e hora quando for criado
	 */
	@Test
	public void testSalvarFuncionario_dataHoraCriacaoEdicao() {
		
		Funcionario funcionario = new Funcionario();
		
		funcionarioFacade.salvarFuncionario(funcionario);
		
		assertNotNull(funcionario.getDataHoraCriacao());
		assertNotNull(funcionario.getDataHoraEdicao());
		
	}
	
	/**
	 * Teste que verifica se um novo funcionário vai ter o código do usuário que o criou
	 */
	@Test
	public void testSalvarFuncionario_usuarioCriacaoEdicao() {
		
		Funcionario funcionario = new Funcionario();
		
		funcionarioFacade.salvarFuncionario(funcionario);
		
		assertNotEquals(new Integer(0) ,funcionario.getUsuarioCriacao());
		assertNotEquals(new Integer(0) ,funcionario.getUsuarioEdicao());
		
	}
	
	@Test
	public void testEditarFuncionario_dataHoraEdicao(){
		
		Funcionario funcionario = new Funcionario();
		
		funcionarioFacade.editarFuncionario(funcionario);
		
		assertNotNull(funcionario.getDataHoraEdicao());
		
	}
	
	@Test
	public void testListaTodosFuncionarios(){
		
		funcionarioFacade.listaTodosFuncionarios();
		
	}
	
	

}
