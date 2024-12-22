package br.com.cotiinformatica.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.MembroResponseDto;
import br.com.cotiinformatica.dtos.TestemunhoRequestDto;
import br.com.cotiinformatica.dtos.TestemunhoResponseDto;
import br.com.cotiinformatica.entities.Testemunho;
import br.com.cotiinformatica.repositories.MembroRepository;
import br.com.cotiinformatica.repositories.TestemunhoRepository;
import br.com.cotiinformatica.services.interfaces.TestemunhoService;

@Service
public class TestemunhoServiceImpl implements TestemunhoService {

	@Autowired
	private TestemunhoRepository testemunhoRepository;
	
	@Autowired
	private MembroRepository membroRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public TestemunhoResponseDto cadastrarTestemunho(TestemunhoRequestDto request) {
		
		var testemunha = membroRepository.findById(request.getTestemunhaId()).get();
		
		var membro = membroRepository.findById(request.getMembroId()).get();
		
		var testemunho = new Testemunho();
		testemunho.setId(UUID.randomUUID());
		testemunho.setDepoimento(request.getDepoimento());
		testemunho.setTestemunha(testemunha);
		testemunho.setMembro(membro);
		
		testemunhoRepository.save(testemunho);
		
		var response = new TestemunhoResponseDto();
		response.setId(testemunho.getId());
		response.setDepoimento(testemunho.getDepoimento());
		response.setTestemunha(modelMapper.map(testemunho.getTestemunha(), MembroResponseDto.class));
		response.setMembro(modelMapper.map(testemunho.getMembro(), MembroResponseDto.class));
		
		return response;
	}

	@Override
	public TestemunhoResponseDto consultarTestemunhoPorId(UUID id) {
		return modelMapper.map(testemunhoRepository.findById(id).get(), TestemunhoResponseDto.class);
	}

	@Override
	public List<TestemunhoResponseDto> consultarTestemunhos() {
		return testemunhoRepository.findAll().stream()
	            .map(testemunho -> modelMapper.map(testemunho, TestemunhoResponseDto.class))
	            .collect(Collectors.toList());
	}

	
}
