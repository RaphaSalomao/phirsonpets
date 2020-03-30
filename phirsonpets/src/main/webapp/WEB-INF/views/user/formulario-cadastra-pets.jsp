<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phirson Pets</title>
<link rel="stylesheet" href="${CSS}/style.css">
<c:url value="/resources/css" var="CSS" />
<c:url value="/resources/imagens" var="IMG" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" href="${CSS}/home/style.css">
</head>
<%@ include file="/WEB-INF/views/default/header.jsp"%>
<body>
	<br>
	<!-- IGNORARs:mvcUrl('PC#detalhe')
	.arg(0, produto.id)
	.build()-->
	<form:form
		action="${s:mvcUrl('UC#cadastrarPet').arg(0,usuario.id).build()}"
		method="POST" commandName="pet">
		<label>Nome do Pet: </label>
		<form:input path="nome" />
		<form:errors path="nome" />
		<br>
		<label>Raça: </label>
		<form:input path="raca" />
		<form:errors path="raca" />
		<br>
		<label>Especie: </label>
		<form:select path="tipoAnimal">
			<form:options items="${tiposAnimais}" />
		</form:select>
		<form:errors path="tipoAnimal" />
		<br>
		<label>Sexo: </label>
		<form:select path="genero">
			<form:options items="${generos}" />
		</form:select>
		<form:errors path="genero" />
		<br>
		<button>Finalizar</button>
	</form:form>
</body>
<%@include file="/WEB-INF/views/default/footer.jsp"%>
</html>