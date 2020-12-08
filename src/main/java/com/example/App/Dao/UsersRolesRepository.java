/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.App.Dao;

import com.example.App.Entities.UsersRoles;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author MIKE
 */
public interface UsersRolesRepository extends JpaRepository<UsersRoles, Integer> {
    
     @Query(value = "SELECT idusersroles FROM users_roles  WHERE users_username=:users_username",nativeQuery = true)
        public  List<Integer>getidbyusername (@Param(value = "users_username")String usersIduser);
    
}
