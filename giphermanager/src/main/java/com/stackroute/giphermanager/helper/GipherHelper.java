package com.stackroute.giphermanager.helper;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.stackroute.giphermanager.model.Gipher;

public class GipherHelper {
	
	String baseurl = "https://api.giphy.com/v1/gifs/search?api_key=T31ikSprcGov7jizTYF0hp7M8vMYYuNX&q={0}&limit=1&offset=0&rating=G&lang=en";
	
	public List<Gipher> getGipherFromExternalAPI(String query) {
		
		RestTemplate restTemplate = new RestTemplate();
		final String finalUrl = MessageFormat.format(baseurl, query);
		System.out.println("finalUrl"+finalUrl);
	    URI uri = null;
		try {
			uri = new URI(finalUrl);
		} catch (URISyntaxException e) {
			System.out.println("exception is resttemplate");
			e.printStackTrace();
		}
	 
	    ResponseEntity<Gipher> result = restTemplate.getForEntity(uri, Gipher.class);
	     System.out.println("result-------- "+result.getBody());;
	     return null;
	    
		
	}

}
