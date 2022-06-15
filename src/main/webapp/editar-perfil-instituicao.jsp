<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/assets/css/estilo.css"%></style>
	<title>Resultados da busca | EducaTECH</title>
</head>

<body>
	<h1>Minha Conta Instituição</h1>
	<label for="input-email">E-mail</label>
		<input type="email" id="input-email" placeholder="Digite seu e-mail" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$" max="100" required>
	<label for="input-celular">Celular</label>
		<input type="tel" id="input-celular" placeholder="(xx) xxxxx-xxxx" min="11" max="11" pattern="\([0-9]{2}\)[\s][0-9]{5}-[0-9]{4}" required>
	<label for="input-telefone">Telefone</label>
		<input type="tel" id="input-telefone" placeholder="(xx) xxxx-xxxx" min="14" max="14" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4}" required>
    <div>
	<label id="label-cep">CEP</label>
		<input type="text" name="cep" id="input-cep">
	<label id="label-cidade">Cidade</label>
		<input type="text" name="cidade" id="input-cidade">
	<label id="label-estado">Estado</label>
		<input type="text" name="estado" id="input-estado">
	<label id="label-complemento">Complemento</label>
		<input type="text" name="complemento" id="input-complemento">
	<label id="label-bairro">Bairro</label>
		<input type="text" name="bairro" id="input-bairro">
	<label id="label-rua">Rua</label>
		<input type="text" name="rua" id="input-rua">
	<label id="label-numero">Número</label>
		<input type="text" name="numero" id="input-numero">
      <label id="label-referencias">Referência</label>
		<input type="text" name="referencia" id="input-referencia">
	</div>
    <div>
		<label id="label-descricao">Descrição</label>
			<input type="text" name="descricao" id="input-descricao">
	</div>
	<button type="reset">Cancelar</button>
	<button type="submit">Salvar alterações</button>
</body>

</html>