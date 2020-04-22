package com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByNomeCliente(String nomeCliente);
}
