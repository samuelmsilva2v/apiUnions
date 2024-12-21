package br.com.cotiinformatica.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idGrupo;
	@Column(length = 100)
	private String nome;
	
	@ManyToMany(mappedBy = "grupos")
	private List<Membro> membros;
}
