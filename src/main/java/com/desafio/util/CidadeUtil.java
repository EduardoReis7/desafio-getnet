package com.desafio.util;

import java.util.List;
import java.util.stream.Collectors;

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

	public static List<CidadeDto> convertListEntityToListDto(List<Cidade> listEntity) {
		return listEntity.stream().map(i -> new CidadeDto(i)).collect(Collectors.toList());
	}

}