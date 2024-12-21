package br.com.cotiinformatica.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Convidado {

	@Id
	private UUID idConvidado;
	@Column(length = 100)
	private String nome;
	private String telefone;
	@Column(length = 100)
	private String email;
	@Column(length = 50)
	private String especialidade;
	
	@ManyToOne
    @JoinColumn(name = "membro_id", nullable = false)
    private Membro membro;
}
