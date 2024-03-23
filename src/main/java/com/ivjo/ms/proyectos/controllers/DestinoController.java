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

import com.ivjo.ms.proyectos.domain.Destino;
import com.ivjo.ms.proyectos.services.DestinoService;

@RestController
@RequestMapping("/api/v1/destinos")
public class DestinoController {
	@Autowired
	private DestinoService desService;
	@GetMapping
	public List<Destino> listarDestinos(){
		return desService.listarTodosD();
	}
	@GetMapping("/{id}")
	public Destino listarPorIdD(@PathVariable Long id) {
		return desService.buscarPorIdD(id);
	}
	@PostMapping
	public Destino crearDestino(@RequestBody Destino destino) {
		return desService.grabarD(destino);
	}
	@PutMapping ("/{id}")
	public Destino editarDestino(@PathVariable Long id, @RequestBody Destino des) {
		Destino desDB=desService.buscarPorIdD(id);
		desDB.setNomDestino(des.getNomDestino());
		return desService.grabarD(desDB);
	}
	@DeleteMapping("/{id}")
	public void eliminarDestino(@PathVariable Long id) {
		desService.eliminarD(id);
	}
}
