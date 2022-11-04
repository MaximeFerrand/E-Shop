<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.request.contextPath}/">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${error!=null }">
		<div>pas de login</div>
	</c:if>
	<form action="login" method="post">
		<input name="login">
		<button type="submit">envoyer</button>
	</form>
</body>
</html>