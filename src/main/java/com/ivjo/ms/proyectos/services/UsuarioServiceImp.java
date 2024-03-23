package com.ivjo.ms.proyectos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivjo.ms.proyectos.domain.Usuario;
import com.ivjo.ms.proyectos.repositories.UsuarioRepository;
@Service
public class UsuarioServiceImp implements UsuarioService {
	@Autowired
	private UsuarioRepository usuRep;
	@Override
	@Transactional
	public List<Usuario> listarTodosUsuario() {
		return usuRep.findAll();
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public Usuario BuscarPorIdU(Long id) {
		Optional <Usuario> usuario=usuRep.findById(id);
		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario grabarU(Usuario usuario) {
		return usuRep.save(usuario);
	}

	@Override
	@Transactional
	public Usuario actualizarU(Usuario usuario, Long id) {
		usuario.setId(id);
		return usuRep.save(usuario);
	}
	@Override
	@Transactional
	public void eliminarU(Long id) {
		usuRep.deleteById(id);

	}

	@Override
	@Transactional
	public Usuario findByEmail(String email) {
		return usuRep.findByEmail(email).get();
	}

}
