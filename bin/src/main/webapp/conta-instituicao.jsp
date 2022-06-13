<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Conta Instituição | EducaTECH</title>
  
</head>
<body>

  
    <form class="form-register" action="editarInstituicao" method="post">

        <h1 class="intro"> Instituição </h1>
    
        <div>
          <label>Nome<em>*</em></label>
          <input type="text" value="<c:out value='${instituicao.nome}' />" id="primary-name">
          <label id="cnpj">CNPJ<em>*</em></label>
          <input type="text" value="<c:out value='${instituicao.cnpj}' />" id="cnpj">  
        </div>
    
        <div>
          <label>Celular<em>*</em></label>
          <input type="tel" value="<c:out value='${contato.celualar}' />" id="cellphone">
          <label>Telefone</label>
          <input type="tel" value="<c:out value='${contato.telefone}' />" id="telephone">
          <label>E-mail corporativo<em>*</em></label>
          <input type="email" value="<c:out value='${contato.email} '/>" id="email-corporate">
        </div>
    
        <div>
          <label>CEP<em>*</em></label>
          <input type="text" value="<c:out value='${endereco.cep}' />" id="cep">
          <label>Cidade<em>*</em></label>
          <input type="text" value="<c:out value='${endereco.cidade}' />" id="city">
          <label>Estado<em>*</em></label>
          <input type="text" value="<c:out value='${endereco.estado}' />" id="state">
          <label>Complemento<em>*</em></label>
          <input type="text" value="<c:out value='${endereco.complemento}' />" id="complement">
          <label>Bairro<em>*</em></label>
          <input type="text" value="<c:out value='${endereco.bairro}' />" id="neighborhood">
          <label>Rua<em>*</em></label>
          <input type="text" value="<c:out value='${endereco.logradouro}' />" id="street">
          <label>Número<em>*</em></label>
          <input type="text" value="<c:out value='${endereco.numero}' />" id="number-house">
          <label>Referência<em>*</em></label>
          <input type="text" value="<c:out value='${endereco.referencia}' />" id="references">
        </div>
    
        <div>
          <label>Senha<em>*</em></label>
          <input type="text" value="<c:out value='${usuario.senha}' />" id="password">
          <label>Repita a senha<em>*</em></label>
          <input type="text" value="<c:out value='${usuario.senha}' />" id="repeat-password">
        </div>
    
        <div>
          <label>Descrição</label>
          <input type="text" value="<c:out value='${instituicao.descricao}' />" id="description">
         </div>
        <div>
          <button>Alterar Dados</button>
        </div>
      
      </form>
    
  </body>
</html>