package com.jfra.crmquality.entidade.faces;

import com.jfra.crmquality.entidade.Setor;
import com.jfra.crmquality.entidade.faces.util.JsfUtil;
import com.jfra.crmquality.entidade.faces.util.JsfUtil.PersistAction;
import com.jfra.crmquality.entidade.faces.EJB.SetorFacade;

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

@Named("setorController")
@SessionScoped
public class SetorController implements Serializable {

    @EJB
    private com.jfra.crmquality.entidade.faces.EJB.SetorFacade ejbFacade;
    private List<Setor> items = null;
    private Setor selected;

    public SetorController() {
    }

    public Setor getSelected() {
        return selected;
    }

    public void setSelected(Setor selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SetorFacade getFacade() {
        return ejbFacade;
    }

    public Setor prepareCreate() {
        selected = new Setor();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("SetorCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("SetorUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("SetorDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Setor> getItems() {
        if (items == null) {
            items = getFacade().listaTodosSetores();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction == PersistAction.UPDATE) {
                    getFacade().editarSetor(selected);
                } else if (persistAction == PersistAction.DELETE) {
                    getFacade().apagarSetor(selected);
                } else {
                    getFacade().salvarSetor(selected);
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

    public Setor getSetor(java.lang.Integer id) {
        return getFacade().buscaSetorID(id);
    }

    public List<Setor> getItemsAvailableSelectMany() {
        return getFacade().listaTodosSetores();
    }

    public List<Setor> getItemsAvailableSelectOne() {
        return getFacade().listaTodosSetores();
    }
    
    /**
     * Método que retorna a descrição do setor
     * @param id
     * @return String - descrição do setor
     */
    public String getDescricaoById(Integer id){
        Setor setor = getSetor(id);
        return setor.getDescricaoSetor();
    }

    @FacesConverter(forClass = Setor.class)
    public static class SetorControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SetorController controller = (SetorController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "setorController");
            return controller.getSetor(getKey(value));
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
            if (object instanceof Setor) {
                Setor o = (Setor) object;
                return getStringKey(o.getIdSetor());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Setor.class.getName()});
                return null;
            }
        }

    }

}
