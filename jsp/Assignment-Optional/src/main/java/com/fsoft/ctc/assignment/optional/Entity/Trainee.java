/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsoft.ctc.assignment.optional.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "trainee")
@NamedQueries({
    @NamedQuery(name = "Trainee.findAll",
            query = "SELECT c FROM Trainee c")
    ,
    @NamedQuery(name = "Trainee.findByName",
            query = "SELECT c FROM Trainee c WHERE c.firstName = :firstName")
    ,
    @NamedQuery(name = "Trainee.findByEmail",
            query = "SELECT c FROM Trainee c WHERE c.email = :email")
    ,
        @NamedQuery(name = "Trainee.findBySiteClass",
            query = "SELECT c FROM Trainee c WHERE c.siteClass = :siteClass")
})
public class Trainee implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "email")
    private String email;
    @ManyToOne
    @JoinColumn(name = "site_id")
    private SiteClass siteClass;

    public SiteClass getSiteClass() {
        return siteClass;
    }

    public void setSiteClass(SiteClass siteClass) {
        this.siteClass = siteClass;
    }

    public Trainee() {
    }

    public Trainee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
