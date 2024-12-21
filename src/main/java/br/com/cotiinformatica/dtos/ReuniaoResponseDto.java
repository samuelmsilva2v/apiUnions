package br.com.cotiinformatica.dtos;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class ReuniaoResponseDto {

	private UUID idReuniao;
	private Date dataEHora;
	private String local;
	private String motivo;
	private MembroResponseDto solicitante;
	private MembroResponseDto convidado;
}
