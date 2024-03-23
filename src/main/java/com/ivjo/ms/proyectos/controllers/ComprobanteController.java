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

import com.ivjo.ms.proyectos.domain.Comprobante;
import com.ivjo.ms.proyectos.services.ComprobanteService;

@RestController
@RequestMapping("/api/v1/comprobantes")
public class ComprobanteController {
	@Autowired
	private ComprobanteService comService;
	@GetMapping
	public List<Comprobante> listarComprobantes(){
		return comService.listarTodosC();
	}
	@GetMapping ("/{id}")
	public Comprobante listarPorIdC(@PathVariable Long id) {
		return comService.buscarPorIdC(id);
	}
	@PostMapping 
	public Comprobante crearComprobante(@RequestBody Comprobante comprobante) {
		return comService.grabarC(comprobante);
	}
	@PutMapping ("/{id}")
	public Comprobante editarComprobante(@PathVariable Long id, @RequestBody Comprobante com) {
		Comprobante comDB=comService.buscarPorIdC(id);
		comDB.setFechaComprobante(com.getFechaComprobante());
		comDB.setTipo(com.getTipo());
		return comService.grabarC(comDB);
	}
	@DeleteMapping("/{id}")
	public void eliminarComprobante(@PathVariable Long id) {
		comService.eliminarC(id);
	}
}
