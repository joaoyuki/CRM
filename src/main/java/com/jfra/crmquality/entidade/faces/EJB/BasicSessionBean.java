package com.jfra.crmquality.entidade.faces.EJB;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Joao
 */
//JPA exige que seja serializable
public abstract class BasicSessionBean implements Serializable{ //Abistract para não ficar implementando
    
    private static final long serialVersionUID = 1L;
    
    @PersistenceContext(unitName = "liquor")
    private EntityManager em; //Vai ser injetado diretamente
    
    public final static boolean debug = false;
    
    //COnstrutor público
    public BasicSessionBean(){
        
    }
    
    public EntityManager getEm(){
        return em;
    }
    
    //Retorna uma lista de objetos
    public <T> List<T> getList (Class<T> classToCast, String query, Object... values){
        
        Query qr = createQuery(query, values);
        return qr.getResultList();
        
    }
    
    public <T> List<T> getLimitedList (Class<T> classToCast, String query, int limit ,Object... values){
        
        Query qr = createQuery(query, values);
        qr.setMaxResults(limit);
        return qr.getResultList();
        
    }
    
    public <T> List<T> getNamedList (Class<T> classToCast, String namedQuery, Object... values){
        
        Query qr = em.createNamedQuery(namedQuery);
         if (values != null){
            for (int i = 0; i < values.length ; i++){
                Object object = values[i];
                qr.setParameter(i+1, object);
            }
        }
        return qr.getResultList();
        
    }
    
    //Retorna apenas um objeto
    public <T> T getPojo(Class<T> classToCast, String query, Object... values){
        Query qr = createQuery(query, values);
        return (T) qr.getSingleResult();
    }
    
    public <T> T getPojo(Class<T> classToCast, Serializable primaryKey){
        return em.find(classToCast, primaryKey);
    }
    
    //Executa comandos insert e update
    public int executeQuery(String query, Object... values){
        Query qr = createQuery(query, values);
        return qr.executeUpdate();
    }

    //Método criado para criar querys dinâmicas
    private Query createQuery(String query, Object[] values) {
        Query qr = em.createQuery(query);
        if (values != null){
            for (int i = 0; i < values.length ; i++){
                Object object = values[i];
                qr.setParameter(i+1, object);
            }
        }
        return qr;
    }
    
    
    
}
