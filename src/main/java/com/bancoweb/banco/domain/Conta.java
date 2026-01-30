package com.bancoweb.banco.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "tipo"
)
@JsonSubTypes({
	    @JsonSubTypes.Type(value = ContaCorrente.class, name = "contaCorrente"),
	    @JsonSubTypes.Type(value = ContaPoupanca.class, name = "contaPoupanca")
})
@Document(collection="conta_bancaria")
public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String numero;
	private String senha;
	private Double saldo;
	
	private Cliente cliente;
	private List<Transacao> transacoes = new ArrayList<>();
	
	public Conta() {
	}

	public Conta(String id, String senha, Double saldo, Cliente cliente) {
		this.id = id;
		this.numero = gerarNumeroDaConta();
		this.senha = senha;
		this.saldo = saldo;
		this.cliente = cliente;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}
	
	public String gerarNumeroDaConta() {
		int numero = ThreadLocalRandom.current().nextInt(100000, 199999);
		return String.valueOf(numero);
	}
	
	public void depositar(double quantia) {
		if (quantia > 0)
			saldo += quantia;
		else
			throw new IllegalArgumentException("Deposito inválido, quantia deve ser maior que 0");
	}
	
	public void sacar(double quantia) {
		if (quantia < saldo)
			saldo -= quantia;
		else
			throw new IllegalArgumentException("Saque inválido, quantia excede o saldo disponível");
	}
	
	public void transferir(Conta origem, Conta destino, double quantia) {
		origem.sacar(quantia);
		destino.depositar(quantia);
		transacoes.add(new Transacao(null, new Date(), origem.cliente.getTitular(), destino.cliente.getTitular(), destino.getNumero(), quantia));
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
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id);
	}
}