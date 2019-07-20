package com.stackroute.giphermanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.giphermanager.exception.GipherNotFoundExeption;
import com.stackroute.giphermanager.model.Gipher;
import com.stackroute.giphermanager.model.GipherSearch;
import com.stackroute.giphermanager.repository.GipherRepository;

@Service
public class GipherServiceImpl implements GipherService {
	
	@Autowired
	GipherRepository gipherRepository;
	

	@Override
	public boolean createGipher(Gipher gipher) {
		if(null != gipherRepository.save(gipher)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteGipher(String userId, int noteId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAllGiphers(String userId) throws GipherNotFoundExeption {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Gipher updateGipher(Gipher Gipher, int id, String userId) throws GipherNotFoundExeption {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gipher getGipherByUserId(String userId, int gipherId) throws GipherNotFoundExeption {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gipher> getAllGipherByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gipher> getGipherFromExternalAPI(GipherSearch gipherSearch) {
		// TODO Auto-generated method stub
		return null;
	}

}
