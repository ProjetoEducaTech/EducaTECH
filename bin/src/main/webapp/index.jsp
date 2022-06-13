<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EducaTECH | Página Inicial</title>
<script type="text/javascript"
	src="https://gc.kis.v2.scr.kaspersky-labs.com/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js?attr=ESerl7938NuUsZS3e2cYi_cB25S6iH38zzx21pSbemuafp7CUXvyAeDWZB2p48qrZdj4h8-dbsENbUoWY2gdCYsCV-f_V6kDGjSATKpYEs-JtesRILk1pNRbwM8J95eJrICnTGmqc_GvAk5--THZmMfGikbA8eEIPvGqMgskrGoZlSTOLhZtusX8QhkLJDSAb3QRmPXVrJYdbRyK7JPEdo2N8Hfwz9bUoD4b5_QqMmFNRoIJSCqOxzjdCZ0NEpT6RPVx49eLLmC8Hl64GO-xNR3xYTByNl6EplufkMnSYi-dWzZloNmQkgFYMnVLVe2GyR3n4DBOks85ga7oln7Y4pb4JtHtVtUPFL2Shouk9EE"
	charset="UTF-8"></script>
</head>

<body>
	<header>

		<form class="form-culsulta-inicial" action="/consulta-incial"
			method="post">

			<h1 class="intro">Selecione as suas preferências para encontrar
				o curso perfeito!</h1>

			<div class="container-field">
				<select class="optn" name="modalidade">
					<option selected disabled value="">Modalidade</option>
					<option selected value="0">EAD</option>
					<option selected value="1">Presencial</option>
					<option selected value="2">Semi Presencial</option>
					<option selected value="3">AO Vivo</option>
				</select> <select class="optn" name="turno">

					<option selected disabled value="">Turno</option>
					<option selected value="0">Matutino</option>
					<option selected value="1">Vespertino</option>
					<option selected value="2">Noturno</option>
					<option selected value="3">Integral</option>
					<option selected value="4">Livre</option>
				</select> <select class="optn" name="area">
					<option selected disabled value="">Área</option>
				</select> <select class="optn" name="preco">
					<option selected disabled value="">Preço</option>
				</select> <input class="btn-buscar" type="submit" value="Buscar">
			</div>
		</form>

		<div>
			Cursos de graduação mais bem avaliados
			<div>
				<table id="tabela-curso">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Duracao</th>
							<th>Turno</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="curso" items="${cursosAvaliados}">
							<tr>
								<td><c:out value="${curso.nome}" /></td>
								<td><c:out value="${curso.duracao}" /></td>
								<td><c:out value="${curso.Turno}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</header>
</body>

</html>