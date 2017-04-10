package com.jfra.crmquality.entidade.faces;

import com.jfra.crmquality.entidade.Unidade;
import com.jfra.crmquality.entidade.faces.util.JsfUtil;
import com.jfra.crmquality.entidade.faces.util.JsfUtil.PersistAction;
import com.jfra.crmquality.entidade.faces.EJB.UnidadeFacade;

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

@Named("unidadeController")
@SessionScoped
public class UnidadeController implements Serializable {

    @EJB
    private com.jfra.crmquality.entidade.faces.EJB.UnidadeFacade ejbFacade;
    private List<Unidade> items = null;
    private Unidade selected;

    public UnidadeController() {
    }

    public Unidade getSelected() {
        return selected;
    }

    public void setSelected(Unidade selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private UnidadeFacade getFacade() {
        return ejbFacade;
    }

    public Unidade prepareCreate() {
        selected = new Unidade();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("UnidadeCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("UnidadeUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("UnidadeDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Unidade> getItems() {
        if (items == null) {
            items = getFacade().listaTodasUnidade();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction == PersistAction.UPDATE) {
                    getFacade().alteraUnidade(selected);
                } else if (persistAction == PersistAction.DELETE) {
                    getFacade().apagaUnidade(selected);
                } else {
                    getFacade().salvarUnidade(selected);
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

    public Unidade getUnidade(java.lang.Integer id) {
        return getFacade().retornUnidadePorID(id);
    }

    public List<Unidade> getItemsAvailableSelectMany() {
        return getFacade().listaTodasUnidade();
    }

    public List<Unidade> getItemsAvailableSelectOne() {
        return getFacade().listaTodasUnidade();
    }

    @FacesConverter(forClass = Unidade.class)
    public static class UnidadeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UnidadeController controller = (UnidadeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "unidadeController");
            return controller.getUnidade(getKey(value));
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
            if (object instanceof Unidade) {
                Unidade o = (Unidade) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Unidade.class.getName()});
                return null;
            }
        }

    }

}
