<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<nav>
		<ul>
			<li class="dropdown">
			<a href="#" class="dropbtn"></a>
				<div class="dropdown-content">
				<a href="<%=request.getContextPath()%>/novo">Sobre O EducaTech</a>
					<a href="<%=request.getContextPath()%>/consulta-principal"> Pesquisar cursos </a>
					 <a href="<%=request.getContextPath()%>/conheca-faculdades"> Conheça as faculdades </a>
					 <a href="<%=request.getContextPath()%>/cursos-favoritos">Favoritos </a>
					<a href="<%=request.getContextPath()%>/conta-aluno">Perfil</a>
					 <a href="<%=request.getContextPath()%>/login">Login | </a>
					 <a href="<%=request.getContextPath()%>/novo-aluno">Cadastrar-se</a>
				</div>
			</li>
		</ul>
	</nav>
</header>