/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crm.quality.DAO;

import com.jfra.crmquality.entidade.HistoricoLoginUsuario;
import com.jfra.crmquality.entidade.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AbadaCapoeira
 */

 @ApplicationScoped
public class UsuarioDAOImpl implements UsuarioDAO{
    
    @PersistenceContext(unitName = "liquor")
    private EntityManager em;

    @Override
    public Usuario salvaUsuario(Usuario usuario) {
        
        em.persist(usuario);
        
        return usuario;
        
    }

    @Override
    public Usuario editaUsuario(Usuario usuario) {
        
        em.merge(usuario);
        
        return usuario;
        
    }

    @Override
    public List<Usuario> listaTodosUsuarios() {
        
        List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
        
        try{
            
            listaDeUsuarios = em.createNamedQuery("Usuario.findAll").getResultList();
            
        }catch(NoResultException e){
            return listaDeUsuarios;
        }
        
        return listaDeUsuarios;
        
    }

    @Override
    public Usuario buscaUsuarioID(int id) {
        
        Usuario usuario = new Usuario();
        
        try{
            
            usuario = (Usuario) em.createNamedQuery("Usuario.findById").setParameter("id", id);
            
        }catch(NoResultException e){
            return usuario;
        }
        
        return usuario;
        
    }

    @Override
    public void apagaUsuario(Usuario usuario) {
        
        em.remove(em.merge(usuario));
        
    }

    @Override
    public Usuario buscaUsuarioPorNomeSenha(String nome, String senha) {

        Usuario usuario = new Usuario();
        
        try{
        usuario = (Usuario) em.createNamedQuery("Usuario.validaLogin")
                .setParameter("nome", nome)
                .setParameter("senha", senha)
                .getSingleResult();
        }catch(NoResultException e){
            return null;
        }
        
        return usuario;
    }

    @Override
    public void salvaHistorico(HistoricoLoginUsuario historicoLoginUsuario) {
        
        em.persist(historicoLoginUsuario);
        
    }
    
}
