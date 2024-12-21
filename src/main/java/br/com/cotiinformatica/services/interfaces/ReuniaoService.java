package br.com.cotiinformatica.services.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.dtos.ReuniaoRequestDto;
import br.com.cotiinformatica.dtos.ReuniaoResponseDto;

public interface ReuniaoService {

	String marcarReuniao(ReuniaoRequestDto request);
    
	ReuniaoResponseDto editarReunião(UUID idReuniao, ReuniaoRequestDto request);
	
	ReuniaoResponseDto excluirReuniao(UUID idReuniao);
	
	ReuniaoResponseDto consultarReuniaoPorId(UUID idReuniao);
	
    List<ReuniaoResponseDto> consultarReunioes();
}
