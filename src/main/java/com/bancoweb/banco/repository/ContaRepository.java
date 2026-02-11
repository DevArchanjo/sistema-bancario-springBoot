package com.bancoweb.banco.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bancoweb.banco.domain.Conta;

@Repository
public interface ContaRepository extends MongoRepository<Conta, String> {

	Optional<Conta> findByNumero(String numero);

	Optional<Conta> findByNumeroAndSenha(String numero, String senha);
}