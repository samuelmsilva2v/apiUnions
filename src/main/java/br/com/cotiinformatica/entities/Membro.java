package br.com.cotiinformatica.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Membro {

	@Id
	private UUID idMembro;
	@Column(length = 150)
	private String nome;
	@Column(length = 150)
	private String email;
	private String senha;
	@Column(length = 50)
	private String telefone;
	@Column(length = 150)
	private String empresa;
	private String curriculo;
	@Column(length = 100)
	private String siteEmpresa;
	
	@ManyToMany
    @JoinTable(
        name = "membro_grupo",
        joinColumns = @JoinColumn(name = "membro_id"),
        inverseJoinColumns = @JoinColumn(name = "grupo_id")
    )
	private List<Grupo> grupos;

}
