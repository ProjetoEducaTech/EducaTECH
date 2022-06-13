<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt-BR">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cursos favoritos | EducaTECH</title>
</head>

<body>
	
	<div>
		<h1>Meus Cursos Favoritos</h1>
		<c:forEach var="curso" items="${cursos}">
		
			<div class="card">
			 <div class="content-card">
			<form action="desfavoritar-curso" method="post">
				<input type="hidden" name="id" value='${curso.id}'/>
				<p><c:out value="${curso.nome}" /></p>
				<p><c:out value="${curso.descricao}" /></p>
				<button>Desfavoritar Curso</button>
			</form>
			</div>
			
		</div>
			
		</c:forEach>
	</div>

</body>

</html>