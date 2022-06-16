<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/assets/css/estilo.css"%></style>
	<title> ${instituicao.nome} | EducaTECH</title>
</head>

<body>
	<%@ include file="menu-instituicao.jsp"%>
	 <h1><c:out value='${instituicao.nome}'/></h1>
	
	<h5>Descricao da Instituicao</h5>
	<p><c:out value='${instituicao.descricao}'/></p>
	
	<h5>Endereço</h5>
	<p><c:out value='${endereco.logradouro}'/>, <c:out value='${endereco.numero}'/>-<c:out value='${endereco.bairro}'/></p>
	<p><c:out value='${endereco.cidade}'/> | <c:out value='${endereco.estado}'/></p>
	
	<h5>Informações de Contato</h5>
	<p> <c:out value='${contato.celular}'/> | <c:out value='${contato.telefone}'/></p>
	
</body>

</html>