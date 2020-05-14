package com.desafio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.desafio.model.Cidade;

@Repository
public interface CidadeRepository extends MongoRepository<Cidade, String>{
	
	List<Cidade> findByNomeCidade(String nomeCidade);
	
	List<Cidade> findByEstado(String estado);
	
	Optional<Cidade> findByNomeCidadeAndEstado(String nomeCidade, String estado);
}