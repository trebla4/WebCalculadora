<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculadora</title>
</head>
<body>
<script>
function Validate()
{
var valor = document.forms["calc"]["val"].value;

if(!valor)
{
alert("CAMPO VALOR VACIO");
return false;
}
return true;
}
</script>
<form name = "calc" method="POST" action="Calculadora" onsubmit="return Validate()">
		<br>"Escribe en el campo de texto, perisiona el boton de la operacion y vuelve a ecribir, de nuevo selecciona la operacion"</br>
		<input type="text" name="val">
			
		<input type="submit" name="suma" value="SUMA">
		<input type="submit" name="resta" value="RESTA">
		<input type="submit" name="multiplicacion" value="MULTIPLICACION">
		<input type="submit" name="division" value="DIVISION">
		<input type="submit" name="borrar" value="BORRAR VAR">
		<br>
		<input type="text" name="user" value= "RESULTADO =" style="width: 104px; ">
		<input type="text" name="resultado" readonly="readonly" value="<%if(request.getAttribute("valor") != null){out.print(request.getAttribute("valor"));} %>">
		
	</form>
	<br>
</body>
</html>