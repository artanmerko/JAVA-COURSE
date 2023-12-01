<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Costomer Name: <c:out value="${name}"/></h2>
    <h4>Item name: <c:out value="${itemName}"/></h4>
    <h4>Price: <c:out value="${price}"/></h4>
    <h4>Description: <c:out value="${description}"/></h4>
    <h4>Vendor: <c:out value="${vendor}"/></h4>
</body>
</html>
