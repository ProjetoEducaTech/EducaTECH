<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/assets/css/estilo.css"%></style>
	<title>Minhas Avaliações | Portal do Aluno</title>
</head>

<body>
	<h1>Minhas Avaliações</h1>
	<div>
		<c:forEach var="avaliacao" items="${avaliacoes}">
		<div>  
			<p><c:out value='${avaliacao.nota}'/></p>
			<p><c:out value='${avaliacao.comentario}'/></p>
			<p><c:out value='${avaliacao.dataAvaliacao}'/></p>
			<p><c:out value='${avaliacao.aluno.nome}'/></p>
	        <p><c:out value='${avaliacao.aluno.pronome}'/></p>
			<a href="editar-avaliacao?id=<c:out value='${avaliacao.id}'/>">Editar</a>
			<a href="deletar-avaliacao?id=<c:out value='${avaliacao.id}'/>">Deletar</a>
		</div>
	    </c:forEach>
	</div>
</body>

</html>