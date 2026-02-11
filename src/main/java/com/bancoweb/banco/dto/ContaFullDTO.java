package com.bancoweb.banco.dto;

import java.io.Serializable;
import java.util.List;

import com.bancoweb.banco.domain.Transacao;

public class ContaFullDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String titular;
	private String numero;
	private Double saldo;
	private String documento;
	private String razaoSocial;
	private List<Transacao> transacoes;
	
	public ContaFullDTO(String id, String titular, String numero, Double saldo, String documento, String razaoSocial) {
		this.id = id;
		this.titular = titular;
		this.numero = numero;
		this.saldo = saldo;
		this.documento = documento;
		this.razaoSocial = razaoSocial;
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
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public List<Transacao> getTransacoes() {
		return transacoes;
	}
	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
}