package com.stackroute.giphermanager.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.giphermanager.model.Gipher;
import com.stackroute.giphermanager.service.GipherService;



/*
 * As in this assignment, we are working with creating RESTful web service, hence annotate
 * the class with @RestController annotation.A class annotated with @Controller annotation
 * has handler methods which returns a view. However, if we use @ResponseBody annotation along
 * with @Controller annotation, it will return the data directly in a serialized 
 * format. Starting from Spring 4 and above, we can use @RestController annotation which 
 * is equivalent to using @Controller and @ResposeBody annotation
 */
@RestController
@CrossOrigin(origins="*")
public class GipherController {

	/*
	 * Autowiring should be implemented for the NoteService. (Use Constructor-based
	 * autowiring) Please note that we should not create any object using the new
	 * keyword
	 */
	@Autowired
	GipherService gipherService;
	
	public GipherController(GipherService gipherService) {
	this.gipherService =  gipherService;
	}
	

	/*
	 * Define a handler method which will create a specific note by reading the
	 * Serialized object from request body and save the note details in the
	 * database.This handler method should return any one of the status messages
	 * basis on different situations: 
	 * 1. 201(CREATED) - If the note created successfully. 
	 * 2. 409(CONFLICT) - If the noteId conflicts with any existing user.
	 * 
	 * This handler method should map to the URL "/api/v1/note" using HTTP POST method
	 */
	
	@GetMapping("/api/v1/gipher/{giferId}")
	public ResponseEntity<?> getAllNoteById(@PathVariable("userid") String userId){
			List<Gipher> allNotes;
			allNotes = gipherService.getAllGipherByUserId(userId);
			return new ResponseEntity<>(allNotes,HttpStatus.OK);		
	}
	
	
	@PostMapping("/api/v1/gipher")
	public ResponseEntity<?> createGipher(@RequestBody Gipher gipher){
		String user = gipher.getGipherCreatedBy();
		System.out.println("gipher---"+gipher.getGipherTitle());
		Calendar calender = Calendar.getInstance();
		Date date = calender.getTime();
		gipher.setGipherCreationDate(date);
			boolean flag = gipherService.createGipher(gipher);
			if(flag) {
				return new ResponseEntity<>(gipher,HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
	}
	
	/*
	 * Define a handler method which will delete a note from a database.
	 * This handler method should return any one of the status messages basis 
	 * on different situations: 
	 * 1. 200(OK) - If the note deleted successfully from database. 
	 * 2. 404(NOT FOUND) - If the note with specified noteId is not found.
	 *
	 * This handler method should map to the URL "/api/v1/note/{id}" using HTTP Delete
	 * method" where "id" should be replaced by a valid noteId without {}
	 */
//	@DeleteMapping("/api/v1/note/{userid}/{noteid}")
//	public ResponseEntity<?> deleteNote(@PathVariable("userid") String userId,@PathVariable("noteid") int noteId){
//			boolean flag = noteService.deleteNote(userId, noteId);
//			if(flag) {
//				return new ResponseEntity<>(HttpStatus.OK);
//			}else {
//				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
//	}
	

	/*
	 * Define a handler method which will update a specific note by reading the
	 * Serialized object from request body and save the updated note details in a
	 * database. 
	 * This handler method should return any one of the status messages
	 * basis on different situations: 
	 * 1. 200(OK) - If the note updated successfully.
	 * 2. 404(NOT FOUND) - If the note with specified noteId is not found.
	 * 
	 * This handler method should map to the URL "/api/v1/note/{id}" using HTTP PUT method.
	 */
//	@PutMapping("/api/v1/note/{userid}/{noteid}")
//	public ResponseEntity<?> updateNote(@PathVariable("userid") String userId,@PathVariable("noteid") int noteId, @RequestBody Note note){
//			Note updatedNote;
//			try {
//				updatedNote = noteService.updateNote(note, noteId, userId);
//				return new ResponseEntity<>(updatedNote,HttpStatus.OK);
//			} catch (NoteNotFoundExeption e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}		
//	}
	
	/*
	 * Define a handler method which will get us the all notes by a userId.
	 * This handler method should return any one of the status messages basis on
	 * different situations: 
	 * 1. 200(OK) - If the note found successfully. 
	 * 
	 * This handler method should map to the URL "/api/v1/note" using HTTP GET method
	 */
//	@GetMapping("/api/v1/note/{userid}/{noteid}")
//	public ResponseEntity<?> getNoteById(@PathVariable("userid") String userId,@PathVariable("noteid") int noteId){
//			Note updatedNote;
//			try {
//				updatedNote = noteService.getNoteByNoteId(userId, noteId);
//				return new ResponseEntity<>(updatedNote, HttpStatus.OK);
//			} catch (NoteNotFoundExeption e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}		
//	}
	
	

	
//	@DeleteMapping("/api/v1/note/{userid}")
//	public ResponseEntity<?> deleteAllNote(@PathVariable("userid") String userId){
//			boolean updatedNote;
//			try {
//				updatedNote = noteService.deleteAllNotes(userId);
//				return new ResponseEntity<>(HttpStatus.OK);	
//			} catch (NoteNotFoundExeption e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
//			}
//				
//	}


}
