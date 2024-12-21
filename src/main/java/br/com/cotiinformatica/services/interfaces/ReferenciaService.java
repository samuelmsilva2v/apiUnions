package br.com.cotiinformatica.services.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.dtos.ReferenciaRequestDto;
import br.com.cotiinformatica.dtos.ReferenciaResponseDto;

public interface ReferenciaService {

	ReferenciaResponseDto cadastrarReferencia(ReferenciaRequestDto request);
	
	ReferenciaResponseDto editarReferencia(UUID idReferencia, ReferenciaRequestDto request);
	
	ReferenciaResponseDto removerReferencia(UUID idReferencia);
	
	ReferenciaResponseDto consultarReferenciaPorId(UUID idReferencia);
	
	List<ReferenciaResponseDto> consultarReferencias();
}
