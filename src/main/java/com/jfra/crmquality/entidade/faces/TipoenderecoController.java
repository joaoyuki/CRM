package com.jfra.crmquality.entidade.faces;

import com.jfra.crmquality.entidade.Tipoendereco;
import com.jfra.crmquality.entidade.faces.util.JsfUtil;
import com.jfra.crmquality.entidade.faces.util.JsfUtil.PersistAction;
import com.jfra.crmquality.entidade.faces.EJB.TipoenderecoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("tipoenderecoController")
@SessionScoped
public class TipoenderecoController implements Serializable {

    @EJB
    private com.jfra.crmquality.entidade.faces.EJB.TipoenderecoFacade ejbFacade;
    private List<Tipoendereco> items = null;
    private Tipoendereco selected;

    public TipoenderecoController() {
    }

    public Tipoendereco getSelected() {
        return selected;
    }

    public void setSelected(Tipoendereco selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TipoenderecoFacade getFacade() {
        return ejbFacade;
    }

    public Tipoendereco prepareCreate() {
        selected = new Tipoendereco();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("TipoenderecoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("TipoenderecoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("TipoenderecoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Tipoendereco> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
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

    public Tipoendereco getTipoendereco(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Tipoendereco> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tipoendereco> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tipoendereco.class)
    public static class TipoenderecoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoenderecoController controller = (TipoenderecoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoenderecoController");
            return controller.getTipoendereco(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Tipoendereco) {
                Tipoendereco o = (Tipoendereco) object;
                return getStringKey(o.getIdTipoEndereco());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tipoendereco.class.getName()});
                return null;
            }
        }

    }

}
