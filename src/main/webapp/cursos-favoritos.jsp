<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Portal do Estudante | Cursos favoritos</title>
        <style><%@include file="/assets/css/estilo.css"%></style>
    	<script><%@include file="/assets/js/mascaras.js"%></script>
    </head>
    <body>
        <nav>
            <div class="barranav"> <!--barra de navegação*-->
                <a href="index.html">Principal</a> <!--link 1*-->
                <a href="sobre.html">Sobre o EducaTECH</a> <!--link 2-->
                <div class="dropdown"> <!--botão que desce-->
                  <button class="dropbtn">Dropdown</button>
                  <div class="dropdown-content">
                    <a href="#">Link 1</a>
                    <a href="#">Link 2</a>
                    <a href="#">Link 3</a>
                  </div>
                </div>
              </div>
        </nav>
    </body>
    <footer>
    </footer>
</html>