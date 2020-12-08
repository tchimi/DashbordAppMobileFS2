/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.App.Dao;

import com.example.App.Entities.Emploitemps;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author MIKE
 */
public interface EmploiTempsRepository extends JpaRepository<Emploitemps, Integer> {
   
     @Query("select a.codeAnnee from Anneeacad a ")
        public List<String> listeAnneeacad();
    
}
