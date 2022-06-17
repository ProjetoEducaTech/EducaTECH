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
		<div class="avaliacao">
			<img src="data:image/<c:out value='${avaliacao.aluno.foto.extensao}'/>;base64,<c:out value='${avatar}'/>" class="avatar" height="75" width="75">
			<span><c:out value='${avaliacao.aluno.nome}'/></span>
			<span><c:out value='${avaliacao.aluno.sobrenome}'/></span>
			<span>|</span>
			<span><c:out value='${avaliacao.aluno.pronome}'/></span>
			<p><c:out value='${avaliacao.comentario}'/></p>
			<span>Nota:</span>
			<span><c:out value='${avaliacao.nota}'/></span>			
			<p><c:out value='${avaliacao.dataAvaliacao}'/></p>
			<a href="editar-avaliacao?id=<c:out value='${avaliacao.id}'/>">Editar</a>
			<a href="deletar-avaliacao?id=<c:out value='${avaliacao.id}'/>">Deletar</a>
		</div>
	    </c:forEach>
	</div>
</body>

</html>