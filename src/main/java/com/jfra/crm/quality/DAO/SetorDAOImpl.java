package com.jfra.crm.quality.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.jfra.crmquality.entidade.Setor;
import javax.enterprise.context.ApplicationScoped;


 @ApplicationScoped
public class SetorDAOImpl implements SetorDAO{

    @PersistenceContext(unitName = "liquor")
    private EntityManager em;
    
    public SetorDAOImpl(){
        
    }
	
    
	@Override
	public Setor salvarSetor(Setor setor) {
		
		em.persist(setor);
		
		return setor;
	}


	@Override
	public Setor editarSetor(Setor setor) {
		
		return em.merge(setor);
	}


	@Override
	public List<Setor> listaTodosSetores() {
		
		List<Setor> setores = new ArrayList<Setor>();
		
		try{
			setores = em.createNamedQuery("Setor.findAll").getResultList();
		}catch(NoResultException e){
			return setores;
		}
		
		return setores;
	}


	@Override
	public Setor buscaSetorID(int id) {
		
		Setor setor = new Setor();
		
		try{
			setor = (Setor) em.createNamedQuery("Setor.findByIdSetor").setParameter("idSetor", id).getSingleResult();
		}catch(NoResultException e){
			return setor;
		}
		
		return setor;
	}


	@Override
	public void deletaSetor(Setor setor) {

		em.remove(setor);
		
	}
	
	

}
