package com.desafio.util;

import java.util.List;
import java.util.stream.Collectors;

import com.desafio.dto.ClienteDto;
import com.desafio.model.Cliente;

public class ClienteUtil {
	
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

	public static List<ClienteDto> convertListEntityToListDto(List<Cliente> listEntity) {
		return listEntity.stream().map(i -> new ClienteDto(i)).collect(Collectors.toList());
	}
	
	
}
