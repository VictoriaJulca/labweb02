package com.ivjo.ms.proyectos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivjo.ms.proyectos.domain.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Optional<Cliente> findByDni(String dni);
	Optional<Cliente> findByEmail(String email); 
}
