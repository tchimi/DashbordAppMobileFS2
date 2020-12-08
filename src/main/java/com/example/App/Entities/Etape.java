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
@Table(name = "etape")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etape.findAll", query = "SELECT e FROM Etape e"),
    @NamedQuery(name = "Etape.findByCodeEtape", query = "SELECT e FROM Etape e WHERE e.codeEtape = :codeEtape"),
    @NamedQuery(name = "Etape.findByLibelleEtape", query = "SELECT e FROM Etape e WHERE e.libelleEtape = :libelleEtape")})
public class Etape implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE_ETAPE")
    private String codeEtape;
    @Basic(optional = false)
    @Column(name = "LIBELLE_ETAPE")
    private String libelleEtape;
   

    public Etape() {
    }

    public Etape(String codeEtape) {
        this.codeEtape = codeEtape;
    }

    public Etape(String codeEtape, String libelleEtape) {
        this.codeEtape = codeEtape;
        this.libelleEtape = libelleEtape;
    }

    public String getCodeEtape() {
        return codeEtape;
    }

    public void setCodeEtape(String codeEtape) {
        this.codeEtape = codeEtape;
    }

    public String getLibelleEtape() {
        return libelleEtape;
    }

    public void setLibelleEtape(String libelleEtape) {
        this.libelleEtape = libelleEtape;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeEtape != null ? codeEtape.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etape)) {
            return false;
        }
        Etape other = (Etape) object;
        if ((this.codeEtape == null && other.codeEtape != null) || (this.codeEtape != null && !this.codeEtape.equals(other.codeEtape))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.App.Entities.Etape[ codeEtape=" + codeEtape + " ]";
    }
    
}
