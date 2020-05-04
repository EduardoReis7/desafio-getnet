package com.desafio.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome_cliente", nullable = false)
	private String nomeCliente;
	@Column(name = "sexo", nullable = false)
	private String sexo;
	@Column(name = "data_nascimento", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	@Column(name = "idade", nullable = false)
	private Integer idade;
	
	@ManyToOne
	private Cidade cidade;
	
}