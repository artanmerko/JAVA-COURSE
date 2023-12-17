<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/15/2023
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Club</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- Adjust to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container my-4">

    <h1 class="mb-3">Add to Your Book Shelf</h1>

    <a href="/home" class="btn btn-secondary mb-3">Back to shelves</a>

    <form:form action="/books" modelAttribute="book" method="post">

        <div class="mb-3">
            <form:label path="title" class="form-label">Title:</form:label>
            <form:input type="text" path="title" class="form-control"/>
            <form:errors path="title" class="text-danger"/>
        </div>

        <div class="mb-3">
            <form:label path="author" class="form-label">Author:</form:label>
            <form:input type="text" path="author" class="form-control"/>
            <form:errors path="author" class="text-danger"/>
        </div>

        <div class="mb-3">
            <form:label path="thoughts" class="form-label">Thoughts:</form:label>
            <form:textarea path="thoughts" class="form-control" rows="3"></form:textarea>
            <form:errors path="thoughts" class="text-danger"/>
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
