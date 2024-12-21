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

import br.com.cotiinformatica.dtos.ReferenciaRequestDto;
import br.com.cotiinformatica.dtos.ReferenciaResponseDto;
import br.com.cotiinformatica.services.interfaces.ReferenciaService;

@RestController
@RequestMapping("/api/referencias")
public class ReferenciaController {

	@Autowired
	private ReferenciaService referenciaService;
	
	@PostMapping
	public ReferenciaResponseDto post(@RequestBody ReferenciaRequestDto request) {
		return referenciaService.cadastrarReferencia(request);
	}
	
	@PutMapping("{id}")
	public ReferenciaResponseDto update(@PathVariable UUID idReferencia, @RequestBody ReferenciaRequestDto request) {
		return referenciaService.editarReferencia(idReferencia, request);
	}
	
	@DeleteMapping("{id}")
	public ReferenciaResponseDto delete(@PathVariable UUID idReferencia) {
		return referenciaService.removerReferencia(idReferencia);
	}
	
	@GetMapping("{id}")
	public ReferenciaResponseDto getById(@PathVariable UUID idReferencia) {
		return referenciaService.consultarReferenciaPorId(idReferencia);
	}
	
	@GetMapping
	public List<ReferenciaResponseDto> getAll() {
		return referenciaService.consultarReferencias();
	}
}
