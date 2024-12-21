package br.com.cotiinformatica.services.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.dtos.MembroRequestDto;
import br.com.cotiinformatica.dtos.MembroResponseDto;

public interface MembroService {
	
	MembroResponseDto cadastrarMembro(MembroRequestDto request);
	
	MembroResponseDto atualizarMembro(UUID id, MembroRequestDto request);
	
	MembroResponseDto removerMembro(UUID id);
	
	MembroResponseDto consultarMembroPorId(UUID id);
	
	List<MembroResponseDto> consultarMembros();
}
