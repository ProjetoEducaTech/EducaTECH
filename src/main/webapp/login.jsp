<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login | Educatech</title>
</head>

<body>
	<h1>Bem-Vindo!</h1>
	<form>
		<label for="email">E-mail<em>*</em></label> <input type="email"
			name="email"> <label for="senha">Senha<em>*</em></label> <input
			type="password" name="senha">
		<button type="submit">Entrar</button>
	</form>
	<p>
		Não possui cadastro? Cadastrar-se como <a href="cadastrar-aluno.jsp">Aluno</a> ou <a href="cadastrar-instituicao.jsp">Instituição</a>
	</p>
</body>
</html>