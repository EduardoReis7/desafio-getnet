package com.desafio.controllers.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlterarNomeClienteForm {
	
	@NotNull(message = "O campo não pode ser nulo.")
	@NotEmpty(message = "O campo não pode estar vazio.")
	private String nomeCliente;
	
}
