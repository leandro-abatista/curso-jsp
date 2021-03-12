<jsp:useBean id="beanJsp" class="model.classes.beans.UsuarioBean" type="model.classes.beans.UsuarioBean"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>curso-jsp</title>

<link rel="stylesheet" href="resources/css/tabela-usuarios.css">
</head>
<body>
	
	<!-- div pai -->
	<div class="container">
	
		<h2>Registros de Usuários Cadastrados</h2>
		
		<table class="tabela">
	
			<thead>
				<tr>
					<th>LOGIN</th>
					<th>SENHA</th>
				</tr>
			</thead>
				
			<c:forEach items="${usuarios}" var="usuario">
				<tbody>
					<tr>
						<td><c:out value="${usuario.login}"/></td>
						<td><c:out value="${usuario.senha}"/></td>
					</tr>
				</tbody>
			</c:forEach>
	
		</table>
	
	</div>
	
</body>
</html>