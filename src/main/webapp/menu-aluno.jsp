<header>
	<nav>
		<ul class="menu">
			<li class="dropdown">
				<a href="<%=request.getContextPath()%>/sobre">Sobre O EducaTech</a> 
			</li>
			<li class="dropdown">
				<a href="<%=request.getContextPath()%>/consulta-principal">Pesquisar Cursos</a>
			</li>
			<li class="dropdown">
				<a href="<%=request.getContextPath()%>/conheca-faculdades">Conhe�a as Faculdades</a>
			</li>
			<li class="dropdown">
				<a href="<%=request.getContextPath()%>/cursos-favoritos">Cursos Favoritos</a>
			</li>
			<c:if test="${usuario == null}">
				<li>
					<a href="<%=request.getContextPath()%>/login">Login</a>
					<span>|<span>
					<a href="<%=request.getContextPath()%>/novo-aluno">Cadastrar-se</a>
				</li>
			</c:if>
			<c:if test="${usuario != null}">
				<li class="dropdown">
					<a href="#" class="dropbtn">
						<img src="data:image/<c:out value='${usuario.extensao}'/>;base64,<c:out value='${usuario.foto}'/>" class="avatar" height="25" width="25">
					</a>
						<div class="dropdown-content">
							<a href="<%=request.getContextPath()%>/conta-aluno">Minha Conta</a>
			 				<a href="<%=request.getContextPath()%>/sair">Sair</a>
						</div>
				</li>		
			</c:if>
		</ul>
	</nav>
</header>