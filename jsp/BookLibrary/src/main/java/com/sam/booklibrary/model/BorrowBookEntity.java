/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.booklibrary.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author tuan
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "BorrowBookEntity.findAll",
            query = "SELECT b FROM BorrowBookEntity b"),
    @NamedQuery(name = "BorrowBookEntity.findByUserId",
            query = "SELECT b FROM BorrowBookEntity b WHERE b.userId = :userId"),
    
})
public class BorrowBookEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "userid")
    private Long userId;
    
    @Column(name = "bookid")
    private Long bookId;
    @Column(name = "currtime")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date currTime;

    public BorrowBookEntity() {
    }

    public BorrowBookEntity(Long userId, Long bookId, Date currTime) {
        this.userId = userId;
        this.bookId = bookId;
        this.currTime = currTime;
    }

    
    
    
    
    public Date getCurrTime() {
        return currTime;
    }

    public void setCurrTime(Date currTime) {
        this.currTime = currTime;
    }
    
    

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BorrowBookEntity)) {
            return false;
        }
        BorrowBookEntity other = (BorrowBookEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sam.booklibrary.model.BorrowBookEntity[ id=" + id + " ]";
    }
    
}
