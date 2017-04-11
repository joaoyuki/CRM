package com.jfra.crmquality.entidade.faces;

import com.jfra.crm.quality.DAO.FuncionarioDAOImpl;
import com.jfra.crmquality.entidade.Funcionario;
import com.jfra.crmquality.entidade.faces.util.JsfUtil;
import com.jfra.crmquality.entidade.faces.util.JsfUtil.PersistAction;
import com.jfra.crmquality.entidade.faces.EJB.FuncionarioFacade;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.StreamedContent;


@Named("funcionarioController")
@SessionScoped
public class FuncionarioController implements Serializable {
    
    public static final String RG = "rg";
    public static final String FOTO = "foto";
    public static final String CPF = "cpf";
    
    private String imagemAbrir;
    
    @EJB
    private com.jfra.crmquality.entidade.faces.EJB.FuncionarioFacade ejbFacade;

    private UploadedFile teste;
    
    private List<Funcionario> items = null;
    private Funcionario selected;

    public FuncionarioController() {
    }

    public Funcionario getSelected() {
        return selected;
    }

    public void setSelected(Funcionario selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FuncionarioFacade getFacade() {
        return ejbFacade;
    }

    public Funcionario prepareCreate() {
        selected = new Funcionario();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("FuncionarioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("FuncionarioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("FuncionarioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Funcionario> getItems() {
        if (items == null) {
            items = getFacade().listaTodosFuncionarios();
        }
        return items;
    }
    
    /**
     * Método que faz o upload da imagem e salva no objeto
     * @param fileUploadEvent 
     */
 public void doUpload(FileUploadEvent fileUploadEvent) { 
          
             String tipoFoto = (String)fileUploadEvent.getComponent().getAttributes().get("tipoArquivo");

             UploadedFile uploadedFile = fileUploadEvent.getFile();  
             String fileNameUploaded = uploadedFile.getFileName();
             long fileSizeUploaded = uploadedFile.getSize(); 
             //selected.setFoto(uploadedFile.getContents());
        try {
            byte[] foto = IOUtils.toByteArray(uploadedFile.getInputstream());
            
            switch(tipoFoto){
                case RG: 
                    selected.setRg_foto(foto);
                    break;
                
                case FOTO:
                    selected.setFoto(foto);
                    break;
                    
                case CPF:
                    selected.setCpf_foto(foto);
                    break;
            }

             String infoAboutFile = "<br/> Arquivo recebido: <b>" +fileNameUploaded +"</b><br/>"+
                 "Tamanho do Arquivo: <b>"+fileSizeUploaded+"</b>";
             FacesContext facesContext = FacesContext.getCurrentInstance();
             facesContext.addMessage(null, new FacesMessage("Sucesso", 			                                                                       infoAboutFile));
        } catch (IOException ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }             
   }    

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction == PersistAction.UPDATE) {
                    getFacade().editarFuncionario(selected);
                } else if (persistAction == PersistAction.DELETE) {
                    getFacade().apagaFuncionario(selected);
                } else {
                    getFacade().salvarFuncionario(selected);
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
    
    public StreamedContent abrirImagem(Funcionario selected){
        
        
        if (selected != null &&  selected.getFoto() != null){

            
            
                InputStream stream = null;
            
                switch(getImagemAbrir()){
                case RG: 
                    if (selected.getRg_foto() != null){
                        stream = new ByteArrayInputStream(selected.getRg_foto());
                    }
                    break;
                    
                case CPF:
                    if (selected.getCpf_foto() != null){
                        stream = new ByteArrayInputStream(selected.getCpf_foto());
                    }
                    break;
                    
                default:
                    stream = new ByteArrayInputStream(selected.getFoto());
                    break;
            }
            
            StreamedContent imagem = new DefaultStreamedContent(stream);
            return imagem;
        } else {
            InputStream stream = new ByteArrayInputStream(new byte[1]);
            StreamedContent imagem = new DefaultStreamedContent();
            return imagem;
        }
        
    }
    

    public Funcionario getFuncionario(java.lang.Integer id) {
        return getFacade().buscaFuncionarioID(id);
    }

    public List<Funcionario> getItemsAvailableSelectMany() {
        return getFacade().listaTodosFuncionarios();
    }

    public List<Funcionario> getItemsAvailableSelectOne() {
        return getFacade().listaTodosFuncionarios();
    }

    public UploadedFile getTeste() {
        return teste;
    }

    public void setTeste(UploadedFile teste) {
        this.teste = teste;
    }

    public String getImagemAbrir() {
        return imagemAbrir;
    }

    public void setImagemAbrir(String imagemAbrir) {
        this.imagemAbrir = imagemAbrir;
    }
    
    

    @FacesConverter(forClass = Funcionario.class)
    public static class FuncionarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FuncionarioController controller = (FuncionarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "funcionarioController");
            return controller.getFuncionario(getKey(value));
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
            if (object instanceof Funcionario) {
                Funcionario o = (Funcionario) object;
                return getStringKey(o.getIdFuncionario());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Funcionario.class.getName()});
                return null;
            }
        }

    }

}
