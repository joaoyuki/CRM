package com.jfra.crm.quality.DAO;

import java.util.List;

import com.jfra.crmquality.entidade.Setor;

public interface SetorDAO{
	
	/**
	 * Método que salva o setor
	 * @param setor
	 * @return
	 */
	public Setor salvarSetor(Setor setor);
	
	/**
	 * Método que edita um setor
	 * @param setor
	 * @return
	 */
	public Setor editarSetor(Setor setor);
	
	/**
	 * Método que lista todos os setores
	 * @return
	 */
	public List<Setor> listaTodosSetores();
	
	/**
	 * Método que busca um setor pelo ID 
	 * @param id
	 * @return
	 */
	public Setor buscaSetorID(int id);
	
	/**
	 * Método que deleta um setor
	 * @param setor
	 */
	public void deletaSetor(Setor setor);

}
