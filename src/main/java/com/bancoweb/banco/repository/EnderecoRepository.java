package com.bancoweb.banco.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bancoweb.banco.domain.Endereco;

@Repository
public interface EnderecoRepository extends MongoRepository<Endereco, String> {

	Endereco findByCep(String cep);
}