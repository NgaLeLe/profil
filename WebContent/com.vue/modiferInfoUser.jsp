<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!doctype html>
    <html lang="en">

    <head>
        <title>Bienvenue</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
        <div class="media">
            <img class="align-self-center mr-3" src="com.images\pic1.jpg" alt="Generic placeholder image">
            <div class="media-body ">
                <h4 class="mt-5 mb-4">Bonjour ${nom}, vous venez de connecter</h4>
                <c:choose>
                    <c:when test="${update.equals('OK')}">
                        <h6 class="m-5"> Vous venez modifier vos infors ! </h6>
                    </c:when>
                </c:choose>
                <form method="post" action="updateUser">
                    <div class="form-group row">
                        <label for="inputNom" class="col-sm-2 col-form-label">Nom</label>
                        <div class="col-sm-8">
                            <input type="text" name="iptNom" class="form-control" id="inputNom" placeholder="Votre nom" value="${nom}">
                            <c:choose>
                                <c:when test="${error.equals('1')}">
                                    <small id="nomHelpBlock" class="form-text text-muted"> Nom n'est pas rempli ! </small>");
                                </c:when>
                            </c:choose>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
                        <div class="col-sm-8">
                            <input type="email" name="iptEmail" class="form-control" id="inputEmail3" placeholder="email@yahoo.com" value="${email}">
                            <c:choose>
                                <c:when test="${error.equals('2')}">
                                    <small id="nomHelpBlock" class="form-text text-muted"> Email n'est pas rempli ! </small>");
                                </c:when>
                            </c:choose>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputAge" class="col-sm-2 col-form-label">Age</label>
                        <div class="col-sm-8">
                            <input type="number" name="iptAge" class="form-control" id="inputAge" placeholder="Saisir votre age" value="${age}">
                            <c:choose>
                                <c:when test="${error.equals('5')}">
                                    <small id="nomHelpBlock" class="form-text text-muted">Age n'est pas rempli ou l'age doit �tre entre 18-95 ! ! </small>");
                                </c:when>
                            </c:choose>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
                        <div class="col-sm-8">
                            <input type="password" name="iptPassword" class="form-control" id="inputPassword3" value="${password}">
                            <c:choose>
                                <c:when test="${error.equals('4')}">
                                    <small id="nomHelpBlock" class="form-text text-muted">Votre password n'est pas remli ! </small>");
                                </c:when>
                            </c:choose>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputAdress3" class="col-sm-2 col-form-label">Adress</label>
                        <div class="col-sm-8">
                            <input type="text" name="iptAdress" class="form-control" id="inputAdress3" value="${adress}">
                            <c:choose>
                                <c:when test="${error.equals('3')}">
                                    <small id="nomHelpBlock" class="form-text text-muted">Adress n'est pas rempli ! </small>");

                                </c:when>
                            </c:choose>
                        </div>
                    </div>
                    <div class="col-sm-8 ">
                        <button type="submit" class="btn btn-primary ">Mise � jour</button>
                        <a href="/profil/espaceUser" class="btn btn-primary">Retour</a>
                    </div>
                </form>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js " integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo " crossorigin="anonymous "></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js " integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1 " crossorigin="anonymous "></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js " integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM " crossorigin="anonymous "></script>
    </body>

    </html>