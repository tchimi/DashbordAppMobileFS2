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
@Table(name = "emploitemps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emploitemps.findAll", query = "SELECT e FROM Emploitemps e"),
    @NamedQuery(name = "Emploitemps.findByIdemploitemps", query = "SELECT e FROM Emploitemps e WHERE e.idemploitemps = :idemploitemps"),
    @NamedQuery(name = "Emploitemps.findByNamefile", query = "SELECT e FROM Emploitemps e WHERE e.namefile = :namefile"),
    @NamedQuery(name = "Emploitemps.findByEmploitempscol", query = "SELECT e FROM Emploitemps e WHERE e.emploitempscol = :emploitempscol")})
public class Emploitemps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idemploitemps")
    private Integer idemploitemps;
    @Basic(optional = false)
    @Column(name = "namefile")
    private String namefile;
    @Column(name = "emploitempscol")
    private String emploitempscol;
   
   
    @JoinColumn(name = "anneeacad_CODE_ANNEE", referencedColumnName = "CODE_ANNEE")
    @ManyToOne(optional = false)
    private Anneeacad anneeacadCODEANNEE;
    @JoinColumn(name = "etape_CODE_ETAPE", referencedColumnName = "CODE_ETAPE")
    @ManyToOne
    private Etape etapeCODEETAPE;
    @JoinColumn(name = "semestre_CODE_SEMESTRE", referencedColumnName = "CODE_SEMESTRE")
    @ManyToOne(optional = false)
    private Semestre semestreCODESEMESTRE;
    @JoinColumn(name = "user_username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Users userUsername;

    public Emploitemps() {
    }

    public Emploitemps(Integer idemploitemps) {
        this.idemploitemps = idemploitemps;
    }

    public Emploitemps(Integer idemploitemps, String namefile) {
        this.idemploitemps = idemploitemps;
        this.namefile = namefile;
    }

    public Integer getIdemploitemps() {
        return idemploitemps;
    }

    public void setIdemploitemps(Integer idemploitemps) {
        this.idemploitemps = idemploitemps;
    }

    public String getNamefile() {
        return namefile;
    }

    public void setNamefile(String namefile) {
        this.namefile = namefile;
    }

    public String getEmploitempscol() {
        return emploitempscol;
    }

    public void setEmploitempscol(String emploitempscol) {
        this.emploitempscol = emploitempscol;
    }

   

    public Anneeacad getAnneeacadCODEANNEE() {
        return anneeacadCODEANNEE;
    }

    public void setAnneeacadCODEANNEE(Anneeacad anneeacadCODEANNEE) {
        this.anneeacadCODEANNEE = anneeacadCODEANNEE;
    }

    public Etape getEtapeCODEETAPE() {
        return etapeCODEETAPE;
    }

    public void setEtapeCODEETAPE(Etape etapeCODEETAPE) {
        this.etapeCODEETAPE = etapeCODEETAPE;
    }

    public Semestre getSemestreCODESEMESTRE() {
        return semestreCODESEMESTRE;
    }

    public void setSemestreCODESEMESTRE(Semestre semestreCODESEMESTRE) {
        this.semestreCODESEMESTRE = semestreCODESEMESTRE;
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
        hash += (idemploitemps != null ? idemploitemps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emploitemps)) {
            return false;
        }
        Emploitemps other = (Emploitemps) object;
        if ((this.idemploitemps == null && other.idemploitemps != null) || (this.idemploitemps != null && !this.idemploitemps.equals(other.idemploitemps))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.App.Entities.Emploitemps[ idemploitemps=" + idemploitemps + " ]";
    }
    
}
