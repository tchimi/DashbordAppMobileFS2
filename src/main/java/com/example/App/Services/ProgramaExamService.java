/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.App.Services;

import com.example.App.Dao.ProgramExamRepository;
import com.example.App.Dao.UsersRepository;
import com.example.App.Entities.Note;
import com.example.App.Entities.Programexam;
import com.example.App.Entities.Users;
import com.example.App.domain.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

public class ProgramaExamService {
    @Autowired
    ProgramExamRepository programexamRepository;
    
    @Autowired
    UsersRepository userRepository;
    
    @Value("${dirProgramExam}")
    String dirProgramExam;
    
     @RequestMapping(value = "/saveProgramexam", method = RequestMethod.POST)
    public ResponseEntity<Response> saveNote(@RequestParam("programexam") String programexam, @RequestParam("file") MultipartFile file) throws JsonProcessingException, IOException {
        
        Programexam programexam1 = new ObjectMapper().readValue(programexam, Programexam.class);
        Users user = new Users();
        user=userRepository.getOne("mike");
        //System.out.println(note1.getAnneeacademie);
        
        programexam1.setUserUsername(user);
        programexam1.setNamefile(file.getOriginalFilename());
         System.out.println(file.getOriginalFilename());
         System.out.println(programexam1.getSemestreCODESEMESTRE());
        file.transferTo(new File(dirProgramExam+file.getOriginalFilename()));
        programexamRepository.save(programexam1);
     
        return new ResponseEntity<Response>(new Response(""),HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getProgramexam", method = RequestMethod.GET)
        public List<Programexam>getListProgramexams(){

            return  programexamRepository.findAll();
        }
        
    @RequestMapping(value = "/deleteProgramexam", method = RequestMethod.POST)
        public void deleteNote(@RequestBody Programexam programexam ) {
      
        programexamRepository.delete(programexam);
        File file=new File(dirProgramExam+programexam.getNamefile());
        file.delete();
        }
        
    @RequestMapping(value="/listeNiveau", method=RequestMethod.GET )
    public List<String>listeNiveau(){
        return programexamRepository.listeNiveau();
    }
    
    private static final int BUFFER_SIZE = 4096;
    @RequestMapping (value="/DownloadFileProgramexam/{filename}", method=RequestMethod.GET )
    public void doDownload(HttpServletRequest request,
               HttpServletResponse response, @PathVariable(value = "filename") String fileName ) throws IOException {

           // get absolute path of the application
           ServletContext context = request.getServletContext();
           String appPath = context.getRealPath("");
           System.out.println("filepath = " + dirProgramExam);

           // construct the complete absolute path of the file

           File downloadFile = new File(dirProgramExam+fileName);
           FileInputStream inputStream = new FileInputStream(downloadFile);

           // get MIME type of the file
           String mimeType = context.getMimeType(dirProgramExam+fileName);
           if (mimeType == null) {
               // set to binary type if MIME mapping not found
               mimeType = "application/octet-stream";
           }
           System.out.println("MIME type: " + mimeType);

           // set content attributes for the response
           response.setContentType(mimeType);
           response.setContentLength((int) downloadFile.length());

           // set headers for the response
           String headerKey = "Content-Disposition";
           String headerValue = String.format("attachment; filename=\"%s\"",
                   downloadFile.getName());
           response.setHeader(headerKey, headerValue);

           // get output stream of the response
           OutputStream outStream = response.getOutputStream();

           byte[] buffer = new byte[BUFFER_SIZE];
           int bytesRead = -1;

           // write bytes read from the input stream into the output stream
           while ((bytesRead = inputStream.read(buffer)) != -1) {
               outStream.write(buffer, 0, bytesRead);
           }

           inputStream.close();
           outStream.close();
    }
}
