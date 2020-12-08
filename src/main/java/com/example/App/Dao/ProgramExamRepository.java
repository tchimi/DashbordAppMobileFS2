/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.App.Dao;

import com.example.App.Entities.Programexam;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author MIKE
 */
public interface ProgramExamRepository extends JpaRepository<Programexam, Integer> {
    
     @Query("select n.codeNiveau from Niveau n")
    public List<String> listeNiveau();
    
}
