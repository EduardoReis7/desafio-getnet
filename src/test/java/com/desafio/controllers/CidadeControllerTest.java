package com.desafio.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.desafio.dto.CidadeDto;
import com.desafio.repository.CidadeRepository;
import com.desafio.services.CidadeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CidadeControllerTest {
	
	@MockBean
	CidadeRepository cidadeRepository;
	
	@MockBean
	CidadeService cidadeService;
	
//	@Before
//	public void setUp() throws Exception{
//		
//	}
	
	@Test
	public void testCadastrar() throws Exception {
		CidadeDto cidadeDto = new CidadeDto();
		cidadeService.save(cidadeDto);
		assertEquals(cidadeRepository.findAll(), 0);
	}
}
