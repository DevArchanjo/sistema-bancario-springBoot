package com.bancoweb.banco.domain;

import java.util.Date;

import org.springframework.data.annotation.TypeAlias;

import com.bancoweb.banco.dto.ClienteJuridicoDTO;

@TypeAlias("PJ")
public class ClienteJuridico extends Cliente {
	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private String razaoSocial;
	private Date dataDeAbertura;
	
	public ClienteJuridico() {
	}

	public ClienteJuridico(String id, String titular, Endereco endereco, String cnpj, String rasaoSocial, Date dataDeAbertura) {
		super(id, titular, endereco);
		this.cnpj = cnpj;
		this.razaoSocial = rasaoSocial;
		this.dataDeAbertura = dataDeAbertura;
	}
	
	public ClienteJuridico(ClienteJuridicoDTO objDTO) {
		super(objDTO);
		this.cnpj = objDTO.getCnpj();
		this.razaoSocial = objDTO.getRazaoSocial();
		this.dataDeAbertura = objDTO.getDataDeAbertura();
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