/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ASW
 */
@Entity
@Table(name = "HUMIDITY")
@NamedQueries({
    @NamedQuery(name = "Humidity.findAll", query = "SELECT h FROM Humidity h")})
public class Humidity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HU_ID")
    private Integer huId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HU_VALUE")
    private int huValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HU_DATE")
    @Temporal(TemporalType.DATE)
    private Date huDate;
    @Size(max = 255)
    @Column(name = "HU_COMMENT")
    private String huComment;

    public Humidity() {
    }

    public Humidity(Integer huId) {
        this.huId = huId;
    }

    public Humidity(Integer huId, int huValue, Date huDate) {
        this.huId = huId;
        this.huValue = huValue;
        this.huDate = huDate;
    }

    public Integer getHuId() {
        return huId;
    }

    public void setHuId(Integer huId) {
        this.huId = huId;
    }

    public int getHuValue() {
        return huValue;
    }

    public void setHuValue(int huValue) {
        this.huValue = huValue;
    }

    public Date getHuDate() {
        return huDate;
    }

    public void setHuDate(Date huDate) {
        this.huDate = huDate;
    }

    public String getHuComment() {
        return huComment;
    }

    public void setHuComment(String huComment) {
        this.huComment = huComment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (huId != null ? huId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Humidity)) {
            return false;
        }
        Humidity other = (Humidity) object;
        if ((this.huId == null && other.huId != null) || (this.huId != null && !this.huId.equals(other.huId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samples.entity.Humidity[ huId=" + huId + " ]";
    }
    
}
