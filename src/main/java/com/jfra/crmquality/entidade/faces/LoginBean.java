/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces;

import com.jfra.crmquality.entidade.Usuario;
import com.jfra.crmquality.entidade.faces.EJB.UsuarioFacade;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author joaoassis
 */

@ManagedBean
@SessionScoped
public class LoginBean extends BaseCDIBean{
    
    //Como o CDI faz a persistencia do objetos de forma aletória, usamos esse atributo para guardar uma "versão" do objeto
    private static final long serialVersionUID = 1L;
    
    @Inject
    private UsuarioFacade usuarioSessionBean;    
    
    @NotNull(message = "O campo login não pode ser nulo")
    private String login;
    @NotNull(message = "O campo senha não pode ser nulo")
    @Min(value = 5, message = "A senha deve ter no mínimo 5 caracteres")
    private String password;  
    
    public String doLogin() throws ValidatorException{
 
        Usuario usuario = usuarioSessionBean.isUsuarioValidoParaLogin(login, password);
        
        if (null != usuario){
            return usuarioSessionBean.doLogin(usuario);
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuário ou senha inválidos",""));
            return "";
        }

    }
    
    
//    public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
//    
//        String password = value.toString();
//        
//        //User user = bean.isUserOk(userName, password);
//        //if(user == null){
//            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_FATAL, "Senha inválida", "Senha inválida"));
//            //throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_FATAL, "Senha errada", "A senha digitada esta errada"));
//        //}
//    }    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
}
