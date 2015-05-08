package com.quizapu.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.quizapu.spring.config.model.EstadoTipoDeUsuario;
import com.quizapu.spring.config.model.NombreTipoDeUsuario;
import com.quizapu.spring.config.model.TipoDeUsuario;
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
		List<Usuario> usuarioEncontrado = getServicioUsuario().findUsuariosByRutAndContraseña(
				usuario.getRut(), usuario.getContraseña());
		if (usuarioEncontrado.size() == 1) {
			modelAndView = new ModelAndView("/view/inicio.jsp");
			usuario = usuarioEncontrado.get(0);
			usuario.setTiposDeUsuario(getServicioTipoDeUsuario().findByIdUsuario(usuario.getId()));
			modelAndView.addObject("usuario", usuario);
			modelAndView = generarMenu(modelAndView, usuario);
		} else {
			modelAndView = new ModelAndView("/view/inicio-de-sesion.jsp");
			modelAndView.addObject("mensaje", "Rut o contraseña invalidos.");
		}
		return modelAndView;
	}

	private ModelAndView generarMenu(ModelAndView modelAndView, Usuario usuario) {
		int opcionActivarCuenta = 0, opcionBloquearCuenta = 0, opcionDarDeBajaACliente = 0, opcionMantenerDatosDeClientes = 0;
		int opcionCerrarArriendo = 0, opcionConsultarArriendos = 0, opcionConsultarClienteYSuCartera = 0;
		int opcionPasarArriendoACarteraVencida = 0, opcionRegistrarArriendos = 0, opcionMovimientosHistoricosDeProductos = 0;
		int opcionNivelesDeStock = 0, opcionIngresarUnidadesDeBicicletas = 0, opcionMantenerBicicletas = 0, opcionChequearPorArriendosMorosos = 0;
		List<TipoDeUsuario> tiposDeUsuario = usuario.getTiposDeUsuario();
		for (TipoDeUsuario tipoDeUsuario : tiposDeUsuario) {
			if (tipoDeUsuario.getNombreTipoDeUsuario() == NombreTipoDeUsuario.ADMINISTRADOR_DE_SISTEMA
					&& tipoDeUsuario.getEstadoTipoDeUsuario() == EstadoTipoDeUsuario.ACTIVO) {
				opcionActivarCuenta = 1;
				opcionBloquearCuenta = 1;
				opcionChequearPorArriendosMorosos = 1;
			}
			if (tipoDeUsuario.getNombreTipoDeUsuario() == NombreTipoDeUsuario.SUPERVISOR
					&& tipoDeUsuario.getEstadoTipoDeUsuario() == EstadoTipoDeUsuario.ACTIVO) {
				opcionDarDeBajaACliente = 1;
			}
			if (tipoDeUsuario.getNombreTipoDeUsuario() == NombreTipoDeUsuario.EJECUTIVO_DE_ATENCION_A_CLIENTES
					&& tipoDeUsuario.getEstadoTipoDeUsuario() == EstadoTipoDeUsuario.ACTIVO) {
				opcionMantenerDatosDeClientes = 1;
			}
			if (tipoDeUsuario.getNombreTipoDeUsuario() == NombreTipoDeUsuario.EJECUTIVO_DE_VENTAS
					&& tipoDeUsuario.getEstadoTipoDeUsuario() == EstadoTipoDeUsuario.ACTIVO) {
				opcionCerrarArriendo = 1;
				opcionConsultarArriendos = 1;
				opcionConsultarClienteYSuCartera = 1;
				opcionPasarArriendoACarteraVencida = 1;
				opcionRegistrarArriendos = 1;
				opcionNivelesDeStock = 1;
			}
			if (tipoDeUsuario.getNombreTipoDeUsuario() == NombreTipoDeUsuario.CLIENTE
					&& tipoDeUsuario.getEstadoTipoDeUsuario() == EstadoTipoDeUsuario.ACTIVO) {
				opcionConsultarArriendos = 1;
			}
			if (tipoDeUsuario.getNombreTipoDeUsuario() == NombreTipoDeUsuario.ENCARGADO_DE_PRODUCTO
					&& tipoDeUsuario.getEstadoTipoDeUsuario() == EstadoTipoDeUsuario.ACTIVO) {
				opcionMovimientosHistoricosDeProductos = 1;
				opcionMantenerBicicletas = 1;
			}
			if (tipoDeUsuario.getNombreTipoDeUsuario() == NombreTipoDeUsuario.ENCARGADO_DE_BODEGA
					&& tipoDeUsuario.getEstadoTipoDeUsuario() == EstadoTipoDeUsuario.ACTIVO) {
				opcionNivelesDeStock = 1;
				opcionIngresarUnidadesDeBicicletas = 1;
			}
		}
		modelAndView.addObject("opcionActivarCuenta", opcionActivarCuenta);
		modelAndView.addObject("opcionBloquearCuenta", opcionBloquearCuenta);
		modelAndView.addObject("opcionDarDeBajaACliente", opcionDarDeBajaACliente);
		modelAndView.addObject("opcionMantenerDatosDeClientes", opcionMantenerDatosDeClientes);
		modelAndView.addObject("opcionCerrarArriendo", opcionCerrarArriendo);
		modelAndView.addObject("opcionConsultarArriendos", opcionConsultarArriendos);
		modelAndView
				.addObject("opcionConsultarClienteYSuCartera", opcionConsultarClienteYSuCartera);
		modelAndView.addObject("opcionPasarArriendoACarteraVencida",
				opcionPasarArriendoACarteraVencida);
		modelAndView.addObject("opcionRegistrarArriendos", opcionRegistrarArriendos);
		modelAndView.addObject("opcionMovimientosHistoricosDeProductos",
				opcionMovimientosHistoricosDeProductos);
		modelAndView.addObject("opcionNivelesDeStock", opcionNivelesDeStock);
		modelAndView.addObject("opcionIngresarUnidadesDeBicicletas",
				opcionIngresarUnidadesDeBicicletas);
		modelAndView.addObject("opcionMantenerBicicletas", opcionMantenerBicicletas);
		modelAndView.addObject("opcionChequearPorArriendosMorosos",
				opcionChequearPorArriendosMorosos);
		return modelAndView;
	}
}
