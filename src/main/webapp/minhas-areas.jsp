<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Minhas Áreas | Portal da Instituição</title>
</head>

<body>

	<h1>Minhas Áreas</h1>

	<c:forEach var="area" items="${areas}">
		<p>
			<c:out value='${area.nome}' />
		</p>

	</c:forEach>

	<div>
	<a href="cadastrar-area.jsp">+</a>
	</div>

</body>
</html>