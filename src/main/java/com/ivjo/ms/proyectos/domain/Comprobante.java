package com.ivjo.ms.proyectos.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Comprobante {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idComp;
	private String tipo;
	@Temporal(TemporalType.DATE)
	private Date fechaComprobante;
	
	@ManyToMany(mappedBy="contratado")
	private List<ViajeContratado> contratado=new ArrayList<>();

	
	}
