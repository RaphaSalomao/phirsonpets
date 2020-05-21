<%@ include file="/WEB-INF/views/default/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Phirson Pets</title>
<c:url value="/resources/css" var="CSS" />
<c:url value="/resources/imagens" var="IMG" />
<%@ include file="/WEB-INF/views/default/icon-links.jsp"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" href="${CSS}/home/style.css">
<link rel="stylesheet" href="${CSS}/user/perfil-cliente.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/default/header.jsp"%>
	<main>
		<div class="container pt-1 pb-1">
			<div class="row">
				<div class="col">
					<div class="container-imagem-perfil">
						<img src="${IMG}/user/perfil-cliente/imagem-perfil-cliente.jpg"
							alt="Imagem de Perfil"
							class="imagem-perfil-cliente rounded-circle">
					</div>
					<h2 class="nome-cliente">${usuario.nome }</h2>
					<h5 class="text-tier-cliente">
						Tier de ${usuario.nome}
						</h3>
						<div class="container-tier-cliente">
							<img src="${IMG}/user/perfil-cliente/icone-estrela.svg"
								alt="Icone Estrela" class="icones-tier-cliente"> <img
								src="${IMG}/user/perfil-cliente/icone-estrela.svg"
								alt="Icone Estrela" class="icones-tier-cliente">
						</div>
						<div class="container-icone-adicionar-pet">
							<a href="${s:mvcUrl('UC#cadastrarPet').arg(0,usuario.id).build()}">
								<img src="${IMG}/user/perfil-cliente/icone-adicionar-pets.svg"
									alt="Flecha Descer" class="icone-adicionar-pets">
							</a>
						</div>
						<div class="container-pets">
						<c:forEach items="${pets}" var="pet">
							<div class="row">
								<div class="col-md-auto">
									<div class="container-flechas">
										<a href="${s:mvcUrl('UC#formularioEditaPet').arg(0, pet.indice).build() }" ><img src="${IMG}/user/perfil-cliente/icone-editar-pets.svg"
											alt="Flecha Subir" class="icone-editar-pets"></a>
									</div>
								</div>
								<div class="col-md-auto">
									<div class="container-imagem-perfil-cachorro">
										<img
											src="${IMG}/user/perfil-cliente/imagem-perfil-cachorro.jpg"
											alt="Imagem de Perfil"
											class="imagem-perfil-cachorro rounded-circle">
									</div>
								</div>
								<div class="col-md-auto">
									<h5 class="nome-pet">${pet.nome }</h5>
									<div class="container-tier-cachorro">
										<c:forEach var="i" begin="1" end="${pet.notaInteira }">
											<img src="${IMG}/user/perfil-cliente/icone-estrela.svg"
												alt="Icone Estrela" class="icones-tier-cachorro"> 
										</c:forEach>
										<c:if test="${pet.notaMedia - pet.notaInteira >= 0.2 }">
											<img src="${IMG}/user/perfil-cliente/icone-meia-estrela.svg"
												alt="Icone Meia Estrela" class="icones-tier-cachorro">
										</c:if>
									</div>
									<h5 class="raca-pet">${pet.raca }</h5>
									<h5 class="sexo-pet">${pet.genero }</h5>
								</div>
							</div>
							</c:forEach>
						</div>
				</div>
				<div class="container-descricao col-6">
					<h1 class="text-descricao-cliente">Breve Descrição</h1>
					<p class="descricao-cliente">Lorem Ipsum is simply dummy text
						of the printing and typesetting industry. Lorem Ipsum has been the
						industry's standard dummy text ever since the 1500s, when an
						unknown printer took a galley of type and scrambled it to make a
						type specimen book.</p>
					<h5 class="celular">
						<img src="${IMG}/user/perfil-cliente/icone-whatsapp-rosa.svg"
							alt="Icone Whatsapp" class="icone-celular">${usuario.celular }
					</h5>
				</div>
				<div class="col">
					<div class="container-historico-cuidadores">
						<table>
							<tr>
								<div class="row">
									<div class="col-5">
										<div class="container-imagem-perfil-cuidador">
											<img
												src="${IMG}/user/perfil-cliente/imagem-perfil-cuidador.jpg"
												alt="Imagem de Perfil"
												class="imagem-perfil-cuidador rounded-circle">
										</div>
									</div>
									<div class="col-7">
										<h5 class="nome-cuidador">Beatriz da Silva</h5>
										<div class="container-button-avaliar-cuidador rounded-pill">
											<button type="submit" name="Avaliar Cuidador"
												class=" btn btn-sm button-avaliar-cuidador">Avaliar
												Cuidador</button>
										</div>
									</div>
								</div>
							</tr>

							<tr>
								<div class="row">
									<div class="col-5">
										<div class="container-imagem-perfil-cuidador">
											<img
												src="${IMG}/user/perfil-cliente/imagem-perfil-cuidador.jpg"
												alt="Imagem de Perfil"
												class="imagem-perfil-cuidador rounded-circle">
										</div>
									</div>
									<div class="col-7">
										<h5 class="nome-cuidador">Beatriz da Silva</h5>
										<div class="container-button-avaliar-cuidador rounded-pill">
											<button type="submit" name="Avaliar Cuidador"
												class=" btn btn-sm button-avaliar-cuidador">Avaliar
												Cuidador</button>
										</div>
									</div>
								</div>
							</tr>

							<tr>
								<div class="row">
									<div class="col-5">
										<div class="container-imagem-perfil-cuidador">
											<img
												src="${IMG}/user/perfil-cliente/imagem-perfil-cuidador.jpg"
												alt="Imagem de Perfil"
												class="imagem-perfil-cuidador rounded-circle">
										</div>
									</div>
									<div class="col-7">
										<h5 class="nome-cuidador">Beatriz da Silva</h5>
										<div class="container-button-avaliar-cuidador rounded-pill">
											<button type="submit" name="Avaliar Cuidador"
												class=" btn btn-sm button-avaliar-cuidador">Avaliar
												Cuidador</button>
										</div>
									</div>
								</div>
							</tr>

							<tr>
								<div class="row">
									<div class="col-5">
										<div class="container-imagem-perfil-cuidador">
											<img
												src="${IMG}/user/perfil-cliente/imagem-perfil-cuidador.jpg"
												alt="Imagem de Perfil"
												class="imagem-perfil-cuidador rounded-circle">
										</div>
									</div>
									<div class="col-7">
										<h5 class="nome-cuidador">Beatriz da Silva</h5>
										<div class="container-button-avaliar-cuidador rounded-pill">
											<button type="submit" name="Avaliar Cuidador"
												class=" btn btn-sm button-avaliar-cuidador">Avaliar
												Cuidador</button>
										</div>
									</div>
								</div>
							</tr>

						</table>

					</div>
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
