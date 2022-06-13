<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Meus Cursos | Portal da Instituição</title>
</head>

<body>
<div>
	<h1>Meus Cursos</h1>
	
	<div class="card">
		<c:forEach var="curso" items="${cursos}">
				<p>
					<c:out value='${curso.nome}' />
				</p>
				<div>
					<form  action="deletar-curso" method="post">
      		<div>
        		<button type="submit">deletar curso</button>
        	</div>
      		</form>
				</div>
					<form  action="editar-curso" method="post">
      		<div>
        		<button type="submit">editar curso</button>
        	</div>
      		</form>
		</c:forEach>
	</div>
	</div>
</body>
</html>