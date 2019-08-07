package com.bae.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bae.domain.SentAccount;

@Repository
public interface AccountRepository extends MongoRepository<SentAccount, String>{

}
