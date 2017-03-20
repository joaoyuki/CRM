package com.jfra.crm.quality.DAO;

import com.jfra.crmquality.entidade.Funcionario;

public interface FuncionarioDAO {
	
	/**
	 * Método que salva um novo funcionário
	 * @param funcionario
	 * @return
	 */
	public Funcionario salvarFuncionario(Funcionario funcionario);

}
