package com.bancoweb.banco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancoweb.banco.domain.Endereco;
import com.bancoweb.banco.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;

	public Endereco findById(String id) {
		Optional<Endereco> endereco = repository.findById(id);
		return endereco.orElseThrow(()-> new NullPointerException("Endereco não encontrado!"));
	}
	
	public Endereco findByCep(String cep) {
		return repository.findByCep(cep);
	}
	
	public List<Endereco> findAll(){
		List<Endereco> enderecos = repository.findAll();
		return enderecos;
	}
}