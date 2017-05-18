/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces;

import com.jfra.crmquality.entidade.Marca;
import com.jfra.crmquality.entidade.faces.EJB.MarcaFacade;
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

@Named("marcaController")
@SessionScoped
public class MarcaController implements Serializable{
    
    @EJB
    MarcaFacade marcaFacade;
    
    private List<Marca> items = null;
    private Marca selected;
    
    public MarcaController(){
        
    }

    public MarcaFacade getMarcaFacade() {
        return marcaFacade;
    }

    public void setMarcaFacade(MarcaFacade marcaFacade) {
        this.marcaFacade = marcaFacade;
    }

    public void setItems(List<Marca> items) {
        this.items = items;
    }

    public Marca getSelected() {
        return selected;
    }

    public void setSelected(Marca selected) {
        this.selected = selected;
    }
    
    public Marca prepareCreate(){
        selected = new Marca();
        return selected;
    }
    
    public void create() {
        persist(JsfUtil.PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("MarcaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(JsfUtil.PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("MarcaUpdated"));
    }   
    
    public void destroy() {
        persist(JsfUtil.PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("MarcaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Marca> getItems() {
        if (items == null) {
            items = getMarcaFacade().listaTodasMarcas();
        }
        return items;
    }  
    
    private void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        if (selected != null) {
            try {
                if (persistAction == JsfUtil.PersistAction.UPDATE) {
                    getMarcaFacade().editarMarca(selected);
                } else if (persistAction == JsfUtil.PersistAction.DELETE) {
                    getMarcaFacade().apagaMarca(selected);
                } else {
                    getMarcaFacade().salvarMarca(selected);
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
