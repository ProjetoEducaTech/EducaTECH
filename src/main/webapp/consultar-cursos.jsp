<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultados da busca | EducaTECH</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
        integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
            </select>
            <select class="optn" name="turno">
                <!--select de instituições-->>
                <option selected disabled value="">Turno</option>
            </select>
            <select class="optn" name="area">
                <option selected disabled value="">Área</option>
            </select>
            <select class="optn" name="preco">
                <option selected disabled value="">Preço</option>
            </select>
            <label for="nota">
                <input class="optn" type="number" name="nota" placeholder="Nota">
            </label>
            <input class="btn-buscar" type="submit" value="Buscar">
        </div> <!-- container-field -->
    </header>

    <section class="search-result">
        <h2>Resultados da pesquisa</h2>
        <div class="container-card">
            <div class="card">
                <div class="content-card">
                    <div class="ctn-card">
                        <img class="img-card" src="assets/img/unopar-logo.png" alt="">
                    </div>
                    <div>
                        <a href="#"><i class="material-icons">info</i></a>
                    </div>
                </div> <!-- content-card -->
                <div class="card-info">
                    <div>
                        <a href="#" class="card-link">Análise e Desenvolvimento de Sistemas</a>
                    </div>
                </div>
            </div> <!-- card -->

            <div class="card">
                <div class="content-card">
                    <div class="ctn-card">
                        <img class="img-card" src="assets/img/unopar-logo.png" alt="">
                    </div>
                    <div>
                        <a href="#"><i class="material-icons">info</i></a>
                    </div>
                </div> <!-- content-card -->
                <div class="card-info">
                    <div>
                        <a href="#" class="card-link">Análise e Desenvolvimento de Sistemas</a>
                    </div>
                </div>
            </div> <!-- card -->

            <div class="card">
                <div class="content-card">
                    <div class="ctn-card">
                        <img class="img-card" src="assets/img/unopar-logo.png" alt="">
                    </div>
                    <div>
                        <a href="#"><i class="material-icons">info</i></a>
                    </div>
                </div> <!-- content-card -->
                <div class="card-info">
                    <div>
                        <a href="#" class="card-link">Análise e Desenvolvimento de Sistemas</a>
                    </div>
                </div>
            </div> <!-- card -->

            <div class="card">
                <div class="content-card">
                    <div class="ctn-card">
                        <img class="img-card" src="assets/img/unopar-logo.png" alt="">
                    </div>
                    <div>
                        <a href="#"><i class="material-icons">info</i></a>
                    </div>
                </div> <!-- content-card -->
                <div class="card-info">
                    <div>
                        <a href="#" class="card-link">Análise e Desenvolvimento de Sistemas</a>
                    </div>
                </div>
            </div> <!-- card -->

            <div class="card">
                <div class="content-card">
                    <div class="ctn-card">
                        <img class="img-card" src="assets/img/unopar-logo.png" alt="">
                    </div>
                    <div>
                        <a href="#"><i class="material-icons">info</i></a>
                    </div>
                </div> <!-- content-card -->
                <div class="card-info">
                    <div>
                        <a href="#" class="card-link">Análise e Desenvolvimento de Sistemas</a>
                    </div>
                </div>
            </div> <!-- card -->

            <div class="card">
                <div class="content-card">
                    <div class="ctn-card">
                        <img class="img-card" src="assets/img/unopar-logo.png" alt="">
                    </div>
                    <div>
                        <a href="#"><i class="material-icons">info</i></a>
                    </div>
                </div> <!-- content-card -->
                <div class="card-info">
                    <div>
                        <a href="#" class="card-link">Análise e Desenvolvimento de Sistemas</a>
                    </div>
                </div>
            </div> <!-- card -->

        </div> <!-- cards -->
    </section> <!-- search-result -->

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