package com.ivjo.ms.proyectos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivjo.ms.proyectos.domain.Destino;
import com.ivjo.ms.proyectos.repositories.DestinoRepository;
@Service
public class DestinoServiceImp implements DestinoService {
	@Autowired
	private DestinoRepository desRep;
	@Override
	@Transactional
	public List<Destino> listarTodosD() {
		return desRep.findAll();
	}

	@Override
	@Transactional
	public Destino buscarPorIdD(Long idd) {
		Optional <Destino> destino=desRep.findById(idd);
		return destino.get();
	}

	@Override
	@Transactional
	public Destino grabarD(Destino destino) {
		return desRep.save(destino);
	}

	@Override
	@Transactional
	public Destino actualizarD(Destino destino, Long idd) {
		destino.setIdDest(idd);
		return desRep.save(destino);
	}

	@Override
	@Transactional
	public void eliminarD(Long idd) {
		desRep.deleteById(idd);

	}

	@Override
	@Transactional
	public Destino findByNomDestino(String nom) {
		return desRep.findByNomDestino(nom).get();
	}

}
