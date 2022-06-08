<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Página Curso | Educatech</title>
</head>

<body>
	<header>
		<button type="button" name="retornar">Retornar</button>

		<img alt="Logo da Instituição">
		<p>Curso de graduação em</p>
		<h1>Nome do curso</h1>
		<p>Localização</p>
	</header>

	<h2>Descrição do Curso</h2>
	<p>
		<c:out value='${curso.descricao}' />
	</p>

	<div class="avaliacao">
		<h2>É estudante do curso? Que tal deixar uma avaliação para
			outros alunos?</h2>
		<form>
			<textarea></textarea>
			<div class="estrelas">
				<input type="radio" id="estrela5" name="avaliar" value="5" /> <label
					for="estrela5" title="text">5 estrelas</label> <input type="radio"
					id="estrela54" name="avaliar" value="4" /> <label for="estrela4"
					title="text">4 estrelas</label> <input type="radio" id="estrela3"
					name="avaliar" value="3" /> <label for="estrel3" title="text">3
					esrtrelas</label> <input type="radio" id="estrela2" name="avaliar"
					value="2" /> <label for="estrela2" title="text">2 estrelas</label>
				<input type="radio" id="estrel1" name="avaliar" value="1" /> <label
					for="estrela1" title="text">1 estrela</label>
			</div>
			<button>Submeter avaliação</button>
		</form>
	</div>

	<h2>Avaliações</h2>
	<c:forEach var="avaliacao" items="${curso.avaliacoes}">
		<p>
			<c:out value='${avaliacao.nota}' />
		</p>
		<p>
			<c:out value='${avaliacao.comentario}' />
		</p>
		<p>
			<c:out value='${avaliacao.data}' />
		</p>
		<p>
			<c:out value='${avaliacao.aluno}' />
		</p>
	</c:forEach>

	<div class="detalhes">
		<p>Área:</p>
		<p>Duração do Curso:</p>
		<p>Modalidade:</p>
		<p>Turno:</p>
		<p>Preço:</p>
	</div>
</body>
</html>