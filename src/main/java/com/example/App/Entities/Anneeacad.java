/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.App.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MIKE
 */
@Entity
@Table(name = "anneeacad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anneeacad.findAll", query = "SELECT a FROM Anneeacad a"),
    @NamedQuery(name = "Anneeacad.findByCodeAnnee", query = "SELECT a FROM Anneeacad a WHERE a.codeAnnee = :codeAnnee")})
public class Anneeacad implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE_ANNEE")
    private String codeAnnee;
    

    public Anneeacad() {
    }

    public Anneeacad(String codeAnnee) {
        this.codeAnnee = codeAnnee;
    }

    public String getCodeAnnee() {
        return codeAnnee;
    }

    public void setCodeAnnee(String codeAnnee) {
        this.codeAnnee = codeAnnee;
    }

   
   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeAnnee != null ? codeAnnee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anneeacad)) {
            return false;
        }
        Anneeacad other = (Anneeacad) object;
        if ((this.codeAnnee == null && other.codeAnnee != null) || (this.codeAnnee != null && !this.codeAnnee.equals(other.codeAnnee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.App.Entities.Anneeacad[ codeAnnee=" + codeAnnee + " ]";
    }

   
    
}
