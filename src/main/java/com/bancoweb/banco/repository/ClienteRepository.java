package com.bancoweb.banco.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bancoweb.banco.domain.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
	
	Cliente findByDocument(String document);
}
