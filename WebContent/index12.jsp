<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Seja bem vindo ao curso jsp</h1>
		<%out.print("Seu sucesso garantidso, usasndo out.print"); %>
	<br/>
	<!-- Exepressão de saída do jsp. o código abaixo subtitui o out.print-->
	<%= "Seu sucesso garantido sem out.print" %>
	
	
	
	<form action="recebernome.jsp">
		
		<input type="text" id="nome" name="nome">
		<br>
		<input type="submit" value="Enviar">
		
		
		
		
	</form>
	
	<!-- tag declarativa -> pode ser declaraado variáveis e métodos-->
	<%! 
	
		int cont = 2 + 2; 
		
		public int retorna(int n){
			return n * 3;
		}
	%>
	
	<%= "Resultado : " + cont %>
	<br>
	<br>
	<%= "Resultado : " + retorna(8) %>
	<br>
	<br>
	<%= "applicattion " + application.getInitParameter("estado") %>
	
	<br>
	<br>
	<br>
	<h2><a href="index4.jsp">Index4</a></h2>
		

</body>
</html>