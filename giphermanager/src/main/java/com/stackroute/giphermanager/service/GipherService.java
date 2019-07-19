package com.stackroute.giphermanager.service;

import java.util.List;

import com.stackroute.giphermanager.exception.GipherNotFoundExeption;
import com.stackroute.giphermanager.model.Gipher;

public interface GipherService {

	    boolean createGipher(Gipher Gipher);

	    boolean deleteGipher(String userId, int noteId);

	    boolean deleteAllGiphers(String userId) throws GipherNotFoundExeption;

	    Gipher updateGipher(Gipher Gipher, int id, String userId) throws GipherNotFoundExeption;

	    Gipher getNGipherByGipherId(String userId,int noteId) throws GipherNotFoundExeption;

	    List<Gipher> getAllGipherByUserId(String userId);

	}

