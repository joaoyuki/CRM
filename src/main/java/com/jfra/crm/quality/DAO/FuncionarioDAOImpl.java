package com.jfra.crm.quality.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.jfra.crmquality.entidade.Funcionario;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

    @Override
    public Funcionario buscaFotoPorID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> listaFuncionariosSemFoto() {
        
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        try{
                
                Query q = em.createQuery("SELECT NEW com.jfra.crmquality.entidade.Funcionario(f.idFuncionario, f.nomeFuncionario, f.sobrenomeFuncionario, f.cpf, f.rg, f.dataNascimento, f.emailEmpresa, f.dataAdmissão, f.dataDemissao) from Funcionario f", Funcionario.class);
                funcionarios = q.getResultList();

                
        }catch (NoResultException e){
                return funcionarios;
        }

        return funcionarios;
        
    }

}
