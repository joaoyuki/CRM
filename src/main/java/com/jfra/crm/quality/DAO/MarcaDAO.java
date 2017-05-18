/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crm.quality.DAO;

import com.jfra.crmquality.entidade.Marca;
import java.util.List;

/**
 *
 * @author AbadaCapoeira
 */
public interface MarcaDAO {
    
    public Marca salvarMarca(Marca marca);
    
    public Marca editarMarca(Marca marca);
    
    public List<Marca> listaTodasMarcas();
    
    public Marca buscaMarcaID(int id);
    
    public void deletaMarca(Marca marca);
    
}
