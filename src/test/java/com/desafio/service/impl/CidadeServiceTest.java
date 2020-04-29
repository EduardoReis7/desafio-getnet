package com.desafio.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.desafio.dto.CidadeDto;
import com.desafio.repository.CidadeRepository;
import com.desafio.services.CidadeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class CidadeServiceTest {
	
	private static final Long ID = 1L;
	private static final String NOME_CIDADE = "Tapes";
	private static final String ESTADO = "RS";
	
	private CidadeDto cidadeDto;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	CidadeService cidadeService;
	
	@BeforeEach
	void setUp() {
		cidadeDto = new CidadeDto();
		cidadeDto.setId(ID);
		cidadeDto.setNomeCidade(NOME_CIDADE);
		cidadeDto.setEstado(ESTADO);
		
		cidadeService.save(cidadeDto);
	}
	
	@AfterEach
	void clean() {
		cidadeRepository.deleteAll();
	}
	
	@Test
	void testSave() {
		CidadeDto response = cidadeService.save(cidadeDto);
		assertNotNull(response);
	}
	
	@Test
	void testFindByNomeCidade() {
		CidadeDto response = cidadeService.findByNomeCidade(NOME_CIDADE);
		assertEquals(response.getNomeCidade(), NOME_CIDADE);
	}
	
	@Test
	void testFindByEstado() {
		CidadeDto response = cidadeService.findByEstado(ESTADO);
		assertEquals(response.getEstado(), ESTADO);
	}
}
