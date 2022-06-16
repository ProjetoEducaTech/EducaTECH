<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/assets/css/estilo.css"%></style>
	<title>Perfil Aluno| EducaTECH</title>
</head>

<body>
    <h1>Minha Conta</h1>
	
	<p>Nome: <c:out value='${aluno.nome}'/></p>
	<p>CPF: <c:out value='${aluno.cpf}'/></p>
	<p>Data de Nascimento: <c:out value='${aluno.dataNascimento}'/></p>
	<p>Pronome: <c:out value='${aluno.pronome}'/></p>
	<p>Gênero: <c:out value='${aluno.genero}'/></p>
	<p>Celular: <c:out value='${contato.celular}'/></p>
	<p>Telefone: <c:out value='${contato.telefone}'/></p>
	<p>E-mail: <c:out value='${contato.email}'/></p>
	<p>Biografia: <c:out value='${aluno.biografia}'/></p>
	<a href="editar-aluno?id=<c:out value='${aluno.id}'/>">Alterar Dados</a>
</body>

</html>