package br.com.cotiinformatica.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.MembroRequestDto;
import br.com.cotiinformatica.dtos.MembroResponseDto;
import br.com.cotiinformatica.entities.Grupo;
import br.com.cotiinformatica.entities.Membro;
import br.com.cotiinformatica.repositories.GrupoRepository;
import br.com.cotiinformatica.repositories.MembroRepository;
import br.com.cotiinformatica.services.interfaces.MembroService;

@Service
public class MembroServiceImpl implements MembroService {
	
	@Autowired
	private MembroRepository membroRepository;
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public MembroResponseDto cadastrarMembro(MembroRequestDto request) {
		
		List<Grupo> grupos = grupoRepository.findAllById(request.getGruposIds());
		
		var membro = modelMapper.map(request, Membro.class);
		membro.setIdMembro(UUID.randomUUID());
		membro.setGrupos(grupos);
		
		membroRepository.save(membro);
		
		grupos.forEach(grupo -> grupo.getMembros().add(membro));
		
		grupoRepository.saveAll(grupos);
		
		return modelMapper.map(membro, MembroResponseDto.class);
	}

	@Override
	public MembroResponseDto atualizarMembro(UUID idMembro, MembroRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembroResponseDto removerMembro(UUID idMembro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembroResponseDto consultarMembroPorId(UUID idMembro) {
		
		var membro = membroRepository.findById(idMembro).get();
		
		return modelMapper.map(membro, MembroResponseDto.class);
	}

	@Override
	public List<MembroResponseDto> consultarMembros() {
		return membroRepository.findAll().stream()
	            .map(membro -> modelMapper.map(membro, MembroResponseDto.class))
	            .collect(Collectors.toList());
	}

}
