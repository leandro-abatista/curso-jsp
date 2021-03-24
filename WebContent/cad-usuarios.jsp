<%@page import="model.classes.beans.UsuarioBean"%>
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

<script type="text/javascript" src="resources/javascript/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>

</head>

<body>
	
	<jsp:include page="cabecalho.jsp"/>
	
	<div class="div-pai">
		<p>Cadastro de Usuários</p>
		
		<div id="msg" class="msg">
  			<h3>${mensagem}</h3>
		</div>
		
		<form class="formulario" action="usuarioServlet" method="post">
		
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
						style="width: 30em;">
					</div>	
					
					<div class="campo">
						<label for="cpf">CPF</label>
						<input id="cpf" type="text" name="cpf" value="${user.cpf}" required="required"
						style="width: 12em;"  maxlength="14">
					</div>	
				
				</fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="login">Login</label>
						<input id="login" type="text" id="login" name="login" value="${user.login}" required="required"
						style="width: 21em;">
					</div>	
					
					<div class="campo">
						<label for="senha">Senha</label>
						<input id="senha" type="text" id="senha" name="senha" value="${user.senha}" required="required"
						style="width: 21em;" >
					</div>	
				
				</fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
						<label for="telefone">Telefone</label>
						<input id="telefone" type="text" name="telefone" value="${user.telefone}" required="required"
						style="width: 12em;" maxlength="17">
					</div>	
					
					<div class="campo">
						<label for="email">E-mail</label>
						<input id="email" type="email" name="email" value="${user.email}" required="required"
						style="width: 30em;" x-moz-errormessage="Informe um endereço de e-mail válido.">
					</div>	
				
				</fieldset>
				
				<fieldset class="grupo">
					
					<div class="campo">
						<label for="ativo" >Ativo</label>
						<input type="checkbox" id="ativo" name="ativo" 
							
							<%
								if(request.getAttribute("user") != null){
									UsuarioBean user = (UsuarioBean) request.getAttribute("user");
									if(user.isAtivo()){
										out.print(" ");
										out.print("checked=\"checked\"");
										out.print(" ");
									}
								}
							%>
						
						>
					</div>
					
					<div class="campo">
						
						<label for="perfil">Perfil</label>
						<select id="perfil" name="perfil">
						
							<option selected="selected" disabled="disabled">Selecione</option>
							<option value="Administrador">Administrador</option>
							<option value="Usuário">Usuário</option>
						
						</select>
					
					</div>
					
					<div class="campo">
						
						<label for="departamento">Departamento</label>
						<select id="departamento" name="departamento">
						
							<option selected="selected" disabled="disabled">Selecione</option>
							<option value="Rercursos Humanos">Rercursos Humanos</option>
							<option value="Administrativo">Administrativo</option>
							<option value="Financeiro">Financeiro</option>
							<option value="Comercial">Comercial</option>
							<option value="Tecnologia da Informação">Tecnologia da Informação</option>
							<option value="Operacional">Operacional</option>
						
						</select>
					
					</div>
					
					<div class="campo">
						
						<label for="cargo">Cargo</label>
						<select id="cargo" name="cargo">
						
							<option selected="selected" disabled="disabled">Selecione</option>
							<option value="Gerente Administrativo">Gerente Administrativo</option>
							<option value="Auxiliar Administrativo">Auxiliar Administrativo</option>
							<option value="Diretor Administrativo">Diretor Administrativo</option>
							<option value="Diretor Executivo">Diretor Executivo</option>
							<option value="Gerente de TI">Gerente de TI</option>
							<option value="Auxiliar de TI">Auxiliar de TI</option>
						
						</select>
					
					</div>
					
				</fieldset>
				
					
			</fieldset>
			
			
			<button class="btn submit" type="submit" value="salvar">Salvar</button>
			
			<button type="submit" class="btn submit" value="Cancelar"
				onclick="document.getElementById('formulario').reset();">Cancelar</button>
			
		</form>
		
	</div>
	
	<section>
	
		<div class="caption">Usuários Cadastrados</div>
	
		<div class="tbl-header">
			
			<table>
			
					<thead>
					
						<tr>
							<th style="width: 8%; text-align: left;">Código</th>
							<th style="width: 30%; text-align: left;">Nome</th>
							<th style="width: 20%; text-align: left;">Login</th>
							<th style="width: 25%; text-align: left;">E-mail</th>
							<th style="width: 15%; text-align: left;">Telefone</th>
							<th style="width: 15%; text-align: center;">Opção</th>
						</tr>
						
					</thead>
					
			</table>
			
		</div>
		
		<div class="tbl-content">
		
			<table>
			
				<tbody>

					<c:forEach items="${usuarios}" var="usuario">

						<tbody>

							<tr>

								<td width="8%"><c:out value="${usuario.codigo}" /></td>
								<td width="23%"><c:out value="${usuario.nome}" /></td>
								<td width="18%"><c:out value="${usuario.login}" /></td>
								<td width="23%"><c:out value="${usuario.email}" /></td>
								<td width="18%"><c:out value="${usuario.telefone}" /></td>

								<td align="center" width="15%">
								
								<a id="edit" type="button" class="botao edit" href="usuarioServlet?acao=update&user=${usuario.codigo}">
							    <span class="material-icons"> edit </span>
								</a> 
								
								<a id="delete" type="button" class="botao delete" href="#" data-toggle="modal" data-target="#${usuario.codigo}"> 
								<span class="material-icons"> delete_forever </span>
								</a> 
								
								<a id="addCall" type="button" class="botao addCall" href="telefonesServlet?acao=addTel&user=${usuario.codigo}">
								<span class="material-icons"> add_ic_call </span>
								</a>
								
								</td>

							</tr>

						</tbody>

						<!-- Início Modal de confirmação de exclusão de registro -->
						<div class="modal modal-danger fade" id="${usuario.codigo}"
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
											Deseja excluir o registro
											<c:out value="${usuario.codigo}" />
											?
										</h6>
									</div>

									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Cancelar</button>
										<a type="submit" class="btn btn-warning"
											href="usuarioServlet?acao=delete&user=${usuario.codigo}">Excluir</a>
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
		$('#cpf').mask("000.000.000-00", {reverse:true});
		$('#telefone').mask("(00) 0000-0000");
		
	});

	</script>
	
</body>
</html>