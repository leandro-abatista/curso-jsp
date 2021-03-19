<%@page import="model.classes.beans.UsuarioBean"%>
<jsp:useBean id="beanJsp" class="model.classes.beans.UsuarioBean" type="model.classes.beans.UsuarioBean"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>curso-jsp</title>

<link rel="stylesheet" href="resources/css/estiloTableConsulta.css">

<script type="text/javascript" src="resources/javascript/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>

</head>

<body>
	
	<jsp:include page="cabecalho.jsp"/>
	
	<div class="div-pai">
	
		<p>Consulta de Usuários</p>
		
		<form id="formulario" action="servletConsultaUser" method="post">


			<div class="caption">Usuários Cadastrados</div>

			<div class="tbl-header">

				<table>

					<thead>

						<tr>
							<th style="width: 8%;">Código</th>
							<th style="width: 20%;">Nome</th>
							<th style="width: 20%;">Login</th>
							<th style="width: 25%;">E-mail</th>
							<th style="width: 15%;">Telefone</th>
						</tr>

					</thead>

				</table>

			</div>

			<div class="tbl-content">

				<table>

					<tbody>

						<c:forEach items="${usuarios}" var="user">

							<tr>

								<td width="8%"><c:out value="${user.codigo}"/></td>
								<td width="20%"><c:out value="${user.nome}"/></td>
								<td width="20%"><c:out value="${user.login}"/></td>
								<td width="25%"><c:out value="${user.email}"/></td>
								<td width="15%"><c:out value="${user.telefone}"/></td>


							</tr>

						</c:forEach>

					</tbody>
					
				</table>

			</div>

		</form>
		
	</div>
	
</body>
</html>