/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.booklibrary.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author tuan
 */
public class BorrowModel implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long id;
    private UserEntity user;
    private BookEntity book;
    private Date currTime;

    public BorrowModel() {
    }

    public BorrowModel(Long id, UserEntity user, BookEntity book, Date currTime) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.currTime = currTime;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public Date getCurrTime() {
        return currTime;
    }

    public void setCurrTime(Date currTime) {
        this.currTime = currTime;
    }
    
    
    
}
