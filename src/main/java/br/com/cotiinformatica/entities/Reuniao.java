package br.com.cotiinformatica.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Reuniao {

	@Id
	private UUID idReuniao;
	private Date dataEHora;
	private String local;
	private String motivo;

	@ManyToOne
	@JoinColumn(name = "id_solicitante", nullable = false)
	private Membro solicitante;
	
	@ManyToOne
    @JoinColumn(name = "id_convidado", nullable = false)
	private Membro convidado;
}
