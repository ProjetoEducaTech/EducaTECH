<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Página Inicial | EducaTECH</title>
<body>
	<header>
		<h3>Selecione as suas preferências para encontrar o curso
			perfeito!</h3>
		<form>
			<select name="modalidade">
				<option selected disabled value="">Modalidade</option>
				<option selected value="0">EAD</option>
				<option selected value="1">Presencial</option>
				<option selected value="2">Semi-Presencial</option>
				<option selected value="3">Ao Vivo</option>
			</select> 
			<select name="turno">
				<option selected disabled value="">Turno</option>
				<option selected value="0">Matutino</option>
				<option selected value="1">Vespertino</option>
				<option selected value="2">Noturno</option>
				<option selected value="3">Integral</option>
				<option selected value="4">Livre</option>
			</select> 
			<select name="area">
				<option selected disabled value="">Área</option>
			</select> 
			<select name="preco">
				<option selected disabled value="">Preço</option>
			</select> <input type="submit" value="Buscar">
		</form>
	</header>
	<h1>Cursos de graduação mais bem avaliados</h1>
	<c:forEach var="curso" items="${cursosAvaliados}">
		<c:out value="${curso.nome}" />
		<c:out value="${curso.duracao}" />
		<c:out value="${curso.Turno}" />
	</c:forEach>
</body>
</html>