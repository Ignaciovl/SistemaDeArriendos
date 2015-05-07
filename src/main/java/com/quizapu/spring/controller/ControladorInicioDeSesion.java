package com.quizapu.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.quizapu.spring.config.model.Usuario;
import com.quizapu.spring.service.ServicioTipoDeUsuario;
import com.quizapu.spring.service.ServicioUsuario;

@Controller
public class ControladorInicioDeSesion {

	@Autowired
	ServicioUsuario servicioUsuario;

	@Autowired
	ServicioTipoDeUsuario servicioTipoDeUsuario;

	public ServicioUsuario getServicioUsuario() {
		return servicioUsuario;
	}

	public void setServicioUsuario(ServicioUsuario servicioUsuario) {
		this.servicioUsuario = servicioUsuario;
	}

	public ServicioTipoDeUsuario getServicioTipoDeUsuario() {
		return servicioTipoDeUsuario;
	}

	public void setServicioTipoDeUsuario(ServicioTipoDeUsuario servicioTipoDeUsuario) {
		this.servicioTipoDeUsuario = servicioTipoDeUsuario;
	}

	@RequestMapping(value = { "/", "/inicioDeSesion" })
	public ModelAndView inicioDeSesion(@ModelAttribute Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("/view/inicio-de-sesion.jsp");
		return modelAndView;
	}

	@RequestMapping(value = "/ingresar", method = RequestMethod.POST)
	public ModelAndView iniciarSesion(@ModelAttribute Usuario usuario) {
		ModelAndView modelAndView;
		List<Usuario> usuarioEncontrado = getServicioUsuario()
				.findUsuariosByRutAndContraseña(usuario.getRut(), usuario.getContraseña());
		if (usuarioEncontrado.size() == 1) {
			modelAndView = new ModelAndView("/view/inicio.jsp");
		} else {
			modelAndView = new ModelAndView("/view/inicio-de-sesion-fallido.jsp");
		}
		return modelAndView;
	}
}
