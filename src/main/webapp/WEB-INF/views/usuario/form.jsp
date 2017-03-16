<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de usuários</title>
</head>
<body>

		<c:url var="post_url"  value="/usuario" />
		<form:form action="${post_url}" method="post" commandName="usuario" enctype="multipart/form-data">
	
		<div>
			<label>Nome</label> 
			<form:input path="nome" />
			<form:errors path="nome"/>
		</div>
		<div>
			<label>Sobrenome</label>
			<form:input path="sobrenome" />
			<form:errors path="sobrenome"/>
		</div>
		<div>
			<label>Login</label> 
			<form:input path="login" />
			<form:errors path="login"/>
		</div>
		
		<div>
			<label>Senha</label>
			<form:input path="senha" />
		</div>
		<div>
			<button type="submit">Cadastrar</button>
		</div>
	</form:form>
</body>
</html>