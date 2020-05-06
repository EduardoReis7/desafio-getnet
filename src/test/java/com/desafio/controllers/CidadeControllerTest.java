package com.desafio.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.desafio.dto.CidadeDto;
import com.desafio.repository.CidadeRepository;
import com.desafio.services.CidadeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class CidadeControllerTest {
	
	private static final Long ID = 1L;
	private static final String NOME_CIDADE = "Tapes";
	private static final String ESTADO = "RS";
	private static final String URL = "/cidades";
	
	private CidadeDto cidadeDto;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	CidadeService cidadeService;
	
	@Autowired
	MockMvc mvc;
	
	@BeforeEach
	void setUp() throws Exception {
		cidadeDto = new CidadeDto();
		cidadeDto.setId(ID);
		cidadeDto.setNomeCidade(NOME_CIDADE);
		cidadeDto.setEstado(ESTADO);
		
		cidadeService.save(cidadeDto);
	}
	
	@AfterEach
	void clean() throws Exception {
		cidadeRepository.deleteAll();
	}
	
	@Test
	void testCadastrarCidadeValida() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayLoad(ID, NOME_CIDADE, ESTADO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}
	
	
	@Test
	void testCadastrarCidadeNull() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post(URL).content("")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	void testListarCidades() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(URL)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	void testBuscarCidadePorNome() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(URL + "/nome-cidade/" + cidadeDto.getNomeCidade())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	void testBuscarCidadePorEstado() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(URL + "/estado/" + cidadeDto.getEstado())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	String getJsonPayLoad(Long id, String nome, String estado) throws Exception {
		cidadeDto = new CidadeDto();
		cidadeDto.setId(id);
		cidadeDto.setNomeCidade(nome);
		cidadeDto.setEstado(estado);
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(cidadeDto);
	}
}