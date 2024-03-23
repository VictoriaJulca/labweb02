package com.ivjo.ms.proyectos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivjo.ms.proyectos.domain.Destino;

public interface DestinoRepository extends JpaRepository<Destino, Long> {
	Optional<Destino> findByNomDestino(String nomDestino );
}
