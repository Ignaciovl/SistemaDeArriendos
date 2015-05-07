package com.quizapu.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quizapu.spring.config.model.TipoDeUsuario;
import com.quizapu.spring.repository.RepositorioTipoDeUsuario;

@Service
@Transactional
public class ServicioTipoDeUsuario {

	@Autowired
	private RepositorioTipoDeUsuario repositorioTipoDeUsuario;

	public RepositorioTipoDeUsuario getRepositorioTipoDeUsuario() {
		return repositorioTipoDeUsuario;
	}

	public void setRepositorioTipoDeUsuario(RepositorioTipoDeUsuario repositorioTipoDeUsuario) {
		this.repositorioTipoDeUsuario = repositorioTipoDeUsuario;
	}

	public List<TipoDeUsuario> findAll() {
		return getRepositorioTipoDeUsuario().findAll();
	}

	public List<TipoDeUsuario> findByIdUsuario(Integer idUsuario) {
		return getRepositorioTipoDeUsuario().findByIdUsuario(idUsuario);
	}

	public List<TipoDeUsuario> findByIdUsuarioAndNombreTipoDeUsuario(Integer idUsuario,
			String nombreTipoDeUsuario) {
		return getRepositorioTipoDeUsuario().findByIdUsuarioAndNombreTipoDeUsuario(idUsuario,
				nombreTipoDeUsuario);
	}

	public TipoDeUsuario save(TipoDeUsuario tipoDeUsuario) {
		return getRepositorioTipoDeUsuario().save(tipoDeUsuario);
	}

	public void delete(TipoDeUsuario tipoDeUsuario) {
		getRepositorioTipoDeUsuario().delete(tipoDeUsuario);
	}
}
