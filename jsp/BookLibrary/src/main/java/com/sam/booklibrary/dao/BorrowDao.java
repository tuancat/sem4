/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.booklibrary.dao;

import com.sam.booklibrary.configuration.InitConnection;
import com.sam.booklibrary.model.BorrowBookEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author tuan
 */
public class BorrowDao {
    private static EntityManagerFactory emf = InitConnection.getInstance().getEmf();
    private static EntityManager em;

    public static void createBorrowBook(BorrowBookEntity b) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();
    }
    
    public static List<BorrowBookEntity> findAll() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<BorrowBookEntity> result = em.createNamedQuery("BorrowBookEntity.findAll")
                .getResultList();
//        em.
        em.getTransaction().commit();
        em.close();
        return result;
    }
    
    public static List<BorrowBookEntity> findBorrowBookByUserId(Long userId) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<BorrowBookEntity> result = em.createNamedQuery("BorrowBookEntity.findByUserId").setParameter("userId", userId)
                .getResultList();
//        em.
        em.getTransaction().commit();
        em.close();
        return result;
    }
}
