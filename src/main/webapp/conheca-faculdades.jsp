<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/assets/css/estilo.css"%></style>
	<title>Conheca as Faculdades| EducaTECH</title>
</head>
<body>
<%@ include file="menu-aluno.jsp"%>
	<h1>Faculdades</h1>

	<div>
		<c:forEach var="instituicao" items="${instituicoes}">
			<div>

				<p>
					<c:out value='${instituicao.nome}' />
				</p>
				<p>
					<c:out value='${instituicao.descricao}' />
				</p>
				
				<a href="pagina-instituicao?id=<c:out value='${instituicao.id}'/>">Ir para a pagina da Instituicao</a>

			</div>
		</c:forEach>
	</div>
</body>
</html>