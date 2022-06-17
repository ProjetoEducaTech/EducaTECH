<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/assets/css/estilo.css"%></style>
	<title>${curso.nome} | Educatech</title>
</head>

<body>
	<%@ include file="menu-aluno.jsp"%>
	<div class="cabecalho">
	<button type="button" name="retornar">Retornar</button>
		<img alt="Logo da Instituição">
		<p>Curso de graduação em</p>
		<h1><c:out value='${curso.nome}'/></h1>
		<p>Localização<c:out value='${endereco.cidade}'/>
		<c:out value='${endereco.estado}'/></p>
	</div>
		<h3>Descrição do Curso</h3>
		<p><c:out value='${curso.descricao}'/></p>
	<div class="avaliar">
		<h4>É estudante do curso? Que tal deixar uma avaliação para outros alunos?</h4>
		<form action="inserir-avaliacao" method="post">
			<input type="hidden" name = "id" value="${curso.id}"/>
			<textarea name="comentario"></textarea>
			<div class="estrelas">
				<label for="estrela5" title="text">5 estrelas</label>
				<input type="radio" id="estrela5" name="nota" value="5"/> 
				<label for="estrela4" title="text">4 estrelas</label> 
				<input type="radio" id="estrela4" name="nota" value="4"/> 
				<label for="estrela3" title="text">3 estrelas</label>
				<input type="radio" id="estrela3" name="nota" value="3"/> 
				<label for="estrela2" title="text">2 estrelas</label>
				<input type="radio" id="estrela2" name="nota" value="2"/> 
				<label for="estrela1" title="text">1 estrela</label>
				<input type="radio" id="estrela1" name="nota" value="1"/> 
			</div>
			<button type="submit">Submeter avaliação</button>
		</form>
	</div>
	<div class="avaliacoes">
	<h2>Avaliações</h2>
	<c:forEach var="avaliacao" items="${avaliacoes}">
		<div class="avaliacao">
			<img src="data:image/<c:out value='${avaliacao.extensao}'/>;base64,<c:out value='${avaliacao.foto}'/>" class="avatar" height="75" width="75">
			<span><c:out value='${avaliacao.nome}'/></span>
			<span><c:out value='${avaliacao.sobrenome}'/></span>
			<span>|</span>
			<span><c:out value='${avaliacao.pronome}'/></span>
			<p><c:out value='${avaliacao.comentario}'/></p>
			<span>Nota:</span>
			<span><c:out value='${avaliacao.nota}'/></span>			
			<p><c:out value='${avaliacao.data}'/></p>
			<a href="editar-avaliacao?id=<c:out value='${avaliacao.id}'/>">Editar</a>
			<a href="deletar-avaliacao?id=<c:out value='${avaliacao.id}'/>">Deletar</a>
		</div>
	  </c:forEach>
	</div>
  	<div class="detalhes">
  		<h2>Detalhes</h2>
		<p>Área: <c:out value='${area.nome}'/></p>
		<p>Duração do Curso: <c:out value='${curso.duracao}'/></p>
		<p>Modalidade: <c:out value='${curso.modalidade}'/></p>
		<p>Turno: <c:out value='${curso.turno}'/></p>
		<p>Preço: <c:out value='${curso.preco}'/></p>
	</div>
	</body>
</html>