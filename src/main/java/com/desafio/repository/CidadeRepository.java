package com.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	List<Cidade> findByNomeCidade(String nomeCidade);
	
	List<Cidade> findByEstado(String estado);
	
}