<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Resultados da busca | EducaTECH</title>
 </head>

<body>
	<h1>Minha Conta Instituição</h1>
	<label for="email">E-mail</label>
      <input type="email" id="email" placeholder="Digite seu e-mail" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$" maxlength="100" required>
	<label for="cellphone">Celular</label>
      <input type="tel" placeholder="(xx) xxxxx-xxxx" minlength="11" maxlength="11"
        pattern="\([0-9]{2}\)[\s][0-9]{5}-[0-9]{4}" required>
      <label for="telephone">Telefone<em>*</em></label>
      <input type="tell" id="telephone" placeholder="(xx) xxxx-xxxx" minlength="10" maxlength="10"
        pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4}" required>
    </div>
    <div>
      <label id="cep">CEP<em>*</em></label>
      <input type="text">
      <label id="city">Cidade<em>*</em></label>
      <input type="text">
      <label id="state">Estado<em>*</em></label>
      <input type="text">
      <label id="complement">Complemento<em>*</em></label>
      <input type="text">
      <label id="neighborhood">Bairro<em>*</em></label>
      <input type="text">
      <label id="street">Rua<em>*</em></label>
      <input type="text">
      <label id="number-house">Número<em>*</em></label>
      <input type="text">
      <label id="references">Referência<em>*</em></label>
      <input type="text">
    </div>

    <div>
      <label id="description">Descrição</label>
      <input type="text">
    </div>
    <input class="button-save" type="submit" value="Salvar alteraçoes">
  </div>


</body>

</html>