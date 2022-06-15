<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/assets/css/estilo.css"%></style>
	<title>Login | Educatech</title>
</head>

<body>

	<h1>Bem-Vindo!</h1>
	
	<form action = "efetuar-login" method = "post">
		<label for="email">E-mail<em>*</em></label>
			<input type="email" name="email" id="input-login">
		<label for="senha">Senha<em>*</em></label>
			<input type="password" name="senha" id="input-login">
		<button type="submit" id="botao-entrar">Entrar</button>
	</form>
	
	<p>Não possui cadastro? Cadastrar-se como <a href="<%=request.getContextPath()%>/novo-aluno" id="a-aluno">Aluno</a> ou <a href="<%=request.getContextPath()%>/nova-instituicao" id="a-instituicao">Instituição</a></p>
</body>
</html>