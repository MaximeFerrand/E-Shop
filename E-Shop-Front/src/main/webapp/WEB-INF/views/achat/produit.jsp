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
		<h1>nos produits</h1>
		<table class="table">
			<thead>
				<tr>
					<th>produit:</th>
					<th>prix:</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="produit" items="${produits}">
					<tr>
						<td>${produit.libelle}</td>
						<td>${produit.prix}</td>
						<td><a href="achat/panier/add/${produit.id}"
							class="btn btn-link">ajouter au panier</a></td>
						<td>${panier.get(produit)}</td>
						<td><c:if test="${panier.containsKey(produit)}">
								<a href="achat/panier/delete/${produit.id}" class="btn btn-link">retirer
									du panier</a>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="achat/panier/validate" class="btn btn-link">valider</a>
	</div>
</body>
</html>