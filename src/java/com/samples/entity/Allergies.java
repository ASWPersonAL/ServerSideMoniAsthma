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
@Table(name = "ALLERGIES")
@NamedQueries({
    @NamedQuery(name = "Allergies.findAll", query = "SELECT a FROM Allergies a")})
public class Allergies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AL_ID")
    private Integer alId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AL_BIRKVALUE")
    private int alBirkvalue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AL_SAGEBRUSHVALUE")
    private int alSagebrushvalue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AL_ELMVALUE")
    private int alElmvalue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AL_ELVALUE")
    private int alElvalue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AL_GRASSVALUE")
    private int alGrassvalue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AL_DATE")
    @Temporal(TemporalType.DATE)
    private Date alDate;
    @Size(max = 255)
    @Column(name = "AL_COMMENT")
    private String alComment;

    public Allergies() {
    }

    public Allergies(Integer alId) {
        this.alId = alId;
    }

    public Allergies(Integer alId, int alBirkvalue, int alSagebrushvalue, int alElmvalue, int alElvalue, int alGrassvalue, Date alDate) {
        this.alId = alId;
        this.alBirkvalue = alBirkvalue;
        this.alSagebrushvalue = alSagebrushvalue;
        this.alElmvalue = alElmvalue;
        this.alElvalue = alElvalue;
        this.alGrassvalue = alGrassvalue;
        this.alDate = alDate;
    }

    public Integer getAlId() {
        return alId;
    }

    public void setAlId(Integer alId) {
        this.alId = alId;
    }

    public int getAlBirkvalue() {
        return alBirkvalue;
    }

    public void setAlBirkvalue(int alBirkvalue) {
        this.alBirkvalue = alBirkvalue;
    }

    public int getAlSagebrushvalue() {
        return alSagebrushvalue;
    }

    public void setAlSagebrushvalue(int alSagebrushvalue) {
        this.alSagebrushvalue = alSagebrushvalue;
    }

    public int getAlElmvalue() {
        return alElmvalue;
    }

    public void setAlElmvalue(int alElmvalue) {
        this.alElmvalue = alElmvalue;
    }

    public int getAlElvalue() {
        return alElvalue;
    }

    public void setAlElvalue(int alElvalue) {
        this.alElvalue = alElvalue;
    }

    public int getAlGrassvalue() {
        return alGrassvalue;
    }

    public void setAlGrassvalue(int alGrassvalue) {
        this.alGrassvalue = alGrassvalue;
    }

    public Date getAlDate() {
        return alDate;
    }

    public void setAlDate(Date alDate) {
        this.alDate = alDate;
    }

    public String getAlComment() {
        return alComment;
    }

    public void setAlComment(String alComment) {
        this.alComment = alComment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alId != null ? alId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Allergies)) {
            return false;
        }
        Allergies other = (Allergies) object;
        if ((this.alId == null && other.alId != null) || (this.alId != null && !this.alId.equals(other.alId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.samples.entity.Allergies[ alId=" + alId + " ]";
    }
    
}
