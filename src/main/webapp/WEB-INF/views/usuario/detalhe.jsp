<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Descrição de usuário - ${usuario.nome}</title>
</head>
<body>
	<fieldset>
		<div>
			<label>Nome</label>
			<input type="text" value="${usuario.nome}" disabled="disabled" />
		</div>

		<div>
			<label>Sobrenome</label>
			<input type="text" value="${usuario.sobrenome}" disabled="disabled" />
		</div>

		<div>
			<label>Login</label>
			<input type="text" value="${usuario.login}" disabled="disabled" />
		</div>

		<div>
			<label>Senha</label>
			<input type="text" value="${usuario.senha}" disabled="disabled" />
		</div>
	</fieldset>
	<form action='<c:url value="/usuario/lista"/>' method="get">
		<input type="submit" value="Lista de Usuários">
	</form>
</body>
</html>