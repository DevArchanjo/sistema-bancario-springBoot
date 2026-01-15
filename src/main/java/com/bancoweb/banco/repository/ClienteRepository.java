package com.bancoweb.banco.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bancoweb.banco.domain.Cliente;
import com.bancoweb.banco.domain.ClienteFisico;
import com.bancoweb.banco.domain.ClienteJuridico;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
	
	Optional<ClienteFisico> findByCpf(String cpf);
	
	Optional<ClienteJuridico> findByCnpj(String cnpj);
}