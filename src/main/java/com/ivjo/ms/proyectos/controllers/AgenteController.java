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

import com.ivjo.ms.proyectos.domain.Agente;
import com.ivjo.ms.proyectos.services.AgenteService;

@RestController
@RequestMapping("/api/v1/agentes")
public class AgenteController {
	@Autowired
	private AgenteService ageService;
	
	@GetMapping
	public List<Agente> listarAgentes(){
		return ageService.listarTodosA();
	}
	@GetMapping("/{id}")
	public Agente listarPorIdA(@PathVariable Long id) {
		return ageService.buscarPorIdA(id);
		
	}
	@PostMapping("/{id}")
	public Agente crearAgente(@RequestBody Agente agente) {
		return ageService.grabarA(agente);
	}
	@PutMapping ("/{id}")
	public Agente editarAgente(@PathVariable Long id, @RequestBody Agente age) {
		Agente ageDB=ageService.buscarPorIdA(id);
		
		ageDB.setCelularAge(age.getCelularAge());
		ageDB.setDniAge(age.getDniAge());
		ageDB.setEmailAge(age.getEmailAge());
		ageDB.setFechaRegAge(age.getFechaRegAge());
		ageDB.setMatAge(age.getMatAge());
		ageDB.setNomAge(age.getNomAge());
		ageDB.setPatAge(age.getPatAge());
		return ageService.grabarA(ageDB);
	}
	@DeleteMapping("/{id}")
	public void eliminarAgente(@PathVariable Long id) {
		ageService.eliminarA(id);
	}
}
