package br.com.cotiinformatica.entities;

import java.util.UUID;

import br.com.cotiinformatica.enums.Avaliacao;
import br.com.cotiinformatica.enums.TipoReferencia;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Referencia {

	@Id
	private UUID idReferencia;
	private String observacoes;
	private TipoReferencia tipoReferencia;
	private Avaliacao avaliacao;

	@ManyToOne
	@JoinColumn(name = "id_avaliador", nullable = false)
	private Membro avaliador;
	@ManyToOne
	@JoinColumn(name = "id_avaliado", nullable = false)
	private Membro avaliado;
}
