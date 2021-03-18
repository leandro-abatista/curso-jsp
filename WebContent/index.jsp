<jsp:useBean id="beanJsp" class="model.classes.beans.UsuarioBean" type="model.classes.beans.UsuarioBean"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>curso-jsp</title>

<link rel="stylesheet" href="resources/css/estilo.css">
</head>
<body>

	<form class="form" action="acessoServlet" method="post">
		<!-- div pai -->
		<div class="card">
			
			<div class="card-top">
			
				<img class="imguser" alt="" src="resources/img/userimg.png">
				<h2 class="titulo">Painel de Controle</h2>
				<p class="paragrafo">Área Restrita</p>
			
			</div>
			
			<div class="card-group">
			
				<label id="login">Login: </label>
				<input type="text" id="login" name="login" placeholder="Digite seu login" required="required">
				
			</div>
			
			<div class="card-group">
			
				<label id="senha">Senha: </label>
				<input type="password" id="senha" name="senha" placeholder="Digite sua senha" required="required">
			
			</div>
			
			<div class="card-group">
			
				<label id="label-3"><input type="checkbox">Lembrar-me </label>
			
			</div>
			
			<div class="card-group btn">
			
				<button type="submit" value="acessar">Acessar</button>
			
			</div>
			
		</div>
	
	</form>

</body>
</html>