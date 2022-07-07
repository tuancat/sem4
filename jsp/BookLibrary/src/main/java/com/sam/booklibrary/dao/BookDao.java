/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.booklibrary.dao;

import com.sam.booklibrary.configuration.InitConnection;
import com.sam.booklibrary.model.BookEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author cattuan
 */
public class BookDao {

    private static EntityManagerFactory emf = InitConnection.getInstance().getEmf();
    private static EntityManager em;

    public static void createBook(BookEntity b) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();
    }

    public static List<BookEntity> findAll() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<BookEntity> result = em.createNamedQuery("BookEntity.findAll")
                .getResultList();
//        em.
        em.getTransaction().commit();
        em.close();
        return result;
    }
    public static BookEntity findOne(Long id) {
        em = emf.createEntityManager();
        return em.find(BookEntity.class, id);
    }
    public static BookEntity persitBook(BookEntity b) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        if (b.getId() == null) {
            em.persist(b);
        } else {
            em.merge(b);
        }
        
        em.getTransaction().commit();
        return b;
    }
    public static void deleteBook(Long id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(BookEntity.class, id));
        em.getTransaction().commit();
    }
}
