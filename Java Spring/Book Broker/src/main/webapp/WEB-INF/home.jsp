<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/18/2023
  Time: 7:26 AM
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
    <link rel="stylesheet" href="/css/main.css"> <!-- Adjust as per your file structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container mt-4">
    <h1 class="mb-3">Welcome, <c:out value="${user.userName}"/></h1>

    <h3 class="mb-3">Books from everyone's shelves:</h3>

    <div class="d-flex justify-content-between mb-3">
        <a href="/logout" class="btn btn-outline-secondary">Logout</a>
        <a href="/addPage" class="btn btn-primary">+ Add to my shelf</a>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author Name</th>
            <th>Owner</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td><c:out value="${book.id}"/></td>
                <td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
                <td><c:out value="${book.author}"/></td>
                <td><c:out value="${book.user.userName}"/></td>
                <c:if test="${user == book.user}">
                    <td><a href="books/${book.id}/edit">edit</a> <a href="books/${book.id}/delete">delete</a></td>
                </c:if>
                <c:if test="${user != book.user}">
                    <td><a href="books/${book.id}/borrow">Borrow</a></td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h3>Books I'm Borrowing</h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author Name</th>
            <th>Owner</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <c:if test="${user.id==book.borrower.id}">
                <tr>
                    <td><c:out value="${book.id}"/></td>
                    <td><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
                    <td><c:out value="${book.author}"/></td>
                    <td><c:out value="${book.user.userName}"/></td>
                    <c:if test="${user!=book.user}">
                        <td><a href="books/${book.id}/return">return</a></td>
                    </c:if>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>