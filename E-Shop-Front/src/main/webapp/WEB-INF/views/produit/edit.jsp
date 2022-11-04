<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.request.contextPath}/">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<title>eshop</title>
</head>
<body>
	<div class="container">
		<form:form method="post" action="produit" modelAttribute="produit">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" readonly="true" cssClass="form-control"
					placeholder="auto" />
			</div>
			<div class="form-group">
				<form:label path="libelle">libelle:</form:label>
				<form:input path="libelle" cssClass="form-control" />
				<form:errors path="libelle" cssClass="alert alert-danger small"
					element="div"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="prix">prix:</form:label>
				<form:input type="number" step="0.1" path="prix"
					cssClass="form-control" />
				<form:errors path="prix" cssClass="alert alert-danger small"
					element="div"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="fournisseur">fournisseur:</form:label>
				<%--
				<form:select path=""
					items="collection qui contient les donnees à mettre dans le select"
					itemLabel="attribut d'un objet de la collection à mettre entre la balise option"
					itemValue="attribut de l'objet de la collection =>value"></form:select>
				<select name="nom du parametre qui recupere la valeur">
					<option value="valeur a envoyer">a afficher</option>
				</select>
				--%>
				<form:select cssClass="form-control" path="fournisseur.id" items="${fournisseurs}" itemValue="id" itemLabel="infos">
				</form:select>
				<form:errors path="fournisseur"></form:errors>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">enregistrer</button>
				<a href="produit" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>