<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de curso | Educatech</title>
    <link rel="icon" href="assets/img/logo.png" sizes="32x32"/>
	<style><%@include file="/assets/css/estilo.css"%></style>
    <script><%@include file="/assets/js/mascaras.js"%></script>
</head>

<body>
	
    <form action="#" method="post">
        <h1>Cadastrar curso</h1>
        <fieldset>
            <div class="container">
                <label for="nome">Nome do curso<em>*</em></label>
                <input type="text" id="nome" placeholder="Digite o nome do curso">
            </div>
        </fieldset>
        <fieldset>
            <div class="container">
                <label>Tipo de ingresso<em>*</em></label>
                <select name="ingresso">
                    <option selected disabled value="">Selecione uma opção</option>
                </select>
            </div>
            <div class="container">
                <label>Modalidade<em>*</em></label>
                <select name="modalidade">
                    <option selected disabled value="">Selecione uma opção</option>
                </select>
            </div>
            <div class="container">
                <label>Turno<em>*</em></label>
                <select name="turno">
                    <option selected disabled value="">Selecione uma opção</option>
                </select>
            </div>
        </fieldset>
        <fieldset>
            <div class="container">
                <label>Duração do curso<em>*</em></label>
                <select name="duracao">
                    <option selected disabled value="">Selecione uma opção</option>
                </select>
            </div>
            <div class="container">
                <label>Área<em>*</em></label>
                <select name="area">
                    <option selected disabled value="">Selecione uma opção</option>
                </select>
            </div>
            <div class="container">
                <label for="nome">Preço do curso<em>*</em></label>
                <input type="text" id="preco" placeholder="Digite o preço">
            </div>
        </fieldset>
        <fieldset>
            <div class="container">
                <label for="link"><strong>Link</strong></label>
                <textarea rows="1"></textarea>
            </div>
        </fieldset>
        <fieldset>
            <div class="container">
                <label for="descricao"><strong>Descrição</strong></label>
                <textarea rows="5" id="descricao" name="descricao"></textarea>
            </div>
        </fieldset>

        <fieldset>
            <div class="botao">
                <input type="submit" value="Cadastrar curso">
            </div>
        </fieldset>
    </form>
</body>

</html>