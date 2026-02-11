package com.bancoweb.banco.domain;

import java.util.Date;

import org.springframework.data.annotation.TypeAlias;

import com.bancoweb.banco.dto.ClienteFisicoDTO;

@TypeAlias("PF")
public class ClienteFisico extends Cliente {
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private Date dataDeNascimento;
	
	public ClienteFisico() {
	}

	public ClienteFisico(String id, String titular, Endereco endereco, String cpf, Date dataDeNascimento) {
		super(id, titular, endereco);
		this.cpf = cpf;
		if (this.cpf == null || this.cpf.length() != 11) {
			throw new IllegalArgumentException("CPF inválido, verifique se o documento foi digitado corretamente");
		}
		this.dataDeNascimento = dataDeNascimento;
	}

	public ClienteFisico(ClienteFisicoDTO objDTO) {
		super(objDTO);
		this.cpf = objDTO.getCpf();
		this.dataDeNascimento = objDTO.getDataDeNascimento();
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