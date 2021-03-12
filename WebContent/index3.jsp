<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- diretivas do jsp -->
	<%@ page import="java.util.Date" %>
	<%= "data de hoje: " + new Date() %>
	<br>
	<br>
	<br>
	<!-- Página de erro do jsp -->
	<%@ page errorPage="recebernome3.jsp" %>
	<%= "Resultado --> " + 100/4 %>
	<br>
	<br>
	<br>
	<h2><a href="index4.jsp">Index4</a></h2>
</body>
</html>