/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfra.crm.quality.DAO;

import com.jfra.crmquality.entidade.Unidade;
import java.util.List;

/**
 *
 * @author joaoassis
 */
public interface UnidadeDAO {
    
    /**
     * Método que salva uma nova unidade
     * @param unidade
     * @return 
     */
    public Unidade salvarUnidade(Unidade unidade);
    
    /**
     * Método que edita unidade
     * @param unidade
     * @return 
     */
    public Unidade editaUnidade(Unidade unidade);
    
    /**
     * Método que lista todas as unidades cadastradas
     * @return 
     */
    public List<Unidade> listaTodasUnidades();
    
    /**
     * Busca unidade por ID
     * @param id
     * @return 
     */
    public Unidade buscaUnidadeID(int id);
    
    /**
     * Método que apaga uma unidade
     * @param unidade 
     */
    public void apagaUnidade(Unidade unidade);
    
}
