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

<!-- Adicionando JQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>

<link rel="stylesheet" href="resources/css/estilocad.css">
</head>

<body>
	
	<jsp:include page="cabecalho.jsp"/>
	
	<div class="div-pai">
		<p>Dados do Fornecedor</p>
		
		<div id="msg" class="msg">
  			<h3>${mensagem}</h3>
		</div>
		
		<form class="form" action="fornecedorServlet" method="post" onsubmit="return validarCampos() ? true : false;">
		
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
				
				<p>Dados do Endereço</p>
				
				<fieldset class="grupo">
					
					<div class="campo">
						<label for="cep">CEP</label>
						<input id="cep" type="text" name="cep" value="${forn.dataCadastro}" required="required"
						style="width: 8em;" onblur="consultarCep();">
					</div>	
					
					<div class="campo">
						<label for="logradouro">Logradouro</label>
						<input id="logradouro" type="text" name="logradouro" value="${forn.dataCadastro}" required="required"
						style="width: 30em;">
					</div>
					
					<div class="campo">
						<label for="numero">Número</label>
						<input id="numero" type="text" name="numero" value="${forn.dataCadastro}" required="required"
						style="width: 8em;">
					</div>
				
				</fieldset>
				
				<fieldset class="grupo">
					
					<div class="campo">
						<label for="bairro">Bairro</label>
						<input id="bairro" type="text" name="bairro" value="${forn.dataCadastro}" required="required"
						style="width: 15em;">
					</div>
					
					<div class="campo">
						<label for="cidade">Cidade</label>
						<input id="cidade" type="text" name="cidade" value="${forn.dataCadastro}" required="required"
						style="width: 20em;">
					</div>
					
					<div class="campo">
						<label for="estado">Estado</label>
						<input id="estado" type="text" name="estado" value="${forn.dataCadastro}" required="required"
						style="width: 5em;">
					</div>
					
					<div class="campo">
						<label for="ibge">IBGE</label>
						<input id="ibge" type="text" name="ibge" value="${forn.dataCadastro}" required="required"
						style="width: 10em;">
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
				<th align="center" width="8%">AÇÃO</th>
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
					
					<td align="center" width="8%">
						<a id="edit" class="botao edit" href="fornecedorServlet?acao=update&forn=${forn.codigo}">
							<span class="material-icons">
								edit
							</span>
						</a>
						
						<a id="delete" class="botao delete" href="fornecedorServlet?acao=delete&forn=${forn.codigo}">
							<span class="material-icons">
								delete
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

	function validarCampos() {
		if (document.getElementById('razaosocial').value == '') {
			alert('Informe o campo Razão Social');
			return false;
		} 

		return true;
	}

	function consultarCep() {
		var cep = $('#cep').val();


		//Consulta o webservice viacep.com.br **consumindo o webservice/
        $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

            if (!("erro" in dados)) {
                //Atualiza os campos com os valores da consulta.
                $("#logradouro").val(dados.logradouro);
                $("#numero").val(dados.numero);
                $("#bairro").val(dados.bairro);
                $("#cidade").val(dados.localidade);
                $("#estado").val(dados.uf);
                $("#ibge").val(dados.ibge);
            } //end if.
            else {

				$("#cep").val('');
            	$("#logradouro").val('');
                $("#numero").val('');
                $("#bairro").val('');
                $("#cidade").val('');
                $("#estado").val('');
                $("#ibge").val('');
                
              	//CEP pesquisado não foi encontrado.
	            alert("CEP não encontrado.");

	            $('#cep').focus();
	            
            	}
        });
    
	}

	</script>
	
</body>
</html>