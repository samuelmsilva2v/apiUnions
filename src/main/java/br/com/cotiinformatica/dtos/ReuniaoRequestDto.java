package br.com.cotiinformatica.dtos;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class ReuniaoRequestDto {

	private Date dataEHora;
	private String local;
	private String motivo;
	private UUID solicitanteId;
	private UUID convidadoId;
}
