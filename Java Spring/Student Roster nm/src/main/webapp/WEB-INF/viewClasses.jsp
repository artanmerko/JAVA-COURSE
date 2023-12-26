<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/26/2023
  Time: 4:49 PM
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
    <title>All Classes</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<h1>All Classes</h1>
<p><a href="/">Dashboard</a></p>

<table>
    <thead>
    <tr>
        <th>Class</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td><a href="/classes/${course.id}"><c:out value="${course.name}"/></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
