package com.desafio.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.controllers.form.AlterarNomeClienteForm;
import com.desafio.dto.ClienteDto;
import com.desafio.model.Cliente;
import com.desafio.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<ClienteDto> cadastrar(@Valid @RequestBody ClienteDto dto) {
		ClienteDto clienteDto = clienteService.save(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteDto);
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> listaCliente = clienteService.listar();
		return ResponseEntity.ok().body(listaCliente);
	}

	@GetMapping(value = "/{nomeCliente}")
	public ResponseEntity<List<ClienteDto>> buscarClientePeloNome(String nomeCliente) {
		List<ClienteDto> clienteDto = clienteService.buscarPorNomeCliente(nomeCliente);
		return ResponseEntity.ok().body(clienteDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDto> buscarClientePeloId(String id) {
		ClienteDto clienteDto = clienteService.buscarPorId(id);
		return ResponseEntity.ok().body(clienteDto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDto> alterarNomeCliente(@PathVariable String id, @Valid @RequestBody AlterarNomeClienteForm form) {
		clienteService.alterarNomeCliente(id, form);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClienteDto> deletarClientePeloId(@PathVariable String id) {
		clienteService.removerPorId(id);
		return ResponseEntity.noContent().build();
	}
}
