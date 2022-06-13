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
		<div class="bolinhas">
		
		</div>	
		<div class="aba">
			<h2>Passo 1 - Informações Básicas</h2>
			<label>Data de nascimento<em>*</em></label> 
			<input type="date" name="data-nascimento" id="input-data-nascimento"> 
			<label>Nome<em>*</em></label> 
			<input type="text" name="nome" id="input-nome-aluno"> 
			<label>Sobrenome<em>*</em></label>
			<input type="text" name="sobrenome" id="input-sobrenome-aluno">
				<div class="alternativas">
					<p>Já possui cadastro? <a href="login.jsp">Fazer login</a></p>
					<p>Não é um aluno?<a href="cadastrar-instituicao.jsp">Cadastrar-se como Instituição</a></p>
				</div>
		</div>
		<div class="aba">
			<h2>Passo 2 - Informações de Contato</h2>
			<label>Celular<em>*</em></label> 
			<input type="tel" name="celular" id="input-celular">
			<label>Telefone</label> 
			<input type="tel" name="telefone" id="input-telefone"> 
			<label>E-mail<em>*</em></label>
			<input type="email" name="email" id="input-email">
		</div>
		<div class="aba">
			<h2>Passo 3 - Informações Pessoais</h2>
			<label>Gênero<em>*</em></label>
			<select name="genero" id=select-genero>					
				<option value="0">Masculino</option>
				<option value="1">Feminino</option>
				<option value="2">Outros</option>
			</select> 
			<label>Pronomes<em>*</em></label> 
			<select name="pronome" id="select-pronome">
				<option value="0">Ele/Dele</option>
				<option value="1">Ela/Dela</option>
				<option value="2">Elu/Delu</option>
			</select> 
			<label>CPF<em>*</em></label> 
				<input type="text" name="cpf" id="input=cpf">
		</div>
		<div class="aba">
			<h2>Passo 4 - Senha</h2>
			<label>Senha<em>*</em></label> 
				<input type="text" name="senha" id="input-senha">
			<label>Repita a Senha<em>*</em></label> 
				<input type="text" name="repita-senha" id="input-senha-repetir">
		</div>
		<div class="aba">
			<h2>Passo 5 - Informações Adicionais</h2>
			<label>Biografia</label> 
				<input type="text" name="biografia" id="input-bio">
			<label>Foto de Perfil</label> 
				<input type="file" name="foto-perfil" id="input-foto">
		</div>
		<div class="botoes">
			<button type="button" id="botao-voltar">Voltar</button>
			<button type="button" id="botao-avancar">Avançar</button>
			<button type="submit" id="botao-cadastrar">Cadastrar-se</button>
		</div>
	</form>
</body>
</html>