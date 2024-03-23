package com.ivjo.ms.proyectos.services;

import java.util.List;
import com.ivjo.ms.proyectos.domain.Destino;

public interface DestinoService {
	List<Destino> listarTodosD();
	Destino buscarPorIdD(Long idd);
	Destino grabarD(Destino destino);
	Destino actualizarD(Destino destino,Long idd);
	void eliminarD(Long idd);
	Destino findByNomDestino (String nom);
}
