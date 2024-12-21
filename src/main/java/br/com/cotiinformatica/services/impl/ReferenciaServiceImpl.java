package br.com.cotiinformatica.services.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.MembroResponseDto;
import br.com.cotiinformatica.dtos.ReferenciaRequestDto;
import br.com.cotiinformatica.dtos.ReferenciaResponseDto;
import br.com.cotiinformatica.entities.Referencia;
import br.com.cotiinformatica.repositories.MembroRepository;
import br.com.cotiinformatica.repositories.ReferenciaRepository;
import br.com.cotiinformatica.services.interfaces.ReferenciaService;

@Service
public class ReferenciaServiceImpl implements ReferenciaService {
	
	@Autowired
	private ReferenciaRepository referenciaRepository;
	
	@Autowired
	private MembroRepository membroRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ReferenciaResponseDto cadastrarReferencia(ReferenciaRequestDto request) {
		
		var avaliador = membroRepository.findById(request.getAvaliadorId()).get();
		
		var avaliado = membroRepository.findById(request.getAvaliadoId()).get();
		
		var referencia = new Referencia();
		referencia.setIdReferencia(UUID.randomUUID());
		referencia.setObservacoes(request.getObservacoes());
		referencia.setTipoReferencia(request.getTipoReferencia());
		referencia.setAvaliacao(request.getAvaliacao());
		referencia.setAvaliador(avaliador);
		referencia.setAvaliado(avaliado);
		
		referenciaRepository.save(referencia);
		
		var response = new ReferenciaResponseDto();
		response.setIdReferencia(referencia.getIdReferencia());
		response.setObservacoes(referencia.getObservacoes());
		response.setTipoReferencia(referencia.getTipoReferencia());
		response.setAvaliacao(referencia.getAvaliacao());
		response.setAvaliador(modelMapper.map(referencia.getAvaliador(), MembroResponseDto.class));
		response.setAvaliado(modelMapper.map(referencia.getAvaliado(), MembroResponseDto.class));
		
		return response;
	}

	@Override
	public ReferenciaResponseDto editarReferencia(UUID idReferencia, ReferenciaRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReferenciaResponseDto removerReferencia(UUID idReferencia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReferenciaResponseDto consultarReferenciaPorId(UUID idReferencia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReferenciaResponseDto> consultarReferencias() {
		// TODO Auto-generated method stub
		return null;
	}

}
