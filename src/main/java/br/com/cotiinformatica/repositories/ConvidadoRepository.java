package br.com.cotiinformatica.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cotiinformatica.entities.Convidado;

public interface ConvidadoRepository extends JpaRepository<Convidado, UUID> {

}
