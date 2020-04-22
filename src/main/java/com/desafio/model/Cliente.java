package com.desafio.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Cliente {
	
	private String nomeCliente;
	private String sexo;
	private LocalDateTime dataNascimento;
	private Integer idade;
	private Cidade cidade;
	
}