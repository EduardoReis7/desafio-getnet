package com.desafio.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody CidadeDTO dto) {
		
		Response<CidadeDTO> response = new Response<CidadeDTO>();
		Cidade cidade = cidadeService.save(CidadeUtil.convertDtoToEntity(dto));
		response.setData(CidadeUtil.convertEntityToDto(cidade));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping(value = "/nome-cidade/{nome}")
	public ResponseEntity<?> buscar(@PathVariable String nome) {
		Cidade cidade = cidadeService.findByNome(nome);
		CidadeUtil.convertEntityToDto(cidade);
		return ResponseEntity.ok().body(cidade);
	}
	
}
