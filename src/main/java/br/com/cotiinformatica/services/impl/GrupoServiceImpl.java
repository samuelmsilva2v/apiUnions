package br.com.cotiinformatica.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.GrupoRequestDto;
import br.com.cotiinformatica.dtos.GrupoResponseDto;
import br.com.cotiinformatica.entities.Grupo;
import br.com.cotiinformatica.repositories.GrupoRepository;
import br.com.cotiinformatica.services.interfaces.GrupoService;

@Service
public class GrupoServiceImpl implements GrupoService {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public GrupoResponseDto cadastrarGrupo(GrupoRequestDto request) {
		
		var grupo = modelMapper.map(request, Grupo.class);
		grupo.setIdGrupo(UUID.randomUUID());	
		
		grupoRepository.save(grupo);
		
		return modelMapper.map(grupo, GrupoResponseDto.class);
	}

	@Override
	public GrupoResponseDto atualizarGrupo(UUID idGrupo, GrupoRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GrupoResponseDto removerGrupo(UUID idGrupo) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GrupoResponseDto consultarGrupoPorId(UUID idGrupo) {
		
		var grupo = grupoRepository.findById(idGrupo).get();
		
		return modelMapper.map(grupo, GrupoResponseDto.class);
	}

	@Override
	public List<GrupoResponseDto> consultarGrupos() {
		return grupoRepository.findAll().stream()
	            .map(grupo -> modelMapper.map(grupo, GrupoResponseDto.class))
	            .collect(Collectors.toList());
	}

}
