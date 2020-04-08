package com.desafio.services.impl;

import org.springframework.stereotype.Service;

import com.desafio.models.Cidade;
import com.desafio.repository.CidadeRepository;
import com.desafio.services.CidadeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CidadeServiceImpl implements CidadeService{
	
	private final CidadeRepository cidadeRepository;

	@Override
	public Cidade save(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	@Override
	public Cidade findByNome(String nome) {
		return cidadeRepository.findByNome(nome);
	}

	@Override
	public Cidade findByEstado(String estado) {
		return cidadeRepository.findByEstado(estado);
	}
	
}