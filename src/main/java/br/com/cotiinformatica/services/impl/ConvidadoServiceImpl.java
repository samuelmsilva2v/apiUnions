package br.com.cotiinformatica.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.ConvidadoRequestDto;
import br.com.cotiinformatica.dtos.ConvidadoResponseDto;
import br.com.cotiinformatica.entities.Convidado;
import br.com.cotiinformatica.repositories.ConvidadoRepository;
import br.com.cotiinformatica.repositories.MembroRepository;
import br.com.cotiinformatica.services.interfaces.ConvidadoService;

@Service
public class ConvidadoServiceImpl implements ConvidadoService {

	@Autowired
	private ConvidadoRepository convidadoRepository;

	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ConvidadoResponseDto cadastrarConvidado(ConvidadoRequestDto request) {
		
		var membro = membroRepository.findById(request.getMembroId()).get();
		
		var convidado = modelMapper.map(request, Convidado.class);
		convidado.setIdConvidado(UUID.randomUUID());
		convidado.setMembro(membro);
		
		convidadoRepository.save(convidado);
		
		return modelMapper.map(convidado, ConvidadoResponseDto.class);
	}

	@Override
	public ConvidadoResponseDto atualizarConvidado(UUID id, ConvidadoRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConvidadoResponseDto removerConvidado(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConvidadoResponseDto consultarConvidadoPorId(UUID id) {
		
		var convidado = convidadoRepository.findById(id).get();

		return modelMapper.map(convidado, ConvidadoResponseDto.class);
	}

	@Override
	public List<ConvidadoResponseDto> consultarConvidados() {
		return convidadoRepository.findAll().stream()
	            .map(convidado -> modelMapper.map(convidado, ConvidadoResponseDto.class))
	            .collect(Collectors.toList());
	}

}
