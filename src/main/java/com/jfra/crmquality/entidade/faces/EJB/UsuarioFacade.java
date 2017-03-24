/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces.EJB;

import com.jfra.crm.quality.DAO.UsuarioDAOImpl;
import com.jfra.crmquality.entidade.HistoricoLoginUsuario;
import com.jfra.crmquality.entidade.Usuario;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author AbadaCapoeira
 */

@Stateless
public class UsuarioFacade {
    
    @Inject
    UsuarioDAOImpl usuarioDAOImpl;
    
    /**
     * Método que salva um novo usuário
     * @param usuario
     * @return 
     */
    public Usuario salvaUsuario(Usuario usuario){
        
        usuario.setDataHoraCriacao(new Date());
        usuario.setDataHoraEdicao(new Date());
        usuarioDAOImpl.salvaUsuario(usuario);
        return usuario;
        
    }
    
    public List<Usuario> getListaUsuarios(){
        return usuarioDAOImpl.listaTodosUsuarios();
    }
    
    public Usuario getUsuarioById(int id){
        return usuarioDAOImpl.buscaUsuarioID(id);
    }
    
    /**
     * Método que verifica se um usuário é válido para fazer login ao sistema
     * @param nome
     * @param senha
     * @return 
     */
    public Usuario isUsuarioValidoParaLogin(String nome, String senha){
       
        return usuarioDAOImpl.buscaUsuarioPorNomeSenha(nome, senha);

    }
    
    /**
     * Método que salva o histórico de acesso do usuário ao sistema
     * @param usuario
     * @return 
     */
    public String doLogin(Usuario usuario){
        
        HistoricoLoginUsuario historico = new HistoricoLoginUsuario();
        historico.setIdUsuario(usuario.getUsuarioPK().getId());
        historico.setDataHoraLogin(new Date());
        
        usuarioDAOImpl.salvaHistorico(historico);
        return "faces/principal.xhtml";
    }
    
}
