<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/15/2023
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Belt Exam</title>
    <!-- Bootstrap -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous">

</head>

<body>
<div class="container">
    <div
            class="d-flex flex-column justify-content-center align-items-center gap-2">
        <h1>User Authentication</h1>
    </div>
    <div
            class="d-flex justify-content-center gap-5 mt-3">
        <div class = "bg-light p-5">
            <h3>Register</h3>
            <form:form class="form d-flex flex-column gap-3" action="/register"
                       method="post" modelAttribute="newUser">
                <div class="d-flex flex-column justify-content-center align-items-center gap-2">
                    <form:errors path="userName" class="errors text-danger"></form:errors>
                    <form:label path="userName">Name: </form:label>
                    <form:input class="form-control" type="text" path="userName" id="registerUserName"></form:input>
                </div>
                <div class="d-flex flex-column  justify-content-center align-items-center gap-2">
                    <form:errors path="email" class="errors text-danger"></form:errors>
                    <form:label path="email">Email: </form:label>
                    <form:input class="form-control" type="text" path="email" id="registerEmail"></form:input>
                </div>
                <div class="d-flex flex-column  justify-content-center align-items-center gap-2">
                    <form:errors path="password" class="errors text-danger"></form:errors>
                    <form:label path="password">Password: </form:label>
                    <form:input class="form-control" type="password" path="password" id="registerPassword"></form:input>
                </div>
                <div class="d-flex flex-column  justify-content-center align-items-center gap-2">
                    <form:errors path="confirm" class="errors text-danger"></form:errors>
                    <form:label path="confirm">Confirm Password: </form:label>
                    <form:input class="form-control" type="password" path="confirm" id="registerConfirm"></form:input>
                </div>
                <input class="w-50 btn btn-primary" type="submit" value="Submit" />
            </form:form>
        </div>
        <div class = "bg-light p-5">
            <h3>Log In</h3>
            <form:form class="form d-flex flex-column gap-3" action="/login"
                       method="post" modelAttribute="newLogin">
                <div class="d-flex flex-column  justify-content-center align-items-center gap-2">
                    <form:errors path="email" class="errors text-danger"></form:errors>
                    <form:label path="email">Email: </form:label>
                    <form:input class="form-control" type="text" path="email" id="loginEmail"></form:input>
                </div>
                <div class="d-flex flex-column  justify-content-center align-items-center gap-2">
                    <form:label path="password">Password: </form:label>
                    <form:input class="form-control" type="password" path="password" id="loginPassword"></form:input>
                    <form:errors path="password" class="errors text-danger"></form:errors>
                </div>
                <input class="w-50 btn btn-primary" type="submit" value="Submit" />
            </form:form>
        </div>
    </div>
</div>
</body>

</html>