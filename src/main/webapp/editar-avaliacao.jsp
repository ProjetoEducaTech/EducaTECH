<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style><%@include file="/assets/css/estilo.css"%></style>
<title>Editar Avalição | Educatech</title>
</head>

<body>

		<h2>Editar Avaliação</h2>
		<form action="atualizar-avaliacao" method="post">
			<input type="hidden" name = "id" value="${avaliacao.id}"/>
					<textarea name="comentario"><c:out value='${avaliacao.comentario}' /></textarea>
			<div class="estrelas">
				<input type="radio" id="estrela5" name="nota" value="5" /> <label for="estrela5" title="text">5 estrelas</label> 
				<input type="radio" id="estrela4" name="nota" value="4" /> <label for="estrela4" title="text">4 estrelas</label>
				<input type="radio" id="estrela3" name="nota" value="3" /> <label for="estrela3" title="text">3 estrelas</label>
				<input type="radio" id="estrela2" name="nota" value="2" /> <label for="estrela2" title="text">2 estrelas</label>
				<input type="radio" id="estrela1" name="nota" value="1" /> <label for="estrela1" title="text">1 estrela</label>
			</div>
			<button type="submit">Editar</button>
		</form>

</body>
</html>