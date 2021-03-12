<jsp:useBean id="beanJsp" class="model.classes.beans.UsuarioBean" type="model.classes.beans.UsuarioBean"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>curso-jsp</title>


<link rel="stylesheet" href="resources/css/estilocad.css">
</head>

<body>
	
	<jsp:include page="cabecalho.jsp"/>
	
	<div class="div-pai">
		<p>Cadastro de Usuários</p>
		
		<div id="msg" class="msg">
  			<h3>${mensagem}</h3>
		</div>
		
		<form class="form" action="usuarioServlet" method="post">
		
			<fieldset>
			
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="codigo">Código</label>
						<input id="codigo" type="text" id="codigo" name="codigo" value="${user.codigo}" readonly="readonly"
						style="width: 10em;">
					</div>	
				
				</fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="nome">Nome</label>
						<input id="nome" type="text" name="nome" value="${user.nome}" required="required"
						style="width: 20em;">
					</div>	
					
					<div class="campo">
						<label for="cpf">CPF</label>
						<input id="cpf" type="text" name="cpf" value="${user.cpf}" required="required"
						style="width: 20em;">
					</div>	
				
				</fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="login">Login</label>
						<input id="login" type="text" id="login" name="login" value="${user.login}" required="required"
						style="width: 20em;">
					</div>	
					
					<div class="campo">
						<label for="senha">Senha</label>
						<input id="senha" type="text" id="senha" name="senha" value="${user.senha}" required="required"
						style="width: 20em;">
					</div>	
				
				</fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="telefone">Telefone</label>
						<input id="telefone" type="text" name="telefone" value="${user.telefone}" required="required"
						style="width: 20em;">
					</div>	
					
					<div class="campo">
						<label for="email">E-mail</label>
						<input id="email" type="email" name="email" value="${user.email}" required="required"
						style="width: 30em;">
					</div>	
				
				</fieldset>
				
					
			</fieldset>
			
			
			<button class="btn submit" type="submit" value="salvar">Salvar</button>
			
			<button class="btn submit" type="submit" value="cancelar"
			onclick="history.go(0)">Cancelar</button>
			
		</form>
		
	<table class="table" cellpadding="0" cellspacing="0">
		<caption>Registros de Usuários Cadastrados</caption>
		<thead>
			<tr>
				<th width="14%">CÓDIGO</th>
				<th width="20%">LOGIN</th>
				<th width="23%">NOME</th>
				<th width="23%">E-MAIL</th>
				<th style="text-align: center;">AÇÃO</th>
			</tr>
		</thead>
			
		<c:forEach items="${usuarios}" var="usuario">
			<tbody>
				<tr>
					<td width="10%"><c:out value="${usuario.codigo}"/></td>
					<td width="20%"><c:out value="${usuario.login}"/></td>
					<td width="25%"><c:out value="${usuario.nome}"/></td>
					<td width="25%"><c:out value="${usuario.email}"/></td>
					
					<td >
						<a id="edit" class="botao edit" href="usuarioServlet?acao=update&user=${usuario.codigo}">Atualizar</a>
						
						<a id="delete" class="botao delete" href="usuarioServlet?acao=delete&user=${usuario.codigo}"
						data-confirm="Tem certeza que deseja excluir o registro selecionado?">Excluir</a>
					</td>
				</tr>
			</tbody>
		</c:forEach>
	
	</table>
	
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){  // A DIFERENÇA ESTA AQUI, EXECUTA QUANDO O DOCUMENTO ESTA "PRONTO"
		  $( "div.msg" ).fadeIn( 300 ).delay( 2500 ).fadeOut( 400 );
		});
	</script>
	
</body>
</html>