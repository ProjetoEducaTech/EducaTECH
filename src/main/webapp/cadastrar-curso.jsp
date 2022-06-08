<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastro de curso | Educatech</title>
</head>

<body>


	<div class="aba">
		<c:if test="${curso == null}">
			<form action="inserir-curso" method="post">
				<h1>Cadastrar Curso</h1>
		</c:if>
		<c:if test="${curso != null}">
			<form action="atualizar-curso" method="post">
				<h1>Atualizar curso</h1>
		</c:if>
		<label for="nome">Nome do curso<em>*</em></label> <input type="text"
			id="nome" value="<c:out value='${curso.nome}' />"
			placeholder="Digite o nome do curso" name="curso"> <label>Modalidade<em>*</em></label>
		<label>Modalidade<em>*</em></label> <select name="modalidade">
				<option value="<c:out value='${curso.modalidade}' />"><c:out value='${curso.modalidade}' /></option>
				<option value="0">EAD</option>
				<option value="1">Presencial</option>
				<option value="2">Semi-Presencial</option>
				<option value="3">Ao Vivo</option>

			</select> <label>Turno<em>*</em></label> <select name="turno">
				<option value="<c:out value='${curso.turno}' />"><c:out value='${curso.turno}' /></option>
				<option value="0">Matutino</option>
				<option value="1">Vespertino</option>
				<option value="2">Noturno</option>
				<option value="3">Integral</option>
				<option value="4">Livre</option>

		</select> <label>Duração do Curso<em>*</em></label> <input type="text"
			value="<c:out value='${curso.duracao}' />" name="duracao"> <label>Área<em>*</em></label>
		<select name="area">

			<c:forEach var="area" items="${areas}">
				<option value="<c:out value="${area.id}"/>"><c:out
						value="${area.nome}" /></option>
			</c:forEach>

		</select> <label for="nome">Preço do curso<em>*</em></label> <input type="text"
			id="preco" value="<c:out value='${curso.preco}' />"
			placeholder="Digite o preço" name="preco">
	</div>

	<div class="aba">
		<label for="link">Link do Site Oficial do Curso</label>
		<textarea rows="1" name="link" value="<c:out value='${curso.link}' />"></textarea>

		<label for="descricao"><strong>Descrição</strong></label>
		<textarea rows="5" value="<c:out value='${curso.descricao}' />"
			id="descricao" name="descricao"></textarea>
	</div>
	<c:if test="${curso == null}">
		<fieldset>
			<div class="botao">
				<button type="submit">Cadastrar Curso</button>
			</div>
		</fieldset>
	</c:if>

	<c:if test="${curso != null}">
		<fieldset>
			<div class="botao">
				<button type="submit">Atualizar Curso</button>
			</div>
		</fieldset>
	</c:if>

	</form>

	<c:if test="${curso != null}">
		<form action="deletar-curso" method="post">
			<div>
				<button type="submit">deletar avaliação</button>
			</div>
		</form>
	</c:if>
</body>

</html>