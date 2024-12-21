package br.com.cotiinformatica.services.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.dtos.ConvidadoRequestDto;
import br.com.cotiinformatica.dtos.ConvidadoResponseDto;

public interface ConvidadoService {

	ConvidadoResponseDto cadastrarConvidado(ConvidadoRequestDto request);
	
	ConvidadoResponseDto atualizarConvidado(UUID id, ConvidadoRequestDto request);
	
	ConvidadoResponseDto removerConvidado(UUID id);
	
	ConvidadoResponseDto consultarConvidadoPorId(UUID id);
	
	List<ConvidadoResponseDto> consultarConvidados();
}
