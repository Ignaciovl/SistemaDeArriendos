package com.quizapu.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quizapu.spring.config.model.Usuario;

@Repository
public interface RepositorioUsuario extends CrudRepository<Usuario, Integer> {

	long count();

	List<Usuario> findAll();

	Usuario findOne(Integer id);

	List<Usuario> findUsuariosByRut(@Param(value = "rut") String rut);

	List<Usuario> findUsuariosByRutAndContrase�a(@Param(value = "rut") String rut,
			@Param(value = "contrase�a") String contrase�a);

	@SuppressWarnings("unchecked")
	Usuario save(Usuario usuario);

	void delete(Integer id);

	void delete(Usuario usuario);

}
