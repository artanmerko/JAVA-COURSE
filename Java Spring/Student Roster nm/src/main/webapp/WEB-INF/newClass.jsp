<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/26/2023
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Class</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<h1>New Class</h1>
<p><a href="/">Dashboard</a></p>
<form:form action="/classes/new" modelAttribute="course" method="post">
    <div>
        <form:errors path="name"/>
        <form:label path="name" for="name">Name:</form:label>
        <form:input path="name" type="text"/>
    </div>
    <div>
        <input value="Add" type="submit"/>
    </div>
</form:form>
</body>
</html>
