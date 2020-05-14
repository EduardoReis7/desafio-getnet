package com.desafio.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "cidade")
public class Cidade {
	
	@Id
	private String id;
	private String nomeCidade;
	private String estado;
	
}