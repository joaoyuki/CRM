/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces.EJB;

import com.jfra.crmquality.entidade.Usuario;
import com.jfra.crmquality.entidade.UsuarioPK;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joaoassis
 */
public class UsuarioSessionBeanTest {
    
    private static EJBContainer container;
    
    public UsuarioSessionBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        container = EJBContainer.createEJBContainer();
    }
    
    @AfterClass
    public static void tearDownClass() {
        container.close();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEm method, of class UsuarioSessionBean.
     */
    //@Test
    public void testGetEm() throws Exception {
        System.out.println("getEm");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioSessionBean instance = (UsuarioSessionBean)container.getContext().lookup("java:global/classes/UsuarioSessionBean");
        EntityManager expResult = null;
        EntityManager result = instance.getEm();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of salvaUsuario method, of class UsuarioSessionBean.
     */
    //@Test
    public void testSalvaUsuario() throws Exception {
        System.out.println("salvaUsuario");
        Usuario usuario = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsuarioSessionBean instance = (UsuarioSessionBean)container.getContext().lookup("java:global/classes/UsuarioSessionBean");
        Usuario expResult = null;
        Usuario result = instance.salvaUsuario(usuario);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaUsuarios method, of class UsuarioSessionBean.
     */
    //@Test
    public void testGetListaUsuarios() throws Exception {

        System.out.println("getAllUsers");
        UsuarioSessionBean instance = getUserSession();
        List<Usuario> result = instance.getListaUsuarios();
        assertNotNull(result);
        assertTrue(result.size() >= 1);

    }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    
    //@Test
    public void isUsuarioValidoParaLogin()throws Exception{
        
        System.out.println("isUsuarioValidoParaLogin");
        UsuarioSessionBean instance = getUserSession();
        Usuario usuarios = instance.isUsuarioValidoParaLogin("joao", "123456");
        assertNotNull(usuarios);

    }
    
    //@Test
    public void salvaUsuario() throws Exception{
        
        System.out.println("Salva usuário");
        UsuarioSessionBean instance = getUserSession();
        Usuario usuario = new Usuario();
        usuario.setSenha("123456");
        UsuarioPK usuarioPK = new UsuarioPK();
        usuarioPK.setId(1L);
        usuarioPK.setNome("Joao");
        usuario.setUsuarioPK(usuarioPK);
        instance.salvaUsuario(usuario);
        
    }
    
    
    //@Test
    public void doLoginTeste() throws NamingException{
        
        System.out.println("Salva usuário");
        UsuarioSessionBean instance = getUserSession();
        
        Usuario usuario = new Usuario();
        usuario = instance.getUsuarioById(1);
        
       
        instance.doLogin(usuario);
        
    }
    
    
    
    public UsuarioSessionBean getUserSession() throws NamingException{
        return (UsuarioSessionBean)container.getContext().lookup("java:global/classes/UsuarioSessionBean");
    }
    
}
