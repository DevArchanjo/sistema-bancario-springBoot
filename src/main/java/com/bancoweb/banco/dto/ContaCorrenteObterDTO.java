package com.bancoweb.banco.dto;

import com.bancoweb.banco.domain.ClienteFisico;
import com.bancoweb.banco.domain.ClienteJuridico;
import com.bancoweb.banco.domain.ContaCorrente;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "titular", "numero", "documento", "razaoSocial"})
public class ContaCorrenteObterDTO extends ContaDTO {
	private static final long serialVersionUID = 1L;
	
	private String documento;
	private String razaoSocial;
	
	public ContaCorrenteObterDTO() {
	}

	public ContaCorrenteObterDTO(ContaCorrente obj) {
		super(obj);
		if (obj.getCliente() instanceof ClienteFisico) {
			ClienteFisico cf = (ClienteFisico)obj.getCliente();
			this.documento = cf.getCpf();
		}
		
		if (obj.getCliente() instanceof ClienteJuridico) {
			ClienteJuridico cj = (ClienteJuridico)obj.getCliente();
			this.documento = cj.getCnpj();
			this.razaoSocial = cj.getRazaoSocial();
		}
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
}