package com.desafio.converters;

import com.desafio.dto.CidadeDTO;
import com.desafio.models.Cidade;

public class CidadeConverter {

	public static CidadeDTO convertEntityToDto(Cidade cidade) {

		CidadeDTO dto = new CidadeDTO();
		dto.setNome(cidade.getNome());
		dto.setEstado(cidade.getEstado());

		return dto;
	}

	public static Cidade convertDtoToEntity(CidadeDTO dto) {

		Cidade cidade = new Cidade();
		cidade.setNome(dto.getNome());
		cidade.setEstado(dto.getEstado());

		return cidade;
	}
}
