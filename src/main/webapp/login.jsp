<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login instituição | Educatech</title>
    <link rel="icon" href="assets/img/logo.png" sizes="32x32"/>
	<style><%@include file="/assets/css/estilo.css"%></style>
    <script><%@include file="/assets/js/mascaras.js"%></script>
</head>
<body>
    <form action="#" method="post">
        <h1>Seja bem-vindo</h1>
        <fieldset>
            <div class="container">
                <label for="cnpj">CNPJ<em>*</em></label>
                <input type="number" id="cnpj" placeholder="Digite seu CNPJ" title="CNPJ" required>
            </div>
        </fieldset>
        <fieldset>
            <div class="container">
                <label for="senha">Senha<em>*</em></label>
                <input type="password" id="senha" placeholder="Digite sua senha" pattern="{8,}"
                    title="Oito ou mais digitos" required>
            </div>
        </fieldset>
        <fieldset>
            <div class="container">
                <span>
                    <a id="novaSenha" href="?">Esqueceu a senha?</a>
                </span>
            </div>
        </fieldset>
        <fieldset>
            <div class="botao">
                <input type="submit" value="Cadastre-se">
            </div>
        </fieldset>
        <fieldset>
            <div class="container">
                <p class="possuiConta">
                    Não possui uma conta? <a href="cadastro-instituicao.html">Cadastre-se aqui</a>
                </p>
            </div>
        </fieldset>
    </form>
</body>
</html>