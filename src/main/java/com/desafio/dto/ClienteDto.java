package com.desafio.dto;

import java.time.LocalDate;

import com.desafio.model.Cidade;
import com.desafio.model.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {
	
	private Long id;
	private String nomeCliente;
	private String sexo;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	private Integer idade;
	private Cidade cidade;

	public ClienteDto() {
		
	}
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nomeCliente = cliente.getNomeCliente();
		this.sexo = cliente.getSexo();
		this.dataNascimento = cliente.getDataNascimento();
		this.idade = cliente.getIdade();
		this.cidade = cliente.getCidade();
	}

	@Override
	public String toString() {
		return  "{  \"cidade\": {    \"estado\": \""+this.cidade.getEstado()+"\",    \"id\": "+this.cidade.getId()+",    \"nomeCidade\": \""+this.cidade.getNomeCidade()+"\"  },  \"dataNascimento\": \""+this.dataNascimento+"\",  \"idade\": "+this.idade+",  \"nomeCliente\": \""+this.nomeCliente+"\",  \"sexo\": \""+this.sexo+"\"}";
	}

}
