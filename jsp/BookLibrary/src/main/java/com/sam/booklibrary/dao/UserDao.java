/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.booklibrary.dao;

import com.sam.booklibrary.configuration.InitConnection;
import com.sam.booklibrary.model.UserEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author tuanc
 */
public class UserDao {
    private static EntityManagerFactory emf = InitConnection.getInstance().getEmf();
    private static EntityManager em;

    public static void createUser(UserEntity u) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
    }

    public static List<UserEntity> findAll() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<UserEntity> result = em.createNamedQuery("UserEntity.findAll")
                .getResultList();
//        em.
        em.getTransaction().commit();
        em.close();
        return result;
    }
    public static UserEntity findOne(Long id) {
        em = emf.createEntityManager();
        return em.find(UserEntity.class, id);
    }
    public static UserEntity persitUser(UserEntity b) {
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
    public static void deleteUser(Long id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(UserEntity.class, id));
        em.getTransaction().commit();
    }
}
