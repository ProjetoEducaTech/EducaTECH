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
        <h1>Preencha os campos para filtrar os cursos</h1>
            <select name="modalidade">
                <option selected disabled value="">Modalidade</option>
            </select>
             <select name="turno">
                <option selected disabled value="">Turno</option>
            </select>
            <select name="area">
                <option selected disabled value="">Área</option>
            </select>
            <select name="preco">
                <option selected disabled value="">Preço</option>
            </select>
            <label for="nota">
                <input type="number" name="nota" placeholder="Nota">
            </label>
            <input type="submit" value="Buscar">

    <div class="resultados">
        <h2>Resultados da pesquisa</h2>
        <div class="card">
         	
        </div>
    </div>
 
</body>
</html>