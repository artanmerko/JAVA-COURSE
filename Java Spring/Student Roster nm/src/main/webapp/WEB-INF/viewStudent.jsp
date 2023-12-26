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
    <title><c:out value="${student.name}"/></title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<h1><c:out value="${student.name}"/>'s Classes</h1>
<p><a href="/">Dashboard</a></p>

<form action="/students/${student.id}/add-class" method="post">
    <table>
        <thead>
        <tr>
            <td>
                Classes:
                <select name="courseId" id="courseId" class="input">
                    <c:forEach var="course" items="${availableCourses}">
                        <option value="${course.id}">${course.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td><input class="input" class="button" type="submit" value="Add"/></td>
        </tr>
        </thead>
    </table>
</form>

<hr>

<table>
    <thead>
    <tr>
        <th>Class Name</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="course" items="${assignedCourses}">
        <tr>
            <td><a href="/classes/${course.id}"><c:out value="${course.name}"/></a></td>
            <td><a href="/students/${student.id}/classes/${course.id}/drop">drop</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
