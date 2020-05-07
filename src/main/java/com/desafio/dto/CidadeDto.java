package com.desafio.dto;

import com.desafio.model.Cidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeDto {
	
	private Long id;
	private String nomeCidade;
	private String estado;
	
	public CidadeDto() {
		
	}
	
	public CidadeDto(Cidade cidade) {
		this.id = cidade.getId();
		this.nomeCidade = cidade.getNomeCidade();
		this.estado = cidade.getEstado();
	}
}