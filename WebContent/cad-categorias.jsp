<jsp:useBean id="beanJsp" class="model.classes.beans.Telefone" type="model.classes.beans.Telefone"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>curso-jsp</title>

<link rel="stylesheet" href="resources/css/estilocad.css">

<script type="text/javascript" src="resources/javascript/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>

</head>

<body>
	
	<jsp:include page="cabecalho.jsp"/>
	
	<div class="div-pai">
		<p>Cadastro de Categorias</p>
		
		<div id="msg" class="msg">
  			<h3>${mensagem}</h3>
		</div>
		
		<form class="form" action="categoriaServlet" method="post">
		
			<fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="codigo">Código</label>
						<input id="codigo" type="text"  name="codigo" readonly="readonly" style="width: 10em;">
					</div>
				
					<div class="campo">
						<label for="descricao">Descricao</label>
						<input id="descricao" type="text" name="descricao"  required="required" style="width: 20em;">
					</div>	
					
				</fieldset>
				
			</fieldset>
			
			<button class="btn submit" type="submit" value="salvar">Salvar</button>
			
			<button class="btn submit" type="submit" value="cancelar" onclick="document.getElementById('formulario').reset();">Cancelar</button>
			
		</form>
		
	<table class="table" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th width="8%">CÓDIGO</th>
				<th width="20%">DESCRIÇÃO</th>
				<th align="center" width="15%">AÇÃO</th>
			</tr>
		</thead>
			
		<c:forEach items="${categorias}" var="cat">
		
			<tbody>
			
				<tr>
				
					<td width="8%"><c:out value="${cat.codigo}"/></td>
					<td width="20%"><c:out value="${cat.descricao}"/></td>
					
					<td align="center" width="15%">
						
						<a id="delete" class="botao delete" href="#" data-toggle="modal" data-target="#${cat.codigo}">
							<span class="material-icons">
								delete
							</span>
						</a>
						
					</td>
					
				</tr>
				
			</tbody>
			
			<!-- Início Modal de confirmação de exclusão de registro -->
			<div class="modal modal-danger fade" id="${cat.codigo}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog  modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
		
							<h5 class="modal-title" id="TituloModalCentralizado">Confirmar exclusão</h5>
		
							<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
								<span aria-hidden="true">&times;</span>
							</button>
		
						</div>
		
						<div class="modal-body">
							<h6>Deseja excluir a categoria <c:out value="${cat.descricao}"/> ?</h6>
						</div>
		
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
							<a type="submit" class="btn btn-warning" href="categoriaServlet?acao=delete&cat=${cat.codigo}">Excluir</a>
						</div>
								
					</div>
				</div>
			</div>
			<!-- Fim do Modal de confirmação de exclusão de registro -->
			
		</c:forEach>
	
	</table>
	
	</div>
	
	
	<script type="text/javascript" src="resources/javascript/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="resources/javascript/jquery.mask.min.js"></script>

	<script type="text/javascript">
	$(document).ready(function(){  // A DIFERENÇA ESTA AQUI, EXECUTA QUANDO O DOCUMENTO ESTA "PRONTO"
		  $( "div.msg" ).fadeIn( 300 ).delay( 2500 ).fadeOut( 400 );
	});

	$(document).ready(function () {
		$('#numero').mask("(00) 0000-0000");
		
	});

	</script>
	
</body>
</html>