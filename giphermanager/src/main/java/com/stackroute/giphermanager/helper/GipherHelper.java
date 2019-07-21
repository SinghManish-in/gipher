package com.stackroute.giphermanager.helper;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.stackroute.giphermanager.model.Gipher;

public class GipherHelper {

	String baseurl = "https://api.giphy.com/v1/gifs/search?api_key=T31ikSprcGov7jizTYF0hp7M8vMYYuNX&q={0}&limit=5&offset=0&rating=G&lang=en";

	public List<Gipher> getGipherFromExternalAPI(String query) {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(MessageFormat.format(baseurl, query), HttpMethod.GET,
				null, new ParameterizedTypeReference<String>() {
				});
		String result = response.getBody();
		System.out.println("result----------------" + result);
		JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();
		System.out.println("data-------" + jsonObject.get("data"));
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		List<Gipher> outputList = (List<Gipher>) gson.fromJson(jsonObject.get("data"), ArrayList.class);
		return outputList;
	}
}
