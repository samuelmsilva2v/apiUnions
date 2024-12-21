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

import br.com.cotiinformatica.dtos.ReuniaoRequestDto;
import br.com.cotiinformatica.dtos.ReuniaoResponseDto;
import br.com.cotiinformatica.services.interfaces.ReuniaoService;

@RestController
@RequestMapping("/api/reunioes")
public class ReuniaoController {

	@Autowired
	private ReuniaoService reuniaoService;
	
	@PostMapping
	public String post(@RequestBody ReuniaoRequestDto request) {
		return reuniaoService.marcarReuniao(request);
	}

	@PutMapping("{idReuniao}")
	public ReuniaoResponseDto update(@PathVariable UUID idReuniao, @RequestBody ReuniaoRequestDto request) {
		return reuniaoService.editarReunião(idReuniao, request);
	}

	@DeleteMapping("{idReuniao}")
	public ReuniaoResponseDto delete(@PathVariable UUID idReuniao) {
		return reuniaoService.excluirReuniao(idReuniao);
	}

	@GetMapping("{idReuniao}")
	public ReuniaoResponseDto getById(@PathVariable UUID idReuniao) {
		return reuniaoService.consultarReuniaoPorId(idReuniao);
	}

	@GetMapping
	public List<ReuniaoResponseDto> getAll() {
		return reuniaoService.consultarReunioes();
	}
}
