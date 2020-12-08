/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.App.Dao;

import com.example.App.Entities.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author MIKE
 */
public interface UsersRepository extends JpaRepository<Users, String> {
    
    @Query(value = "Select roles_role  from users_roles where users_username=:usersname",nativeQuery = true )
        public List<String>getlistRoleforUsers(@Param(value = "usersname") String usersIduser);
    
    @Query(value = "Select u from Users u where u.username=:username")
        public Users getUserByUsername(@Param(value = "username")String username);
   
}
