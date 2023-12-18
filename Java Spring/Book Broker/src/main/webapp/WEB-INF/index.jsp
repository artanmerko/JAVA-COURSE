<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/17/2023
  Time: 4:52 PM
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
    <title>Book Club</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container mt-4">

    <h1 class="text-center mb-4">Book Club!</h1>
    <p class="text-center">A place for friends to share thoughts on books.</p>

    <div class="row">
        <div class="col-md-6">
            <h2>Register</h2>
            <form:form action="/register" modelAttribute="newUser" method="post">
                <div class="mb-3">
                    <form:label path="userName" class="form-label">User Name:</form:label>
                    <form:input path="userName" class="form-control" type="text"/>
                    <form:errors path="userName" class="text-danger"/>
                </div>
                <div class="mb-3">
                    <form:label path="email" class="form-label">Email:</form:label>
                    <form:input path="email" class="form-control" type="text"/>
                    <form:errors path="email" class="text-danger"/>
                </div>
                <div class="mb-3">
                    <form:label path="password" class="form-label">Password:</form:label>
                    <form:input path="password" class="form-control" type="password"/>
                    <form:errors path="password" class="text-danger"/>
                </div>
                <div class="mb-3">
                    <form:label path="confirm" class="form-label">Confirm:</form:label>
                    <form:input path="confirm" class="form-control" type="password"/>
                    <form:errors path="confirm" class="text-danger"/>
                </div>
                <div class="d-grid">
                    <input type="submit" value="Submit" class="btn btn-primary"/>
                </div>
            </form:form>
        </div>

        <div class="col-md-6">
            <h2>Log In</h2>
            <form:form action="/login" modelAttribute="newLogin" method="post">
                <div class="mb-3">
                    <form:label path="email" class="form-label">Email:</form:label>
                    <form:input path="email" class="form-control" type="text"/>
                    <form:errors path="email" class="text-danger"/>
                </div>
                <div class="mb-3">
                    <form:label path="password" class="form-label">Password:</form:label>
                    <form:input path="password" class="form-control" type="password"/>
                    <form:errors path="password" class="text-danger"/>
                </div>
                <div class="d-grid">
                    <input type="submit" value="Submit" class="btn btn-primary"/>
                </div>
            </form:form>
        </div>
    </div>

</div>

</body>
</html>