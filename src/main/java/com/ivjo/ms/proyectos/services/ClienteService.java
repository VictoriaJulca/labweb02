package com.ivjo.ms.proyectos.services;

import java.util.List;

import com.ivjo.ms.proyectos.domain.Cliente;
import com.ivjo.ms.proyectos.exception.EntityNotFoundException;
import com.ivjo.ms.proyectos.exception.IllegalOperationException;

public interface ClienteService {
	List<Cliente> listarTodos() ;
	Cliente buscarPorId(Long id);
	Cliente grabar(Cliente cliente) throws IllegalOperationException;;
	Cliente actualizar(Cliente cliente,Long id) throws EntityNotFoundException, IllegalOperationException;
	void eliminar(Long id) throws EntityNotFoundException, IllegalOperationException;
	Cliente findByDni(String dni);
	Cliente findByEmail(String email);
}
