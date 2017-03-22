package com.jfra.crm.quality.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jfra.crmquality.entidade.Setor;

public class SetorDAOImpl implements SetorDAO{

    @PersistenceContext(unitName = "liquor")
    private EntityManager em;
	
    
	@Override
	public Setor salvarSetor(Setor setor) {
		
		em.persist(setor);
		
		return setor;
	}
	
	

}
