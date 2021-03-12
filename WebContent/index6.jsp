<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="UTF-8"%>

<%@ taglib uri="/WEB-INF/testetag.tld" prefix ="mt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:forward page="recebernome4.jsp">
		<jsp:param value="curso de jsp site java avançado.com" name="paramforward"/>
	</jsp:forward>
</body>
</html>