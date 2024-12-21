package br.com.cotiinformatica.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cotiinformatica.entities.Membro;

public interface MembroRepository extends JpaRepository<Membro, UUID> {

}
