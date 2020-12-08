/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.App.Dao;

import com.example.App.Entities.Actualite;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author MIKE
 */
public interface ActualiteRepository extends JpaRepository<Actualite, Integer> {
    
}
