/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.App.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "niveau")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Niveau.findAll", query = "SELECT n FROM Niveau n"),
    @NamedQuery(name = "Niveau.findByCodeNiveau", query = "SELECT n FROM Niveau n WHERE n.codeNiveau = :codeNiveau")})
public class Niveau implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE_NIVEAU")
    private String codeNiveau;

    public Niveau() {
    }

    public Niveau(String codeNiveau) {
        this.codeNiveau = codeNiveau;
    }

    public String getCodeNiveau() {
        return codeNiveau;
    }

    public void setCodeNiveau(String codeNiveau) {
        this.codeNiveau = codeNiveau;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeNiveau != null ? codeNiveau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveau)) {
            return false;
        }
        Niveau other = (Niveau) object;
        if ((this.codeNiveau == null && other.codeNiveau != null) || (this.codeNiveau != null && !this.codeNiveau.equals(other.codeNiveau))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.App.Entities.Niveau[ codeNiveau=" + codeNiveau + " ]";
    }

}
