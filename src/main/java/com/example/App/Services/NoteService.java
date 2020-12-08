/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.App.Services;

import com.example.App.Dao.NoteRepository;
import com.example.App.Dao.UsersRepository;
import com.example.App.Entities.Note;
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
public class NoteService {
    @Autowired
    NoteRepository noteRepository;
    
    @Autowired
    UsersRepository userRepository;
    
    @Value("${dirNotes}")
    String dirNotes;
   
     @RequestMapping(value = "/saveNote", method = RequestMethod.POST)
    public ResponseEntity<Response> saveNote(@RequestParam("note") String note,@RequestParam("file") MultipartFile file) throws JsonProcessingException, IOException {
        
        Note note1 = new ObjectMapper().readValue(note, Note.class);
        Users user=new Users();
        user=userRepository.getOne("mike");
        System.out.println(note1.getNamefile());
        
        note1.setUserUsername(user);
        note1.setNamefile(file.getOriginalFilename());
         System.out.println(file.getOriginalFilename());
         System.out.println(note1.getEtapeCODEETAPE().getCodeEtape());
        file.transferTo(new File(dirNotes+file.getOriginalFilename()));
        noteRepository.save(note1);
     
        return new ResponseEntity<Response>(new Response(""),HttpStatus.OK);
    }
    
     @RequestMapping(value = "/getNote", method = RequestMethod.GET)
        public List<Note>getListNotes(){

            return  noteRepository.findAll();
        }
    
        
    @RequestMapping(value = "/deleteNote", method = RequestMethod.POST)
        public void deleteNote(@RequestBody Note note ) {
      
        noteRepository.delete(note);
        File file=new File(dirNotes+note.getNamefile());
        file.delete();
       
    }
 
//    @Autowired
//    private ServletContext servletContext;
// 
//   
//    @RequestMapping(value="/DownloadFileNote/{filename}" , method = RequestMethod.GET)
//    public ResponseEntity<InputStreamResource> downloadFile1(
//            @PathVariable(value = "filename") String fileName) throws IOException {
// 
//        MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
//        System.out.println("fileName: " + fileName);
//        System.out.println("mediaType: " + mediaType);
//         System.out.println(dirNotes);
// 
//        File file = new File( + fdirNotesileName);
//        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
// 
//        return ResponseEntity.ok()
//                // Content-Disposition
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
//                // Content-Type
//                .contentType(mediaType)
//                // Contet-Length
//                .contentLength(file.length()) //
//                .body(resource);
//    }    
    private static final int BUFFER_SIZE = 4096;
    @RequestMapping (value="/DownloadFileNote/{filename}", method=RequestMethod.GET )
    public void doDownload(HttpServletRequest request,
               HttpServletResponse response, @PathVariable(value = "filename") String fileName ) throws IOException {

           // get absolute path of the application
           ServletContext context = request.getServletContext();
           String appPath = context.getRealPath("");
           System.out.println("filepath = " + dirNotes);

           // construct the complete absolute path of the file

           File downloadFile = new File(dirNotes+fileName);
           FileInputStream inputStream = new FileInputStream(downloadFile);

           // get MIME type of the file
           String mimeType = context.getMimeType(dirNotes+fileName);
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
    
    @RequestMapping(value="/listeEtape", method=RequestMethod.GET )
    public List<String>listeEtape(){
        return noteRepository.listEtape();
    }
    
    @RequestMapping(value="/listeAnneeacad", method=RequestMethod.GET )
    public List<String>listeAnneeacad(){
        return noteRepository.listeAnneeacad();
    }
    
    @RequestMapping(value="/listeSemestre", method=RequestMethod.GET )
    public List<String>listeSemestre(){
        return noteRepository.listeSemestre();
    }
}