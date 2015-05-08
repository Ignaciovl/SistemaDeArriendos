<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Inicio</title>
</head>
<body>

	<h1>Inicio</h1>

	<p style="font-size: 18px">${opcionActivarCuenta == 1 ? "Activar Cuenta" : "" }</p>
	<p style="font-size: 18px">${opcionBloquearCuenta == 1 ? "Bloquear Cuenta" : "" }</p>
	<p style="font-size: 18px">${opcionDarDeBajaACliente == 1 ? "Dar de Baja a Cliente" : "" }</p>
	<p style="font-size: 18px">${opcionMantenerDatosDeClientes == 1 ? "Mantener Datos de Clientes" : "" }</p>
	<p style="font-size: 18px">${opcionCerrarArriendo == 1 ? "Cerrar Arriendo" : "" }</p>
	<p style="font-size: 18px">${opcionConsultarArriendos == 1 ? "Consultar Arriendos" : "" }</p>
	<p style="font-size: 18px">${opcionConsultarClienteYSuCartera == 1 ? "Consultar Cliente y su Cartera" : "" }</p>
	<p style="font-size: 18px">${opcionPasarArriendoACarteraVencida == 1 ? "Pasar Arriendo a Cartera Vencida" : "" }</p>
	<p style="font-size: 18px">${opcionRegistrarArriendos == 1 ? "Registrar Arriendos" : "" }</p>
	<p style="font-size: 18px">${opcionMovimientosHistoricosDeProductos == 1 ? "Movimientos Historicos de Productos" : "" }</p>
	<p style="font-size: 18px">${opcionNivelesDeStock == 1 ? "Niveles de Stock" : "" }</p>
	<p style="font-size: 18px">${opcionIngresarUnidadesDeBicicletas == 1 ? "Ingresar Unidades de Bicicletas" : "" }</p>
	<p style="font-size: 18px">${opcionMantenerBicicletas == 1 ? "Mantener Bicicletas" : "" }</p>
	<p style="font-size: 18px">${opcionChequearPorArriendosMorosos == 1 ? "Chequear por Arriendos Morosos" : "" }</p>

	<p>
		<a style="font-size: 18px" href="cerrarSesion.html"
			onclick="return confirm('¿Esta seguro de querer cerrar sesion?')">Cerrar
			Sesion</a>
	</p>
</body>
</html>