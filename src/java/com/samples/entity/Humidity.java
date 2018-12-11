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
    @Column(name = "H_ID")
    private Integer hId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "H_VALUE")
    private int hValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "H_DATE")
    @Temporal(TemporalType.DATE)
    private Date hDate;
    @Size(max = 255)
    @Column(name = "H_COMMENT")
    private String hComment;

    public Humidity() {
    }

    public Humidity(Integer hId) {
        this.hId = hId;
    }

    public Humidity(Integer hId, int hValue, Date hDate) {
        this.hId = hId;
        this.hValue = hValue;
        this.hDate = hDate;
    }

    public Integer getHId() {
        return hId;
    }

    public void setHId(Integer hId) {
        this.hId = hId;
    }

    public int getHValue() {
        return hValue;
    }

    public void setHValue(int hValue) {
        this.hValue = hValue;
    }

    public Date getHDate() {
        return hDate;
    }

    public void setHDate(Date hDate) {
        this.hDate = hDate;
    }

    public String getHComment() {
        return hComment;
    }

    public void setHComment(String hComment) {
        this.hComment = hComment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hId != null ? hId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Humidity)) {
            return false;
        }
        Humidity other = (Humidity) object;
        if ((this.hId == null && other.hId != null) || (this.hId != null && !this.hId.equals(other.hId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samples.entity.Humidity[ hId=" + hId + " ]";
    }
    
}
