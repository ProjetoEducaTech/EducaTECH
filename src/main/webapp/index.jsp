<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>EducaTECH | Página Inicial</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css"
		integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw=="
		crossorigin="anonymous" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
		integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="icon" href="assets/img/logo.png" sizes="32x32" />
	<style><%@include file="/assets/css/estilo.css"%></style>
    <script><%@include file="/assets/js/mascaras.js"%></script>
</head>
<body>
	<header>
		<div class="menu-bg">
			<div class="menu">
				<div class="menu-logo">
					<a href="index.html"><img src="img/logo.png" alt="logo"></a>
				</div> <!-- menu_logo -->
				<nav class="nav">
					<ul class="nav-list">
						<li><a href="#somos" class="nav-link">Sobre o EducaTECH</a></li>
					</ul> <!-- nav_list -->
				</nav> <!-- nav -->
			</div> <!-- menu -->
		</div> <!-- menu- bg -->
		<h1 class="intro">Preencha os campos para filtrar os cursos</h1>
		<div class="container-field">
			<select class="optn" name="modalidade">
				<option selected disabled value="">Modalidade</option>
			</select> <!-- optn -->
			<select class="optn" name="turno">
				<!--select de instituições-->>
				<option selected disabled value="">Turno</option>
			</select> <!-- optn -->
			<select class="optn" name="area">
				<option selected disabled value="">Área</option>
			</select> <!-- optn -->
			<select class="optn" name="preco">
				<option selected disabled value="">Preço</option>
			</select> <!-- optn -->
			<label for="nota">
				<input class="optn" type="number" name="nota" placeholder="Nota">
			</label> <!-- optn -->
			<input class="btn-buscar" type="submit" value="Buscar">
		</div> <!-- container-field -->
	</header>
	<div class="wave-shape">
		<svg id="curve" data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1416.99 174.01">
			<path class="cls-1" d="M0,280.8S283.66,59,608.94,163.56s437.93,150.57,808,10.34V309.54H0V280.8Z"
				transform="translate(0-135.53)" />
		</svg>
	</div>
	<footer class="footer">
		<p class="logo">EducaTECH</p>
		<div class="social-media">
			<a href="#"><i class="fab fa-github"></i></a>
			<a href="#"><i class="fab fa-linkedin"></i></a>
			<a href="#"><i class="fab fa-instagram"></i></a>
		</div> <!-- social-media -->
		<p class="footer-copyright">@2022, Todos os direitos reservados.</p>
	</footer> <!-- footer -->
</body>
</html>