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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "actualite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actualite.findAll", query = "SELECT a FROM Actualite a"),
    @NamedQuery(name = "Actualite.findByIdactualite", query = "SELECT a FROM Actualite a WHERE a.idactualite = :idactualite"),
    @NamedQuery(name = "Actualite.findByMessage", query = "SELECT a FROM Actualite a WHERE a.message = :message"),
    @NamedQuery(name = "Actualite.findByTitre", query = "SELECT a FROM Actualite a WHERE a.titre = :titre")})
public class Actualite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idactualite")
    private Integer idactualite;
    @Basic(optional = false)
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @Column(name = "titre")
    private String titre;
    @Basic(optional = false)
    @Lob
    @Column(name = "namefile")
    private String namefile;
    @JoinTable(name = "etudiant_has_actualite", joinColumns = {
        @JoinColumn(name = "actualite_idactualite", referencedColumnName = "idactualite")}, inverseJoinColumns = {
        @JoinColumn(name = "etudiant_idetudiant", referencedColumnName = "idetudiant")})
   
    @JoinColumn(name = "user_username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Users userUsername;

    public Actualite() {
    }

    public Actualite(Integer idactualite) {
        this.idactualite = idactualite;
    }

    public Actualite(Integer idactualite, String message, String titre, String namefile) {
        this.idactualite = idactualite;
        this.message = message;
        this.titre = titre;
        this.namefile = namefile;
    }

    public Integer getIdactualite() {
        return idactualite;
    }

    public void setIdactualite(Integer idactualite) {
        this.idactualite = idactualite;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNamefile() {
        return namefile;
    }

    public void setNamefile(String namefile) {
        this.namefile = namefile;
    }

   

    public Users getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(Users userUsername) {
        this.userUsername = userUsername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactualite != null ? idactualite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actualite)) {
            return false;
        }
        Actualite other = (Actualite) object;
        if ((this.idactualite == null && other.idactualite != null) || (this.idactualite != null && !this.idactualite.equals(other.idactualite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.App.Entities.Actualite[ idactualite=" + idactualite + " ]";
    }
    
}
