<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	 <style><%@include file="/assets/css/estilo.css"%></style>
	<title>Minha Conta | Portal da Instituição</title>
</head>

<body>
	<header>
		<h1>Minha Conta</h1>
		<h4>Dados Pessoais</h4>
		<h4>Endereço</h4>
		<button>Alterar dados</button>
	</header>
	<div>
		<img alt="Foto de Perfil"> 
		<c:out value='${instituicao.nome}'/>
		<p>Alterar imagem<input type="file" name="imagem" id="input-imagem"></p>
	</div>
	<div class="aba">
		<form action="editarInstituicao" method="post">
			<label id="cnpj">CNPJ</label> 
				<input type="text" value="<c:out value='${instituicao.cnpj}'/>" id="input-cnpj"> 
			<label>Celular</label>
				<input type="tel" value="<c:out value='${contato.celualar}'/>" id="input-celular"> 
			<label>E-mail corporativo</label> 
				<input type="email" value="<c:out value='${contato.email}'/>" id="input-email-corp"> 
			<label>Telefone</label> 
				<input type="tel" value="<c:out value='${contato.telefone}'/>" id="input-telefone">
		</form>
	</div>
	<div class="aba">
		<form action="editarInstituicao" method="post">
			<label>CEP</label> 
				<input type="text" value="<c:out value='${endereco.cep}'/>" id="input-cep"> 
			<label>Cidade</label>
				<input type="text" value="<c:out value='${endereco.cidade}'/>"id="input-cidade"> 
			<label>Estado</label> 
				<input type="text" value="<c:out value='${endereco.estado}'/>" id="input-estado"> 
			<label>Complemento</label>
				<input type="text" value="<c:out value='${endereco.complemento}'/>"id="input-complemento"> 
			<label>Bairro</label> 
				<input type="text" value="<c:out value='${endereco.bairro}'/>" id="input-bairro">
			<label>Rua</label>
				<input type="text" value="<c:out value='${endereco.logradouro}'/>" id="input-rua"> 
			<label>Número</label> 
				<input type="text" value="<c:out value='${endereco.numero}'/>" id="input-numero"> 
			<label>Referência</label>
				<input type="text" value="<c:out value='${endereco.referencia}'/>" id="input-referencia">
		</form>
	</div>
		<button type="reset" id="botao-cancelar">Cancelar</button> 
		<button type="submit" id="botao-salvar">Salvar alterações</button>
</body>

</html>