<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/26/2023
  Time: 10:25 AM
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
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>New Category</title>
</head>
<body>

<h1>New Category</h1>
<p><a href="/">Home</a></p>
<hr>

<form:form action="/categories/new" method="post" modelAttribute="category" name="categoryForm">
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
            <td colspan=2><input class="input" class="button" type="submit" value="Submit"/></td>
        </tr>
        </thead>
    </table>
</form:form>
</body>
</html>