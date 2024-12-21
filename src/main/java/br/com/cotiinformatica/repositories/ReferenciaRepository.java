package br.com.cotiinformatica.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cotiinformatica.entities.Referencia;

public interface ReferenciaRepository extends JpaRepository<Referencia, UUID>{

}
