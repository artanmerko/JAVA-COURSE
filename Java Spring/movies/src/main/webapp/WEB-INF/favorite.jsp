<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/20/2023
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Favorite Movies</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- Adjust as per your file structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <style>
        table.table td {
            /*text-align: center;*/
            vertical-align: middle;
        }
    </style>
</head>
<body style="background-color: #F8FAFC;">

<div class="container mt-4">
    <h1 class="mb-3">My Favorite Movies</h1>

    <div class="d-flex justify-content-between mb-3">
        <a href="/home" class="btn btn-outline-secondary">Back to Home</a>
        <a href="/logout" class="btn btn-outline-secondary">Logout</a>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Network</th>
            <th>Posted By</th>
            <th>Average Rating</th>
            <th>Picture</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="movie" items="${favoriteMovies}">
            <tr>
                <td><c:out value="${movie.id}"/></td>
                <td><a href="/movies/${movie.id}"><c:out value="${movie.title}"/></a></td>
                <td><c:out value="${movie.network}"/></td>
                <td><c:out value="${movie.user.userName}"/></td>
                <td><fmt:formatNumber value="${movie.averageRating}" minFractionDigits="1" maxFractionDigits="1"/></td>
                <td>
                    <img src="${movie.pictureUrl}" alt="${movie.title} Picture" style="max-width: 100px;"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>
