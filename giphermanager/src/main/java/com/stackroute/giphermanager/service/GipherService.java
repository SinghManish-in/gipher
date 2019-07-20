package com.stackroute.giphermanager.service;

import java.util.List;

import com.stackroute.giphermanager.exception.GipherNotFoundExeption;
import com.stackroute.giphermanager.model.Gipher;
import com.stackroute.giphermanager.model.GipherSearch;

public interface GipherService {

	    boolean createGipher(Gipher Gipher);

	    boolean deleteGipher(String userId, int gipherId);

	    boolean deleteAllGiphers(String userId) throws GipherNotFoundExeption;

	    Gipher updateGipher(Gipher Gipher, int id, String userId) throws GipherNotFoundExeption;

	    Gipher getGipherByUserId(String userId,int gipherId) throws GipherNotFoundExeption;

	    List<Gipher> getAllGipherByUserId(String userId);
	    
	    List<Gipher> getGipherFromExternalAPI(GipherSearch gipherSearch);

	}

