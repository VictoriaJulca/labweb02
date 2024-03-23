package com.ivjo.ms.proyectos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ivjo.ms.proyectos.domain.Comprobante;
import com.ivjo.ms.proyectos.repositories.ComprobanteRepository;
@Service
public class ComprobanteServiceImp implements ComprobanteService {
	@Autowired
	private ComprobanteRepository comRep;
	@Override
	@Transactional
	public List<Comprobante> listarTodosC() {
		return comRep.findAll();
	}

	@Override
	@Transactional
	public Comprobante buscarPorIdC(Long id) {
		Optional <Comprobante> comprobante=comRep.findById(id);
		return comprobante.get();
	}

	@Override
	@Transactional
	public Comprobante grabarC(Comprobante comprobante) {
		return comRep.save(comprobante);
	}

	@Override
	@Transactional
	public Comprobante actualizarC(Comprobante comprobante, Long id) {
		comprobante.setIdComp(id);
		return comRep.save(comprobante);
	}

	@Override
	@Transactional
	public void eliminarC(Long id) {
		comRep.deleteById(id);

	}

}
