package com.desafio.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.controllers.form.AlterarNomeClienteForm;
import com.desafio.dto.ClienteDto;
import com.desafio.model.Cliente;
import com.desafio.repository.ClienteRepository;
import com.desafio.services.ClienteService;
import com.desafio.util.ClienteUtil;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public ClienteDto save(ClienteDto clienteDto) {
		Cliente cliente = ClienteUtil.convertDtoToEntity(clienteDto);
		return ClienteUtil.convertEntityToDto(clienteRepository.save(cliente));
	}

	@Override
	public List<ClienteDto> buscarPorNomeCliente(String nomeCliente) {
		return ClienteUtil.convertListEntityToListDto(clienteRepository.findByNomeCliente(nomeCliente));
	}

	@Override
	public ClienteDto buscarPorId(String id) {
		return ClienteUtil.convertOptionalEntityToDto(clienteRepository.findById(id));
	}

	@Override
	public void removerPorId(String id) {
		clienteRepository.delete(ClienteUtil.convertDtoToEntity(buscarPorId(id)));
	}

	@Override
	public ClienteDto alterarNomeCliente(String id, AlterarNomeClienteForm form) {
		Cliente cliente = ClienteUtil.convertOptionalEntityToEntity(clienteRepository.findById(id));
		cliente.setNomeCliente(form.getNomeCliente());
		clienteRepository.save(cliente);
		return ClienteUtil.convertEntityToDto(cliente);
	}

	@Override
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
}
