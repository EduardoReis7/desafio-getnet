package com.desafio.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

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

import com.desafio.controllers.form.AlterarNomeClienteForm;
import com.desafio.dto.CidadeDto;
import com.desafio.dto.ClienteDto;
import com.desafio.model.Cidade;
import com.desafio.repository.CidadeRepository;
import com.desafio.repository.ClienteRepository;
import com.desafio.services.CidadeService;
import com.desafio.services.ClienteService;
import com.desafio.util.CidadeUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class ClienteControllerTest {
	
	private static final String NOME_CLIENTE = "Eduardo";
	private static final String SEXO = "Masculino";
	private static final LocalDate DATA_NASCIMENTO = LocalDate.of(2000,07,07);
	private static final Integer IDADE = 19;
	private static final String URL = "/clientes";
	
	private ClienteDto clienteDto2;
	private ClienteDto clienteDto;
	private CidadeDto cidade2;
	private AlterarNomeClienteForm alterarNomeClienteForm;
	
	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	CidadeService cidadeService;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	MockMvc mvc;
	
	@BeforeEach
	void setUp() throws Exception {
		
		Cidade cidade = new Cidade();
		cidade.setNomeCidade("Porto Alegre");
		cidade.setEstado("RS");
		
		cidade2 = cidadeService.save(CidadeUtil.convertEntityToDto(cidade));
		
		clienteDto = new ClienteDto();
		clienteDto.setNomeCliente(NOME_CLIENTE);
		clienteDto.setSexo(SEXO);
		clienteDto.setDataNascimento(DATA_NASCIMENTO);
		clienteDto.setIdade(IDADE);
		clienteDto.setCidade(CidadeUtil.convertDtoToEntity(cidade2));
		
		clienteDto2  =  clienteService.save(clienteDto);
		
		alterarNomeClienteForm = new AlterarNomeClienteForm();
		alterarNomeClienteForm.setNomeCliente("Julio");
		
	}
	
	@AfterEach
	void clean() throws Exception {
		clienteRepository.deleteAll();
		cidadeRepository.deleteAll();
	}
	
	@Test
	void testCadastrarCliente() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayLoad())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}
	
	@Test
	void testBuscarClientePorNome() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(URL+"?nomeCliente="+clienteDto.getNomeCliente())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	void testBuscarClientePorId() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(URL+"?id="+clienteDto.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	void testListarClientes() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(URL)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	void testDeletarClientePorId() throws Exception {
		mvc.perform(MockMvcRequestBuilders.delete(URL+"/"+clienteDto2.getId()))
				.andExpect(status().isNoContent());
	}
	
	@Test
	void testAtualizarNomeCliente() throws Exception {
		mvc.perform(MockMvcRequestBuilders.put(URL+"/"+clienteDto2.getId())
				.content(getJsonAlterarNome())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
	
	String getJsonPayLoad() throws Exception {
		return clienteDto2.toString();
	}
	
	String getJsonAlterarNome() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(alterarNomeClienteForm);
	}
}
