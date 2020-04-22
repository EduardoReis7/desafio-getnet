package com.desafio.dto;

import java.time.LocalDate;

import com.desafio.model.Cidade;
import com.desafio.model.Cliente;

import lombok.Data;

@Data
public class ClienteDto {
	
	private Long id;
	private String nomeCliente;
	private String sexo;
	private LocalDate dataNascimento;
	private Integer idade;
	private Cidade cidade;

	public ClienteDto() {

	}

	public ClienteDto(Cliente cliente) {

		id = cliente.getId();
		nomeCliente = cliente.getNomeCliente();
		sexo = cliente.getSexo();
		dataNascimento = cliente.getDataNascimento();
		idade = cliente.getIdade();
		cidade = cliente.getCidade();
	}
}
