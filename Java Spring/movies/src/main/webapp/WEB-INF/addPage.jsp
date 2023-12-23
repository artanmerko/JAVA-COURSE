<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/23/2023
  Time: 10:20 AM
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
    <title>Movies</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- Adjust to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container my-4">

    <h1 class="mb-3">Add to Your Movie</h1>

    <a href="/home" class="btn btn-secondary mb-3">Back to movies</a>

    <form:form action="/movies" modelAttribute="movie" method="post">

        <div class="mb-3">
            <form:label path="title" class="form-label">Title:</form:label>
            <form:input type="text" path="title" class="form-control"/>
            <form:errors path="title" class="text-danger"/>
        </div>

        <div class="mb-3">
            <form:label path="network" class="form-label">Network:</form:label>
            <form:input type="text" path="network" class="form-control"/>
            <form:errors path="network" class="text-danger"/>
        </div>

        <div class="mb-3">
            <form:label path="description" class="form-label">Description:</form:label>
            <form:textarea path="description" class="form-control" rows="3"></form:textarea>
            <form:errors path="description" class="text-danger"/>
        </div>

        <div class="mb-3">
            <form:input type="hidden" path="user" value="${user.id}"/>
            <form:errors path="user" class="text-danger"/>
        </div>

        <div class="d-grid">
            <input type="submit" value="Submit" class="btn btn-primary"/>
        </div>

    </form:form>

</div>
</body>
</html>