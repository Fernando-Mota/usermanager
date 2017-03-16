<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Produtos</title>
</head>
<div>${mensagem}</div>
<body>
	<table>
		<tr>
			<td>Nome</td>
			<td>Sobrenome</td>
			<td>Login</td>
			<td>Apagar</td>
		</tr>
		<c:forEach var="usuario" items="${usuarios}" >
			<tr>
				<td><a href='<c:url value="/usuario/${usuario.id}" />'>${usuario.nome}</a></td>
				<td>${usuario.sobrenome}</td>
				<td>${usuario.login}</td>
				<td>
					<form action='<c:url value="/usuario/deleta"/>' method="post">
						<input type="submit" value="Apagar">
						<input type="hidden" name="id" value="${usuario.id}">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form action='<c:url value="/usuario/form"/>' method="get">
		<input type="submit" value="Cadastrar">
	</form>
	<form action='<c:url value="/"/>' method="get">
		<input type="submit" value="Página Principal">
	</form>
</body>
</html>