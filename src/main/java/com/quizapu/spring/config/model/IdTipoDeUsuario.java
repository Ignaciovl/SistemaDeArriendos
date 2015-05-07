package com.quizapu.spring.config.model;

import java.io.Serializable;

import javax.persistence.Column;

public class IdTipoDeUsuario implements Serializable {

	private static final long serialVersionUID = 4282637241936893289L;
	
	@Column(name = "id_usuario")
	private int idUsuario;
	@Column(name = "nombre_tipo_de_usuario")
	private NombreTipoDeUsuario nombreTipoDeUsuario;

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

}
