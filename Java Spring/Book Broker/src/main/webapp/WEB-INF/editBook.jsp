<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/18/2023
  Time: 7:49 AM
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
  <title>Book Share</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
  <h1 class="mb-3">Change your entry</h1>
  <a href="/home" class="btn btn-secondary mb-3">Back to the shelves</a>

  <%--@elvariable id="bookEdit" type="javax"--%>
  <form:form method="put" action="/books/${bookEdit.id}/update" modelAttribute="bookEdit" class="mb-3">

    <div class="mb-3">
      <form:label path="title" class="form-label">Title:</form:label>
      <form:input path="title" class="form-control"></form:input>
      <form:errors path="title" class="text-danger"></form:errors>
    </div>
    <div class="mb-3">
      <form:label path="author" class="form-label">Author:</form:label>
      <form:input path="author" class="form-control"></form:input>
      <form:errors path="author" class="text-danger"></form:errors>
    </div>
    <div class="mb-3">
      <form:label path="thoughts" class="form-label">My thoughts:</form:label>
      <form:textarea path="thoughts" class="form-control" rows="3"></form:textarea>
      <form:errors path="thoughts" class="text-danger"></form:errors>
    </div>
    <button type="submit" class="btn btn-info">Submit</button>
  </form:form>
</div>
</body>
</html>