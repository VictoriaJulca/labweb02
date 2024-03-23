package com.ivjo.ms.proyectos.services;

import java.util.List;


import com.ivjo.ms.proyectos.domain.ViajeContratado;

public interface ViajeContratadoService {
	List <ViajeContratado>listarTodosV();
	ViajeContratado BuscarPorIdV(Long idv);
	ViajeContratado grabarV(ViajeContratado viajeContratado);
	ViajeContratado actualizarV(ViajeContratado viajeContratado, Long idv);
	void eliminarV(Long idv);

}
