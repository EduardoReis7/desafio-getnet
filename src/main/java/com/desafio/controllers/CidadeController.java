package com.desafio.controllers;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.dto.CidadeDto;
import com.desafio.response.Response;
import com.desafio.services.CidadeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cidades")
@RequiredArgsConstructor
public class CidadeController {
	
	public final CidadeService cidadeService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Response<CidadeDto>> cadastrar(@RequestBody CidadeDto dto) {
		
		Response<CidadeDto> response = new Response<CidadeDto>();
		CidadeDto cidadeDto = cidadeService.save(dto);
		response.setData(cidadeDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping(value = "/nome-cidade/{nomeCidade}")
	public ResponseEntity<?> buscarPorNome(@PathVariable String nomeCidade) {
		CidadeDto cidadeDto = cidadeService.findByNomeCidade(nomeCidade);
		return ResponseEntity.ok().body(cidadeDto);
	}
	
	@GetMapping(value = "/estado/{estado}")
	public ResponseEntity<?> buscarPorEstado(@PathVariable String estado) {
		CidadeDto cidadeDto = cidadeService.findByEstado(estado);
		return ResponseEntity.ok().body(cidadeDto);
	}
	
}
