package com.desafio.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.dto.CidadeDto;
import com.desafio.services.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	public CidadeService cidadeService;

	@PostMapping
	public ResponseEntity<CidadeDto> cadastrar(@Valid @RequestBody CidadeDto dto) {
		CidadeDto cidadeDto = cidadeService.save(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(cidadeDto);
	}

	@GetMapping
	public ResponseEntity<List<CidadeDto>> listarCidades() {
		List<CidadeDto> listDto = cidadeService.listarCidades();
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping(value = "/nome-cidade/{nomeCidade}")
	public ResponseEntity<List<CidadeDto>> buscarPorNome(@PathVariable String nomeCidade) {
		List<CidadeDto> cidadeDto = cidadeService.findByNomeCidade(nomeCidade);
		return ResponseEntity.ok().body(cidadeDto);
	}

	@GetMapping(value = "/estado/{estado}")
	public ResponseEntity<List<CidadeDto>> buscarPorEstado(@PathVariable String estado) {
		List<CidadeDto> cidadeDto = cidadeService.findByEstado(estado);
		return ResponseEntity.ok().body(cidadeDto);
	}

}
