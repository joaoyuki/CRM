package com.jfra.crm.quality.DAO;

import com.jfra.crmquality.entidade.Funcionario;

public interface FuncionarioDAO {
	
	/**
	 * M�todo que salva um novo funcion�rio
	 * @param funcionario
	 * @return
	 */
	public Funcionario salvarFuncionario(Funcionario funcionario);

}
