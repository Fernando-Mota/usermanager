<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Teste Técnico - Intelipost</title>
</head>
<body>
    <h2>Teste Técnico - Intelipost</h2>
    
    <h3>Lista de usuários</h3>
	<form action='<c:url value="/usuario/lista"/>' method="get">
		<input type="submit" value="Lista de Usuários">
	</form><br/>
    <h3>Formulário de Login</h3>
	<form action='<c:url value="/login/form"/>' method="get">
		<input type="submit" value="Login">
	</form>
</body>
</html>