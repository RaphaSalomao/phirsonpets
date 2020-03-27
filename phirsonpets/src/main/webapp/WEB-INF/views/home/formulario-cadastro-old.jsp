<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phirson Pets Cadastro</title>
<c:url value="/resources/css/home" var="CSS" />
<c:url value="/resources/imagens/home" var="IMG" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">	
<link rel="stylesheet" href="${CSS}/style.css">
</head>
<body>
	<form:form action="${s:mvcUrl('HC#cadastrarUsuario').build() }"
		method="POST" commandName="usuario">
		<label>E-mail</label>
		<form:input type="email" path="email" />
		<br>
		<form:errors path="email"/>
		<label>Nome Completo</label>
		<form:input path="nome" />
		<br>
		<form:errors path="nome"/>
		<label>Sexo</label>
		<form:select path="genero">
			<form:options items="${generos }" />
		</form:select>
		<br>
		<form:errors path="genero"/>
		<label>CPF</label>
		<form:input  path="cpf" />
		<br>
		<form:errors path="cpf"/>
		<label>Celular</label>
		<form:input path="celular" />
		<br>
		<form:errors path="celular"/>
		<label>Deseja ser um cuidador?</label>
		<label>Sim</label>
		<form:radiobutton path="cuidador"	 value="true" />
		<label>Não</label>
		<form:radiobutton path="cuidador" vaue="false" />
		<br>
		<form:errors path="cuidador"/>
		<label>CEP</label>
		<form:input path="cep" onblur="pesquisacep(this.value);" />
		<br>
		<form:errors path="cep"/>
		<label>Rua</label>
		<form:input path="rua" />
		<br>
		<form:errors path="rua"/>
		<label>Numero</label>
		<form:input path="numero" />
		<br>
		<form:errors path="numero"/>
		<label>Bairro</label>
		<form:input path="bairro" />
		<br>
		<form:errors path="bairro"/>
		<label>Cidade</label>
		<form:input path="cidade" />
		<br>
		<form:errors path="cidade"/>
		<label>UF</label>
		<form:input path="uf" />
		<br>
		<form:errors path="uf"/>
		<label>Senha</label>
		<form:password path="senha" />
		<br>
		<form:errors path="uf"/>
		<label>Confirmar senha</label>
		<input type="password" id="confirma_senha" />
		<br>
		<form:errors path="uf"/>
		<input type="submit">
	</form:form>

	<!-- scripts da pagina -->
	<script type="text/javascript"
		src='<c:url value="/resources/javascript/home/viacepJs.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/resources/javascript/home/validaSenhaJs.js"/>'></script>
</body>
</html>