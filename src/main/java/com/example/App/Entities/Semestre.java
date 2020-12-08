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
@Table(name = "semestre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semestre.findAll", query = "SELECT s FROM Semestre s"),
    @NamedQuery(name = "Semestre.findByCodeSemestre", query = "SELECT s FROM Semestre s WHERE s.codeSemestre = :codeSemestre")})
public class Semestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE_SEMESTRE")
    private String codeSemestre;
  

    public Semestre() {
    }

    public Semestre(String codeSemestre) {
        this.codeSemestre = codeSemestre;
    }

    public String getCodeSemestre() {
        return codeSemestre;
    }

    public void setCodeSemestre(String codeSemestre) {
        this.codeSemestre = codeSemestre;
    }

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeSemestre != null ? codeSemestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semestre)) {
            return false;
        }
        Semestre other = (Semestre) object;
        if ((this.codeSemestre == null && other.codeSemestre != null) || (this.codeSemestre != null && !this.codeSemestre.equals(other.codeSemestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.App.Entities.Semestre[ codeSemestre=" + codeSemestre + " ]";
    }
    
}
