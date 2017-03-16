<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

		<c:url var="post_url"  value="/login/efetualogin" />
		<form action="${post_url}" method="post" enctype="multipart/form-data">
	
		<div>
			<label>Login</label> 
			<input name="login" type="text"/>
		</div>
		
		<div>
			<label>Senha</label>
			<input name="senha" type="password"/>
		</div>
		<div>
			<button type="submit">Logar</button>
		</div>
	</form>
</body>
</html>