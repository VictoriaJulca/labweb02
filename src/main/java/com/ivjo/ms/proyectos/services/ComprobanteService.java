package com.ivjo.ms.proyectos.services;

import java.util.List;

import com.ivjo.ms.proyectos.domain.Comprobante;

public interface ComprobanteService {
	List<Comprobante> listarTodosC();
	Comprobante buscarPorIdC(Long id);
	Comprobante grabarC(Comprobante comprobante);
	Comprobante actualizarC(Comprobante comprobante,Long id);
	void eliminarC(Long id);
}
