package br.com.cotiinformatica.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.entities.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, UUID>{

	@Query("SELECT g FROM Grupo g WHERE g.id IN :ids")
	List<Grupo> findAllById(@Param("ids") List<Long> ids);
}
