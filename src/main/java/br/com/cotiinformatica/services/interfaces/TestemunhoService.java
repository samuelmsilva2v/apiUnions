package br.com.cotiinformatica.services.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.dtos.TestemunhoRequestDto;
import br.com.cotiinformatica.dtos.TestemunhoResponseDto;

public interface TestemunhoService {

	TestemunhoResponseDto cadastrarTestemunho(TestemunhoRequestDto request);

	TestemunhoResponseDto consultarTestemunhoPorId(UUID id);

	List<TestemunhoResponseDto> consultarTestemunhos();
}
