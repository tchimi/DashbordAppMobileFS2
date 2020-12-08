/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.App.Dao;

import com.example.App.Entities.Etape;
import com.example.App.Entities.Note;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author MIKE
 */
public interface NoteRepository extends JpaRepository<Note, Integer> {
    
    @Query("select e.codeEtape from Etape e ")
    public List<String> listEtape ();
    
    @Query("select a.codeAnnee from Anneeacad a ")
    public List<String> listeAnneeacad();
    
    @Query("select s.codeSemestre from Semestre s")
    public List<String> listeSemestre();
   
}
