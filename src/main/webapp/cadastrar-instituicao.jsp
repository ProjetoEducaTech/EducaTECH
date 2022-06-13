<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/assets/css/estilo.css"%></style>
	<title>Cadastro | Portal da Instituição</title>
</head>

<body>
	<form action="inserir-instituicao" method="post">
		<div class="aba">
			<h1>Bem-Vindo!</h1>
			<h2>Passo 1 - Informações Básicas</h2>
			<label>Nome<em>*</em></label> 
				<input type="text" name="nome" id="input-nome-instituicao">
			<label>CNPJ<em>*</em></label> 
				<input type="text" name="cnpj" id="input-cnpj">
			<p>Já possui cadastro? <a href="login.jsp">Fazer login</a></p>
			<p>Não é uma instituição?<a href="cadastrar-aluno.jsp">Cadastrar-se como Aluno</a></p>
		</div>
		<div class="aba">
			<h2>Passo 2 - Informações de Contato</h2>
			<label>Celular<em>*</em></label> 
				<input type="tel" name="celular" id="input-celular">
			<label>Telefone</label> 
				<input type="tel" name="telefone" id="input-telefone"> 
			<label>E-mail Corporativo<em>*</em></label> 
				<input type="email" name="email" id="input-email">
		</div>
		<div class="aba">
			<h2>Passo 3 - Endereço</h2>
			<label>CEP<em>*</em></label>
			<input type="text" name="cep" id="cep"> 
			<label>Cidade<em>*</em></label>
			<input type="text" name="cidade" id="cidade"> 
			<label>Estado<em>*</em></label>
			<input type="text" name="estado" id="input-estado"> 
			<label>Complemento<em>*</em></label>
			<input type="text" name="complemento" id="input-complemento"> 
			<label>Bairro<em>*</em></label>
			<input type="text" name="bairro" id="input-bairro"> 
			<label>Rua<em>*</em></label>
			<input type="text" name="logradouro" id="input-logradouro"> 
			<label>Número<em>*</em></label>
			<input type="text" name="numero" id="input-numero"> 
			<label>Referência<em>*</em></label>
			<input type="text" name="referencia" id="input-referencia">
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
			<label>Descrição</label> 
			<input type="text" name="descricao" id="input-descricao">
			<label>Foto de Perfil</label> 
			<input type="file" name="logo-instituicao" id="input-logo">
		</div>
			<button type="button" id="botao-voltar">Voltar</button>
			<button type="button" id="botao-avancar">Avançar</button>
			<button type="submit" id="botao-cadastrar">Cadastrar-se</button>
	</form>
</body>

</html>