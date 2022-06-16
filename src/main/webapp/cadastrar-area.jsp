<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <style><%@include file="/assets/css/estilo.css"%></style>
      <title>Cadastrar Área | Portal da Instituição</title>
   </head>
   <body>
      <%@include file="/menu-instituicao.jsp"%>
      <form action="inserir-area" method="post">
         <label for="nome">Área</label> 
         <input type="text" name="area" id="nome">
         <button type="reset">Cancelar</button>
         <button type="submit">Cadastrar</button>
      </form>
   </body>
</html>