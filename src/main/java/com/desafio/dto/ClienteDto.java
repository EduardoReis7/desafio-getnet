package com.desafio.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.desafio.model.Cidade;
import com.desafio.model.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {
	
	private String id;
	@NotNull(message = "O campo não pode ser nulo.")
	@NotEmpty(message = "O campo não pode estar vazio.")
	private String nomeCliente;
	@NotNull(message = "O campo não pode ser nulo.")
	@NotEmpty(message = "O campo não pode estar vazio.")
	private String sexo;
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	@NotNull(message = "O campo não pode ser nulo.")
	private Integer idade;
	@NotNull(message = "O campo não pode ser nulo.")
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
