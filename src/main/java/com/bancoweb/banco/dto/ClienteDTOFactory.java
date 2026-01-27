package com.bancoweb.banco.dto;

import com.bancoweb.banco.domain.Cliente;
import com.bancoweb.banco.domain.ClienteFisico;
import com.bancoweb.banco.domain.ClienteJuridico;

public class ClienteDTOFactory {

	public static ClienteDTO fromEntity(Cliente cliente) {
		
		if (cliente instanceof ClienteFisico) {
			return new ClienteFisicoDTO((ClienteFisico) cliente);
		}
		
		if (cliente instanceof ClienteJuridico) {
			return new ClienteJuridicoDTO((ClienteJuridico) cliente);
		}
		
		throw new IllegalArgumentException("Tipo de cliente desconhecido");
	}
}