package com.desafio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.repository.ClienteRepository;
import com.desafio.services.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
	
	private final ClienteService clienteService;
	
	private final ClienteRepository clienteRepository;
}
