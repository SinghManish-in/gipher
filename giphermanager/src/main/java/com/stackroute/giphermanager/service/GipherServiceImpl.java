package com.stackroute.giphermanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.giphermanager.exception.GipherNotFoundExeption;
import com.stackroute.giphermanager.helper.GipherHelper;
import com.stackroute.giphermanager.model.Gipher;
import com.stackroute.giphermanager.repository.GipherRepository;

@Service
public class GipherServiceImpl implements GipherService {
	
	@Autowired
	GipherRepository gipherRepository;
	
	@Autowired
	GipherHelper gipherHelper;
	
	@Override
	public List<Gipher> getAllGiphers() throws GipherNotFoundExeption {
		return gipherRepository.findAll();
	}
	
	@Override
	public List<Gipher> getAllGipherByUserId(String userId) throws GipherNotFoundExeption {
		return gipherRepository.getAllGipherByUserId(userId);
	}
	
	@Override
	public boolean createGipher(Gipher gipher) {
		if(null != gipherRepository.save(gipher)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void deleteGipher(String gipherId) throws GipherNotFoundExeption{
		gipherRepository.deleteById(gipherId);
	}


	@Override
	public void deleteAllGiphers() throws GipherNotFoundExeption {
		gipherRepository.deleteAll();
	}

	@Override
	public Gipher updateGipher(Gipher gipher) throws GipherNotFoundExeption {
		return gipherRepository.save(gipher);
	}

	@Override
	public List<Gipher> getAllGipherByBookmark(String bookMarkedBy) throws GipherNotFoundExeption {
		return gipherRepository.getAllGipherByBookmark(bookMarkedBy);
	}

	@Override
	public List<Gipher> getAllGipherByFavorite(String favoritedBy) throws GipherNotFoundExeption {
		return gipherRepository.getAllGipherByBookmark(favoritedBy);
	}
	
	@Override
	public List<Gipher> getGipherFromExternalAPI(String userId,String query) throws GipherNotFoundExeption{	
		return gipherHelper.getGipherFromExternalAPI(userId,query);
	}
}
