package com.bancoweb.banco.dto;

import com.bancoweb.banco.domain.ClienteFisico;
import com.bancoweb.banco.domain.ClienteJuridico;
import com.bancoweb.banco.domain.Conta;

public class ContaDTOFactory {
	
	public static ContaFullDTO toDTO(Conta obj) {
		if (obj.getCliente() instanceof ClienteFisico cf) {
			return new ContaFullDTO(obj.getId(), obj.getCliente().getTitular(), obj.getNumero(), obj.getSaldo(), cf.getCpf(), null);
		}	
		
		if (obj.getCliente() instanceof ClienteJuridico cj) {
			return new ContaFullDTO(obj.getId(), obj.getCliente().getTitular(), obj.getNumero(), obj.getSaldo(), cj.getCnpj(), cj.getRazaoSocial());
		}
		
		throw new IllegalArgumentException("[Erro] não foi possivel carregar os dados da conta acessada");
	}
	
	public static ContaSearchDTO returnToSimpleAccountSearch(Conta obj) {
		if (obj.getCliente() instanceof ClienteFisico cf) {
			return new ContaSearchDTO(obj.getNumero(), obj.getCliente().getTitular(), cf.getCpf());
		}	
		
		if (obj.getCliente() instanceof ClienteJuridico cj) {
			return new ContaSearchDTO(obj.getNumero(), obj.getCliente().getTitular(), cj.getCnpj());
		}
		
		throw new IllegalArgumentException("[Erro] não foi possivel exibir o cliente buscado");
	}
}
