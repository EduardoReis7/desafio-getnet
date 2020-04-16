package com.desafio.services.impl;

import org.springframework.stereotype.Service;

import com.desafio.dto.CidadeDto;
import com.desafio.model.Cidade;
import com.desafio.repository.CidadeRepository;
import com.desafio.services.CidadeService;
import com.desafio.util.CidadeUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CidadeServiceImpl implements CidadeService{
	
	private final CidadeRepository cidadeRepository;

	@Override
	public CidadeDto save(CidadeDto dto) {
		Cidade cidade = CidadeUtil.convertDtoToEntity(dto);
		return CidadeUtil.convertEntityToDto(cidadeRepository.save(cidade));
	}

	@Override
	public CidadeDto findByNomeCidade(String nome) {
		return CidadeUtil.convertEntityToDto(cidadeRepository.findByNomeCidade(nome));
	}

	@Override
	public CidadeDto findByEstado(String estado) {
		return CidadeUtil.convertEntityToDto(cidadeRepository.findByEstado(estado));
	}
	
}