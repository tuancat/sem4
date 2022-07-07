/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsoft.ctc.assignment.optional.dao;

import com.fsoft.ctc.assignment.optional.Entity.SiteClass;
import com.fsoft.ctc.assignment.optional.Entity.Trainee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cattuan
 */
public class SiteClassDao {
    private EntityManager em;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TraineeService");;

    public SiteClassDao() {
        
    }
    public List<SiteClass> findAll() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<SiteClass> result = em.createQuery("from SiteClass", SiteClass.class).getResultList();
//        em.
        em.getTransaction().commit();
        em.close();
        return result;
    }
    public SiteClass findOne(Long id) {
        em = emf.createEntityManager();
        return em.find(SiteClass.class, id);
    }
    public void createSiteClass(SiteClass t) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }
    public void updateSiteClass(SiteClass b ) {
        em = emf.createEntityManager();
        SiteClass curr = em.find(SiteClass.class, b.getId());
        em.getTransaction().begin();
        curr.setName(b.getName());
        em.getTransaction().commit();
    }
    public void deleteSiteClass(Long id ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(SiteClass.class, id));
        em.getTransaction().commit();
    }
}
