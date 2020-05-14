package com.desafio.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "cliente")
public class Cliente {

	@Id
	private String id;
	private String nomeCliente;
	private String sexo;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	private Integer idade;
	
	private Cidade cidade;
	
}