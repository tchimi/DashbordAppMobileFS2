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
@Table(name = "note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n"),
    @NamedQuery(name = "Note.findByIdnote", query = "SELECT n FROM Note n WHERE n.idnote = :idnote"),
    @NamedQuery(name = "Note.findByNamefile", query = "SELECT n FROM Note n WHERE n.namefile = :namefile")})
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnote")
    private Integer idnote;
    @Basic(optional = false)
    @Column(name = "namefile")
    private String namefile;
   
    @JoinColumn(name = "anneeacad_CODE_ANNEE", referencedColumnName = "CODE_ANNEE")
    @ManyToOne(optional = false)
    private Anneeacad anneeacadCODEANNEE;
    @JoinColumn(name = "etape_CODE_ETAPE", referencedColumnName = "CODE_ETAPE")
    @ManyToOne(optional = false)
    private Etape etapeCODEETAPE;
    @JoinColumn(name = "semestre_CODE_SEMESTRE", referencedColumnName = "CODE_SEMESTRE")
    @ManyToOne(optional = false)
    private Semestre semestreCODESEMESTRE;
    @JoinColumn(name = "user_username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Users userUsername;

    public Note() {
    }

    public Note(Integer idnote) {
        this.idnote = idnote;
    }

    public Note(Integer idnote, String namefile) {
        this.idnote = idnote;
        this.namefile = namefile;
    }

    public Integer getIdnote() {
        return idnote;
    }

    public void setIdnote(Integer idnote) {
        this.idnote = idnote;
    }

    public String getNamefile() {
        return namefile;
    }

    public void setNamefile(String namefile) {
        this.namefile = namefile;
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
        hash += (idnote != null ? idnote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.idnote == null && other.idnote != null) || (this.idnote != null && !this.idnote.equals(other.idnote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.App.Entities.Note[ idnote=" + idnote + " ]";
    }
    
}
