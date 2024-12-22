package br.com.cotiinformatica.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Testemunho {

	@Id
	private UUID id;
	private String depoimento;
	
	@ManyToOne
    @JoinColumn(name = "testemunha_id", nullable = false)
    private Membro testemunha;
	
	@ManyToOne
    @JoinColumn(name = "membro_id", nullable = false)
    private Membro membro;
}
