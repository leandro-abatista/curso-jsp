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
		<p>Cadastro de Telefones</p>
		
		<div id="msg" class="msg">
  			<h3>${mensagem}</h3>
		</div>
		
		<form class="form" action="telefonesServlet" method="post">
		
			<fieldset>
			
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="codigo">Cód. Usuário</label>
						<input id="codigo" type="text" name="codigo" value="${userSelecionado.codigo}" readonly="readonly"
						style="width: 10em;">
					</div>	
					
					<div class="campo">
						<label for="nome">Nome do Usuário</label>
						<input id="nome" type="text" name="nome" value="${userSelecionado.nome}" readonly="readonly" style="width: 30em;">
					</div>
				
				</fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="codigoT">Código</label>
						<input id="codigoT" type="text"  name="codigoT" readonly="readonly" style="width: 10em;">
					</div>
				
					<div class="campo">
						<label for="tipo">Tipo</label>
						<select id="tipo"  name="tipo" style="width: 10em;" required="required">
							<option selected="selected" disabled="disabled">Selecione</option>
							<option>Empresa</option>
							<option>Residencial</option>
							<option>Celular</option>
						</select>
					</div>	
					
					<div class="campo">
						<label for="numero">Número</label>
						<input id="numero" type="text" name="numero"  required="required" style="width: 19em;">
					</div>
					
				</fieldset>
				
			</fieldset>
			
			<button class="btn submit" type="submit" value="salvar">Salvar</button>
			
			<button class="btn submit" type="submit" value="cancelar" onclick="history.go(0)">Cancelar</button>
			
		</form>
		
	</div>

	<section>

		<div class="caption">Telefones Cadastrados</div>

		<div class="tbl-header">

			<table>

				<thead>

					<tr>
						<th width="8%">CÓDIGO</th>
						<th width="20%">TIPO</th>
						<th width="23%">NÚMERO</th>
						<th align="center" width="15%">Opção</th>
					</tr>

				</thead>

			</table>

		</div>

		<div class="tbl-content">

			<table>

				<tbody>

					<c:forEach items="${telefones}" var="fone">

						<tbody>

							<tr>

								<td width="8%"><c:out value="${fone.codigo}" /></td>
								<td width="20%"><c:out value="${fone.tipo}" /></td>
								<td width="23%"><c:out value="${fone.numero}" /></td>

								<td align="center" width="15%">
								
								<a id="delete" type="button" class="botao delete" href="#" data-toggle="modal"
									data-target="#${fone.codigo}"> 
									<span class="material-icons"> delete_forever </span>
								</a>
								
								</td>

							</tr>

						</tbody>

						<!-- Início Modal de confirmação de exclusão de registro -->
						<div class="modal modal-danger fade" id="${fone.codigo}"
							tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
							<div class="modal-dialog  modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">

										<h5 class="modal-title" id="TituloModalCentralizado">Confirmar
											exclusão</h5>

										<button type="button" class="close" data-dismiss="modal"
											aria-label="Fechar">
											<span aria-hidden="true">&times;</span>
										</button>

									</div>

									<div class="modal-body">
										<h6>
											Deseja excluir o telefone
											<c:out value="${fone.numero}" />
											?
										</h6>
									</div>

									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Cancelar</button>
										<a type="submit" class="btn btn-warning"
											href="telefonesServlet?acao=delete&foneId=${fone.codigo}">Excluir</a>
									</div>

								</div>
							</div>
						</div>
						<!-- Fim do Modal de confirmação de exclusão de registro -->

					</c:forEach>

				</tbody>

			</table>

		</div>

	</section>

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