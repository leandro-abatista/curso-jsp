<%@page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="beanJsp" class="model.classes.beans.UsuarioBean" type="model.classes.beans.UsuarioBean"/>

<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>curso-jsp</title>

<link rel="stylesheet" type="text/css" href="resources/css/estiloacessoliberado.css">
</head>
<body>

	<jsp:setProperty property="*" name="beanJsp"/>
	
	<jsp:include page="cabecalho.jsp"/>
	
	<div class="div-h2">
		<h2>Seja bem vindo ao sistema JSP | Usuário Logado: ${sessionScope.usuario.login} | Data/Hora: 
			
			<% 
			Date date = new Date();
			SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy HH:mm:ss");
			out.println(ft.format(date));
			%>
		
		</h2>
		
		
	</div>
	
	

</body>
</html>