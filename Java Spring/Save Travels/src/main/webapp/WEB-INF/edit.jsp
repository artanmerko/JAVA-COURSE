<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/12/2023
  Time: 10:06 AM
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
    <title>Save Travel</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <form:form action="/edit/${travel.id}" method="post" modelAttribute="travel" class="g-3">
                <div class="edit-head mb-3">
                    <h3>Edit Expense</h3>
                    <a href="/" class="btn btn-secondary">Go back</a>
                </div>

                <div class="mb-3">
                    <form:label path="name" class="form-label">Expense Name:</form:label>
                    <form:input path="name" type="text" class="form-control" id="name"/>
                    <form:errors path="name" class="text-danger"/>
                </div>

                <div class="mb-3">
                    <form:label path="vendor" class="form-label">Vendor:</form:label>
                    <form:input path="vendor" type="text" class="form-control" id="vendor"/>
                    <form:errors path="vendor" class="text-danger"/>
                </div>

                <div class="mb-3">
                    <form:label path="amount" class="form-label">Amount:</form:label>
                    <form:input path="amount" type="number" class="form-control" id="amount"/>
                    <form:errors path="amount" class="text-danger"/>
                </div>

                <div class="mb-3">
                    <form:label path="description" class="form-label">Description:</form:label>
                    <form:textarea path="description" rows="3" class="form-control" id="description"/>
                    <form:errors path="description" class="text-danger"/>
                </div>

                <div class="mb-3 text-center">
                    <button type="submit" class="btn btn-primary">Update</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>