package com.desafio.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.controllers.form.AlterarNomeClienteForm;
import com.desafio.dto.ClienteDto;
import com.desafio.model.Cliente;
import com.desafio.repository.ClienteRepository;
import com.desafio.services.ClienteService;
import com.desafio.util.ClienteUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService{

	private final ClienteRepository clienteRepository;
	
	@Override
	public ClienteDto save(ClienteDto clienteDto) {
		Cliente cliente = ClienteUtil.convertDtoToEntity(clienteDto);
		return ClienteUtil.convertEntityToDto(clienteRepository.save(cliente));
	}

	@Override
	public ClienteDto buscarPorNomeCliente(String nomeCliente) {
		return ClienteUtil.convertEntityToDto(clienteRepository.findByNomeCliente(nomeCliente));
	}

	@Override
	public ClienteDto buscarPorId(Long id) {
		return ClienteUtil.convertEntityToDto(clienteRepository.getOne(id));
	}

	@Override
	public void removerPorId(Long id) {
		buscarPorId(id);
		clienteRepository.deleteById(id);
	}

	@Override
	public ClienteDto alterarNomeCliente(Long id, AlterarNomeClienteForm form) {
		Cliente cliente = clienteRepository.getOne(id);
		cliente.setNomeCliente(form.getNomeCliente());
		return ClienteUtil.convertEntityToDto(cliente);
	}

	@Override
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	
}
