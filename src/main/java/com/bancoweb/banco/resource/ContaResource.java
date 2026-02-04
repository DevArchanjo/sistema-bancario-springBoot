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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bancoweb.banco.domain.Conta;
import com.bancoweb.banco.dto.ContaDTO;
import com.bancoweb.banco.dto.ContaDTOFactory;
import com.bancoweb.banco.resource.util.URL;
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

	@GetMapping(value = "/acesso")
	public ResponseEntity<Conta> findByDocument(@RequestParam String numero, @RequestParam String senha) {
		numero = URL.decodeParam(numero);
		senha = URL.decodeParam(senha);
		Conta conta = service.findByNumeroAndSenha(numero, senha);
		return ResponseEntity.ok().body(conta);
	}

	@PostMapping(value = "/inserir")
	public ResponseEntity<Void> insert(@RequestBody Conta obj) {
		Conta novaConta = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaConta.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/atualizar")
	public ResponseEntity<Void> update(@RequestParam String id, @RequestBody Conta obj) {
		id = URL.decodeParam(id);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/depositar")
	public ResponseEntity<Conta> depositar(@RequestParam String numero, @RequestParam String senha,
			@RequestParam double quantia) {
		numero = URL.decodeParam(numero);
		senha = URL.decodeParam(senha);
		quantia = URL.decodeParamToDouble(String.valueOf(quantia));
		Conta origem = service.findByNumeroAndSenha(numero, senha);
		origem = service.depositar(origem, quantia);
		return ResponseEntity.ok().body(origem);
	}

	@PutMapping(value = "/sacar")
	public ResponseEntity<Conta> sacar(@RequestParam String numero, @RequestParam String senha,
			@RequestParam double quantia) {
		numero = URL.decodeParam(numero);
		senha = URL.decodeParam(senha);
		quantia = URL.decodeParamToDouble(String.valueOf(quantia));
		Conta origem = service.findByNumeroAndSenha(numero, senha);
		origem = service.sacar(origem, quantia);
		return ResponseEntity.ok().body(origem);
	}

	@PutMapping(value = "/transferir")
	public ResponseEntity<Conta> transferir(@RequestParam String numero, @RequestParam String senha,
			@RequestParam String numeroDestino, @RequestParam double quantia) {
		;
		numero = URL.decodeParam(numero);
		senha = URL.decodeParam(senha);
		numeroDestino = URL.decodeParam(numeroDestino);
		quantia = URL.decodeParamToDouble(String.valueOf(quantia));
		Conta conta = service.transferir(numero, senha, numeroDestino, quantia);
		return ResponseEntity.ok().body(conta);
	}
}