package com.desafio.util;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import com.desafio.dto.ClienteDto;
import com.desafio.model.Cliente;

public class ClienteUtil {
	
	private ClienteUtil() {	
		throw new IllegalStateException("Utility class");
	}
	public static ClienteDto convertEntityToDto(Cliente cliente) {

		ClienteDto dto = new ClienteDto();
		dto.setId(cliente.getId());
		dto.setNomeCliente(cliente.getNomeCliente());
		dto.setSexo(cliente.getSexo());
		dto.setDataNascimento(cliente.getDataNascimento());
		dto.setIdade(cliente.getIdade());
		dto.setCidade(cliente.getCidade());

		return dto;
	}

	public static Cliente convertDtoToEntity(ClienteDto dto) {

		Cliente cliente = new Cliente();
		cliente.setId(dto.getId());
		cliente.setNomeCliente(dto.getNomeCliente());
		cliente.setSexo(dto.getSexo());
		cliente.setDataNascimento(dto.getDataNascimento());
		cliente.setIdade(dto.getIdade());
		cliente.setCidade(dto.getCidade());

		return cliente;
	}
	
	public static ClienteDto convertOptionalEntityToDto(Optional<Cliente> optCliente) {
		
		if(!optCliente.isPresent()) {
			throw new NoSuchElementException();
		}
		
		ClienteDto dto = new ClienteDto();
		dto.setId(optCliente.get().getId());
		dto.setNomeCliente(optCliente.get().getNomeCliente());
		dto.setSexo(optCliente.get().getSexo());
		dto.setDataNascimento(optCliente.get().getDataNascimento());
		dto.setIdade(optCliente.get().getIdade());
		dto.setCidade(optCliente.get().getCidade());
		
		return dto;
	}
	
	public static Cliente convertOptionalEntityToEntity(Optional<Cliente> optCliente) {
		
		if(!optCliente.isPresent()) {
			throw new NoSuchElementException();
		}
		
		Cliente cliente = new Cliente();
		cliente.setId(optCliente.get().getId());
		cliente.setNomeCliente(optCliente.get().getNomeCliente());
		cliente.setSexo(optCliente.get().getSexo());
		cliente.setDataNascimento(optCliente.get().getDataNascimento());
		cliente.setIdade(optCliente.get().getIdade());
		cliente.setCidade(optCliente.get().getCidade());
			
		return cliente;
		
	}

	public static List<ClienteDto> convertListEntityToListDto(List<Cliente> listEntity) {
		return listEntity.stream().map(i -> new ClienteDto(i)).collect(Collectors.toList());
	}
	
	
}
