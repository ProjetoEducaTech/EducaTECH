<header>
	<nav>
		<ul class="menu">
			<li class="dropdown">
				<a href="<%=request.getContextPath()%>/sobre">Sobre O EducaTech</a> 
			</li>
			<li class="dropdown">
				<a href="<%=request.getContextPath()%>/meus-cursos">Meus Cursos</a>
			</li>
			<li class="dropdown">
				<a href="<%=request.getContextPath()%>/minhas-areas">Minhas Áreas</a>			
			</li>
			<c:if test="${usuario == null}">
				<li>
					<a href="<%=request.getContextPath()%>/login">Login</a>
					<span>|<span>
					<a href="<%=request.getContextPath()%>/nova-instituicao">Cadastrar-se</a>
				</li>
			</c:if>
			<c:if test="${usuario != null}">
				<li class="dropdown">
					<a href="#" class="dropbtn">
						<img src="data:image/<c:out value='${usuario.extensao}'/>;base64,<c:out value='${usuario.foto}'/>" class="avatar" height="25" width="25">
					</a>
						<div class="dropdown-content">
							<a href="<%=request.getContextPath()%>/conta-instituicao">Minha Conta</a>
			 				<a href="<%=request.getContextPath()%>/sair">Sair</a>
						</div>
				</li>		
			</c:if>
		</ul>
	</nav>
</header>