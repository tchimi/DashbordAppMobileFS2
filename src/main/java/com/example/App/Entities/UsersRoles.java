/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.App.Entities;

import com.sun.istack.NotNull;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Chieko Topa
 */
@Entity
@Table(name = "users_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersRoles.findAll", query = "SELECT u FROM UsersRoles u")})
public class UsersRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusersroles")
    private Integer idusersroles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "roles_role")
    private String rolesRole;
    @Basic(optional = false)
    @NotNull  
    @Column(name = "users_username")
    private String usersUsername;

    public UsersRoles() {
    }

    public UsersRoles(Integer idusersroles) {
        this.idusersroles = idusersroles;
    }

    public UsersRoles(Integer idusersroles, String rolesRole, String usersUsername) {
        this.idusersroles = idusersroles;
        this.rolesRole = rolesRole;
        this.usersUsername = usersUsername;
    }

    public Integer getIdusersroles() {
        return idusersroles;
    }

    public void setIdusersroles(Integer idusersroles) {
        this.idusersroles = idusersroles;
    }

    public String getRolesRole() {
        return rolesRole;
    }

    public void setRolesRole(String rolesRole) {
        this.rolesRole = rolesRole;
    }

    public String getUsersUsername() {
        return usersUsername;
    }

    public void setUsersUsername(String usersUsername) {
        this.usersUsername = usersUsername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusersroles != null ? idusersroles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersRoles)) {
            return false;
        }
        UsersRoles other = (UsersRoles) object;
        if ((this.idusersroles == null && other.idusersroles != null) || (this.idusersroles != null && !this.idusersroles.equals(other.idusersroles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.logbook.book.entities.UsersRoles[ idusersroles=" + idusersroles + " ]";
    }
    
}
