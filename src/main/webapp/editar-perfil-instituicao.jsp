<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
   <head>
      <meta charset="UTF-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <style>
         <%@include file="/assets/css/estilo.css"%>
      </style>
      <title>Resultados da busca | EducaTECH</title>
   </head>
   <body>
      <form action="atualizar-instituicao" method="post">
         <div>
            <h1>Minha Conta</h1>
            <a href="#usuario"><img src="" alt="" /></a>
         </div>
         <label for="foto">Foto de Perfil</label> 
		 <input type="file" name="foto-perfil" id="foto">
         <label for="nome">Descricao<em>*</em></label> 
		 <input type="text" name="descricao" id="descricao" value="<c:out value='${instituicao.descricao}'/>">
         <label for="nome">CNPJ<em>*</em></label> 
		 <input type="text" name="cnpj" id="cnpj" value="<c:out value='${instituicao.cnpj}'/>">
         <label for="nome">Nome<em>*</em></label> 
		 <input type="text" name="nome" id="nome" value="<c:out value='${instituicao.nome}'/>">
         <label for="senha">Senha<em>*</em></label> 
		 <input type="text" name="senha" id="senha">
         <label for="input-email">E-mail</label>
         <input type="email" id="input-email" name="email" value="<c:out value='${contato.email}'/>" placeholder="Digite seu e-mail" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$" max="100" required />
         <label for="input-celular">Celular</label>
         <input type="tel" id="input-celular" name="celular" value="<c:out value='${contato.celular}'/>" placeholder="(xx) xxxxx-xxxx" min="15" max="15" pattern="\([0-9]{2}\)[\s][0-9]{5}-[0-9]{4}"/>
         <label for="input-telefone">Telefone</label>
         <input type="tel" id="input-telefone" name="telefone" value="<c:out value='${contato.telefone}'/>" placeholder="(xx) xxxx-xxxx" min="15" max="15" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4}" required />
         <div>
            <label id="label-cep">CEP</label>
            <input type="text" name="cep" id="input-cep" name="cep" value="<c:out value='${endereco.cep}'/>" />
            <label id="label-cidade">Cidade</label>
            <input type="text" name="cidade" id="input-cidade" name="cidade" value="<c:out value='${endereco.cidade}'/>" />
            <label id="label-estado">Estado</label>
            <input type="text" name="estado" id="input-estado" name="estado" value="<c:out value='${endereco.estado}'/>" />
            <label id="label-complemento">Complemento</label>
            <input type="text" name="complemento" id="input-complemento" name="complemento" value="<c:out value='${endereco.complemento}'/>" />
            <label id="label-bairro">Bairro</label>
            <input type="text" name="bairro" id="input-bairro" name="bairro" value="<c:out value='${endereco.bairro}'/>" />
            <label id="label-logradouro">logradouro</label>
            <input type="text" name="logradouro" id="input-logradouro" name="logradouro" value="<c:out value='${endereco.logradouro}'/>" />
            <label id="label-numero">Número</label>
            <input type="text" name="numero" id="input-numero" name="numero" value="<c:out value='${endereco.numero}'/>" />
            <label id="label-referencias">Referência</label>
            <input type="text" name="referencia" id="input-referencia" name="referencia" value="<c:out value='${endereco.referencia}'/>" />
         </div>
         <button type="reset">Cancelar</button>
         <button type="submit">Salvar alterações</button>
      </form>
   </body>
</html>
