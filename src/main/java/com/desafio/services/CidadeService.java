package com.desafio.services;

import java.util.List;

import com.desafio.dto.CidadeDto;

public interface CidadeService {
	
	CidadeDto save(CidadeDto dto);
	
	List<CidadeDto> findByNomeCidade(String nome);
	
	List<CidadeDto> findByEstado(String estado);

	List<CidadeDto> listarCidades();
	
}
