package com.ivjo.ms.proyectos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivjo.ms.proyectos.domain.Agente;


public interface AgenteRepository extends JpaRepository<Agente, Long> {
	Optional<Agente> findByDniAge(String email);
}
