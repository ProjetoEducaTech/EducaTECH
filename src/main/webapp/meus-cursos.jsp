<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/assets/css/estilo.css"%></style>
	<title>Meus Cursos | Portal da Instituição</title>
</head>

<body>
	<%@ include file="menu-instituicao.jsp"%>
<div>
	<h1>Meus Cursos</h1>
	<div class="card">
		<c:forEach var="curso" items="${cursos}">
			<p><a href="pagina-curso?id=<c:out value='${curso.id}'/>"><c:out value='${curso.nome}'/></a></p>
        	<a href="editar-curso?id=<c:out value='${curso.id}'/>">Editar</a>
			<a href="deletar-curso?id=<c:out value='${curso.id}'/>">Deletar</a>
		</c:forEach>
	</div>
</div>
</body>

</html>