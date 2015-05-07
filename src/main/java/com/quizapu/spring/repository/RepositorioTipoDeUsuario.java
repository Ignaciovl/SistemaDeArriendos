package com.quizapu.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quizapu.spring.config.model.TipoDeUsuario;

@Repository
public interface RepositorioTipoDeUsuario extends CrudRepository<TipoDeUsuario, Integer> {

	List<TipoDeUsuario> findAll();

	List<TipoDeUsuario> findByIdUsuario(@Param(value = "idUsuario") Integer idUsuario);

	List<TipoDeUsuario> findByIdUsuarioAndNombreTipoDeUsuario(
			@Param(value = "idUsuario") Integer idUsuario,
			@Param(value = "nombreTipoDeUsuario") String nombreTipoDeUsuario);

	@SuppressWarnings("unchecked")
	TipoDeUsuario save(TipoDeUsuario tipoDeUsuario);

	void delete(TipoDeUsuario tipoDeUsuario);
}
