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
	
	<h1>Bem-Vindo!</h1>
	
	<form action="inserir-instituicao" method="post" id="formulario">
			
		<div class="aba">
			<h2>Passo 1 - Informações Básicas</h2>
			<label for="nome">Nome<em>*</em></label> 
			<input type="text" name="nome" id="nome">
			<label for="cnpj">CNPJ<em>*</em></label> 
			<input type="text" name="cnpj" id="cnpj">
		</div>
		
		<div class="aba">
			<h2>Passo 2 - Informações de Contato</h2>
			<label for="celular">Celular<em>*</em></label> 
			<input type="tel" name="celular" id="celular">
			<label for="telefone">Telefone</label> 
			<input type="tel" name="telefone" id="telefone"> 
			<label for="email">E-mail Corporativo<em>*</em></label> 
			<input type="email" name="email" id="email">
		</div>
		
		<div class="aba">
			<h2>Passo 3 - Endereço</h2>
			<label for="cep">CEP<em>*</em></label>
			<input type="text" name="cep" id="cep"> 
			<label for="cidade">Cidade<em>*</em></label>
			<input type="text" name="cidade" id="cidade"> 
			<label for="estado">Estado<em>*</em></label>
			<input type="text" name="estado" id="estado"> 
			<label for="complemento">Complemento<em>*</em></label>
			<input type="text" name="complemento" id="complemento"> 
			<label for="bairro">Bairro<em>*</em></label>
			<input type="text" name="bairro" id="bairro"> 
			<label for="logradouro">Rua<em>*</em></label>
			<input type="text" name="logradouro" id="logradouro"> 
			<label for="numero">Número<em>*</em></label>
			<input type="text" name="numero" id="numero"> 
			<label for="referencia">Referência<em>*</em></label>
			<input type="text" name="referencia" id="referencia">
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
			<label for="descricao">Descrição</label> 
			<input type="text" name="descricao" id="descricao">
			<label for="logo">Logo da Instituição</label> 
			<input type="file" name="logo-instituicao" id="logo">
		</div>
	
		<div>
			<button type="button" id="botao-voltar" onclick="navegarAba(-1)">Voltar</button>
            <button type="button" id="botao-proximo" onclick="navegarAba(1)">Avançar</button>
		</div>
		
		<div>
			<p>Já possui cadastro? <a href="<%=request.getContextPath()%>/login">Fazer login</a></p>
			<p>Não é uma instituição? <a href="<%=request.getContextPath()%>/novo-aluno">Cadastrar-se como Aluno</a></p>
		</div>
		
	</form>
	
	<script><%@include file="/assets/js/navegar-abas.js"%></script>
	
</body>

</html>