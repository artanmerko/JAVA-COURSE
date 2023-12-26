<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/26/2023
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>New Product</title>
</head>
<body>

<h1>New Product</h1>
<p><a href="/">Home</a></p>
<hr>

<form:form action="/products/new" method="post" modelAttribute="product">

    <table>
        <thead>
        <tr>
            <td class="float-left">Name:</td>
            <td class="float-left">
                <form:input class="input" path="name"/>
                <form:errors path="name" class="text-danger" style="color:red"/>
            </td>
        </tr>
        <tr>
            <td class="float-left">Description:</td>
            <td class="float-left">
                <form:input class="input" path="description"/>
                <form:errors path="description" class="text-danger" style="color:red"/>
            </td>
        </tr>
        <tr>
            <td class="float-left">Price:</td>
            <td class="float-left">
                <form:input type="number" class="input" path="price"/>
                <form:errors path="price" class="text-danger" style="color:red"/>
            </td>
        </tr>
        <tr>
            <td colspan=2><input class="input" class="button" type="submit" value="Submit"/></td>
        </tr>
        </thead>
    </table>
</form:form>
</body>
</html>