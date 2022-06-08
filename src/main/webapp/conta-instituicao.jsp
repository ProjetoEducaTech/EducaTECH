<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt-BR">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Minha Conta | Portal da Instituiçã</title>
</head>

<body>
	<header>
		<h1>Minha Conta</h1>
		<h4>Dados Pessoais</h4>
		<h4>Endereço</h4>
		<button>Alterar dados</button>
	</header>

	<div>
		<img alt="Foto de Perfil"> <label>Nome</label>
		<c:out value='${instituicao.nome}' />
		<button>Alterar imagem</button>
	</div>

	<div class="aba">
		<form action="editarInstituicao" method="post">
			<label id="cnpj">CNPJ</label> <input type="text"
				value="<c:out value='${instituicao.cnpj}' />" id="cnpj"> <label>Celular</label>
			<input type="tel" value="<c:out value='${contato.celualar}' />"
				id="celular"> <label>E-mail corporativo</label> <input
				type="email" value="<c:out value='${contato.email} '/>"
				id="email-corporate"> <label>Telefone</label> <input
				type="tel" value="<c:out value='${contato.telefone}' />"
				id="telefone">
			<button type="button">Cancelar</button>
			<button type="submit">Salvar alterações</button>
		</form>
	</div>

	<div class="aba">
		<form action="editarInstituicao" method="post">
			<label>CEP</label> <input type="text"
				value="<c:out value='${endereco.cep}' />" id="cep"> <label>Cidade</label>
			<input type="text" value="<c:out value='${endereco.cidade}' />"
				id="cidade"> <label>Estado</label> <input type="text"
				value="<c:out value='${endereco.estado}' />" id="estado"> <label>Complemento</label>
			<input type="text" value="<c:out value='${endereco.complemento}' />"
				id="complemento"> <label>Bairro</label> <input type="text"
				value="<c:out value='${endereco.bairro}' />" id="bairro"> <label>Rua</label>
			<input type="text" value="<c:out value='${endereco.logradouro}' />"
				id="rua"> <label>Número</label> <input type="text"
				value="<c:out value='${endereco.numero}' />" id="numero"> <label>Referência</label>
			<input type="text" value="<c:out value='${endereco.referencia}' />"
				id="referencia">
		</form>
		<button type="button">Cancelar</button>
		<button type="submit">Salvar alterações</button>
	</div>
</body>
</html>