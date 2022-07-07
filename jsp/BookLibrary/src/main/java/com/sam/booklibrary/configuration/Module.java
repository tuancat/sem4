/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.booklibrary.configuration;

/**
 *
 * @author cattuan
 */
public enum Module {
    
    BOOKMANAGEMENT  ("BOOK"),  //calls constructor with value 3
//    MEDIUM(2),  //calls constructor with value 2
//    LOW   (1)   //calls constructor with value 1
    ; // semicolon needed when fields / methods f
    private final String module;

    private Module(String module) {
        this.module = module;
    }
}
