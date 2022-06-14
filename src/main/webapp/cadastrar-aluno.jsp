<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/assets/css/estilo.css"%></style>
	<title>Cadastro | Portal do Estudante</title>
</head>

<body>

	<form action="inserir-aluno" method="post">
		
		<h1>Bem-Vindo!</h1>
		
		<div class="passos">
		
		</div>
		
		<div class="aba">
			<h2>Passo 1 - Informações Básicas</h2>
			<label for="data-nascimento">Data de nascimento<em>*</em></label>
			<input type="date" name="data-nascimento" id="data-nascimento">
			<label for="nome-aluno">Nome<em>*</em></label>
			<input type="text" name="nome" id="nome-aluno"> 
			<label for="sobrenome-aluno">Sobrenome<em>*</em></label>
			<input type="text" name="sobrenome" id="sobrenome-aluno">
		</div>
		
		<div class="aba">
			<h2>Passo 2 - Informações de Contato</h2>
			<label for="celular">Celular<em>*</em></label> 
			<input type="tel" name="celular" id="celular">
			<label for="telefone">Telefone</label> 
			<input type="tel" name="telefone" id="telefone"> 
			<label for="email">E-mail<em>*</em></label>
			<input type="email" name="email" id="email">
		</div>
		
		<div class="aba">
			<h2>Passo 3 - Informações Pessoais</h2>
			<label for="genero">Gênero<em>*</em></label>
			<select name="genero" id=genero>					
				<option value="0">Masculino</option>
				<option value="1">Feminino</option>
				<option value="2">Outros</option>
			</select> 
			<label for="pronome">Pronomes<em>*</em></label> 
			<select name="pronome" id="pronome">
				<option value="0">Ele/Dele</option>
				<option value="1">Ela/Dela</option>
				<option value="2">Elu/Delu</option>
			</select> 
			<label for="cpf">CPF<em>*</em></label> 
				<input type="text" name="cpf" id="cpf">
		</div>
		
		<div class="aba">
			<h2>Passo 4 - Senha</h2>
			<label for="senha">Senha<em>*</em></label> 
			<input type="text" name="senha" id="senha">
			<label for="senha-repetida">Repita a Senha<em>*</em></label> 
			<input type="text" name="repita-senha" id="senha-repetida">
		</div>
		
		<div class="aba">
			<h2>Passo 5 - Informações Adicionais</h2>
			<label for="biografia">Biografia</label> 
			<input type="text" name="biografia" id="biografia">
			<label for="foto">Foto de Perfil</label> 
			<input type="file" name="foto-perfil" id="foto">
		</div>
		
		<div>
			<p>Já possui cadastro? <a href="<%=request.getContextPath()%>/login">Fazer login</a></p>
			<p>Não é um aluno? <a href="<%=request.getContextPath()%>/nova-instituicao">Cadastrar-se como Instituição</a></p>
		</div>
		
		
		<div class="botoes">
			<button type="button" id="botao-voltar">Voltar</button>
			<button type="button" id="botao-avancar">Avançar</button>
			<button type="submit" id="botao-cadastrar">Cadastrar-se</button>
		</div>
		
	</form>
</body>
</html>