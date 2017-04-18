package com.jfra.crmquality.entidade.faces.EJB;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jfra.crmquality.entidade.Unidade;
import static org.junit.Assert.*;

public class UnidadeTesteIntegrado {

    private static EntityManager entityManager = null;

    /**
     * Método que criar uma conexão com a persistence-unit teste-unit
     *
     * @return
     */
    public static EntityManager getEntityManager() {

        if (entityManager == null) {
            final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("teste-unit");
            entityManager = entityManagerFactory.createEntityManager();
        }

        return entityManager;

    }

    public static void populaBanco() {

    	Unidade unidade = new Unidade();
    	unidade.setId(1);
    	unidade.setNome("Unidade 01");
    	getEntityManager().persist(unidade);
    	Unidade unidade02 = new Unidade();
    	unidade02.setId(2);
    	unidade02.setNome("Unidade 02");
    	getEntityManager().persist(unidade02);
    	Unidade unidade03 = new Unidade();
    	unidade03.setId(3);
    	unidade03.setNome("Unidade 03");
    	getEntityManager().persist(unidade03);

    }

    @BeforeClass
    public static void init() {
        getEntityManager().getTransaction().begin();
        populaBanco();
    }

    @Before
    public void antes() {

    }

    /**
     * Após a execução de todos os teste a conexão será fechada.
     */
    @AfterClass
    public static void end() {
        getEntityManager().close();
    }
	
    @Test
    public void validaUnidadesInseridas(){
    	
    	List<Unidade> unidades = getEntityManager().createQuery(" SELECT u FROM Unidade u").getResultList();
    	
    	assertNotNull(unidades);
//    	assertEquals("Unidade 01", unidades.get(0).getNome());
//    	assertEquals("Unidade 02", unidades.get(1).getNome());
//    	assertEquals("Unidade 03", unidades.get(2).getNome());
    	
    }
    
}
