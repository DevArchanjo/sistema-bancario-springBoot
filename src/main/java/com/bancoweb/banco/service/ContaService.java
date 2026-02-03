package com.bancoweb.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancoweb.banco.domain.Conta;
import com.bancoweb.banco.domain.ContaCorrente;
import com.bancoweb.banco.domain.ContaPoupanca;
import com.bancoweb.banco.repository.ContaRepository;
import com.bancoweb.banco.service.exception.ObjectNotFoundException;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;

	public Conta findById(String id) {
		Conta conta = repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Conta não encontrada, id inválido"));
		return conta;
	}

	public Conta findByNumero(String numero) {
		Conta conta = repository.findByNumero(numero)
				.orElseThrow(() -> new ObjectNotFoundException("Conta não encontada, numero da conta é inválido"));
		return conta;
	}

	public Conta findByNumeroAndSenha(String numero, String senha) {
		Conta conta = repository.findByNumeroAndSenha(numero, senha).orElseThrow(()-> new ObjectNotFoundException("Acesso negado, verifique o número da conta e senha informados"));
		return conta;
	}
	
	public List<Conta> findAll() {
		List<Conta> list = repository.findAll();
		return list;
	}
	
	public Conta insert(Conta obj) {
		Conta conta = repository.insert(obj);
		return conta;
	}
	
	public Conta update(Conta obj) {
		Conta objNovo = findById(obj.getId());
		updateFields(obj, objNovo);
		return repository.save(objNovo);
	}
	
	public void updateFields(Conta obj, Conta objNovo) {
		if (obj instanceof ContaCorrente) {
			ContaCorrente cc = (ContaCorrente)obj;
			ContaCorrente dadosAtualizados = (ContaCorrente)objNovo;
			dadosAtualizados.setSenha(cc.getSenha());
			dadosAtualizados.setNumero(cc.getNumero());
			dadosAtualizados.setCliente(cc.getCliente());
			dadosAtualizados.getCliente().setEndereco(cc.getCliente().getEndereco());
		}
		
		if (obj instanceof ContaPoupanca) {
			ContaPoupanca cp = (ContaPoupanca)obj;
			ContaPoupanca dadosAtualizados = (ContaPoupanca)objNovo;
			dadosAtualizados.setSenha(cp.getSenha());
			dadosAtualizados.setNumero(cp.getNumero());
			dadosAtualizados.setCliente(cp.getCliente());
			dadosAtualizados.getCliente().setEndereco(cp.getCliente().getEndereco());
		}
	}
}