package com.stackroute.giphermanager.service;

import java.util.List;

import com.stackroute.giphermanager.exception.GipherNotFoundExeption;
import com.stackroute.giphermanager.model.Gipher;
import com.stackroute.giphermanager.model.GipherSearch;

public interface GipherService {

	    boolean createGipher(Gipher Gipher);

	    void deleteGipher(String gipherId) throws GipherNotFoundExeption;

	    void deleteAllGiphers() throws GipherNotFoundExeption;

	    Gipher updateGipher(Gipher Gipher) throws GipherNotFoundExeption;

	    List<Gipher> getAllGipherByUserId(String userId) throws GipherNotFoundExeption;
	    
	    List<Gipher> getAllGipherByBookmark(String userId) throws GipherNotFoundExeption;
	    
	    List<Gipher> getAllGipherByFavorite(String userId) throws GipherNotFoundExeption;
	    
	    List<Gipher> getAllGiphers() throws GipherNotFoundExeption;
	    
	    List<Gipher> getGipherFromExternalAPI(String userId,String query) throws GipherNotFoundExeption;

	}

