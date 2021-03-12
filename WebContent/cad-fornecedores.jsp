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
		<p>Cadastro de Fornecedor</p>
		
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
						<label for="razaosocial">Razão Social</label>
						<input id="razaosocial" type="text" name="razaosocial" value="${forn.razaoSocial}" required="required"
						style="width: 30em;">
					</div>	
					
					<div class="campo">
						<label for="nomefantasia">Nome Fantasia</label>
						<input id="nomefantasia" type="text" name="nomefantasia" value="${forn.nomeFantasia}" required="required"
						style="width: 30em;">
					</div>	
				
				</fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="cnpj">CNPJ</label>
						<input id="cnpj" type="text" name="cnpj" value="${forn.cnpj}" required="required"
						style="width: 20em;">
					</div>	
					
					<div class="campo">
						<label for="inscricaoestadual">Inscrição Estadual</label>
						<input id="inscricaoestadual" type="text" name="inscricaoestadual" value="${forn.inscricaoEstadual}" required="required"
						style="width: 20em;">
					</div>
					
					<div class="campo">
						<label for="inscricaomunicipal">Inscrição Municipal</label>
						<input id="inscricaomunicipal" type="text" name="inscricaomunicipal" value="${forn.inscricaoMunicipal}" required="required"
						style="width: 20em;">
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
		<caption>Registros de Fornecedores Cadastrados</caption>
		<thead>
			<tr>
				<th width="8%">CÓDIGO</th>
				<th width="30%">RAZÃO SOCIAL</th>
				<th width="15%">CNPJ</th>
				<th width="15%">INSC. ESTADUAL</th>
				<th width="15%">DATA DE CADASTRO</th>
				<th style="text-align: center;">AÇÃO</th>
			</tr>
		</thead>
			
		<c:forEach items="${fornecedores}" var="forn">
			<tbody>
				<tr>
					<td width="8%"><c:out value="${forn.codigo}"/></td>
					<td width="30%"><c:out value="${forn.razaoSocial}"/></td>
					<td width="15%"><c:out value="${forn.cnpj}"/></td>
					<td width="15%"><c:out value="${forn.inscricaoEstadual}"/></td>
					<td width="15%"><fmt:formatDate value="${forn.dataCadastro}" pattern="dd-MM-yyyy" /></td>
					
					<td >
						<a id="edit" class="botao edit" href="fornecedorServlet?acao=update&forn=${forn.codigo}">
							<span class="material-icons">
								edit
							</span>
						</a>
						
						<a id="delete" class="botao delete" href="fornecedorServlet?acao=delete&forn=${forn.codigo}">
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