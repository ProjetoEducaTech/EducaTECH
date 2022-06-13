<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Minhas Avaliações | Educatech</title>
</head>

<body>
    <h1>Minhas Avaliações</h1>
    <div>
    <c:forEach var="avaliacao" items="${avaliacoes}">
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
			<c:out value='${avaliacao.aluno.nome}' />
		</p>
        <p>
			<c:out value='${avaliacao.aluno.pronome}' />
		</p>

		<button>Editar</button>
		<button>Excluir</button>

    </c:forEach>

</div>

</body>

</html>