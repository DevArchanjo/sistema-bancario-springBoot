package com.bancoweb.banco.domain;

import java.util.Date;

import org.springframework.data.annotation.TypeAlias;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@TypeAlias("PF")
@JsonPropertyOrder({"id", "titular", "cpf", "dataDeNascimento", "endereco"})
public class ClienteFisico extends Cliente {
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private Date dataDeNascimento;
	
	public ClienteFisico() {
	}

	public ClienteFisico(String id, String titular, Endereco endereco, String cpf, Date dataDeNascimento) {
		super(id, titular, endereco);
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimeto(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
}