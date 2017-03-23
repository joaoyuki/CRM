/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crm.quality.DAO;

import com.jfra.crmquality.entidade.Usuario;
import java.util.List;

/**
 *
 * @author AbadaCapoeira
 */
public interface UsuarioDAO {
    
    /**
     * Método que salva um novo usuário
     * @param usuario
     * @return 
     */
    public Usuario salvaUsuario(Usuario usuario); 
    
    /**
     * Método que edita um usuário
     * @param usuario
     * @return 
     */
    public Usuario editaUsuario(Usuario usuario);
    
    /**
     * Método que lista todos os usuários cadastrados
     * @return 
     */
    public List<Usuario> listaTodosUsuarios();
    
    /**
     * Método que busca um usuário pelo id
     * @param id
     * @return 
     */
    public Usuario buscaUsuarioID(int id);
    
    /**
     * Método que deleta um usuário
     * @param usuario 
     */
    public void apagaUsuario(Usuario usuario);
    
}
