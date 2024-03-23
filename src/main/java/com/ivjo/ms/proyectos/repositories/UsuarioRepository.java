package com.ivjo.ms.proyectos.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ivjo.ms.proyectos.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByEmail(String email);
}
