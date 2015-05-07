package com.quizapu.spring.config.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_de_usuario")
@IdClass(IdTipoDeUsuario.class)
public class TipoDeUsuario {

	@Id
	@Column(name = "id_usuario")
	private int idUsuario;
	@Enumerated(EnumType.STRING)
	@Id
	@Column(name = "nombre_tipo_de_usuario")
	private NombreTipoDeUsuario nombreTipoDeUsuario;
	@Enumerated(EnumType.STRING)
	@Column(name = "estado_tipo_de_usuario")
	private EstadoTipoDeUsuario estadoTipoDeUsuario;

	@ManyToOne
	@JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	private Usuario usuario;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public NombreTipoDeUsuario getNombreTipoDeUsuario() {
		return nombreTipoDeUsuario;
	}

	public void setNombreTipoDeUsuario(NombreTipoDeUsuario nombreTipoDeUsuario) {
		this.nombreTipoDeUsuario = nombreTipoDeUsuario;
	}

	public EstadoTipoDeUsuario getEstadoTipoDeUsuario() {
		return estadoTipoDeUsuario;
	}

	public void setEstadoTipoDeUsuario(EstadoTipoDeUsuario estadoTipoDeUsuario) {
		this.estadoTipoDeUsuario = estadoTipoDeUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
