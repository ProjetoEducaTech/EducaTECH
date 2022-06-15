<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/assets/css/estilo.css"%></style>
	<title>Página Inicial | EducaTECH</title>
</head>

<body>
		<form class="consulta-inicial" action="consulta-inicial" method="post">
			<div class="filtro">
			<label>Modalidade</label>
			<select name="modalidade">
				<option selected value="0">EAD</option>
				<option selected value="1">Presencial</option>
				<option selected value="2">Semi Presencial</option>
				<option selected value="3">Ao Vivo</option>
			</select> 
			<label>Turno</label>
			<select name="turno">
				<option selected value="0">Matutino</option>
				<option selected value="1">Vespertino</option>
				<option selected value="2">Noturno</option>
				<option selected value="3">Integral</option>
				<option selected value="4">Livre</option>
			</select> 
			<label>Área</label> 
			<select name="area">
				<c:forEach var="area" items="${areas}">
					<option value="<c:out value="${area.id}"/>">
					<c:out value="${area.nome}"/></option>
				</c:forEach>
			</select>
			<label>Nota de Corte</label> 
				<input type="text" name="notaCorte"> 
			<button type="submit" id="botao-buscar">Buscar</button>
			</div>			
		</form>
		<div class="destaques">
		<h1>Cursos de graduação mais bem avaliados</h1>
		<c:forEach var="curso" items="${cursosAvaliados}">
		<div class="card" id="card destaque">
			<c:out value="${curso.nome}"/>
			<c:out value="${curso.avaliacao}"/>
		</div>
		</c:forEach>
		</div>
</body>

</html>
