package com.jfra.crm.quality.DAO;

import java.util.List;

import com.jfra.crmquality.entidade.Setor;

public interface SetorDAO{
	
	/**
	 * M�todo que salva o setor
	 * @param setor
	 * @return
	 */
	public Setor salvarSetor(Setor setor);
	
	/**
	 * M�todo que edita um setor
	 * @param setor
	 * @return
	 */
	public Setor editarSetor(Setor setor);
	
	/**
	 * M�todo que lista todos os setores
	 * @return
	 */
	public List<Setor> listaTodosSetores();
	
	/**
	 * M�todo que busca um setor pelo ID 
	 * @param id
	 * @return
	 */
	public Setor buscaSetorID(int id);
	
	/**
	 * M�todo que deleta um setor
	 * @param setor
	 */
	public void deletaSetor(Setor setor);

}
