<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<!-- recebendo a session que vem do index.jsp -->
	<%= session.getAttribute("curso") + " teste"%>
	<%= session.getId() %>
	
	<a href="index2.jsp">Voltar</a>

</body>
</html>