<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/12/2023
  Time: 11:28 AM
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Expense Details</title>
</head>
<body>

<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            <h2 class="card-title">Expense Details</h2>
        </div>
        <div class="card-body">
            <h6 class="card-title">Expense Name: <span class="text-muted"><c:out value="${travel.name}"/></span></h6>
            <h6 class="card-text">Vendor: <span class="text-muted"><c:out value="${travel.vendor}"/></span></h6>
            <h6 class="card-text">Amount: <span class="text-muted"><c:out value="${travel.amount}"/></span></h6>
            <h6 class="card-text">Description: <span class="text-muted"><c:out value="${travel.description}"/></span></h6>
        </div>
        <div class="card-footer text-end">
            <a href="/" class="btn btn-secondary">Go Back</a>
        </div>
    </div>
</div>

</body>
</html>
