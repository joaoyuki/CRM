package com.jfra.crm.quality.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.jfra.crmquality.entidade.Funcionario;
import javax.enterprise.context.ApplicationScoped;

 @ApplicationScoped
public class FuncionarioDAOImpl implements FuncionarioDAO{

    @PersistenceContext(unitName = "liquor")
    private EntityManager em;
	
	@Override
	public Funcionario salvarFuncionario(Funcionario funcionario) {
		
		em.persist(funcionario);
		
		return funcionario;
		
	}

	@Override
	public Funcionario editarFuncionario(Funcionario funcionario) {

		em.merge(funcionario);
		
		return funcionario;
		
	}

	@Override
	public List<Funcionario> listaTodosFuncionarios() {
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try{
			funcionarios = em.createNamedQuery("Funcionario.findAll").getResultList();
		}catch (NoResultException e){
			return funcionarios;
		}
		
		return funcionarios;
	}

	@Override
	public Funcionario buscaFuncionarioPorID(int id) {
		
		Funcionario funcionario = new Funcionario();
		
		try{
			funcionario = (Funcionario) em.createNamedQuery("Funcionario.findByIdFuncionario").setParameter("idFuncionario", id).getSingleResult();
		}catch(NoResultException e){
			return funcionario;
		}
		
		return funcionario;
	}

	@Override
	public void deletaFuncionario(Funcionario funcionario) {
		em.remove(em.merge(funcionario));
		
	}

}
