package com.jfra.crm.quality.DAO;

import java.util.List;

import com.jfra.crmquality.entidade.Funcionario;

public interface FuncionarioDAO {
	
	/**
	 * M�todo que salva um novo funcion�rio
	 * @param funcionario
	 * @return {@link Funcionario}
	 */
	public Funcionario salvarFuncionario(Funcionario funcionario);
	
	/**
	 * M�todo que edita um funcion�rio
	 * @param funcionario
	 * @return {@link Funcionario}
	 */
	public Funcionario editarFuncionario(Funcionario funcionario);
	
	/**
	 * M�todo que retorna todos os funcion�rios cadastrados
	 * @return {@link List} {@link Funcionario}
	 */
	public List<Funcionario> listaTodosFuncionarios();
	
	/**
	 * M�todo que busca funcion�rio por ID
	 * @param id
	 * @return {@link Funcionario}
	 */
	public Funcionario buscaFuncionarioPorID(int id);
	
	/**
	 * M�todo que deleta um funcion�rio
	 * @param funcionario
	 */
	public void deletaFuncionario(Funcionario funcionario);
        
        /**
         * Método que retorna a foto do funcionário por ID
         * @param id
         * @return 
         */
        public Funcionario buscaFotoPorID(int id);
	
        /**
         * Método que retorna uma lista de funcionários sem foto
         * @return 
         */
        public List<Funcionario> listaFuncionariosSemFoto();
	

}
