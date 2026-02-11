package com.bancoweb.banco.domain;

import java.util.concurrent.ThreadLocalRandom;

import com.bancoweb.banco.service.exception.ObjectNotGenerated;

class GerarNumero {
	
	public static String gerarNumeroDaConta(Conta obj) {
		int numero = ThreadLocalRandom.current().nextInt(100000, 999999);
		
		if (obj instanceof ContaCorrente) {
			return String.valueOf(numero + "-1");
		}
		else if(obj instanceof ContaPoupanca) {
			return String.valueOf(numero + "-2");
		}
		else {
			throw new ObjectNotGenerated("[Erro] não foi possivel gerar o numero da conta bancária");
		}
	}
}