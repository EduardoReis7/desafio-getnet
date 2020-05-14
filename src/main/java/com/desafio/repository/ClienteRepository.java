package com.desafio.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.desafio.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>{
	
	List<Cliente> findByNomeCliente(String nomeCliente);
}
