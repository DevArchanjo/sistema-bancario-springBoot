package com.bancoweb.banco.domain;

import java.util.Date;

import org.springframework.data.annotation.TypeAlias;

@TypeAlias("contaPoupanca")
public class ContaPoupanca extends Conta {
	private static final long serialVersionUID = 1L;
	
	private Double taxaDeRendimento;
	
	public ContaPoupanca() {
	}

	public ContaPoupanca(String id, String senha, Double saldo, Cliente cliente) {
		super(id, senha, saldo, cliente);
		this.taxaDeRendimento = 0.05;
		if (saldo > 0.0) {
			setSaldo(saldo + (taxaDeRendimento * saldo));
			getTransacoes().add(new Transacao(null, new Date(), cliente.getTitular(), "Para a própria conta", getNumero(), saldo));
		}
	}

	public Double getTaxaDeRendimento() {
		return taxaDeRendimento;
	}

	public void setTaxaDeRendimento(Double taxaDeRendimento) {
		this.taxaDeRendimento = taxaDeRendimento;
	}
	
	@Override
	public void depositar(double quantia) {
		setSaldo((getSaldo() + quantia) * taxaDeRendimento);
	}
	
	@Override
	public void transferir(Conta origem, Conta destino, double quantia) {
		origem.sacar(quantia);
		destino.depositar(quantia);
		getTransacoes().add(new Transacao(null, new Date(), origem.getCliente().getTitular(), destino.getCliente().getTitular(), destino.getNumero(), quantia));
	}
}