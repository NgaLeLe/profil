<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<title>Espace client</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
	<div class="container-fluid row justify-content-center">
		<div class="col-8">
			<h4 class="mt-5 mb-4">Bonjour, Madame/Monsieur
				${sessionScope.client.getNom()} - ${sessionScope.client.getPrenom()}</h4>
		</div>
		<div class="col-4 text-danger">
			Client n'est pas connect� :
			<c:forEach var="client" items="${clientPasConnect}">
				<h6>
					<c:out value="${client.getNom()}" />
				</h6>
			</c:forEach>
		</div>

	</div>

	<table class="table table-hover">
		<thead>
			<tr>
				<!--  int idCommande, int idClient, String produit, int nombre, double prix, String date -->
				<th scope="col">#</th>
				<th scope="col">Date</th>
				<th scope="col">Produit</th>
				<th scope="col">Nombre</th>
				<th scope="col">Prix</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="commande" items="${sessionScope.listCommande}">
				<tr>
					<td>${commande.getIdCommande() }</td>
					<td>${commande.getDate()}</td>
					<td>${commande.getProduit()}</td>
					<td>${commande.getNombre()}</td>
					<td>${commande.getPrix()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form class="form-inline" method="post" action="espaceClient">
		<button type="submit" class="btn btn-primary mb-2" name="deconnecter"
			value="deconnecter">Deconnection</button>
		<button type="submit" class="btn btn-primary mb-2" name="ajouter"
			value="ajouter">
			Ajouter <span class="fa fa-plus"></span>
		</button>
		<button type="submit" class="btn btn-primary mb-2" name="modifier"
			value="modifier">Modifier</button>
	</form>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js "
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo "
		crossorigin="anonymous "></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js "
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1 "
		crossorigin="anonymous "></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js "
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM "
		crossorigin="anonymous "></script>
</body>

</html>