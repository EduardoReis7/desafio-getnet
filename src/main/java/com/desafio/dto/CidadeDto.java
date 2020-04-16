package com.desafio.dto;

import com.desafio.model.Cidade;

import lombok.Data;

@Data
public class CidadeDto {
	
	private Long id;
	private String nomeCidade;
	private String estado;
	
	public CidadeDto() {
		
	}
	
	public CidadeDto(Cidade cidade) {
		
		id = cidade.getId();
		nomeCidade = cidade.getNomeCidade();
		estado = cidade.getEstado();
	}
}