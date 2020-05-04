package com.desafio.controllers.form;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlterarNomeClienteForm {
	
	@NotNull
	private String nomeCliente;
	
}
