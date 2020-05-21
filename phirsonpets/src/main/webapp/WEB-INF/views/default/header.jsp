<header>
        <nav class="navbar navbar-expand-lg">
          <a class="navbar-brand" href="${s:mvcUrl('HC#index').build()}"><img src="${IMG}/home/logo-phirson.png" alt="Logo Phirson Pets" class="cabecalhoPrincipal-logo"></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <img src="${IMG}/home/toggle-bar.svg" alt="Icone Toggle Bar" class="cabecalhoPrincipal-icone-toggle-bar">
          </button>
          <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
            <div class="navbar-nav">
                <a class="nav-item nav-link cabecalhoPrincipal-nav-link" href="${s:mvcUrl('UC#perfilCliente').arg(0,usuario.id).build() }">PERFIL</a>
                <a class="nav-item nav-link cabecalhoPrincipal-nav-link" href="#">CARE</a>
                <a class="nav-item nav-link cabecalhoPrincipal-nav-link" href="#">SUPORTE</a>
            </div>
            </div>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <c:if test="${ehPaginaPerfil == true}">
            	<a class="nav-item nav-link cabecalhoPrincipal-nav-login-link" href="${s:mvcUrl('UC#editarPerfilCliente').arg(0,usuario.id).build()}">Editar</a>
            </c:if>
            <sec:authorize access="!isAuthenticated()">
              <a class="nav-item nav-link cabecalhoPrincipal-nav-login-link" href="/phirsonpets/login">Entrar</a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()"> 
              <a class="nav-item nav-link cabecalhoPrincipal-nav-login-link" href="/phirsonpets/logout">Sair</a>
            </sec:authorize>
              <!--  <a class="nav-item nav-link cabecalhoPrincipal-nav-login-link" href="#">Cadastre-se</a> -->
            </div>
        </nav>
      </header>
