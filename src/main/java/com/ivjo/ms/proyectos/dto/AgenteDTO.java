package com.ivjo.ms.proyectos.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.ivjo.ms.proyectos.domain.ViajeContratado;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class AgenteDTO {
	private long idAgente;
	@NotBlank(message = "El apellido paterno no puede estar en blanco")
	@Size(min = 2, message = "El apellido paterno debe tener al menos 3 caracteres")
	private String PatAge;
	@NotBlank(message = "El apellido materno no puede estar en blanco")
	@Size(min = 2, message = "El apellido paterno debe tener al menos 3 caracteres")
	private String MatAge;
	@NotBlank(message = "El nombre no puede estar en blanco")
	@Size(min = 2, message = "El nombre debe tener al menos 3 caracteres")
	private String nomAge;
	@NotBlank(message = "El DNI no puede estar en blanco")
    @Size(min = 8, max = 8, message = "El DNI debe tener exactamente 8 caracteres")
	@Pattern(regexp = "\\d+", message = "El DNI debe contener solo dígitos")
	private String dniAge;
	@NotBlank(message = "El email no puede estar en blanco")
	@Email(message = " El email no cumple con una estructura valida")
	private String emailAge;
	@NotBlank(message = "El celular no puede estar en blanco")
    @Size(min = 9, max = 9, message = "El celular debe tener exactamente 9 caracteres")
	@Pattern(regexp = "\\d+", message = "El celular debe contener solo dígitos")
	private String celularAge;
	@NotNull(message = "La fecha de registro de investigación no puede estar vacía")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaRegAge;
	private List<ViajeContratado> viajesc=new ArrayList<>();
}
