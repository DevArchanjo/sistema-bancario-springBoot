package com.bancoweb.banco.domain;

import java.util.Date;

import org.springframework.data.annotation.TypeAlias;

@TypeAlias("contaCorrente")
public class ContaCorrente extends Conta {
	private static final long serialVersionUID = 1L;
	
	private double chequeEspecial;
	
	public ContaCorrente() {
	}

	public ContaCorrente(String id, String numero, String senha, Double saldo, Cliente cliente) {
		super(id, numero, senha, saldo, cliente);
		this.chequeEspecial = 500.0;
	}

	public double getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}
	
	@Override
	public void sacar(double quantia) {
		if (getSaldo() + chequeEspecial > quantia)
			setSaldo(getSaldo() - quantia);
		else
			throw new IllegalArgumentException("Saldo insuficiente, cheque especial já foi utilizado");
	}
	
	@Override
	public void transferir(Conta origem, Conta destino, double quantia) {
		origem.sacar(quantia);
		destino.depositar(quantia);
		getTransacoes().add(new Transacao(null, new Date(), origem.getCliente().getTitular(), destino.getCliente().getTitular(), destino.getNumero(), quantia));
	}
}