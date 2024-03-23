package com.ivjo.ms.proyectos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ivjo.ms.proyectos.domain.Agente;
import com.ivjo.ms.proyectos.repositories.AgenteRepository;

@Service
public class AgenteServiceImp implements AgenteService {
	@Autowired
	private AgenteRepository ageRep;
	
	@Override
	@Transactional
	public List<Agente> listarTodosA() {
		return ageRep.findAll();
	}

	@Override
	@Transactional
	public Agente buscarPorIdA(Long id) {
		Optional <Agente> agente=ageRep.findById(id);
		return agente.get();
	}

	@Override
	@Transactional
	public Agente grabarA(Agente agente) {
		return ageRep.save(agente);
	}

	@Override
	@Transactional
	public Agente actualizarA(Agente agente, Long id) {
		agente.setIdAgente(id);
		return ageRep.save(agente);
	}

	@Override
	@Transactional
	public void eliminarA(Long id) {
		ageRep.deleteById(id);

	}

	@Override
	@Transactional
	public Agente findByDniAge(String dni) {
		return ageRep.findByDniAge(dni).get();
	}

}
