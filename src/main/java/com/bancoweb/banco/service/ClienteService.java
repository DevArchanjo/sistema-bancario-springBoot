package com.bancoweb.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancoweb.banco.domain.Cliente;
import com.bancoweb.banco.domain.ClienteFisico;
import com.bancoweb.banco.domain.ClienteJuridico;
import com.bancoweb.banco.repository.ClienteRepository;
import com.bancoweb.banco.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente findById(String id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
	}

	public List<Cliente> findAll() {
		List<Cliente> list = repository.findAll();
		return list;
	}
	
	public Cliente findByDocument(String documento) {
		String doc = documento.replaceAll("\\D", "");
		if (doc.length() == 11) {
			return repository.findByCpf(doc).orElseThrow(()-> new ObjectNotFoundException("CPF não encontrado!"));
		}
		else if (doc.length() == 14) {
			return repository.findByCnpj(doc).orElseThrow(()-> new ObjectNotFoundException("CNPJ não encontrado!"));
		}
		
		throw new ObjectNotFoundException("Documento inválido!");
	}
	
	public Cliente insert(Cliente obj) {
		return repository.insert(obj);
	}
	
	public Cliente udate(Cliente obj) {
		Cliente objAlterado = findById(obj.getId());
		updateFields(objAlterado, obj);
		return repository.save(objAlterado);
	}
	
	public void updateFields(Cliente objNovo, Cliente obj) {
		if (obj instanceof ClienteFisico) {
			ClienteFisico cfNovo = (ClienteFisico)objNovo;
			ClienteFisico cf = (ClienteFisico)obj;
			cfNovo.setTitular(obj.getTitular());
			cfNovo.setEndereco(obj.getEndereco());
			cfNovo.setCpf(cf.getCpf());
			cfNovo.setDataDeNascimeto(cf.getDataDeNascimento());
		}
		else {
			ClienteJuridico cjNovo = (ClienteJuridico)objNovo;
			ClienteJuridico cj = (ClienteJuridico)obj;
			cjNovo.setTitular(cj.getTitular());
			cjNovo.setEndereco(cj.getEndereco());
			cjNovo.setCnpj(cj.getCnpj());
			cjNovo.setRazaoSocial(cj.getRazaoSocial());
			cjNovo.setDataDeAbertura(cj.getDataDeAbertura());
		}
	}
}