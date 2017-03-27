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

import com.jfra.crm.quality.DAO.UsuarioDAOImpl;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioTeste {
	
	@InjectMocks
	UsuarioFacade usuarioFacade;
	
	@Mock
	UsuarioDAOImpl usuarioDAOImpl;
	
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
	
	@Test
	public void doLoginTeste(){
		
		
		
	}

}
