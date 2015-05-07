package com.quizapu.spring.config.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@SequenceGenerator(name = "gen_id_usuario", sequenceName = "seq_id_usuario", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "gen_id_usuario")
	@Column(name = "id", unique = true, nullable = false)
	@NotNull(message = "ID no puede ser nulo")
	@Min(0)
	private int id;
	@Column(name = "rut", unique = true, nullable = false, length = 15)
	@Size(max = 15, message = "El campo Rut no debe superar los 15 caracteres")
	@NotNull(message = "El campo Rut no puede ser nulo")
	@NotEmpty(message = "El campo Rut no puede estar vacio")
	private String rut;
	@Column(name = "contraseña", nullable = false, length = 16)
	@Size(max = 16, message = "El campo Contraseña no debe superar los 16 caracteres")
	@NotNull(message = "El campo Contraseña no puede ser nulo")
	@NotEmpty(message = "El campo Contraseña no puede estar vacio")
	private String contraseña;

	@OneToMany(mappedBy = "usuario")
	private List<TipoDeUsuario> tiposDeUsuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getContrasenia() {
		return contraseña;
	}

	public void setContrasenia(String contrasenia) {
		this.contraseña = contrasenia;
	}

	public List<TipoDeUsuario> getTiposDeUsuario() {
		return tiposDeUsuario;
	}

	public void setTiposDeUsuario(List<TipoDeUsuario> tiposDeUsuario) {
		this.tiposDeUsuario = tiposDeUsuario;
	}

}
