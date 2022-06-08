<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastro | Portal do Estudante</title>
</head>
<body>

	<form action="inserir-aluno" method="post">
		<div class="aba">
			<h1>Bem-Vindo!</h1>
			<h2>Passo 1 - Informações Básicas</h2>
			<label>Data de nascimento<em>*</em></label> <input type="date"
				name="data-nascimento"> <label>Nome<em>*</em></label> <input
				type="text" name="nome"> <label>Sobrenome<em>*</em></label>
			<input type="text" name="sobrenome">
		</div>

		<div class="aba">
			<h2>Passo 2 - Informações de Contato</h2>
			<label>Celular<em>*</em></label> <input type="tel" name="celular">
			<label>Telefone</label> <input type="tel" name="telefone"> <label>E-mail<em>*</em></label>
			<input type="email" name="email">
		</div>

		<div class="aba">
			<h2>Passo 3 - Informações Pessoais</h2>
			<label>Gênero<em>*</em></label> <select name="genero">
				<option value="0">Masculino</option>
				<option value="1">Feminino</option>
				<option value="2">Outros</option>
			</select> <label>Pronomes<em>*</em></label> <select name="pronome">
				<option value="0">Ele/Dele</option>
				<option value="1">Ela/Dela</option>
				<option value="2">Elu/Delu</option>
			</select> <label>CPF<em>*</em></label> <input type="text" name="cpf">
		</div>

		<div class="aba">
			<h2>Passo 4 - Senha</h2>
			<label>Senha<em>*</em></label> <input type="text" name="senha">
			<label>Repita a Senha<em>*</em></label> <input type="text"
				name="repita-senha">
		</div>

		<div class="aba">
			<h2>Passo 5 - Informações Adicionais</h2>
			<label>Biografia</label> <input type="text" name="biografia">
			<label>Foto de Perfil</label> <input type="file" name="foto-perfil">
		</div>

		<div class="botoes">
			<button type="button">Voltar</button>
			<button type="button">Avançar</button>
			<button type="submit">Cadastrar-se</button>
		</div>
	</form>

</body>

</html>