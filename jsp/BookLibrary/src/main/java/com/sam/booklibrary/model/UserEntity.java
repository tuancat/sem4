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

/**
 *
 * @author tuanc
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "UserEntity.findAll",
            query = "SELECT u FROM UserEntity u"),
    @NamedQuery(name = "UserEntity.findByUsername",
            query = "SELECT u FROM UserEntity u WHERE u.userName = :userName"),
    @NamedQuery(name = "UserEntity.checkLogin",
            query = "SELECT u FROM UserEntity u WHERE u.userName = :userName and u.password = :password"),
})
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "userName", nullable = false, length = 255)
    private String userName;
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Column(name = "fullName", nullable = false, length = 255)
    private String fullName;

    public UserEntity() {
    }

    public UserEntity(Long id, String userName, String password, String fullName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
    }

    public UserEntity(String userName, String password, String fullName) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sam.booklibrary.model.UserEntity[ id=" + id + " ]";
    }
    
}
