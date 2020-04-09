package com.desafio.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.dto.CidadeDTO;
import com.desafio.models.Cidade;
import com.desafio.response.Response;
import com.desafio.services.CidadeService;
import com.desafio.util.CidadeUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cidades")
@RequiredArgsConstructor
public class CidadeController {
	
	public final CidadeService cidadeService;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody CidadeDTO dto) {
		
		Response<CidadeDTO> response = new Response<CidadeDTO>();
		Cidade cidade = cidadeService.save(CidadeUtil.convertDtoToEntity(dto));
		response.setData(CidadeUtil.convertEntityToDto(cidade));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping(value = "/nome-cidade/{nome}")
	public ResponseEntity<?> buscarPorNome(@PathVariable String nome) {
		Cidade cidade = cidadeService.findByNome(nome);
		CidadeDTO dto = CidadeUtil.convertEntityToDto(cidade);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/estado/{estado}")
	public ResponseEntity<?> buscarPorEstado(@PathVariable String estado) {
		Cidade cidade = cidadeService.findByEstado(estado);
		CidadeDTO dto = CidadeUtil.convertEntityToDto(cidade);
		return ResponseEntity.ok().body(dto);
	}
	
}
