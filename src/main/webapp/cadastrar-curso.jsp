<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/assets/css/estilo.css"%></style>
	<title>Cadastrar Curso | Portal da Instituição</title>
</head>

<body>

	<%@include file="/menu-instituicao.jsp"%>

	<form action="inserir-curso" method="post">
		
		<h1>Cadastrar Curso</h1>
				
		<div class="passos">
		</div>
		
		<div class="aba">
			<label for="nome">Nome do curso<em>*</em></label> 
			<input type="text" placeholder="Digite o nome do curso" name="curso" id="nome">
			<label for="modalidade">Modalidade<em>*</em></label> 
			<select name="modalidade" id="modalidade">
				<option value="0">EAD</option>
				<option value="1">Presencial</option>
				<option value="2">Semi-Presencial</option>
				<option value="3">Ao Vivo</option>
			</select> 
			<label for="turno">Turno<em>*</em></label> 
			<select name="turno" id="turno">
				<option value="0">Matutino</option>
				<option value="1">Vespertino</option>
				<option value="2">Noturno</option>
				<option value="3">Integral</option>
				<option value="4">Livre</option>
			</select> 
			<label for="duracao">Duração do Curso<em>*</em></label> 
			<input type="text" placeholder="Digite a duração do curso" name="duracao" id="duracao"> 
			<label for="area">Área<em>*</em></label> 
			<select name="area" id="area">
				<c:forEach var="area" items="${areas}">
					<option value="<c:out value="${area.id}"/>"><c:out value="${area.nome}" /></option>
				</c:forEach>
			</select> 
			<label for="preco">Preço do curso<em>*</em></label> 
			<input type="text" placeholder="Digite o preço" name="preco" id="preco">
		</div>
		
		<div class="aba">
			<label for="link">Link do Site Oficial do Curso</label>
			<textarea rows="1" name="link" id="link"></textarea>
			<label for="descricao">Descrição</label>
			<textarea rows="5" id="descricao" name="descricao" id="descricao"></textarea>
		</div>
		
		<button type="reset">Cancelar</button>
		<button type="submit">Cadastrar</button>
</body>

</html>