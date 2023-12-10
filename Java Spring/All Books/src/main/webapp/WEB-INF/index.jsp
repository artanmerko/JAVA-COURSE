<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Books</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Language</th>
        <th>Number of Pages</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td><c:out value="${book.id}" /></td>
            <td><a href="<c:url value='/api/books/${book.id}' />"><c:out value="${book.title}" /></a></td>
            <td><c:out value="${book.language}" /></td>
            <td><c:out value="${book.numberOfPages}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
