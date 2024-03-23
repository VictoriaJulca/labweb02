package com.ivjo.ms.proyectos.services;

import java.util.List;

import com.ivjo.ms.proyectos.domain.Usuario;

public interface UsuarioService {
	List <Usuario>listarTodosUsuario();
	Usuario BuscarPorIdU(Long id);
	Usuario grabarU(Usuario usuario);
	Usuario actualizarU(Usuario usuario, Long id);
	void eliminarU(Long id);
	Usuario findByEmail (String email);
}
