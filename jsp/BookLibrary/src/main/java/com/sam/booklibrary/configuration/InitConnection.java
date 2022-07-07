/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.booklibrary.configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cattuan
 */
public class InitConnection {
    private static InitConnection instance = new InitConnection();
    private EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("BookPU");
    
    private InitConnection() {
        System.out.println("Init connection");
    }
    
    public static InitConnection getInstance() {
        return instance;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    
}
