package com.ivjo.ms.proyectos.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Destino {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idDest;
	private String nomDestino;
	@OneToMany(mappedBy="destino")
	private List<ViajeContratado> viajesco=new ArrayList<>();

}
