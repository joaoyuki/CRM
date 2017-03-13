/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces;

import com.jfra.crmquality.entidade.Usuario;
import com.jfra.crmquality.entidade.faces.EJB.UsuarioSessionBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author joaoassis
 */

@Named
@SessionScoped
public class UsuarioBean extends BaseCDIBean<Usuario>{
    
    private static final long serialVersionUID = 2L;
    
    @Inject
    private UsuarioSessionBean usuarioSessionBean;
    
}
