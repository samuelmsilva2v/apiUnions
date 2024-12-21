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

import br.com.cotiinformatica.dtos.GrupoRequestDto;
import br.com.cotiinformatica.dtos.GrupoResponseDto;
import br.com.cotiinformatica.services.interfaces.GrupoService;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

	@Autowired
	private GrupoService grupoService;
	
	@PostMapping
	public GrupoResponseDto post(@RequestBody GrupoRequestDto request) {
		return grupoService.cadastrarGrupo(request);
	}
	
	@PutMapping("{idGrupo}")
	public GrupoResponseDto update(@PathVariable UUID idGrupo, @RequestBody GrupoRequestDto request) {
		return grupoService.atualizarGrupo(idGrupo, request);
	}
	
	@DeleteMapping("{idGrupo}")
	public GrupoResponseDto delete(@PathVariable UUID idGrupo) {
		return grupoService.removerGrupo(idGrupo);
	}
	
	@GetMapping("{idGrupo}")
	public GrupoResponseDto getById(@PathVariable UUID idGrupo) {
		return grupoService.consultarGrupoPorId(idGrupo);
	}
	
	@GetMapping
	public List<GrupoResponseDto> getAll() {
		return grupoService.consultarGrupos();
	}
	
}
