package com.quizapu.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quizapu.spring.config.model.Usuario;
import com.quizapu.spring.repository.RepositorioUsuario;

@Service
@Transactional
public class ServicioUsuario {

	@Autowired
	private RepositorioUsuario repositorioUsuario;

	public RepositorioUsuario getRepositorioUsuario() {
		return repositorioUsuario;
	}

	public void setRepositorioUsuario(RepositorioUsuario repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}

	public long count() {
		return getRepositorioUsuario().count();
	}

	public List<Usuario> findAll() {
		return getRepositorioUsuario().findAll();
	}

	public Usuario findOne(Integer id) {
		return getRepositorioUsuario().findOne(id);
	}

	public List<Usuario> findUsuariosByRut(String rut) {
		return getRepositorioUsuario().findUsuariosByRut(rut);
	}

	public List<Usuario> findUsuariosByRutAndContraseña(String rut, String contraseña) {
		return getRepositorioUsuario().findUsuariosByRutAndContraseña(rut, contraseña);
	}

	public Usuario save(Usuario usuario) {
		return getRepositorioUsuario().save(usuario);
	}

	public void delete(Integer id) {
		getRepositorioUsuario().delete(id);
	}

	public void delete(Usuario usuario) {
		getRepositorioUsuario().delete(usuario);
	}
}
