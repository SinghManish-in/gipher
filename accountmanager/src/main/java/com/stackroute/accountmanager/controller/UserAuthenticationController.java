package com.stackroute.accountmanager.controller;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.accountmanager.exception.UserAlreadyExistsException;
import com.stackroute.accountmanager.model.User;
import com.stackroute.accountmanager.service.UserAuthenticationService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*
 * As in this assignment, we are working on creating RESTful web service, hence annotate
 * the class with @RestController annotation. A class annotated with the @Controller annotation
 * has handler methods which return a view. However, if we use @ResponseBody annotation along
 * with @Controller annotation, it will return the data directly in a serialized 
 * format. Starting from Spring 4 and above, we can use @RestController annotation which 
 * is equivalent to using @Controller and @ResposeBody annotation
 */
@RestController
@CrossOrigin(origins="*")
public class UserAuthenticationController {
	
	HashMap<String, String> map = new HashMap<>();

    /*
	 * Autowiring should be implemented for the UserAuthenticationService. (Use Constructor-based
	 * autowiring) Please note that we should not create an object using the new
	 * keyword
	 */

	@Autowired
	UserAuthenticationService authicationService;
    public UserAuthenticationController(UserAuthenticationService authicationService) {
    	this.authicationService = authicationService;
	}

/*
	 * Define a handler method which will create a specific user by reading the
	 * Serialized object from request body and save the user details in the
	 * database. This handler method should return any one of the status messages
	 * basis on different situations:
	 * 1. 201(CREATED) - If the user created successfully. 
	 * 2. 409(CONFLICT) - If the userId conflicts with any existing user
	 * 
	 * This handler method should map to the URL "/api/v1/auth/register" using HTTP POST method
	 */
    @PostMapping("/api/v1/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
    	System.out.println(user);
    	Calendar calender = Calendar.getInstance();
    	Date date = calender.getTime();
    	user.setUserAddedDate(date);;
    	try {
    		authicationService.saveUser(user);
		} catch (UserAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		 return new ResponseEntity<>(user,HttpStatus.CREATED);
    	
    }


	/* Define a handler method which will authenticate a user by reading the Serialized user
	 * object from request body containing the username and password. The username and password should be validated 
	 * before proceeding ahead with JWT token generation. The user credentials will be validated against the database entries. 
	 * The error should be return if validation is not successful. If credentials are validated successfully, then JWT
	 * token will be generated. The token should be returned back to the caller along with the API response.
	 * This handler method should return any one of the status messages basis on different
	 * situations:
	 * 1. 200(OK) - If login is successful
	 * 2. 401(UNAUTHORIZED) - If login is not successful
	 * 
	 * This handler method should map to the URL "/api/v1/auth/login" using HTTP POST method
	*/


    @PostMapping("/api/v1/auth/login")
    public ResponseEntity<?> login(@RequestBody User user){
    	System.out.println(user.getUserId()+""+ user.getUserPassword());
    	try {
			String token = getToken(user.getUserId(), user.getUserPassword());
			map.clear();
			map.put("token", token);
			map.put("message", "User logged in successfully");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.clear();
			map.put("token", null);
			map.put("message",e.getMessage());
			return new ResponseEntity<>(map,HttpStatus.UNAUTHORIZED); 
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
    	
    }
    
    @PostMapping("/api/v1/auth/authenticate")
    public ResponseEntity<?> isAuthenticate(ServletRequest request) throws ServletException{
    	
    	HttpServletRequest req = (HttpServletRequest) request;
    	
    	String authHeader = req.getHeader("Authorization");
    	
    	if(authHeader ==  null || !authHeader.startsWith("Bearer ")) {
    		throw new ServletException("Authorization token is missing");
    	}
    	String token = authHeader.substring(7);
    	final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
    	req.setAttribute("claims", claims);
    	HashMap<String, Boolean> map = new HashMap<>();
    	map.clear();
    	map.put("isAuthenticated", true);
    	return new ResponseEntity<>(map,HttpStatus.OK);
    	
    }



    // Generate JWT token
	public String getToken(String username, String password) throws Exception {
			
		if(username == null || password == null) {
			
		}
		User user = authicationService.findByUserIdAndPassword(username, password);
		if(user != null) {
			String jwttoken = Jwts.builder().setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
					.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
			return jwttoken;
		} else
			 throw new ServletException();
        
        
	}


}
