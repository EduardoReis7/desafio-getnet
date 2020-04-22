package com.desafio.controllers.form;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AlterarNomeClienteForm {
	
	@NotNull
	private String nomeCliente;
}
