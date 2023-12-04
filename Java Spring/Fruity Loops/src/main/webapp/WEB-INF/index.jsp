<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Fruit Store</title>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
  <div>
    <h3>Fruit Store</h3>
    <table class="table">
      <thead>
        <tr>
          <th>Name</th>
          <th>Price</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="fruit" items="${fruits}">
          <tr>
            <td>${fruit.name}</td>
            <td>${fruit.price}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>
