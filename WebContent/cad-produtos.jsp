<jsp:useBean id="beanJsp" class="model.classes.beans.FornecedorBean" type="model.classes.beans.FornecedorBean"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
		<p>Cadastro de Produto</p>
		
		<div id="msg" class="msg">
  			<h3>${mensagem}</h3>
		</div>
		
		<form class="form" action="fornecedorServlet" method="post">
		
			<fieldset>
			
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="codigo">Código</label>
						<input id="codigo" type="text" id="codigo" name="codigo" value="${forn.codigo}" readonly="readonly"
						style="width: 10em;">
					</div>	
				
				</fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="nome">Item</label>
						<input id="nome" type="text" name="nome" value="${forn.nome}" required="required"
						style="width: 30em;">
					</div>	
					
				</fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="valor">Valor</label>
						<input id="valor" type="text" name="valor" value="${forn.valor}" required="required"
						style="width: 10em;">
					</div>	
					
					<div class="campo">
						<label for="quantidade">Quantidade</label>
						<input id="quantidade" type="number" name="quantidade" value="${forn.quantidade}" required="required"
						style="width: 8em;" min="1" max="1000">
					</div>
					
				</fieldset>
				
				<fieldset class="grupo">
					
					<div class="campo">
						<label for="datacadastro">Data de Cadastro</label>
						<input id="datacadastro" type="date" name="datacadastro" value="${forn.dataCadastro}" required="required"
						style="width: 12em;" pattern="dd/MM/yyyy" >
					</div>	
				
				</fieldset>
				
					
			</fieldset>
			
			
			<button class="btn submit" type="submit" value="salvar">Salvar</button>
			
			<button class="btn submit" type="submit" value="cancelar"
			onclick="history.go(0)">Cancelar</button>
			
		</form>
		
		<table class="table" cellpadding="0" cellspacing="0">
		<caption>Registros de Produtos Cadastrados</caption>
		<thead>
			<tr>
				<th width="8%">CÓDIGO</th>
				<th width="30%">ITEM</th>
				<th width="15%">VALOR</th>
				<th width="15%">ESTOQUE</th>
				<th width="15%">DATA DE CADASTRO</th>
				<th style="text-align: center;">AÇÃO</th>
			</tr>
		</thead>
			
		<c:forEach items="${produtos}" var="prod">
			<tbody>
				<tr>
					<td width="8%"><c:out value="${prod.codigo}"/></td>
					<td width="30%"><c:out value="${prod.nome}"/></td>
					<td width="15%"><c:out value="${prod.valor}"/></td>
					<td width="15%"><c:out value="${prod.quantidade}"/></td>
					<td width="15%"><fmt:formatDate value="${prod.dataCadastro}" pattern="dd-MM-yyyy" /></td>
					
					<td >
						<a id="edit" class="botao edit" href="fornecedorServlet?acao=update&forn=${prod.codigo}">
							<span class="material-icons">
								edit
							</span>
						</a>
						
						<a id="delete" class="botao delete" href="fornecedorServlet?acao=delete&forn=${prod.codigo}">
							<span class="material-icons">
								delete_sweep
							</span>
						</a>
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