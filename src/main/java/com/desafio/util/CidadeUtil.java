package com.desafio.util;

import com.desafio.dto.CidadeDto;
import com.desafio.model.Cidade;

public class CidadeUtil {
	
	public static CidadeDto convertEntityToDto(Cidade cidade) {

		CidadeDto dto = new CidadeDto();
		dto.setId(cidade.getId());
		dto.setNomeCidade(cidade.getNomeCidade());
		dto.setEstado(cidade.getEstado());

		return dto;
	}

	public static Cidade convertDtoToEntity(CidadeDto dto) {

		Cidade cidade = new Cidade();
		cidade.setId(dto.getId());
		cidade.setNomeCidade(dto.getNomeCidade());
		cidade.setEstado(dto.getEstado());

		return cidade;
	}
	
}