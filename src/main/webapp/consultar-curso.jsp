<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<body>

	<h1 class="intro"> Selecione as suas preferências para encontrar o curso perfeito!</h1>

	<form action="consultar-curso" method="post">

		<div class="container-field">

			<label>Modalidade<em>*</em></label> <select name="modalidade">
				<option value="0">EAD</option>
				<option value="1">Presencial</option>
				<option value="2">Semi-Presencial</option>
				<option value="3">Ao Vivo</option>
			</select> 
			
			<label>Nota de Corte<em>*</em></label> 
			<input type="text" name="notaCorte"> 
			
			<label>Turno<em>*</em></label> 	
			<select name="turno">
				<option value="0">Matutino</option>
				<option value="1">Vespertino</option>
				<option value="2">Noturno</option>
				<option value="3">Integral</option>
				<option value="4">Livre</option>
			</select> 
			
			<label>Preço</label> 
			<input type="range" min="${precoMinimo}" max="${precoMaximo}" value="${precoMinimo}" name="preco"> 
				
			<label>Duracao<em>*</em></label>
			<input type="text" name="duracao"> 
			
			<label>Área<em>*</em></label>
			<select name="area">
				<c:forEach var="area" items="${areas}">
					<option value="<c:out value="${area.id}"/>"><c:out
							value="${area.nome}" /></option>
				</c:forEach>

			</select> 
			
			 <label>Instituições<em>*</em></label> <select name="instituicao">

				<c:forEach var="instituicao" items="${instituicoes}">
					<option value="<c:out value="${instituicao.id}"/>">
						<c:out value="${instituicao.nome}" />
					</option>
				</c:forEach>

			</select> 
			
			<input class="btn-buscar" type="submit" value="Buscar">

		</div>
		
	</form>
	<div>
		<section class="search-result">
			<h2>Resultados da pesquisa</h2>
			<c:forEach var="curso" items="${cursos}">
				<div class="container-card">
					<div class="card">
						<div class="content-card">
							<div class="ctn-card">
								<img class="img-card" src="" alt="">
							</div>
							<div>
								<i class="material-icons">info</i>
							</div>
						</div>
						<div class="card-info">
							<div>
								<a href="${curso.link}" class="card-link">${curso.nome}</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</section>
	</div>

</body>

</html>
