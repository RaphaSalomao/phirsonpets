<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Phirson Pets</title>
<c:url value="/resources/css/home" var="CSS" />
<c:url value="/resources/imagens/home" var="IMG" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" href="${CSS}/style.css">
<link rel="stylesheet" href="${CSS}/cadastro-usuario.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/default/header.jsp"%>

	<main>
		<div class="container">
			<form:form action="${s:mvcUrl('HC#cadastrarUsuario').build()}"
				method="POST" commandName="usuario" cssClass="usuario">
				<div class="container">
					<div class="row">
						<div class="col-6">
							<div class="d-flex flex-column">
								<div class="container-email">
									<label class="text-inputs">E-mail</label>
									<form:input path="email"
										cssClass="email form-control rounded-pill" type="email" />
									<form:errors path="email" />
								</div>

								<div class="container-nome">
									<label class="text-inputs">Nome Completo</label>
									<form:input cssClass="nome form-control rounded-pill"
										path="nome" />
									<form:errors path="nome" />
								</div>

								<div class="container-genero">
									<label class="text-inputs">Sexo</label>
									<form:select path="genero"
										cssClass="genero form-control rounded-pill">
										<form:options items="${generos }" />
									</form:select>
									<form:errors path="genero" />
								</div>

								<div class="container-cpf">
									<label class="text-inputs">CPF</label>
									<form:input cssClass="cpf form-control rounded-pill" path="cpf" />
									<form:errors path="cpf" />
								</div>

								<div class="container-celular">
									<label class="text-inputs">Celular</label>
									<form:input cssClass="celular form-control rounded-pill"
										path="celular" />
									<form:errors path="celular" />
								</div>

								<div class="checkbox-cuidador d-flex">
									<label class="text-inputs">Deseja ser um cuidador?</label>
									<div class="container-radio-buttons">
										<form:radiobutton path="cuidador" cssClass="cuidador1"
											value="true" />
										<label class="text-checkbox-sim">Sim</label>
										<form:radiobutton path="cuidador" cssClass="cuidador1"
											value="false" />
										<label class="text-checkbox-nao">Não</label>
										<form:errors path="cuidador" />
									</div>
								</div>
							</div>
						</div>
						<div class="division-line"></div>
						<div class="col-6">
							<div class="d-flex flex-column">

								<div class="container-cep">
									<label class="text-inputs">CEP</label>
									<form:input path="cep" cssClass="cep form-control rounded-pill"
										onblur="pesquisacep(this.value);" />
									<form:errors path="cep" />
								</div>

								<div class="container-rua">
									<label class="text-inputs">Rua</label>
									<form:input cssClass="rua form-control rounded-pill" path="rua" />
									<form:errors path="rua" />
								</div>

								<div class="container-numero">
									<label class="text-inputs">Numero</label>
									<form:input path="numero"
										cssClass="numero form-control rounded-pill" />
									<form:errors path="numero" />
								</div>

								<div class="container-bairro">
									<label class="text-inputs">Bairro</label>
									<form:input path="bairro"
										cssClass="bairro form-control rounded-pill" />
									<form:errors path="bairro" />
								</div>

								<div class="container-cidade">
									<label class="text-inputs">Cidade</label>
									<form:input path="cidade"
										cssClass="cidade form-control rounded-pill" />
									<form:errors path="cidade" />
								</div>

								<div class="container-uf">
									<label class="text-inputs">Estado</label>
									<form:select path="uf" class="uf form-control rounded-pill">
										<form:options items="${estados}" />
									</form:select>
									<form:errors path="uf" />
								</div>

								<div class="container-senha">
									<label class="text-inputs">Senha</label>
									<form:password path="senha"
										cssClass="senha form-control rounded-pill" />
									<form:errors path="senha" />
								</div>

								<div class="container-confirma_senha">
									<label class="text-inputs">Confirmar senha</label> <input
										type="password" id="confirma_senha"
										class="confirma_senha form-control rounded-pill" />
								</div>

								<div class="container-submit">
									<button type="submit" class="submit rounded-pill">Finalizar
										Cadastro</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</main>

	<%@include file="/WEB-INF/views/default/footer.jsp"%>


	<!-- scripts da pagina -->
	<script type="text/javascript"
		src='<c:url value="/resources/javascript/home/viacepJs.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/resources/javascript/home/validaSenhaJs.js"/>'></script>
	<!-- scripts bootstrap -->
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
