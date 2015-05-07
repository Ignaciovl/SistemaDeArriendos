package com.quizapu.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quizapu.spring.config.model.Usuario;
import com.quizapu.spring.service.ServicioTipoDeUsuario;
import com.quizapu.spring.service.ServicioUsuario;

@Controller
public class ControladorInicio {

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
	
	@RequestMapping(value = { "cerrarSesion" })
	public ModelAndView cierreDeSesion(@ModelAttribute Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("/view/inicio-de-sesion.jsp");
		return modelAndView;
	}
}
