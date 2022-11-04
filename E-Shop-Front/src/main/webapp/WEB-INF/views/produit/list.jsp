<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<title>eshop</title>
<base href="${pageContext.request.contextPath}/">
</head>
<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>id:</th>
					<th>nom:</th>
					<th>prix</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${produits}">
				<tr>
					<td>${p.getId()}</td>
					<td>${p.libelle}</td>
					<td>${p.prix}</td>
					<td><a href="produit/edit?id=${p.id}" class="btn btn-outline-primary">editer</a></td>
					<td><a href="produit/delete?id=${p.id}" class="btn btn-outline-danger">supprimer</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="produit/add" class="btn btn-link">nouveau produit</a>
	</div>
</body>
</html>