package br.com.cotiinformatica.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class TestemunhoRequestDto {

	private String depoimento;
	private UUID testemunhaId;
	private UUID membroId;
}
