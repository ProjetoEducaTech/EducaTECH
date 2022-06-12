<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Página Curso | Educatech</title>
    </head>

    <body>
        <h1><c:out value='${curso.nome}'/></h1>

        <h2>Descrição do Curso</h2>

        <p><c:out value='${curso.descricao}'/></p>

	<div>
		<h2>É estudante do curso? Que tal deixar uma avaliação para outros alunos?</h2>
		<div>
		
		
		<form action="inserir-avaliacao" method="post">	
       	 	<label>Comentario<em>*</em></label>
        	<input type="text" name="comentario" id="comentario">
       		<label>Nota<em>*</em></label>
      		<input type="text" name="nota" id="nota">
      		
      		<div>
        		<button type="submit">Submeter avaliação</button>
        	</div>
        </form>
        </div>
	</div>
	
	<div>
        <h2>Avaliações</h2>
        <div>
        	<c:forEach var="avaliacao" items="${curso.avaliacoes}">
        		<p><c:out value='${avaliacao.nota}'/></p>
        		<p><c:out value='${avaliacao.comentario}'/></p>
        		<p></p>
        	
      		<form  action="atualizar-avaliacao" method="post">
        		
        		<label>Comentario anterior:<c:out value='${avaliacao.nota}'/></label>
        		<input type="text" name="comentario" id="comentario">
        		<label>Nota: <c:out value='${avaliacao.comentario}'/></label>
      			<input type="text" name="nota" id="nota">
      			
      		<div>
        		<button type="submit">atualizar avaliação</button>
        	</div>

      		</form>
      		
      		<form  action="deletar-avaliacao" method="post">
      		<div>
        		<button type="submit">deletar avaliação</button>
        	</div>
      		</form>
        	
        	
        	
        	</c:forEach>
        </div>	
    </div>
    
     <div class="content-card">
			<form action="favoritar-curso" method="post">
				<input type="hidden" name="id" value='${curso.id}'/>
				<button>Favoritar Curso</button>
			</form>
	</div>
	
    </body>
</html>