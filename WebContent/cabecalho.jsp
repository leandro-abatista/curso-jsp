<jsp:useBean id="beanJsp" class="model.classes.beans.UsuarioBean" type="model.classes.beans.UsuarioBean"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>curso-jsp</title>
<!-- icones do google -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<!-- jquery -->
<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
  
  <!-- meu proprio estilo -->
<link rel="stylesheet" type="text/css" href="resources/css/estilocabecalho.css">
</head>
<body>

	<div class="btnAbre"><span class="material-icons">menu_open</span></div>

	<nav class="menulateral">
	
		<div class="titulo">Logo<span class="material-icons btnFecha">close</span></div>
		
		<ul>
			
			<li><a href="acessoliberado.jsp" class="cad1">Home</a></li>
		
			<li><a href="#" class="cad">Cadastro<span class="material-icons seta1">arrow_right</span></a>
				<ul class="itens">
					<li><a href="usuarioServlet?acao=listarTodos">Usuários</a></li>
				</ul>
			</li>
			
			<li><a href="#">Relatório<span class="material-icons seta2">arrow_right</span></a></li>
			
			<li><a href="#">Agenda<span class="material-icons seta3">arrow_right</span></a></li>
			
			<li><a href="#">Serviços<span class="material-icons seta4">arrow_right</span></a></li>
			
			<li><a href="#">Sobre<span class="material-icons seta5">arrow_right</span></a></li>
			
			<li><a href="#">Ajuda<span class="material-icons seta6">arrow_right</span></a></li>
			
			<li><a href="#">Sair<span class="material-icons seta7">arrow_right</span></a></li>
			
		</ul>
		
	</nav>
	
	<script type="text/javascript" src="resources/javascript/script.js"></script>
</body>
</html>