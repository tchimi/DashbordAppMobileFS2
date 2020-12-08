/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.App.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MIKE
 */
@Entity
@Table(name = "programexam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programexam.findAll", query = "SELECT p FROM Programexam p"),
    @NamedQuery(name = "Programexam.findByIdprogramexam", query = "SELECT p FROM Programexam p WHERE p.idprogramexam = :idprogramexam"),
    @NamedQuery(name = "Programexam.findByNamefile", query = "SELECT p FROM Programexam p WHERE p.namefile = :namefile")})
public class Programexam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprogramexam")
    private Integer idprogramexam;
    @Basic(optional = false)
    @Column(name = "namefile")
    private String namefile;
    @JoinColumn(name = "etape_CODE_ETAPE", referencedColumnName = "CODE_ETAPE")
    @ManyToOne
    private Etape etapeCODEETAPE;
    @JoinColumn(name = "niveau_CODE_NIVEAU", referencedColumnName = "CODE_NIVEAU")
    @ManyToOne
    private Niveau niveauCODENIVEAU;
    @JoinColumn(name = "anneeacad_CODE_ANNEE", referencedColumnName = "CODE_ANNEE")
    @ManyToOne(optional = false)
    private Anneeacad anneeacadCODEANNEE;
    @JoinColumn(name = "semestre_CODE_SEMESTRE", referencedColumnName = "CODE_SEMESTRE")
    @ManyToOne(optional = false)
    private Semestre semestreCODESEMESTRE;
    @JoinColumn(name = "user_username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Users userUsername;

    public Programexam() {
    }

    public Programexam(Integer idprogramexam) {
        this.idprogramexam = idprogramexam;
    }

    public Programexam(Integer idprogramexam, String namefile) {
        this.idprogramexam = idprogramexam;
        this.namefile = namefile;
    }

    public Integer getIdprogramexam() {
        return idprogramexam;
    }

    public void setIdprogramexam(Integer idprogramexam) {
        this.idprogramexam = idprogramexam;
    }

    public String getNamefile() {
        return namefile;
    }

    public void setNamefile(String namefile) {
        this.namefile = namefile;
    }

    public Etape getEtapeCODEETAPE() {
        return etapeCODEETAPE;
    }

    public void setEtapeCODEETAPE(Etape etapeCODEETAPE) {
        this.etapeCODEETAPE = etapeCODEETAPE;
    }

    public Niveau getNiveauCODENIVEAU() {
        return niveauCODENIVEAU;
    }

    public void setNiveauCODENIVEAU(Niveau niveauCODENIVEAU) {
        this.niveauCODENIVEAU = niveauCODENIVEAU;
    }

    public Anneeacad getAnneeacadCODEANNEE() {
        return anneeacadCODEANNEE;
    }

    public void setAnneeacadCODEANNEE(Anneeacad anneeacadCODEANNEE) {
        this.anneeacadCODEANNEE = anneeacadCODEANNEE;
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
        hash += (idprogramexam != null ? idprogramexam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programexam)) {
            return false;
        }
        Programexam other = (Programexam) object;
        if ((this.idprogramexam == null && other.idprogramexam != null) || (this.idprogramexam != null && !this.idprogramexam.equals(other.idprogramexam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.App.Entities.Programexam[ idprogramexam=" + idprogramexam + " ]";
    }
    
}
