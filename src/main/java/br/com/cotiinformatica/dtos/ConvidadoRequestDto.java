package br.com.cotiinformatica.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class ConvidadoRequestDto {
	
	private String nome;
	private String telefone;
	private String email;
	private String especialidade;
	private UUID membroId;
}
