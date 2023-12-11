<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/11/2023
  Time: 1:44 PM
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
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Burger Tracker</title>
</head>
<body>
<h1>Burger Tracker</h1>
<table class="table table-striped table-bordered">
    <thead >
    <tr class="table-header">
        <th>Burger Name</th>
        <th>Restaurant Name</th>
        <th>Rating (out of 5)</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="burger" items="${burgers}">
        <tr>
            <td><c:out value="${burger.name}"/></td>
            <td><c:out value="${burger.restaurant}"/></td>
            <td><c:out value="${burger.rating}"/></td>
            <td>
                <div class="action-btn">
                    <a href="/edit/${burger.id}" class="action-btn edit-btn">edit</a>
                    <form action="/delete/${burger.id}" method="post" class="action-btn delete-btn-form">
                        <input type="hidden" name="_method" value="delete">
                        <input type="submit" value="Delete" class="action-btn delete-btn">
                    </form>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<form:form action="/addBurger" mode="post" modelAttribute="burger">
    <h2>Add new burger</h2>
    <div>
        <form:label path="name">Burger Name:</form:label><br>
        <form:errors path="name" class="text-danger"/>
        <form:input path="name" style="width:250px;"/>
    </div>
    <div>
        <form:label path="restaurant">Restaurant Name:</form:label><br>
        <form:errors path="restaurant" class="text-danger"/>
        <form:input path="restaurant" style="width:250px;"/>
    </div>
    <div>
        <form:label path="rating">Rating:</form:label><br>
        <form:errors path="rating" class="text-danger"/>
        <form:input path="rating" style="width:250px;"/>
    </div>
    <div>
        <form:label path="notes">Notes:</form:label><br>
        <form:errors path="notes" class="text-danger"/>
        <form:textarea path="notes" rows="3" style="width:250px;"/>
    </div>
    <div >
        <input class="add-burger" type="submit" value="Create"/>
    </div>
</form:form>
</body>
</html>