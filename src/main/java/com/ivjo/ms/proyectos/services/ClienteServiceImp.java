package com.ivjo.ms.proyectos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ivjo.ms.proyectos.domain.Cliente;
import com.ivjo.ms.proyectos.exception.EntityNotFoundException;
import com.ivjo.ms.proyectos.exception.EntityNotFoundExceptionMessages;
import com.ivjo.ms.proyectos.exception.IllegalOperationException;
import com.ivjo.ms.proyectos.repositories.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService {
	@Autowired
	private ClienteRepository cliRep;

	@Override
	@Transactional
	public List<Cliente> listarTodos() {
		return cliRep.findAll();
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public Cliente buscarPorId(Long id) throws EntityNotFoundException{
		Optional<Cliente> cliente=cliRep.findById(id);
		if (cliente.isEmpty()) throw new EntityNotFoundException(EntityNotFoundExceptionMessages.CLIENTE_NOT_FOUND);
			return cliente.get();

		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public Cliente grabar(Cliente cliente) throws IllegalOperationException{
		if(!cliRep.findByEmail(cliente.getEmail()).isEmpty()) {
			throw new IllegalOperationException("Ya existe un cliente con ese email");
		}
		if(!cliRep.findByDni(cliente.getDni()).isEmpty()) {
			throw new IllegalOperationException("Ya existe un cliente con ese dni");
		}
		return cliRep.save(cliente);
	}

	@Override
	@Transactional
	public Cliente actualizar(Cliente cliente, Long id) throws EntityNotFoundException, IllegalOperationException{
		Optional<Cliente>invEntity=cliRep.findById(id);
		if(invEntity.isEmpty()) {
			throw new EntityNotFoundException("El cliente no existe");
		}
		if(!cliRep.findByEmail(cliente.getEmail()).isEmpty()) {
			throw new IllegalOperationException("El cliente ya existe");
		}
		if(!cliRep.findByDni(cliente.getDni()).isEmpty()) {
			throw new IllegalOperationException("El DNI del cliente ya existe");
		}
		cliente.setIdCliente(id);
		return cliRep.save(cliente);
	}

	@Override
	@Transactional
	public void eliminar(Long id)  throws EntityNotFoundException, IllegalOperationException{
		Cliente inv=cliRep.findById(id).orElseThrow(
				()->new EntityNotFoundException(EntityNotFoundExceptionMessages.CLIENTE_NOT_FOUND)
				);
		// TODO Auto-generated method stub
		cliRep.deleteById(id);

	}

	@Override
	@Transactional
	public Cliente findByDni(String dni) {
		Optional<Cliente> inv= cliRep.findByEmail(dni);
		if(inv.isEmpty()) throw new EntityNotFoundException(EntityNotFoundExceptionMessages.CLIENTE_NOT_FOUND);
		return inv.get();
	}

	@Override
	@Transactional
	public Cliente findByEmail(String email) {
		Optional<Cliente> inv= cliRep.findByEmail(email);
		if(inv.isEmpty()) throw new EntityNotFoundException(EntityNotFoundExceptionMessages.CLIENTE_NOT_FOUND);
		return inv.get();
	}

}
