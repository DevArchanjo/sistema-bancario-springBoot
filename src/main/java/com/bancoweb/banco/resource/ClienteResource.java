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

import com.bancoweb.banco.domain.Cliente;
import com.bancoweb.banco.dto.ClienteDTO;
import com.bancoweb.banco.dto.ClienteDTOFactory;
import com.bancoweb.banco.service.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@GetMapping(value="/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable String id) {
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(ClienteDTOFactory.toDTO(obj));
	}

	@GetMapping()
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<Cliente> list = service.findAll();
		List<ClienteDTO> listDTO = list.stream().map(ClienteDTOFactory::toDTO).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value="/documento/{documento}")
	public ResponseEntity<ClienteDTO> findByDocument(@PathVariable String documento) {
		Cliente busca = service.findByDocument(documento);
		return ResponseEntity.ok().body(ClienteDTOFactory.toDTO(busca));
	}

	@PostMapping(value="/inserir")
	public ResponseEntity<Void> insert(@RequestBody Cliente obj) {
		Cliente novoCliente = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoCliente).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/atualizar/{id}")
	public ResponseEntity<Void> update(@RequestBody Cliente obj, @PathVariable String id) {
		obj.setId(id);
		obj = service.udate(obj);
		return ResponseEntity.noContent().build();
	}
}