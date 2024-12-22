package br.com.cotiinformatica.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class TestemunhoResponseDto {

	private UUID id;
	private String depoimento;
	private MembroResponseDto testemunha;
	private MembroResponseDto membro;
}
