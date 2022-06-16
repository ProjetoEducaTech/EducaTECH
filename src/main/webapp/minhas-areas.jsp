<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/assets/css/estilo.css"%></style>
	<title>Minhas Áreas | Portal da Instituição</title>
</head>

<body>
	<h1>Minhas Áreas</h1>
	<c:forEach var="area" items="${areas}">
		<p><c:out value='${area.nome}'/></p>
		<a href="editar-area?id=<c:out value='${area.id}'/>">Editar</a>
		<a href="deletar-area?id=<c:out value='${area.id}'/>">Deletar</a>
	</c:forEach>
	<a href="<%=request.getContextPath()%>/nova-area">+</a>
</body>

</html>