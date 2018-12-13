/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ASW
 */
@Entity
@Table(name = "BASELINE")
@NamedQueries({
    @NamedQuery(name = "Baseline.findAll", query = "SELECT b FROM Baseline b")})
public class Baseline implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BA_ID")
    private Integer baId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BA_VALUE")
    private int baValue;
    @Size(max = 30)
    @Column(name = "BA_DATE")
    private String baDate;

    public Baseline() {
    }

    public Baseline(Integer baId) {
        this.baId = baId;
    }

    public Baseline(Integer baId, int baValue) {
        this.baId = baId;
        this.baValue = baValue;
    }

    public Integer getBaId() {
        return baId;
    }

    public void setBaId(Integer baId) {
        this.baId = baId;
    }

    public int getBaValue() {
        return baValue;
    }

    public void setBaValue(int baValue) {
        this.baValue = baValue;
    }

    public String getBaDate() {
        return baDate;
    }

    public void setBaDate(String baDate) {
        this.baDate = baDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (baId != null ? baId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Baseline)) {
            return false;
        }
        Baseline other = (Baseline) object;
        if ((this.baId == null && other.baId != null) || (this.baId != null && !this.baId.equals(other.baId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samples.entity.Baseline[ baId=" + baId + " ]";
    }
    
}
