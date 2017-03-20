package com.jfra.crm.quality.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jfra.crmquality.entidade.Funcionario;

public class FuncionarioDAOImpl implements FuncionarioDAO{

    @PersistenceContext(unitName = "liquor")
    private EntityManager em;
	
	@Override
	public Funcionario salvarFuncionario(Funcionario funcionario) {
		
		em.merge(funcionario);
		
		return funcionario;
		
	}

}
