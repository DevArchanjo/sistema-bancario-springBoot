package com.bancoweb.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancoweb.banco.domain.Cliente;
import com.bancoweb.banco.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente findById(String id) {
		return repository.findById(id).orElseThrow(() -> new NullPointerException("Cliente não encontrado"));
	}

	public List<Cliente> findAll() {
		List<Cliente> list = repository.findAll();
		return list;
	}
}