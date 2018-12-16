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
@Table(name = "PEAKFLOW")
@NamedQueries({
    @NamedQuery(name = "Peakflow.findAll", query = "SELECT p FROM Peakflow p")})
public class Peakflow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PF_ID")
    private Integer pfId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PF_VALUE")
    private int pfValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PF_DATE")
    @Temporal(TemporalType.DATE)
    private Date pfDate;
    @Size(max = 255)
    @Column(name = "PF_COMMENT")
    private String pfComment;

    public Peakflow() {
    }

    public Peakflow(Integer pfId) {
        this.pfId = pfId;
    }

    public Peakflow(Integer pfId, int pfValue, Date pfDate) {
        this.pfId = pfId;
        this.pfValue = pfValue;
        this.pfDate = pfDate;
    }

    public Integer getPfId() {
        return pfId;
    }

    public void setPfId(Integer pfId) {
        this.pfId = pfId;
    }

    public int getPfValue() {
        return pfValue;
    }

    public void setPfValue(int pfValue) {
        this.pfValue = pfValue;
    }

    public Date getPfDate() {
        return pfDate;
    }

    public void setPfDate(Date pfDate) {
        this.pfDate = pfDate;
    }

    public String getPfComment() {
        return pfComment;
    }

    public void setPfComment(String pfComment) {
        this.pfComment = pfComment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pfId != null ? pfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peakflow)) {
            return false;
        }
        Peakflow other = (Peakflow) object;
        if ((this.pfId == null && other.pfId != null) || (this.pfId != null && !this.pfId.equals(other.pfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samples.entity.Peakflow[ pfId=" + pfId + " ]";
    }
    
}
