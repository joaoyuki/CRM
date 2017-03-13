/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jfra.crmquality.testes;

import com.jfra.crmquality.entidade.Usuario;
import com.jfra.crmquality.entidade.UsuarioPK;
import com.jfra.crmquality.entidade.faces.EJB.UsuarioSessionBean;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
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
public class UsuaruioJUnitTest {

    UsuarioSessionBean usuarioSessionBean = lookupUsuarioSessionBeanBean();
    
    public static Integer idOfUser;
    private static EJBContainer container;

    
    
    public UsuaruioJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        //container = EJBContainer.createEJBContainer();
    }
    
    @AfterClass
    public static void tearDownClass() {
        //container = EJBContainer.createEJBContainer();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    //@Test
    public void testSalvarUsuario() throws NamingException{
        
        //UsuarioSessionBean bean = getUserSession();
        System.out.println("Salvando usuário");
        Usuario usuario = new Usuario();
        UsuarioPK usuarioPK = new UsuarioPK();
        
        usuario.setSenha("123");
        usuario.setDataHoraCriacao(new Date());
        usuario.setDataHoraEdicao(new Date());
        
        usuarioPK.setId(1L);
        usuarioPK.setNome("joao");
        
        usuario.setUsuarioPK(usuarioPK);
       
        usuarioSessionBean.salvaUsuario(usuario);
        
        
        
    }

    public void persist(Object object) {
        /* Add this to the deployment descriptor of this module (e.g. web.xml, ejb-jar.xml):
         * <persistence-context-ref>
         * <persistence-context-ref-name>persistence/LogicalName</persistence-context-ref-name>
         * <persistence-unit-name>com.mycompany_CRMQuality_war_1.0-SNAPSHOTPU</persistence-unit-name>
         * </persistence-context-ref>
         * <resource-ref>
         * <res-ref-name>UserTransaction</res-ref-name>
         * <res-type>javax.transaction.UserTransaction</res-type>
         * <res-auth>Container</res-auth>
         * </resource-ref> */
        try {
            Context ctx = new InitialContext();
            UserTransaction utx = (UserTransaction) ctx.lookup("java:comp/env/UserTransaction");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("java:comp/env/persistence/LogicalName");
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    public UsuarioSessionBean getUserSession() throws NamingException{
        return (UsuarioSessionBean)container.getContext().lookup("java:global/classes/UsuarioSessionBean");
    }    

    private UsuarioSessionBean lookupUsuarioSessionBeanBean() {
        try {
            Context c = new InitialContext();
            return (UsuarioSessionBean) c.lookup("java:global/liquor/UsuarioSessionBean!com.jfra.crmquality.entidade.faces.EJB.UsuarioSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    

    


}
