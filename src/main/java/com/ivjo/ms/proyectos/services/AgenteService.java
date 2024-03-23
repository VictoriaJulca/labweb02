package com.ivjo.ms.proyectos.services;

import java.util.List;

import com.ivjo.ms.proyectos.domain.Agente;

public interface AgenteService {
	List<Agente> listarTodosA();
	Agente buscarPorIdA(Long id);
	Agente grabarA(Agente agente);
	Agente actualizarA(Agente agente,Long id);
	void eliminarA(Long id);
	Agente findByDniAge (String dni);
}
