package com.desafio.services;

import com.desafio.models.Cidade;

public interface CidadeService {
	
	Cidade save(Cidade cidade);
	
	Cidade findByNome(String nome);
	
	Cidade findByEstado(String estado);
	
}
