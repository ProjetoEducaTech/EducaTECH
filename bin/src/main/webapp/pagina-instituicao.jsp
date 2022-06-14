<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-BR">
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Página instituição | Educatech</title>
    </head>

    <body>

        <h1><c:out value='${instituicao.nome}'/></h1>
        <h2>Descrição da Instituição</h2>

        <p><c:out value='${instituicao.descricao}'/></p>

        <h2>Cursos da Instituição</h2>
        	<c:forEach var="curso" items="${instituicao.cursos}">
        		<p><c:out value='${curso.nome}'/></p>
        		<p><c:out value='${curso.modalidade}'/></p>
        		</c:forEach>
    </body>
    
</html>