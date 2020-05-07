package com.desafio.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.desafio.model.Cidade;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class CidadeRepositoryTest {
	
	private static final Long ID = 1L;
	private static final String NOME_CIDADE = "Tapes";
	private static final String ESTADO = "RS";
	
	private Cidade cidade;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		cidade = new Cidade();
		cidade.setId(ID);
		cidade.setNomeCidade(NOME_CIDADE);
		cidade.setEstado(ESTADO);
		
		cidadeRepository.save(cidade);
	}
	
	@AfterEach
	void clean() throws Exception {
		cidadeRepository.deleteAll();
	}
	
	@Test
	void testSave() throws Exception {
		cidade = new Cidade();
		cidade.setId(2L);
		cidade.setNomeCidade("Chapecó");
		cidade.setEstado("SC");
		
		Cidade response = cidadeRepository.save(cidade);
		
		assertNotNull(response);
	}
}
