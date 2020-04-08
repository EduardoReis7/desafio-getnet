package com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.models.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	Cidade findByNome(String nome);
	
	Cidade findByEstado(String estado);
	
}