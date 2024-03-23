package com.ivjo.ms.proyectos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ivjo.ms.proyectos.domain.ViajeContratado;
import com.ivjo.ms.proyectos.repositories.ViajeRepository;
@Service
public class ViajeContratadoServiceImp implements ViajeContratadoService {
	@Autowired
	private ViajeRepository viaRep;
	@Override
	@Transactional
	public List<ViajeContratado> listarTodosV() {
		return viaRep.findAll();
	}

	@Override
	@Transactional
	public ViajeContratado BuscarPorIdV(Long idv) {
		Optional <ViajeContratado> viajecontratado=viaRep.findById(idv);
		return viajecontratado.get();
	}

	@Override
	@Transactional
	public ViajeContratado grabarV(ViajeContratado viajeContratado) {
		return viaRep.save(viajeContratado);
	}

	@Override
	@Transactional
	public ViajeContratado actualizarV(ViajeContratado viajeContratado, Long idv) {
		viajeContratado.setIdVjCont(idv);
		return viaRep.save(viajeContratado);
	}

	@Override
	@Transactional
	public void eliminarV(Long idv) {
		viaRep.deleteById(idv);
	}
}
