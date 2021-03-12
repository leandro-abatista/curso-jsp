<jsp:useBean id="beanJsp" class="model.classes.beans.UsuarioBean" type="model.classes.beans.UsuarioBean"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>curso-jsp</title>
</head>
<body>


	<c:set var="numero" value="${100/4}"/>
	<c:choose>
		
		<c:when test="${numero >= 50}">
			<c:out value="${'Maior que 50'}"/>
		</c:when>
		
		<c:when test="${numero < 50}">
			<c:out value="${'Menor que 50'}"/>
		</c:when>
		
		<c:otherwise>
			<c:out value="${'Não encontrou valor correto!'}"/>
		</c:otherwise>
		
	</c:choose>
	
	<br>
	<br>
	<c:forEach var="n" begin="1" end="${numero}">
		Item : ${n}
		<br>
	</c:forEach>
	
	<br>
	<br>
	<c:forTokens items="Alex-Fernando-Egidio" delims="-" var="nome">
		
		Nome : <c:out value="${nome}"/>
		<br>
	
	</c:forTokens>
	
	<br>
	<br>
	<c:url value="/acessoliberado.jsp" var="acesso">
		<c:param name="param1" value="111"/>
		<c:param name="param2" value="112"/>
	</c:url>
	${acesso}
	
	<br>
	<br>
	<c:if test="${numero > 25}">
		<c:redirect url="https://www.google.com.br"/>
	</c:if>
	
	<c:if test="${numero < 25}">
		<c:redirect url="https://www.uol.com.br"/>
	</c:if>

<p/>
<p/>
<p/>
<p/>
<p/>


	<form id="form-1" action="usuarioServlet" method="post">
		<br>
		<br>
		<input type="text" id="login" name="login">
		<br>
		<br>
		<input type="password" id="senha" name="senha">
		<br>
		<br>
		<input type="submit"  value="Logar">
		<input type="submit"  value="Atualizar" onclick="history.go(0)">
		
	</form>

</body>
</html>