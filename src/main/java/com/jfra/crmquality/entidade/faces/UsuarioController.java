/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces;

import com.jfra.crmquality.entidade.Usuario;
import com.jfra.crmquality.entidade.faces.EJB.UsuarioFacade;
import com.jfra.crmquality.entidade.faces.util.JsfUtil;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author AbadaCapoeira
 */

@Named("usuarioController")
@SessionScoped
public class UsuarioController implements Serializable{
    
    @EJB
    private UsuarioFacade ejbFacade;
    private List<Usuario> items = null;
    private Usuario selected;

    public UsuarioFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(UsuarioFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }
    
    public UsuarioController(){
        
    }

    public Usuario getSelected() {
        return selected;
    }

    public void setSelected(Usuario selected) {
        this.selected = selected;
    }
    
    public Usuario prepareCreate(){
        selected = new Usuario();
        return selected;
    }
    
    public void create() {
        persist(JsfUtil.PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("CargoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }    
    
    public void update() {
        persist(JsfUtil.PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("CargoUpdated"));
    }

    public void destroy() {
        persist(JsfUtil.PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("CargoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }   
    
    public List<Usuario> getItems() {
        if (items == null) {
            items = getFacade().getListaUsuarios();
        }
        return items;
    }
    
    private UsuarioFacade getFacade() {
        return ejbFacade;
    }
    
    private void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        if (selected != null) {
            try {
                if (persistAction == JsfUtil.PersistAction.CREATE){
                    getFacade().salvaUsuario(selected);
                }else if (persistAction == JsfUtil.PersistAction.DELETE) {
                    getFacade().apagaUsuario(selected);
                } else {
                    getFacade().editaUsuario(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }    
    
}
