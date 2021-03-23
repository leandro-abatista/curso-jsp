
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

<script type="text/javascript" src="resources/javascript/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>

</head>

<body>
	
	<jsp:include page="cabecalho.jsp"/>
	
	<div class="div-pai">
		<p>Cadastro de Entrada de Produto</p>
		
		<div id="msg" class="msg">
  			<h3>${mensagem}</h3>
		</div>
		
		<form class="form" action="produtoServlet" method="post">
		
			<fieldset>
			
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="codigo">Código</label>
						<input id="codigo" type="text" id="codigo" name="codigo" value="${prod.codigo}" readonly="readonly"
						style="width: 10em;">
					</div>	
				
				</fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="fornecedor">Fornecedor</label>
						<select id="fornecedor" name="fornecedor" style="width: 20em;">
							
							<option selected="selected" disabled="disabled">Selecione</option>
							
							<!-- usando jstl -->
							<c:forEach items="${fornecedores}" var="forn">
								<option value="${forn.codigo}" id="${forn.codigo}"
									
									<c:if test="${forn.codigo == prod.codigo_forn}">
										<c:out value="selected=selected"/>
									</c:if>
								
								>
									${forn.razaoSocial}
								</option>
							</c:forEach>
						
						</select>
						
					</div>
				
				</fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="nome">Item</label>
						<input id="nome" type="text" name="nome" value="${prod.nome}" 
						style="width: 30em;">
					</div>	
					
					<div class="campo">
						<label for="categoria">Categoria</label>
						<select id="categoria" name="categoria" style="width: 15em;">
							
							<option selected="selected" disabled="disabled">Selecione</option>
							
							<!-- usando jstl -->
							<c:forEach items="${categorias}" var="cat">
								<option value="${cat.codigo}" id="${cat.codigo}"
									<c:if test="${cat.codigo == prod.codigo_cat}">
										<c:out value="selected=selected"/>
									</c:if>
								>
									${cat.descricao}
								</option>
							</c:forEach>
						
						</select>
						<a class="botao add" type="button" href="categoriaServlet?acao=listarTodos">
							<span class="material-icons">add_box</span>
						</a>
						
					</div>
					
					<div class="campo">
						<label for="unimedida">Unid. Medida</label>
						<select id="unimedida" name="unimedida" style="width: 15em;">
							
							<option selected="selected" disabled="disabled">Selecione</option>
							
							<!-- usando jstl -->
							<c:forEach items="${unimedidas}" var="um">
								<option value="${um.codigo}" id="${um.codigo}"
								
									<c:if test="${um.codigo == prod.codigo_unidmedida}">
										<c:out value="selected=selected"/>
									</c:if>
								
								>
									${um.descricao}
								</option>
							</c:forEach>
							
						</select>
						<a class="botao add" type="button" href="unidadeMedidaServlet?acao=listarTodos">
							<span class="material-icons">add_box</span>
						</a>
						
					</div>
					
				</fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="valor">Valor de Custo</label>
						<input class="valor" id="valor" type="text" name="valor" value="${prod.valor}" required="required"
						style="width: 10em;">
					</div>	
					
					<div class="campo">
						<label for="valorVenda">Valor de Venda</label>
						<input class="valorVenda" id="valorVenda" type="text" name="valorVenda" value="${prod.valorVenda}" required="required"
						style="width: 10em;">
					</div>
					
					<div class="campo">
						<label for="quantidade">Quantidade</label>
						<input id="quantidade" type="number" name="quantidade" value="${prod.quantidade}" required="required"
						style="width: 8em;" min="1" max="1000">
					</div>
					
					<div class="campo">
						<label for="ncm">NCM</label>
						<input id="ncm" type="text" name="ncm" value="${prod.ncm}" required="required"
						style="width: 8em;" maxlength="8">
					</div>
					
					<div class="campo">
						<label for="codigobarra">Código de Barras</label>
						<input id="codigobarra" type="text" name="codigobarra" value="${prod.codigoBarra}" required="required"
						style="width: 15em;" maxlength="13">
					</div>
					
					<div class="campo">
						<label for="peso">Peso</label>
						<input id="peso" type="text" name="peso" value="${prod.peso}" required="required"
						style="width: 10em;">
					</div>
					
				</fieldset>
				
				<fieldset class="grupo">
					
					<div class="campo">
						<label for="datacadastro">Data de Cadastro</label>
						<input id="datacadastro" type="date" name="datacadastro" value="${prod.dataCadastro}" required="required"
						style="width: 15em;" pattern="dd/MM/yyyy HH:mm:ss" >
					</div>	
				
				</fieldset>
				
					
			</fieldset>
			
			
			<button class="btn submit" type="submit" value="salvar">Salvar</button>
			
			<button class="btn submit" type="submit" value="cancelar"
			onclick="document.getElementById('formulario').reset();">Cancelar</button>
			
		</form>
		
	</div>

	<section>

		<div class="caption">Produtos Cadastrados</div>

		<div class="tbl-header">

			<table>

				<thead>

					<tr>
						<th width="8%">CÓDIGO</th>
						<th width="30%">ITEM</th>
						<th width="15%">VALOR</th>
						<th width="15%">ESTOQUE</th>
						<th width="15%">DATA DE CADASTRO</th>
						<th align="center" width="12%">Opção</th>
					</tr>

				</thead>

			</table>

		</div>

		<div class="tbl-content">

			<table>

				<tbody>

					<c:forEach items="${produtos}" var="prod">
						<tbody>
							<tr>
								<td width="8%"><c:out value="${prod.codigo}" /></td>
								<td width="30%"><c:out value="${prod.nome}" /></td>
								<td width="15%"><fmt:formatNumber value="${prod.valor}"
										pattern="#,#00.00" /></td>
								<td width="15%"><c:out value="${prod.quantidade}" /></td>
								<td width="15%"><fmt:formatDate
										value="${prod.dataCadastro}" pattern="dd-MM-yyyy" /></td>

								<td align="center" width="12%">
								
								<a id="edit" type="button" class="botao edit"
									href="produtoServlet?acao=update&prod=${prod.codigo}"> 
									<span class="material-icons"> edit </span>
								</a> 
								
								<a id="delete" type="button" class="botao delete" href="#"
									data-toggle="modal" data-target="#${prod.codigo}"> 
									<span class="material-icons"> delete_forever </span>
								</a>
								
								</td>
								
							</tr>
							
						</tbody>

						<!-- Início Modal de confirmação de exclusão de registro -->
						<div class="modal modal-danger fade" id="${prod.codigo}"
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
											Deseja excluir o produto <c:out value="${prod.nome}" /> ?
										</h6>
									</div>

									<div class="modal-footer">
										<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
										<a type="submit" class="btn btn-warning"
											href="produtoServlet?acao=delete&prod=${prod.codigo}">Excluir</a>
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

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="resources/javascript/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="resources/javascript/jquery.mask.min.js"></script>
	<script type="text/javascript" src="resources/javascript/jquery.maskMoney.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){  // A DIFERENÇA ESTA AQUI, EXECUTA QUANDO O DOCUMENTO ESTA PRONTO
		 $( "div.msg" ).fadeIn( 300 ).delay( 2500 ).fadeOut( 400 );
	});

	$(document).ready(function() {
    	$("input.valor").maskMoney({showSymbol: false, decimal:",", thousands:"."});	
    	$("input.valorVenda").maskMoney({showSymbol: false, decimal:",", thousands:"."});	
    	$("#peso").mask('###.##0,000', {reverse: false});	
	});
	
	</script>
	
</body>
</html>