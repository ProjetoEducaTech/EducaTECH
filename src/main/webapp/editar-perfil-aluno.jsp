<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style><%@include file="/assets/css/estilo.css"%></style>
    <title>Editar Perfil| Portal do Aluno</title>
</head>

<body>
	<form class="form-editar-perfil" action="/editar-aluno" method="post">
	<div>
	    <h1>Minha Conta</h1>
		<a href="#usuario"><img src="" alt=""></a>
    </div>
	<div>
		<label>Gênero</label>
	        <select name="genero" id="select-genero">
	          <option value="0">Masculino</option>
	          <option value="1">Feminino</option>
	          <option value="2">Outro</option>
	        </select>
		<label for="pronome">Pronome</label>
		      <select name="pronome" id="select-pronome">
		        <option value="0">Ele/Dele</option>
		        <option value="1">Ela/Dela</option>
		        <option value="2">Elu/Delu</option>
		      </select>
	</div>
		<label for="email">E-mail</label>
			<input type="email" id="input-mail" value="<c:out value='${contato.email}'/>" placeholder="Digite seu e-mail" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$" maxlength="100" required>
      	<label for="celular">Celular</label>
			<input type="tel" id="input-celular" placeholder="(xx) xxxxx-xxxx" value="<c:out value='${contato.celular}'/>" minlength="11" maxlength="11" pattern="\([0-9]{2}\)[\s][0-9]{5}-[0-9]{4}" required>
		<label for="telefone">Telefone</label>
			<input type="tel" id="input-telefone" placeholder="(xx) xxxx-xxxx" value="<c:out value='${contato.telefone}' />" minlength="10" maxlength="10" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4}" required>
      	<label for="input-biografia">Biografia</label>
			<input type="text" id="input-biografia"  value="<c:out value='${aluno.biografia}' />" placeholder="Digite sua Biografia">
      	<label for="alterar-foto">Alterar Foto</label>
      		<input type="file" id="input-foto" value="<c:out value='${usuario.foto}' />" placeholder="Altere sua Foto*" >
      		
	    <input type="button"value="Cancelar" id="botao-cancelar">
	    <input type="submit" value="Salvar alteraçoes" id="botao-salvar">
	</form>
</body>

</html>