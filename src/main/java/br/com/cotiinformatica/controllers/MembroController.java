package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.MembroRequestDto;
import br.com.cotiinformatica.dtos.MembroResponseDto;
import br.com.cotiinformatica.services.interfaces.MembroService;

@RestController
@RequestMapping("/api/membros")
public class MembroController {

	@Autowired
	private MembroService membroService;

	@PostMapping
	public MembroResponseDto post(@RequestBody MembroRequestDto request) {
		return membroService.cadastrarMembro(request);
	}

	@PutMapping("{idMembro}")
	public MembroResponseDto update(@PathVariable UUID idMembro, @RequestBody MembroRequestDto request) {
		return membroService.atualizarMembro(idMembro, request);
	}

	@DeleteMapping("{idMembro}")
	public MembroResponseDto delete(@PathVariable UUID idMembro) {
		return membroService.removerMembro(idMembro);
	}

	@GetMapping("{idMembro}")
	public MembroResponseDto getById(@PathVariable UUID idMembro) {
		return membroService.consultarMembroPorId(idMembro);
	}

	@GetMapping
	public List<MembroResponseDto> getAll() {
		return membroService.consultarMembros();
	}
}
