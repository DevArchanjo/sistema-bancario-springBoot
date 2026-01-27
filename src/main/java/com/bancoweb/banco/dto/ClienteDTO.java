package com.bancoweb.banco.dto;

import java.io.Serializable;

import com.bancoweb.banco.domain.Cliente;
import com.bancoweb.banco.domain.Endereco;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "titular", "endereco"})
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String titular;
	
	private Endereco endereco;
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(String id, String titular, Endereco endereco) {
		this.id = id;
		this.titular = titular;
		this.endereco = endereco;
	}
	
	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.titular = obj.getTitular();
		this.endereco = obj.getEndereco();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}