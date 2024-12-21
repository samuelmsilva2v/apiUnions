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

import br.com.cotiinformatica.dtos.ConvidadoRequestDto;
import br.com.cotiinformatica.dtos.ConvidadoResponseDto;
import br.com.cotiinformatica.services.interfaces.ConvidadoService;

@RestController
@RequestMapping("/api/convidados")
public class ConvidadoController {

	@Autowired
	private ConvidadoService convidadoService;
	
	@PostMapping
	public ConvidadoResponseDto post(@RequestBody ConvidadoRequestDto request) {
		return convidadoService.cadastrarConvidado(request);
	}
	
	@PutMapping("{idConvidado}")
	public ConvidadoResponseDto update(@PathVariable UUID idConvidado, @RequestBody ConvidadoRequestDto request) {
		return convidadoService.atualizarConvidado(idConvidado, request);
	}
	
	@DeleteMapping("{idConvidado}")
	public ConvidadoResponseDto delete(@PathVariable UUID idConvidado) {
		return convidadoService.removerConvidado(idConvidado);
	}
	
	@GetMapping("{idConvidado}")
	public ConvidadoResponseDto getById(@PathVariable UUID idConvidado) {
		return convidadoService.consultarConvidadoPorId(idConvidado);
	}
	
	@GetMapping
	public List<ConvidadoResponseDto> getAll() {
		return convidadoService.consultarConvidados();
	}
}
