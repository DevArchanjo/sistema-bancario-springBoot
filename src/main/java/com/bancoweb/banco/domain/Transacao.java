package com.bancoweb.banco.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="transacao")
public class Transacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Date data;
	private String titular;
	private String transferente;
	private String numero;
	private Double valorDaTransacao;
	
	public Transacao() {
	}

	public Transacao(String id, Date data, String titular, String transferente, String numero,
			Double valorDaTransacao) {
		this.id = id;
		this.data = data;
		this.titular = titular;
		this.transferente = transferente;
		this.numero = numero;
		this.valorDaTransacao = valorDaTransacao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getTransferente() {
		return transferente;
	}

	public void setTransferente(String transferente) {
		this.transferente = transferente;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getValorDaTransacao() {
		return valorDaTransacao;
	}

	public void setValorDaTransacao(Double valorDaTransacao) {
		this.valorDaTransacao = valorDaTransacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		return Objects.equals(id, other.id);
	}
}