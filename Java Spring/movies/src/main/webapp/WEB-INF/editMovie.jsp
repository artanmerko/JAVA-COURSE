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
    <title>Movie Edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-3">Change your entry</h1>
    <a href="/home" class="btn btn-secondary mb-3">Back to movies</a>

    <%--@elvariable id="movieEdit" type="javax"--%>
    <form:form method="put" action="/movies/${movieEdit.id}/update" modelAttribute="movieEdit" class="mb-3">

        <div class="mb-3">
            <form:label path="title" class="form-label">Title:</form:label>
            <form:input path="title" class="form-control"></form:input>
            <form:errors path="title" class="text-danger"></form:errors>
        </div>
        <div class="mb-3">
            <form:label path="network" class="form-label">Network:</form:label>
            <form:input path="network" class="form-control"></form:input>
            <form:errors path="network" class="text-danger"></form:errors>
        </div>
        <div class="mb-3">
            <form:label path="description" class="form-label">Description:</form:label>
            <form:textarea path="description" class="form-control" rows="3"></form:textarea>
            <form:errors path="description" class="text-danger"></form:errors>
        </div>
        <div class="mb-3">
            <form:label path="pictureUrl" class="form-label">Picture URL:</form:label>
            <form:input path="pictureUrl" class="form-control"></form:input>
            <form:errors path="pictureUrl" class="text-danger"></form:errors>
        </div>
        <div class="mb-3">
            <form:label path="videoTrailerUrl" class="form-label">Video Trailer URL:</form:label>
            <form:input path="videoTrailerUrl" class="form-control"></form:input>
            <form:errors path="videoTrailerUrl" class="text-danger"></form:errors>
        </div>
        <button type="submit" class="btn btn-info">Submit</button>
    </form:form>
</div>
</body>
</html>