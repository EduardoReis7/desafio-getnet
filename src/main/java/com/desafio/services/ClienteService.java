package com.desafio.services;

import java.util.List;

import com.desafio.controllers.form.AlterarNomeClienteForm;
import com.desafio.dto.ClienteDto;
import com.desafio.model.Cliente;

public interface ClienteService {
	
	ClienteDto save(ClienteDto clienteDto);
	
	List<ClienteDto> buscarPorNomeCliente(String nomeCliente);
	
	ClienteDto buscarPorId(Long id);
	
	void removerPorId(Long id);
	
	ClienteDto alterarNomeCliente(Long id, AlterarNomeClienteForm form);
	
	List<Cliente> listar();
}
