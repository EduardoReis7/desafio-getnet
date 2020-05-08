package com.desafio.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.dto.CidadeDto;
import com.desafio.exception.BadRequestException;
import com.desafio.model.Cidade;
import com.desafio.repository.CidadeRepository;
import com.desafio.services.CidadeService;
import com.desafio.util.CidadeUtil;

@Service
public class CidadeServiceImpl implements CidadeService{
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public CidadeDto save(CidadeDto dto) {
		Cidade cidade = CidadeUtil.convertDtoToEntity(dto);
		Optional<Cidade> cidadeExistente = buscarPorNomeCidadeEEstado(cidade.getNomeCidade(), cidade.getEstado());
		
		if (cidadeExistente.isPresent()) {
			throw new BadRequestException("Já existe uma cidade com este nome para este mesmo estado.");
		}
			return CidadeUtil.convertEntityToDto(cidadeRepository.save(cidade));
	}

	@Override
	public List<CidadeDto> findByNomeCidade(String nome) {
		return CidadeUtil.convertListEntityToListDto(cidadeRepository.findByNomeCidade(nome));
	}

	@Override
	public List<CidadeDto> findByEstado(String estado) {
		return CidadeUtil.convertListEntityToListDto(cidadeRepository.findByEstado(estado));
	}

	@Override
	public List<CidadeDto> listarCidades() {
		return CidadeUtil.convertListEntityToListDto(cidadeRepository.findAll());
	}

	@Override
	public Optional<Cidade> buscarPorNomeCidadeEEstado(String nomeCidade, String estado) {
		return cidadeRepository.findByNomeCidadeAndEstado(nomeCidade, estado);
	}
	
}