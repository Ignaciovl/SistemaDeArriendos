<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Inicio de Sesion</title>
</head>
<body>
	<form:form method="POST" commandName="usuario" action="ingresar.html">
		Rut:<br/> <form:input path="rut"/> <br/>
		Contrase�a:<br/> <form:input type="password" path="contrase�a"/> <br/>
		<br/> <input type="submit" value="Iniciar Sesion"/>
	</form:form>
	<p style="color: red">Rut o contrase�a invalidos.</p>
</body>
</html>