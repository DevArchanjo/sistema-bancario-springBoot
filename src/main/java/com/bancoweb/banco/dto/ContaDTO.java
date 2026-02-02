package com.bancoweb.banco.dto;

import java.io.Serializable;

import com.bancoweb.banco.domain.Conta;

public class ContaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String numero;
	private String titular;
	
	public ContaDTO() {
	}
	
	public ContaDTO(Conta obj) {
		this.id = obj.getId();
		this.numero = obj.getNumero();
		this.titular = obj.getCliente().getTitular();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}
}