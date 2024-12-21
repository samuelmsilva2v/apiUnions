package br.com.cotiinformatica.services.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.dtos.GrupoRequestDto;
import br.com.cotiinformatica.dtos.GrupoResponseDto;

public interface GrupoService {

	GrupoResponseDto cadastrarGrupo(GrupoRequestDto request);

	GrupoResponseDto atualizarGrupo(UUID idGrupo, GrupoRequestDto request);

	GrupoResponseDto removerGrupo(UUID idGrupo);
	
	GrupoResponseDto consultarGrupoPorId(UUID idGrupo);
	
	List<GrupoResponseDto> consultarGrupos();
}
