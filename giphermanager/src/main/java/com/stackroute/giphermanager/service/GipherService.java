package com.stackroute.giphermanager.service;

import java.util.List;

import com.stackroute.giphermanager.exception.GipherNotFoundExeption;
import com.stackroute.giphermanager.model.Gipher;
import com.stackroute.giphermanager.model.GipherSearch;

public interface GipherService {

	    boolean createGipher(Gipher Gipher);

	    boolean deleteGipher(int gipherId);

	    boolean deleteAllGiphers(String userId) throws GipherNotFoundExeption;

	    Gipher updateGipher(Gipher Gipher) throws GipherNotFoundExeption;

	    List<Gipher> getAllGipherByUserId(String userId) throws GipherNotFoundExeption;
	    
	    List<Gipher> getGipherFromExternalAPI(GipherSearch gipherSearch);

	}

