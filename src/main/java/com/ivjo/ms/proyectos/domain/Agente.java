package com.ivjo.ms.proyectos.domain;

import java.util.ArrayList;

import java.util.Date;
//import java.util.List;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Agente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idAgente;
	private String PatAge;
	private String MatAge;
	private String nomAge;
	@Column(unique=true)
	private String dniAge;
	@Column(unique=true)
	private String emailAge;
	private String celularAge;
	@Temporal(TemporalType.DATE)
	private Date fechaRegAge;
	@OneToMany(mappedBy="agente")
	private List<ViajeContratado> viajesc=new ArrayList<>();
}
