<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Resultados da busca | EducaTECH</title>
</head>

<body>

  <form action="inserir-instituicao" method="post">

    <h1>Bem-Vindo!</h1>

    <div>
      <h2>Passo 1 - Informações Básicas</h2>
      <label>Nome<em>*</em></label>
      <input type="text" name="nome">
      <label>CNPJ<em>*</em></label>
      <input type="text" name="cnpj">
    </div>

    <div>
      <h2>Passo 2 - informações de Contato</h2>
      <label>Celular<em>*</em></label>
      <input type="tel" name="celular">
      <label>Telefone</label>
      <input type="tel" name="telefone">
      <label>E-mail Corporativo<em>*</em></label>
      <input type="email" name="email">
    </div>

    <div>
      <h2>Passo 3 - Endereço</h2>
      <label>CEP<em>*</em></label>
      <input type="text" name="cep">
      <label>Cidade<em>*</em></label>
      <input type="text" name="cidade">
      <label>Estado<em>*</em></label>
      <input type="text" name="estado">
      <label>Complemento<em>*</em></label>
      <input type="text" name="complemento">
      <label>Bairro<em>*</em></label>
      <input type="text" name="bairro">
      <label>Rua<em>*</em></label>
      <input type="text" name="logradouro">
      <label>Número<em>*</em></label>
      <input type="text" name="numero">
      <label>Referência<em>*</em></label>
      <input type="text" name="referencia">
    </div>

    <div>
      <h2>Passo 4 - Senha</h2>
      <label>Senha<em>*</em></label>
      <input type="text" name="senha">
      <label>Repita a Senha<em>*</em></label>
      <input type="text" name="repita-senha">
    </div>

    <div>
      <h2>Passo 5 - Informações Adicionais</h2>
      <label>Descrição</label>
      <input type="text" name="descricao">
     <label>Foto de Perfil</label>
      <input type="file" name="logo-instituicao">
    </div>

     <div>
      <button type="button">Anterior</button>
      <button type="button">Próximo</button>
      <button type="submit">Cadastrar</button>
    </div>  

	</form>

</body>

</html>