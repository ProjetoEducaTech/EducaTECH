<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/assets/css/estilo.css"%></style>
	<title>Perfil Instituicao| EducaTECH</title>
</head>

<body>
	 <h1>Minha Conta</h1>
	
	<p>Nome: <c:out value='${instituicao.nome}'/></p>
	<p>CNPJ: <c:out value='${instituicao.cnpj}'/></p>
	<p>Descrisao: <c:out value='${instituicao.descricao}'/></p>
	
	<h5>Contato</h5>
	<p>Celular: <c:out value='${contato.celular}'/></p>
	<p>Telefone: <c:out value='${contato.telefone}'/></p>
	<p>E-mail: <c:out value='${contato.email}'/></p>
	
	<h5>Endereço</h5>
	
	<p>Cidade: <c:out value='${endereco.cidade}'/></p>
	<p>Bairro: <c:out value='${endereco.bairro}'/></p>
	<p>Rua: <c:out value='${endereco.logradouro}'/></p>
	
	<a href="editar-instituicao?id=<c:out value='${instituicao.id}'/>">Alterar Dados</a>
</body>

</html>