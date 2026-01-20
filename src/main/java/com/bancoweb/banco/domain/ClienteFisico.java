package com.bancoweb.banco.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "titular", "endereco", "cpf", "dataDeNascimento"})
public class ClienteFisico extends Cliente {
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private Date dataDeNascimeto;
	
	public ClienteFisico() {
	}

	public ClienteFisico(String id, String titular, Endereco endereco, String cpf, Date dataDeNascimeto) {
		super(id, titular, endereco);
		this.cpf = cpf;
		this.dataDeNascimeto = dataDeNascimeto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataDeNascimeto() {
		return dataDeNascimeto;
	}

	public void setDataDeNascimeto(Date dataDeNascimeto) {
		this.dataDeNascimeto = dataDeNascimeto;
	}
}