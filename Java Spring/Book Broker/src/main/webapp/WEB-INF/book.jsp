<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/18/2023
  Time: 7:33 AM
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
  <title>Read Share</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<style>
  .thoughts-style {
    border-top: 2px solid #000;
    border-bottom: 2px solid #000;
    padding: 20px 0;
    font-style: italic;
  }
</style>
<body>
<div class="container mt-4">
  <a href="/home" class="btn btn-secondary mb-3">Back to the shelves</a>
  <h1 class="mb-3">${book.title}</h1>

  <c:choose>
    <c:when test="${book.user.equals(user)}">
      <p style="font-weight: bold;">
        <span style="color: red;">${book.user.userName}</span> read
        <span style="color: purple;">${book.title}</span> by
        <span style="color: green;">${book.author}</span>.
      </p>
    </c:when>
    <c:otherwise>
      <p style="font-weight: bold;">
        <span style="color: red;">${book.user.userName}</span> read
        <span style="color: purple;">${book.title}</span> by
        <span style="color: green;">${book.author}</span>.
      </p>
    </c:otherwise>
  </c:choose>

  <p class="font-weight-bold">Here are ${book.user.userName}'s thoughts:</p>
  <blockquote class="thoughts-style">
    ${book.thoughts}
  </blockquote>

  <c:if test="${book.user.equals(user)}">
    <div class="d-flex justify-content-end">
      <a href="/books/${book.id}/edit" class="btn btn-primary me-2">Edit</a>
      <form:form action="/books/${book.id}/delete" method="delete">
        <button type="submit" class="btn btn-danger">Delete</button>
      </form:form>
    </div>
  </c:if>
</div>
</body>
</html>