<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form id="form2" action="recebernome2.jsp">
		<label id="label-1">Name: </label>
		<input type="text" id="nome" name="nome">
		<input type="submit" value="Enviar Session">
		
	</form>
	<!-- Objeto implícito session -->
	<%session.setAttribute("curso", "nome"); %>		
	
	<br>
	<br>
	<!-- vai para o nidex3.jsp -->
	<a href="index3.jsp">Página Index3</a>
</body>
</html>