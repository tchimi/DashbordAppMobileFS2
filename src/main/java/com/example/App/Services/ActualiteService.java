/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.App.Services;

import com.example.App.Dao.ActualiteRepository;
import com.example.App.Dao.UsersRepository;
import com.example.App.Entities.Actualite;
import com.example.App.Entities.Emploitemps;
import com.example.App.Entities.Users;
import com.example.App.domain.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author MIKE
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ActualiteService {
    
  @Autowired
  ActualiteRepository actualiteRepository;
  @Autowired
  UsersRepository userRepository;
  
  @Value("${dirActualite}")
    String dirActualite;
  
    @RequestMapping(value = "/saveActualite", method = RequestMethod.POST)
    public ResponseEntity<Response> saveEmploiTemps(@RequestParam("actualite") String actualite,@RequestParam("file") MultipartFile file) throws JsonProcessingException, IOException {
        
        Actualite actualite1 = new ObjectMapper().readValue(actualite, Actualite.class);
        Users user = new Users();
        user=userRepository.getOne("mike");
        //System.out.println(note1.getAnneeacademie);
        
        actualite1.setUserUsername(user);
        actualite1.setNamefile(file.getOriginalFilename());
         System.out.println(file.getOriginalFilename());
         //System.out.println(note1.getFiliere());
        file.transferTo(new File(dirActualite+file.getOriginalFilename()));
        actualiteRepository.save(actualite1);
     
        return new ResponseEntity<Response>(new Response(""),HttpStatus.OK);
    }
    
    
}
