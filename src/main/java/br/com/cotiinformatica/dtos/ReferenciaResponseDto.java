package br.com.cotiinformatica.dtos;

import java.util.UUID;

import br.com.cotiinformatica.enums.Avaliacao;
import br.com.cotiinformatica.enums.TipoReferencia;
import lombok.Data;

@Data
public class ReferenciaResponseDto {

	private UUID idReferencia;
	private String observacoes;
	private TipoReferencia tipoReferencia;
	private Avaliacao avaliacao;
	private MembroResponseDto avaliador;
	private MembroResponseDto avaliado;
}
