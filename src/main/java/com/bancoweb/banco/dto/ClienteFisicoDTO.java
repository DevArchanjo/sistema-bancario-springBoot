package com.bancoweb.banco.dto;

import java.util.Date;

import com.bancoweb.banco.domain.ClienteFisico;
import com.bancoweb.banco.domain.Endereco;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "titular", "cpf", "dataDeNascimento", "endereco"})
public class ClienteFisicoDTO extends ClienteDTO {
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private Date dataDeNascimento;
	
	public ClienteFisicoDTO() {
	}

	public ClienteFisicoDTO(String id, String titular, Endereco endereco, String cpf, Date dataDeNascimento) {
		super(id, titular, endereco);
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public ClienteFisicoDTO(ClienteFisico obj) {
		super(obj);
		this.cpf = obj.getCpf();
		this.dataDeNascimento = obj.getDataDeNascimento();
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

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
}