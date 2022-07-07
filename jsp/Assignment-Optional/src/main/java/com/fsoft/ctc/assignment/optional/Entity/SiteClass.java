/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsoft.ctc.assignment.optional.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author tuancat
 */
@Entity
@Table(name = "siteclass")
public class SiteClass implements Serializable {
    private Long id;
    private String name;
    private List<Trainee> listTrainee ;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "siteClass", cascade = CascadeType.ALL)
    public List<Trainee> getListTrainee() {
        return listTrainee;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public void setListTrainee(List<Trainee> listTrainee) {
        this.listTrainee = listTrainee;
    }
//    
    
    
}
