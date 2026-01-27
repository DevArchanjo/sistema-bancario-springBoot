package com.bancoweb.banco.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bancoweb.banco.dto.ClienteDTO;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "tipo"
)
@JsonSubTypes({
	    @JsonSubTypes.Type(value = ClienteFisico.class, name = "PF"),
	    @JsonSubTypes.Type(value = ClienteJuridico.class, name = "PJ")
})
@Document(collection="cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String titular;
	
	private Endereco endereco;
	
	public Cliente() {
	}

	public Cliente(String id, String titular, Endereco endereco) {
		this.id = id;
		this.titular = titular;
		this.endereco = endereco;
	}
	
	public Cliente(ClienteDTO objDTO) {
		this.id = objDTO.getId();
		this.titular = objDTO.getTitular();
		this.endereco = objDTO.getEndereco();
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
}