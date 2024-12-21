package br.com.cotiinformatica.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.ReuniaoRequestDto;
import br.com.cotiinformatica.dtos.ReuniaoResponseDto;
import br.com.cotiinformatica.entities.Reuniao;
import br.com.cotiinformatica.repositories.MembroRepository;
import br.com.cotiinformatica.repositories.ReuniaoRepository;
import br.com.cotiinformatica.services.interfaces.ReuniaoService;

@Service
public class ReuniaoServiceImpl implements ReuniaoService {

	@Autowired
	private ReuniaoRepository reuniaoRepository;

	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String marcarReuniao(ReuniaoRequestDto request) {

		var solicitante = membroRepository.findById(request.getSolicitanteId()).get();

		var convidado = membroRepository.findById(request.getConvidadoId()).get();

		var reuniao = new Reuniao();
		reuniao.setIdReuniao(UUID.randomUUID());
		reuniao.setDataEHora(request.getDataEHora());
		reuniao.setMotivo(request.getMotivo());
		reuniao.setSolicitante(solicitante);
		reuniao.setConvidado(convidado);

		reuniaoRepository.save(reuniao);
		
		return "Reunião marcada com sucesso!";
	}

	@Override
	public ReuniaoResponseDto editarReunião(UUID idReuniao, ReuniaoRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReuniaoResponseDto excluirReuniao(UUID idReuniao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReuniaoResponseDto consultarReuniaoPorId(UUID idReuniao) {
		return modelMapper.map(reuniaoRepository.findById(idReuniao).get(), ReuniaoResponseDto.class);
	}

	@Override
	public List<ReuniaoResponseDto> consultarReunioes() {
		return reuniaoRepository.findAll().stream()
	            .map(reuniao -> modelMapper.map(reuniao, ReuniaoResponseDto.class))
	            .collect(Collectors.toList());
	}

}
