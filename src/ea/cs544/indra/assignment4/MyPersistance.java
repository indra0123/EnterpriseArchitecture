/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.cs544.indra.assignment4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author indra
 */
public class MyPersistance {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    public MyPersistance(String persistenceUnitName) {
        init(persistenceUnitName);
    }

    private void init(String persistenceUnitName) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        this.em = emf.createEntityManager();
    }

    private void start(String persistenceUnitName) {
        if (em == null) {
            init(persistenceUnitName);
        }
    }

    public <T> void persist(T t) {
        tx = em.getTransaction();
        tx.begin();
        em.persist(t);
        tx.commit();
    }

    public <T> T get(Class<T> t, long id) {
        return em.find(t, id);
    }

    public <T> boolean delete(Class<T> t, long id) {
        T loadedT = get(t, id);
        if (loadedT != null) {
            tx = em.getTransaction();
            tx.begin();
            em.remove(loadedT);
            tx.commit();
            return true;
        }
        return false;
    }
    
    public <T> void printDataFromDatabase(Class<T>  aClass, String tableName) {
       
        TypedQuery<T> q = em.createQuery("SELECT p FROM "+tableName+" p", aClass);
        q.getResultList().stream().forEach((person) -> {
            System.out.println(person);
        });
    }

    private void close() {
        em = null;
        em.close();
        emf.close();
    }
}
