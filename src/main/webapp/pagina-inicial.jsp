	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
		<style><%@include file="/assets/css/estilo.css"%></style>

	<title>Página Inicial | EducaTECH</title>
</head>

<body>

	<div class="cabecalho">
		<div class="menu">

			<div class="menu-logo">
				<a href="<%=request.getContextPath()%>/pagina-inicial"><img src="/assets/img/logo.png" alt="logo"></a>
			</div>

			<nav class="nav">
				<ul class="nav-lista">
					<li><a href="" class="nav-link">Sobre o EducaTECH</a></li>
					<li><a href="" class="nav-link">Pesquisar cursos</a></li>
					<li><a href="" class="nav-link">Conheça as faculdades</a></li>
					<li><a href="" class="nav-link">Favoritos</a></li>
				</ul>
			</nav>
		</div>
	 </div>
		<form class="form-cadastros" action="consulta-inicial" method="post">
			<h1 class="h1-pagina-principal">Preencha os campos para filtrar os cursos</h1>
			<div class="filtro">
				<label>Modalidade</label>
				<select class="input-campo" name="modalidade">
					<option selected value="4"></option>
					<option value="0">EAD</option>
					<option value="1">Presencial</option>
					<option value="2">Semi-Presencial</option>
					<option value="3">Ao Vivo</option>
				</select>
				<label>Turno</label>
				<select class="input-campo" name="turno">
					<option selected value="5"></option>
					<option value="0">Matutino</option>
					<option value="1">Vespertino</option>
					<option value="2">Noturno</option>
					<option value="3">Integral</option>
					<option value="4">Livre</option>
				</select> 
				
				<label>Área</label>
				<select class="input-campo" name="area">
					<c:forEach var="area" items="${areas}">
						<option value="<c:out value="${area.id}"/>">
						<c:out value="${area.nome}"/>
						</option>
					</c:forEach>
				</select>
				<label>Nota de Corte</label>
				<input class="input-campo" type="text" name="notaCorte">
				<button type="submit" id="botao-buscar">Buscar</button>
			</div>
		</form>
		
		<h2 class="h2-pagina-principal">Cursos de graduação mais bem avaliados</h2>
		<br>
		<div class="destaques">

					<c:forEach var="curso" items="${cursosAvaliados}">
						
				<div class="card-conteudo">
					<div>
						<div class="nome-curso">
							<a class="card-links" href="pagina-curso?id=<c:out value='${curso.id}'/>"><c:out value="${curso.nome}"/></a>
						</div>
						<div class="avaliacao">
							<div class="avaliacao-container">
							
								<input class="input-estrela" type="radio" name="rating" value="5" id="star-5"> 
								<label class="label-estrela" for="star-5">&#9733;</label>
								<input class="input-estrela" type="radio" name="rating" value="4" id="star-4"> 
								<label class="label-estrela" for="star-4">&#9733;</label>
								<input class="input-estrela" type="radio" name="rating" value="3" id="star-3"> 
								<label class="label-estrela" for="star-3">&#9733;</label>
								<input class="input-estrela" type="radio" name="rating" value="2" id="star-2"> 
								<label class="label-estrela" for="star-2">&#9733;</label>
								<input class="input-estrela" type="radio" name="rating" value="1" id="star-1"> 
								<label class="label-estrela" for="star-1">&#9733;</label>
								
							</div>
						</div>
						<div>
							<img class="imagem-card" src="data:image/<c:out value='${curso.instituicao.foto.extensao}'/>;base64,<c:out value='${curso.instituicao.foto}'/>" alt="logo-instituição">
						</div>
					</div>
				</div>
					</c:forEach>
		</div>
		<footer>
			<div class="rodape">
				<div>
					<ul>
						<li><a href="<%=request.getContextPath()%>/pagina-inicial">Página Inicial</a></li>
						<li><a href="<%=request.getContextPath()%>/pagina-inicial">Sobre o EducaTECH</a></li>
					</ul>
				</div>
				
				<div>
					<p>Contato</p>
					<p>projetoeducatech@gmail.com</p>
				</div>
			</div>
	
		<div id="rodape-fim">
			<img class="imagem-logo" src="/assets/img/logo.png" alt="">
			<h6>®2022, Todos os direitos reservados</h6>
		</div>
	</footer>

</body>

</html>
