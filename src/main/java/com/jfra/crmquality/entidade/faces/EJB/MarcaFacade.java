/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crmquality.entidade.faces.EJB;

import com.jfra.crm.quality.DAO.MarcaDAO;
import com.jfra.crm.quality.DAO.MarcaDAOImpl;
import com.jfra.crmquality.entidade.Marca;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author AbadaCapoeira
 */
@Stateless
public class MarcaFacade {
    
    @Inject
    MarcaDAOImpl marcaDAOImpl;
    
    public void salvarMarca(Marca marca){
        
        marcaDAOImpl.salvarMarca(marca);
        
    }
    
    public void editarMarca(Marca marca){
        
        marcaDAOImpl.editarMarca(marca);
        
    }
    
    public List<Marca> listaTodasMarcas(){
        
        return marcaDAOImpl.listaTodasMarcas();
        
    }
    
    public Marca buscaMarcaID(int id){
        
        return marcaDAOImpl.buscaMarcaID(id);
        
    }
    
    public void apagaMarca(Marca marca){
        
        marcaDAOImpl.deletaMarca(marca);
        
    }
    
    
}
