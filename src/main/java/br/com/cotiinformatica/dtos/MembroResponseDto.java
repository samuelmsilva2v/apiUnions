package br.com.cotiinformatica.dtos;

import java.util.UUID;

import br.com.cotiinformatica.entities.Grupo;
import lombok.Data;

@Data
public class MembroResponseDto {

	private UUID idMembro;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String empresa;
	private String curriculo;
	private String siteEmpresa;
	private Grupo grupo;
}
