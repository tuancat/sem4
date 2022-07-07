/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.booklibrary.configuration;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author cattuan
 */

@WebListener
public class ConfigListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ConfigListener is running...");
//        ServletContext ctx = sce.getServletContext();
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        EntityManagerFactory emf = InitConnection.getInstance().getEmf();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
