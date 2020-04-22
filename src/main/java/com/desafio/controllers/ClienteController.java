package com.desafio.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.controllers.form.AlterarNomeClienteForm;
import com.desafio.dto.ClienteDto;
import com.desafio.model.Cliente;
import com.desafio.response.Response;
import com.desafio.services.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

	private final ClienteService clienteService;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@Valid @RequestBody ClienteDto dto) {

		Response<ClienteDto> response = new Response<ClienteDto>();
		ClienteDto clienteDto = clienteService.save(dto);
		response.setData(clienteDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<?> listar() {
		List<Cliente> listaCliente = clienteService.listar();
		return ResponseEntity.ok().body(listaCliente);
	}

	@GetMapping(value = "/{nomeCliente}")
	public ResponseEntity<ClienteDto> buscarClientePeloNome(String nomeCliente) {
		ClienteDto clienteDto = clienteService.buscarPorNomeCliente(nomeCliente);
		return ResponseEntity.ok().body(clienteDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarClientePeloId(Long id) {
		ClienteDto clienteDto = clienteService.buscarPorId(id);
		return ResponseEntity.ok().body(clienteDto);
	}

	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<?> alterarNomeCliente(Long id, @Valid @RequestBody AlterarNomeClienteForm form) {
		Response<ClienteDto> response = new Response<ClienteDto>();
		ClienteDto clienteDto = clienteService.alterarNomeCliente(id, form);
		response.setData(clienteDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletarClientePeloId(Long id) {
		clienteService.removerPorId(id);
		return ResponseEntity.noContent().build();
	}
}
