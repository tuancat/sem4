
package com.fsoft.ctc.assignment.optional.dao;

import com.fsoft.ctc.assignment.optional.Entity.SiteClass;
import com.fsoft.ctc.assignment.optional.Entity.Trainee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TraineeDao {
    private EntityManager em;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TraineeService");;

    public TraineeDao() {
        
    }
    public List<Trainee> findAll() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Trainee> result = em.createQuery("from Trainee", Trainee.class).getResultList();
//        em.
        em.getTransaction().commit();
        em.close();
        return result;
    }
    public List<Trainee> findBySiteClass(SiteClass siteClass) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Trainee> result = em.createQuery("Trainee.findBySiteClass", Trainee.class).setParameter("siteClass", siteClass).getResultList();
//        em.
        em.getTransaction().commit();
        em.close();
        return result;
    }
    public List<Trainee> findByfirstName(String firstName) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Trainee> result = em.createQuery("Trainee.findByName", Trainee.class).setParameter("firstName", firstName).getResultList();
//        em.
        em.getTransaction().commit();
        em.close();
        return result;
    }
    public Trainee findOne(Long id) {
        em = emf.createEntityManager();
        return em.find(Trainee.class, id);
    }
    public void createTrainee(Trainee t) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }
    public void updateTrainee(Trainee b ) {
        em = emf.createEntityManager();
        Trainee curr = em.find(Trainee.class, b.getId());
        em.getTransaction().begin();
        curr.setFirstName(b.getFirstName());
        curr.setLastName(b.getLastName());
        curr.setEmail(b.getEmail());
        em.getTransaction().commit();
    }
    public void deleteTrainee(Long id ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Trainee.class, id));
        em.getTransaction().commit();
    }
}
