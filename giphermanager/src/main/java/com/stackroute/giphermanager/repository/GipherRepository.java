package com.stackroute.giphermanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.giphermanager.model.Gipher;

@Repository
public interface GipherRepository extends MongoRepository<Gipher, String> {

}