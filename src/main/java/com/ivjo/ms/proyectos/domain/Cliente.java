package com.ivjo.ms.proyectos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class Cliente implements Serializable{
	private static final long serialVersionUID= 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idCliente;
	private String apePat;
	private String apeMat;
	private String nombres;
	@Column(unique=true)
	private String dni;
	@Column(unique=true)
	private String email;
	private String celular;
	@Temporal(TemporalType.DATE)
	private Date fechaReg;
	@OneToMany(mappedBy="cliente")
	private List<ViajeContratado> viaje=new ArrayList<>();

}
