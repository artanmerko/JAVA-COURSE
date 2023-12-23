<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/23/2023
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Movie</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<style>
    .des-style {
        border-top: 2px solid #000;
        border-bottom: 2px solid #000;
        padding: 20px 0;
        font-style: italic;
    }
</style>
<body>
<div class="container mt-4">
    <a href="/home" class="btn btn-secondary mb-3">Back to movies</a>
    <h1 class="mb-3">${movies.title}</h1>

    <c:choose>
        <c:when test="${movies.user.equals(user)}">
            <p>Posted by: ${movies.user.userName}</p>
            <p>Network: ${movies.network}</p>
        </c:when>
        <c:otherwise>
            <p>Posted by: ${movies.user.userName}</p>
            <p>Network: ${movies.network}</p>
        </c:otherwise>
    </c:choose>
    <blockquote class="des-style">Description:
        ${movies.description}
    </blockquote>

    <c:if test="${movies.user.equals(user)}">
        <div class="d-flex justify-content-end">
            <a href="/movies/${movies.id}/edit" class="btn btn-primary me-2">Edit</a>
            <form:form action="/movies/${movies.id}/delete" method="delete">
                <button type="submit" class="btn btn-danger">Delete</button>
            </form:form>
        </div>
    </c:if>
</div>
</body>
</html>