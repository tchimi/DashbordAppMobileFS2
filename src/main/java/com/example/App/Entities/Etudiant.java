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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MIKE
 */
@Entity
@Table(name = "etudiant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e"),
    @NamedQuery(name = "Etudiant.findByIdetudiant", query = "SELECT e FROM Etudiant e WHERE e.idetudiant = :idetudiant"),
    @NamedQuery(name = "Etudiant.findByNom", query = "SELECT e FROM Etudiant e WHERE e.nom = :nom"),
    @NamedQuery(name = "Etudiant.findByMatricule", query = "SELECT e FROM Etudiant e WHERE e.matricule = :matricule")})
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idetudiant")
    private Integer idetudiant;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "matricule")
    private String matricule;
   

    public Etudiant() {
    }

    public Etudiant(Integer idetudiant) {
        this.idetudiant = idetudiant;
    }

    public Etudiant(Integer idetudiant, String nom, String matricule) {
        this.idetudiant = idetudiant;
        this.nom = nom;
        this.matricule = matricule;
    }

    public Integer getIdetudiant() {
        return idetudiant;
    }

    public void setIdetudiant(Integer idetudiant) {
        this.idetudiant = idetudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idetudiant != null ? idetudiant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.idetudiant == null && other.idetudiant != null) || (this.idetudiant != null && !this.idetudiant.equals(other.idetudiant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.App.Entities.Etudiant[ idetudiant=" + idetudiant + " ]";
    }
    
}
