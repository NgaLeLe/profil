<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<title>Login d'utilisateur</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
	<div class="media">
		<img class="align-self-center mr-3" src="com.images\pic1.jpg"
			width="50%" alt="Generic placeholder image">
		<div class="media-body ">
			<h4 class="mt-5 mb-4">PAGE LOGIN</h4>
			<form method="post" action="loginUser">
				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-8">
						<input type="email" name="iptEmail" class="form-control"
							id="inputEmail3" placeholder="email@yahoo.com" value="">
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-8">
						<input type="password" name="iptPassword" class="form-control"
							id="inputPassword3" value="">
					</div>
				</div>
				<c:choose>
					<c:when test="${error.equals('1')}">
						<small id="idHelpBlock" class="form-texttext-muted text-danger"> <c:out
								value="Vous n'avez pas rempli email ou password !!! " /></small>
					</c:when>
					<c:when test="${error == '2'}">
						<small id="idHelpBlock" class="form-texttext-muted text-danger"> <c:out
								value="Email n'existe pas ! Essayez un autre email " /></small>
					</c:when>
				</c:choose>
				<div class="col-sm-8 ">
					<button type="submit" class="btn btn-primary ">Connecter</button>
				</div>
			</form>
		</div>
	</div>

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