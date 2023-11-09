<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <!doctype html>
    <html lang="en">

    <head>
        <title>Foster</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS v5.2.1 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

    </head>

    <body>
        <header class="bg-dark py-5 px-3">
            <img src="img/logo.svg" alt="">
        </header>
        <main>
            <div class="container">
                <div class="row justify-content-center mt-3">
                <c:forEach items="${categorias}" var="categoria">
                    <div class="col-lg-4 col-md-6 mb-3">
                        <div class="card text-center">
                            <a href="Controller?op=platos&categoriaid=<c:out value="${categoria.id}"></c:out>&nombrecategoria=<c:out value="${categoria.nombre}"></c:out>#<c:out value="${categoria.nombre}"></c:out>"
                                class="text-decoration-none text-black">
                                <img class="card-img-top" src="img/category/<c:out value="${categoria.nombre}"></c:out>.png" alt="Title"/>
                                <div class="card-body">
                                    <h4 class="card-title"><c:out value="${categoria.nombre}"></c:out>
                                    ID:<c:out value="${categoria.id}"></c:out></h4>
                                </div>
                            </a>
                        </div>
                    </div>
                </c:forEach>
                </div>
            </div>
            <c:if test="${productos!= null}">
            <h1 class="text-center py-3 bg-dark text-white" id="<c:out value="${nombrecategoria}"></c:out>"><c:out value="${nombrecategoria}"></c:out></h1>
            <div class="container">
                <div class="row justify-content-center mt-3">
                <c:forEach items="${productos}" var="producto">
                    <div class="col-lg-4 col-md-6 mb-3 d-flex">
                        <div class="card text-center flex-fill">
                            <img class="card-img-top" src="<c:out value="${producto.imagen}"></c:out>" alt="Title">
                            <div class="card-body">
                                <h4 class="card-title"><c:out value="${producto.titulo}"></c:out></h4>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                </div>
            </div>
            </c:if>
        </main>
        <footer>
            <h1 class="text-center bg-dark text-white py-3 m-0">SufiDev</h1>
        </footer>
        <!-- Bootstrap JavaScript Libraries -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
            </script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
            integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
            </script>
    </body>

    </html>