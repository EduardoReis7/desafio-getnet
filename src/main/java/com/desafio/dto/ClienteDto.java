package com.desafio.dto;

import java.time.LocalDate;

import com.desafio.model.Cidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {
	
	private Long id;
	private String nomeCliente;
	private String sexo;
	private LocalDate dataNascimento;
	private Integer idade;
	private Cidade cidade;

}
