package com.bancoweb.banco.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bancoweb.banco.domain.Endereco;
import com.bancoweb.banco.service.EnderecoService;

@RestController
@RequestMapping(value="/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Endereco>> findAll() {
		List<Endereco> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Endereco> findById(@PathVariable String id) {
		Endereco endereco = service.findById(id);
		return ResponseEntity.ok().body(endereco);
	}
	
	@RequestMapping(value="/cep/{cep}", method = RequestMethod.GET)
	public ResponseEntity<Endereco> findByCep(@PathVariable String cep) {
		Endereco endereco = service.findByCep(cep);
		return ResponseEntity.ok().body(endereco);
	}
}