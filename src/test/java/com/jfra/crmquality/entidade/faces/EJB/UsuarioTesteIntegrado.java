/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces.EJB;

import com.jfra.crmquality.entidade.Usuario;
import com.jfra.crmquality.entidade.UsuarioPK;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author AbadaCapoeira
 */
public class UsuarioTesteIntegrado {

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

        Usuario usuario = new Usuario();
        UsuarioPK usuarioPK = new UsuarioPK();
        usuarioPK.setId(10L);
        usuario.setUsuarioPK(usuarioPK);
        usuario.setDataHoraCriacao(new Date());
        usuario.setDataHoraEdicao(new Date());
        getEntityManager().persist(usuario);

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
    public void teste01(){
        System.out.println("com.jfra.crmquality.entidade.faces.EJB.UsuarioTesteIntegrado.teste01()");
    }

}
