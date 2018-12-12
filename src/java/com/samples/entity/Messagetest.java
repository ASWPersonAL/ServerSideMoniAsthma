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
import javax.validation.constraints.Size;

/**
 *
 * @author ASW
 */
@Entity
@Table(name = "MESSAGETEST")
@NamedQueries({
    @NamedQuery(name = "Messagetest.findAll", query = "SELECT m FROM Messagetest m")})
public class Messagetest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ME_ID")
    private Integer meId;
    @Size(max = 255)
    @Column(name = "ME_MESSAGE")
    private String meMessage;

    public Messagetest() {
    }

    public Messagetest(Integer meId) {
        this.meId = meId;
    }

    public Integer getMeId() {
        return meId;
    }

    public void setMeId(Integer meId) {
        this.meId = meId;
    }

    public String getMeMessage() {
        return meMessage;
    }

    public void setMeMessage(String meMessage) {
        this.meMessage = meMessage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (meId != null ? meId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Messagetest)) {
            return false;
        }
        Messagetest other = (Messagetest) object;
        if ((this.meId == null && other.meId != null) || (this.meId != null && !this.meId.equals(other.meId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samples.entity.Messagetest[ meId=" + meId + " ]";
    }
    
}
