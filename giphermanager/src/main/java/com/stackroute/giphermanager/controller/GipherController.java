package com.stackroute.giphermanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.giphermanager.exception.GipherNotFoundExeption;
import com.stackroute.giphermanager.model.Gipher;
import com.stackroute.giphermanager.service.GipherService;

@RestController
@CrossOrigin(origins = "*")
public class GipherController {

	@Autowired
	GipherService gipherService;

	public GipherController(GipherService gipherService) {
		this.gipherService = gipherService;
	}
	
	@GetMapping("/api/v1/gipher/user/{userid}")
	public ResponseEntity<?> getAllGipherByUserId(@PathVariable("userid") String userId) {
		List<Gipher> giphers;
		try {
			giphers = gipherService.getAllGipherByUserId(userId);
			return new ResponseEntity<>(giphers, HttpStatus.OK);
		} catch (GipherNotFoundExeption e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/api/v1/gipher/{giferId}")
	public ResponseEntity<?> getAllGipherById(@PathVariable("userid") String userId) {
		List<Gipher> giphers;
		try {
			giphers = gipherService.getAllGipherByUserId(userId);
			return new ResponseEntity<>(giphers, HttpStatus.OK);
		} catch (GipherNotFoundExeption e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/api/v1/gipher")
	public ResponseEntity<?> getAllGiphers() {
		List<Gipher> giphers;
		try {
			giphers = gipherService.getAllGiphers();
			return new ResponseEntity<>(giphers, HttpStatus.OK);
		} catch (GipherNotFoundExeption e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@PostMapping("/api/v1/gipher")
	public ResponseEntity<?> createGipher(@RequestBody Gipher gipher) {
		boolean flag = gipherService.createGipher(gipher);
		if (flag) {
			return new ResponseEntity<>(gipher, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/api/v1/gipher")
	public ResponseEntity<?> updateGipher(Gipher gipher) {
		Gipher updateGipher = null;
		try {
			updateGipher = gipherService.updateGipher(gipher);
			return new ResponseEntity<>(updateGipher, HttpStatus.OK);
		} catch (GipherNotFoundExeption e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
