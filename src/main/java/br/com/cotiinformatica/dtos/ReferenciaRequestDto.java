package br.com.cotiinformatica.dtos;

import java.util.UUID;

import br.com.cotiinformatica.enums.Avaliacao;
import br.com.cotiinformatica.enums.TipoReferencia;
import lombok.Data;

@Data
public class ReferenciaRequestDto {

	private String observacoes;
	private TipoReferencia tipoReferencia;
	private Avaliacao avaliacao;
	private UUID avaliadorId;
	private UUID avaliadoId;
}
