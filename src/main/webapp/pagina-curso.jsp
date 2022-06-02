<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <h1><c:out value='${curso.nome}'/></h1>

        <h2>Descrição do Curso</h2>

        <p><c:out value='${curso.descricao}'/></p>

        <h2>É estudante do curso? Que tal deixar uma avaliação para outros alunos?</h2>
        <textarea></textarea>
        <button>Submeter avaliação</button>

        <h2>Avaliações</h2>
        
        	<c:forEach var="avaliacao" items="${curso.avaliacoes}">
        		<p><c:out value='${avaliacao.nota}'/></p>
        		<p><c:out value='${avaliacao.comentario}'/></p>
        		<p><c:out value='${avaliacao.data}'/></p>
        		<p><c:out value='${avaliacao.aluno}'/></p>
        	</c:forEach>
    </body>
</html>