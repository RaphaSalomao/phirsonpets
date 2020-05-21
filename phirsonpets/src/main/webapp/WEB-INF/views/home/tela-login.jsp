<%@ include file="/WEB-INF/views/default/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Phirson Pets</title>
<c:url value="resources/css" var="CSS" />
<c:url value="resources/imagens" var="IMG" />
    <%@ include file="/WEB-INF/views/default/icon-links.jsp"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" href="${CSS}/home/style.css">
<link rel="stylesheet" href="${CSS}/home/tela-login.css">
</head>
<body>

	<%@ include file="/WEB-INF/views/default/header.jsp"%>

	<main>
		<div class="container d-flex align-items-start">
			<form:form servletRelativeAction="/login"
				cssClass="form-login d-flex align-items-start justify-content-center flex-column"
				method="POST">
				<h1 class="text-login">Acesse sua Conta</h1>
				<label for="login" class="label-login">Login</label>
				<input name="username" type="text" id="login"
					class="input-login pl-2" required placeholder="e-mail">
				<form:errors path="email" />
				<label for="senha" class="label-login">Senha</label>
				<input name="password" type="password" id="senha"
					class="input-login pl-2" required placeholder="********">
				<form:errors path="senha" />

				<div class="container-button-login">
					<button type="submit" name="Entrar" class="button-entrar">
						Entrar<img src="${IMG}/home/tela-login/icone-login.svg"
							alt="Icone Login" class="icone-login">
					</button>
				</div>

				<div class="container-imagem-cachorro1">
					<img src="${IMG}/home/tela-login/cachorro1.png"
						alt="Imagem Cachorro1" class="imagem-cachorro1">
				</div>
				<div class="division-line"></div>

			</form:form>

			<div
				class="container-cadastrese d-flex align-items-start justify-content-center flex-column">
				<h1 class="text-cadastrese">Novo na Phirson?</h1>

				<div class="container-button-cadastrese">
					<a href="${s:mvcUrl('HC#formularioCadastro').build()}">
						<button type="button" name="Entrar" class="button-cadastrese">
							Cadastre-se<img src="${IMG}/home/tela-login/icone-cadastrese.svg"
								alt="Icone Cadastre-se" class="icone-cadastrese">
						</button>
					</a>
				</div>
				<div class="container-imagem-cachorro2">
					<img src="${IMG}/home/tela-login/cachorro2.png"
						alt="Imagem Cachorro2" class="imagem-cachorro2">
				</div>
			</div>
		</div>
	</main>


	<%@ include file="/WEB-INF/views/default/footer.jsp"%>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>
