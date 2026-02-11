package com.bancoweb.banco.dto;

import java.io.Serializable;

public class ContaSearchDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String numero;
	private String titular;
	private String documento;
	
	public ContaSearchDTO() {
	}
	
	public ContaSearchDTO(String numero, String titular, String documento) {
		this.numero = numero;
		this.titular = titular;
		this.documento = documento;
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
}