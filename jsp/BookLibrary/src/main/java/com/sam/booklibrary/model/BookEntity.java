/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.booklibrary.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author cattuan
 */
@Entity
@Table(name = "book")
@NamedQueries({
    @NamedQuery(name = "BookEntity.findAll",
            query = "SELECT b FROM BookEntity b"),})
public class BookEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    @Column(name = "description", nullable = false, length = 255)
    private String description;
    @Column(name = "author", nullable = false, length = 255)
    private String author;
    @Column(name = "url", nullable = false, length = 255)
    private String url;

    public BookEntity() {
    }
    
    

    public BookEntity(Long id, String title, String description, String author, String url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.url = url;
    }

    public BookEntity(String title, String description, String author, String url) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.url = url;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookEntity)) {
            return false;
        }
        BookEntity other = (BookEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sam.booklibrary.model.BookEntity[ id=" + id + " ]";
    }

}
