<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<!-- Recebendo um nome da página index.jsp | passagem de parâmetros-->
	<% 
		String nome = "Nome recebido: " + request.getParameter("nome");
		out.println(nome);
	%>
	<br>
	<%= 
		"Nome recebido: " + request.getParameter("nome")
	%>
	<!-- exemplos de objetos implícitos de requisição-->
	<%= request.getContextPath() %>
	<%= request.getContentType() %>
	<%= request.getLocalPort() %>
	<%= request.getLocalName() %>
	<%= request.getLocale() %>
	<%= request.getRemoteHost() %>
	<%= request.getRequestURI() %>
	<%= request.getRequestedSessionId() %>
	<%= request.getCookies() %>
	<br>
	<!-- objetos implicitos de resposta -->
	<%= response.SC_GATEWAY_TIMEOUT %>
	<%= response.getStatus() %>
	<% response.sendRedirect("https://www.uol.com.br"); %>
	<br>
	<br>
	
	
	
	<br>
	<br>
	
	
	<a href="index.jsp">Voltar</a>

</body>
</html>