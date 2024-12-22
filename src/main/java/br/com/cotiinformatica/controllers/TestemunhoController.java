package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.TestemunhoRequestDto;
import br.com.cotiinformatica.dtos.TestemunhoResponseDto;
import br.com.cotiinformatica.services.interfaces.TestemunhoService;

@RestController
@RequestMapping("/api/testemunho")
public class TestemunhoController {
	
	@Autowired
	private TestemunhoService testemunhoService;

	@PostMapping
	public TestemunhoResponseDto post(@RequestBody TestemunhoRequestDto request) {
		return testemunhoService.cadastrarTestemunho(request);
	}
	
	@GetMapping("{id}")
	public TestemunhoResponseDto getById(@PathVariable UUID id) {
		return testemunhoService.consultarTestemunhoPorId(id);
	}
	
	@GetMapping()
	public List<TestemunhoResponseDto> getAll() {
		return testemunhoService.consultarTestemunhos();
	}
}
