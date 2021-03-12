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
	<!-- setProperty -> usa todas as propriedades do bean -->
	<jsp:setProperty property="*" name="beanJsp"/>

	<h1>index11</h1>

	<!-- cabeçalho da página -->
	<jsp:include page="cabecalho.jsp"/>
	
	<br>
	<br>
	${sessionScope.user}	
	<br>
	<input type="button" value="Voltar" onclick="history.go(-1)">
	
	<!-- rodapé da página -->
	<jsp:include page="rodape.jsp"/>
	
</body>
</html>