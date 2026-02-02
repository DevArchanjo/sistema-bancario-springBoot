package com.bancoweb.banco.dto;

import com.bancoweb.banco.domain.Conta;
import com.bancoweb.banco.domain.ContaCorrente;
import com.bancoweb.banco.domain.ContaPoupanca;

public class ContaDTOFactory {
	
	public static ContaDTO toDTO(Conta obj) {
		if (obj instanceof ContaCorrente) {
			return new ContaCorrenteObterDTO((ContaCorrente)obj);
		}	
		
		if (obj instanceof ContaPoupanca) {
			return new ContaPoupancaObterDTO((ContaPoupanca)obj);
		}
		
		throw new IllegalArgumentException("Conta não encontrada, [ERRO] ao tentar converter para DTO");
	}
}
