package com.jfra.crm.quality.DAO;

import java.util.List;

import com.jfra.crmquality.entidade.Funcionario;

public interface FuncionarioDAO {
	
	/**
	 * Método que salva um novo funcionário
	 * @param funcionario
	 * @return {@link Funcionario}
	 */
	public Funcionario salvarFuncionario(Funcionario funcionario);
	
	/**
	 * Método que edita um funcionário
	 * @param funcionario
	 * @return {@link Funcionario}
	 */
	public Funcionario editarFuncionario(Funcionario funcionario);
	
	/**
	 * Método que retorna todos os funcionários cadastrados
	 * @return {@link List} {@link Funcionario}
	 */
	public List<Funcionario> listaTodosFuncionarios();
	
	/**
	 * Método que busca funcionário por ID
	 * @param id
	 * @return {@link Funcionario}
	 */
	public Funcionario buscaFuncionarioPorID(int id);
	
	/**
	 * Método que deleta um funcionário
	 * @param funcionario
	 */
	public void deletaFuncionario(Funcionario funcionario);
	
	

}
