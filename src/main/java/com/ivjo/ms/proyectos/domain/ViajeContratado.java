package com.ivjo.ms.proyectos.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class ViajeContratado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idVjCont;
	@Temporal(TemporalType.DATE)
	private Date fechaContrato;
	@Temporal(TemporalType.DATE)
	private Date fechaViaje;
	private float monto;

	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Destino destino;
	@ManyToOne
	private Agente agente;
	
	@ManyToMany
	@JoinTable(name="ComprobantesViajes",
	joinColumns=@JoinColumn(name="idComp"),
	inverseJoinColumns = @JoinColumn(name="idVjCont"))
	private List<Comprobante> contratado;

}
