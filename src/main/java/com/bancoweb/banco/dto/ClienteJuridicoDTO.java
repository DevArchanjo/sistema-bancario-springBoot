package com.bancoweb.banco.dto;

import java.util.Date;

import com.bancoweb.banco.domain.ClienteJuridico;
import com.bancoweb.banco.domain.Endereco;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "titular", "cnpj", "razaoSocial", "dataDeAbertura", "endereco"})
public class ClienteJuridicoDTO extends ClienteDTO {
	private static final long serialVersionUID = 1L;

	private String cnpj;
	private String razaoSocial;
	private Date dataDeAbertura;
	
	public ClienteJuridicoDTO() {
	}

	public ClienteJuridicoDTO(String id, String titular, Endereco endereco, String cnpj, String razaoSocial, Date dataDeAbertura) {
		super(id, titular, endereco);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.dataDeAbertura = dataDeAbertura;
	}

	public ClienteJuridicoDTO(ClienteJuridico obj) {
		super(obj);
		this.cnpj = obj.getCnpj();
		this.razaoSocial = obj.getRazaoSocial();
		this.dataDeAbertura = obj.getDataDeAbertura();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Date getDataDeAbertura() {
		return dataDeAbertura;
	}

	public void setDataDeAbertura(Date dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}
}