package com.desafio.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.desafio.model.Cidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeDto {
	
	private Long id;
	@NotNull(message = "O campo não pode ser nulo.")
	@NotEmpty(message = "O campo não pode estar vazio.")
	private String nomeCidade;
	@NotNull(message = "O campo não pode ser nulo.")
	@NotEmpty(message = "O campo não pode estar vazio.")
	private String estado;
	
	public CidadeDto() {
		
	}
	
	public CidadeDto(Cidade cidade) {
		this.id = cidade.getId();
		this.nomeCidade = cidade.getNomeCidade();
		this.estado = cidade.getEstado();
	}
}