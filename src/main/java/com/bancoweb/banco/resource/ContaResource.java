package com.bancoweb.banco.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bancoweb.banco.domain.Conta;
import com.bancoweb.banco.dto.ContaDTO;
import com.bancoweb.banco.dto.ContaDTOFactory;
import com.bancoweb.banco.service.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaResource {

	@Autowired
	private ContaService service;

	@GetMapping()
	public ResponseEntity<List<ContaDTO>> findAll() {
		List<Conta> list = service.findAll();
		List<ContaDTO> listDTO = list.stream().map(ContaDTOFactory::toDTO).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Conta> findById(@PathVariable String id) {
		Conta conta = service.findById(id);
		return ResponseEntity.ok().body(conta);
	}
	
	@GetMapping(value = "/numero/{numero}")
	public ResponseEntity<ContaDTO> findByNumero(@PathVariable String numero) {
		ContaDTO conta = ContaDTOFactory.toDTO(service.findByNumero(numero));
		return ResponseEntity.ok().body(conta);
	}

	@GetMapping(value = "/acesso/{numero}/{senha}")
	public ResponseEntity<Conta> findByDocument(@PathVariable String numero, @PathVariable String senha) {
		Conta conta = service.findByNumeroAndSenha(numero, senha);
		return ResponseEntity.ok().body(conta);
	}
	
	@PostMapping(value = "/inserir")
	public ResponseEntity<Void> insert(@RequestBody Conta obj) {
		Conta novaConta = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaConta.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Conta obj) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}