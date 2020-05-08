package com.desafio.services;

import java.util.List;
import java.util.Optional;

import com.desafio.dto.CidadeDto;
import com.desafio.model.Cidade;

public interface CidadeService {
	
	CidadeDto save(CidadeDto dto);
	
	List<CidadeDto> findByNomeCidade(String nome);
	
	List<CidadeDto> findByEstado(String estado);

	List<CidadeDto> listarCidades();
	
	Optional<Cidade> buscarPorNomeCidadeEEstado(String nomeCidade, String estado);
	
}
