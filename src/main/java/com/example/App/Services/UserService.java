/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.App.Services;

import com.example.App.Dao.RoleRepository;
import com.example.App.Dao.UsersRepository;
import com.example.App.Dao.UsersRolesRepository;
import com.example.App.Entities.Note;
import com.example.App.Entities.Role;
import com.example.App.Entities.Users;
import com.example.App.domain.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author MIKE
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class UserService {
    
    @Autowired
    UsersRepository usersRepository;
     @Autowired
    RoleRepository roleRepository;
    
    @Autowired
    UsersRolesRepository usersRoleRepository;
    
    
     @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ResponseEntity<Response> saveNote(@RequestBody Users user) throws JsonProcessingException, IOException {
     
        usersRepository.save(user);
     
        return new ResponseEntity<Response>(new Response(""),HttpStatus.OK);
    }
    
     @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(@RequestBody Note note, @RequestBody User user) throws JsonProcessingException, IOException {
         System.out.println(note.getNamefile());
         System.out.println(user.getName());
         
        return "ok";
    }
    
    //   pour recuperer un utilsateur connecté
    @RequestMapping(value = "/getLogeUser", method=RequestMethod.GET)
    public Map<String, Object>getLogeUser(HttpServletRequest httpServletRequest){
        HttpSession httpSession=httpServletRequest.getSession();
        SecurityContext securityContext=(SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
        String username=securityContext.getAuthentication().getName();
        List<String>roles=new ArrayList<String>();
        for(GrantedAuthority ga:securityContext.getAuthentication().getAuthorities()){
            roles.add(ga.getAuthority());
        }
        Map<String ,Object>params=new HashMap<>();
        params.put("username",username);
        params.put("roles", roles);
        return params;
    }
    
    @RequestMapping(value = "/listUser")
    public List<Users> listUtilisateur() {
        return usersRepository.findAll();

    }
    
    @RequestMapping(value = "/addRoleToUser/{username}/{roles}", method = RequestMethod.GET)
    public void addRoleToUser(@PathVariable(value = "username") String username, @PathVariable(value = "roles") List<String> roles) {
        Users user = usersRepository.getOne(username);
        List<Integer> listeid = usersRoleRepository.getidbyusername(username);
        for (Integer integer : listeid) {
            usersRoleRepository.deleteById(integer);
        }
        for (String r : roles) {
            Role role = roleRepository.getOne(r);
            user.getRoles().add(role);
        }

        usersRepository.save(user);

    }
    
   @RequestMapping(value = "/getlistRoleByUsername/{username}", method = RequestMethod.GET)

    public List<String> getlistRoleByUsername(@PathVariable(value = "username") String username) {
        Users user = usersRepository.getUserByUsername(username);
        return usersRepository.getlistRoleforUsers(user.getUsername());
    }
    
//     @Transactional
//    @RequestMapping(value = "/UpdateUtilisateur/{idusername}", method = RequestMethod.POST)
//    public void UpdateUtilisateur(@RequestBody Users utilisateur,@PathVariable(value="idusername")String idusername) {
//         
//       
//         usersRepository.UpdateUser(utilisateur.getUsername(),utilisateur.getPassword(),utilisateur.getNom(),utilisateur.getPrenom(),idusername);
//    }
}

    

