package com.desafio.services;

import com.desafio.dto.CidadeDto;

public interface CidadeService {
	
	CidadeDto save(CidadeDto dto);
	
	CidadeDto findByNomeCidade(String nome);
	
	CidadeDto findByEstado(String estado);
	
}
