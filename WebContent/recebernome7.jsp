<jsp:useBean id="beanJsp" class="model.classes.beans.UsuarioBean" type="model.classes.beans.UsuarioBean"/>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="UTF-8"%>

<%@ taglib uri="/WEB-INF/testetag.tld" prefix ="mt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Recebernome6</h1>
	
	<jsp:include page="cabecalho.jsp"/>
	
		<% session.setAttribute("user", "java avançado"); %>
		<br>
		<a href="index11.jsp">Enviar</a>
		<br>
		<br>
		<!-- esse botão atualiza a página -->
		<input type="button" value="Atualizar" onclick="history.go(0)">
	
	
	
	<jsp:include page="rodape.jsp"/>
	
</body>
</html>