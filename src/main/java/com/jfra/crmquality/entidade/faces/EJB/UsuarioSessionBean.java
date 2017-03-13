/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces.EJB;

import com.jfra.crmquality.entidade.HistoricoLoginUsuario;
import com.jfra.crmquality.entidade.Usuario;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;
import javax.persistence.NoResultException;

/**
 *
 * @author joaoassis
 */
@Stateless //Não vai guardar o status
@TransactionManagement(TransactionManagementType.CONTAINER)// Diz que o container vai fazer o controle da transação
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class UsuarioSessionBean extends BasicSessionBean{
    
    public Usuario salvaUsuario(Usuario usuario){
        
        usuario.setDataHoraCriacao(new Date());
        usuario.setDataHoraEdicao(new Date());
        getEm().persist(usuario);
        return usuario;
        
    }
    
    public List<Usuario> getListaUsuarios(){
        return getEm().createNamedQuery("Usuario.findAll").getResultList();
    }
    
    public Usuario getUsuarioById(int id){
        return (Usuario) getEm().createNamedQuery("Usuario.findById")
                .setParameter("id", id)
                .getSingleResult();
    }
    
    public Usuario isUsuarioValidoParaLogin(String nome, String senha){
        
        Usuario usuario = new Usuario();
        
        try{
        usuario = (Usuario) getEm().createNamedQuery("Usuario.validaLogin")
                .setParameter("nome", nome)
                .setParameter("senha", senha)
                .getSingleResult();
        }catch(NoResultException e){
            return null;
        }
        return usuario;

    }
    
    public String doLogin(Usuario usuario){
        
        HistoricoLoginUsuario historico = new HistoricoLoginUsuario();
        historico.setIdUsuario(usuario.getUsuarioPK().getId());
        historico.setDataHoraLogin(new Date());
        
        getEm().persist(historico);
        return "faces/principal.xhtml";
    }
    
    
    
}
