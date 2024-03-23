package com.ivjo.ms.proyectos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivjo.ms.proyectos.domain.ViajeContratado;
import com.ivjo.ms.proyectos.services.ViajeContratadoService;

@RestController
@RequestMapping("/api/v1/viajes")
public class ViajeController {
	@Autowired
	private ViajeContratadoService viaService;
	@GetMapping
	public List<ViajeContratado> listarViajes(){
		return viaService.listarTodosV();
	}
	@GetMapping ("/{id}")
	public ViajeContratado listarPorIdV(@PathVariable Long id) {
		return viaService.BuscarPorIdV(id);
	}
	@PostMapping
	public ViajeContratado crearViaje(@RequestBody ViajeContratado viaje) {
		return viaService.grabarV(viaje);
	}
	@PutMapping("/{id}")
	public ViajeContratado editarViaje(@PathVariable Long id, @RequestBody ViajeContratado via) {
		ViajeContratado viaDB=viaService.BuscarPorIdV(id);
		viaDB.setFechaContrato(via.getFechaContrato());
		viaDB.setFechaViaje(via.getFechaViaje());
		viaDB.setMonto(via.getMonto());
			return viaService.grabarV(viaDB);
	}
	@DeleteMapping("/{id}")
	public void eliminarViaje(@PathVariable Long id) {
		viaService.eliminarV(id);
	}
	
}
