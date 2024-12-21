package br.com.cotiinformatica.dtos;

import java.util.UUID;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class GrupoResponseDto {

	@Id
	private UUID idGrupo;
	private String nome;
}
