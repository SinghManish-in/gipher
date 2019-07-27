package com.stackroute.giphermanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.giphermanager.exception.GipherNotCreatedException;
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
	public Gipher createGipher(Gipher gipher) throws GipherNotCreatedException{
		Gipher savedGipher = gipherRepository.insert(gipher);
		if(null == savedGipher) {
			throw new GipherNotCreatedException("Gipher not created");
		} else {
			return savedGipher;
		}
	}
	
	@Override
	public Gipher updateGipher(Gipher gipher,String gipherId) {
		Optional<Gipher> categoryToUpdate = gipherRepository.findById(gipherId);
		Gipher updatedGipher = null;
		if(null != categoryToUpdate) {
			updatedGipher = gipherRepository.save(gipher); 
			 return gipher;
		}
		 return updatedGipher;
		
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
	public List<Gipher> getAllGipherByBookmark(String bookMarkedBy) throws GipherNotFoundExeption {
		return gipherRepository.getAllGipherByBookmark(bookMarkedBy);
	}

	@Override
	public List<Gipher> getAllGipherByFavorite(String favoritedBy) throws GipherNotFoundExeption {
		return gipherRepository.getAllGipherByFavorite(favoritedBy);
	}
	
	@Override
	public List<Gipher> getGipherFromExternalAPI(String userId,String query) throws GipherNotCreatedException{	
		List<Gipher> savedGiphers = new ArrayList<Gipher>();
		for(Gipher gipher : gipherHelper.getGipherFromExternalAPI(userId,query))
			savedGiphers.add(createGipher(gipher));
		return savedGiphers;
	}

	@Override
	public Optional<Gipher> getGipherById(String gipherId) throws GipherNotFoundExeption {
		return gipherRepository.findById(gipherId);
	}
}
