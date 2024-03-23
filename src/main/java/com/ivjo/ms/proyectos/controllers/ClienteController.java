package com.ivjo.ms.proyectos.controllers;
import java.util.Map;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivjo.ms.proyectos.domain.Cliente;
import com.ivjo.ms.proyectos.exception.IllegalOperationException;
import com.ivjo.ms.proyectos.services.ClienteService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
	@Autowired
	private ClienteService cliService;
	
	@GetMapping
	public List<Cliente> listarClientes(){
		return cliService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable Long id) {
		Optional<Cliente> invOptional=Optional.ofNullable(cliService.buscarPorId(id));
		if(invOptional.isPresent()) {
			return ResponseEntity.ok(invOptional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> crearCliente(@Valid @RequestBody Cliente cliente) throws IllegalOperationException {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cliService.grabar(cliente));
		
	}
	

	
	@PutMapping ("/{id}")
	public ResponseEntity<?> editarCliente(@PathVariable Long id, @RequestBody Cliente cli) throws IllegalOperationException {
		Optional <Cliente> o=Optional.ofNullable(cliService.buscarPorId(id));
		if(o.isPresent()) {
			Cliente cliDB=o.get();
		cliDB.setApeMat(cli.getApeMat());
		cliDB.setApePat(cli.getApePat());
		cliDB.setCelular(cli.getCelular());
		cliDB.setDni(cli.getDni());
		cliDB.setEmail(cli.getEmail());
		cliDB.setFechaReg(cli.getFechaReg());
		cliDB.setNombres(cli.getNombres());
		return ResponseEntity.status(HttpStatus.CREATED).body(cliService.grabar(cliDB));
	}
	return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarCliente(@PathVariable Long id) throws EntityNotFoundException,IllegalOperationException  {
		Optional<Cliente> o=Optional.of(cliService.buscarPorId(id));
		if(o.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
