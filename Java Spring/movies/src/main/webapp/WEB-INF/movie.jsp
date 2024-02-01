<%--
  Created by IntelliJ IDEA.
  User: Artan
  Date: 12/23/2023
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Movie</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
    .des-style {
        border-top: 2px solid #000;
        border-bottom: 2px solid #000;
        padding: 20px 0;
        font-style: italic;
    }
    .review-section {
        border: 2px solid #ccc;
        padding: 10px;
        margin-top: 5px;
        width: 500px;
        align-items: center;
    }
    .review-user {
        font-weight: bold;
    }
    .review-note {
        margin-top: 10px;
    }
    .review-h{
        padding: 10px;
        margin-top: 20px;
        width: 500px;
        align-items: center;
    }
    .center-align {
        display: flex;
        justify-content: space-around;
        align-items: center;
        flex-direction: row;
    }
    .center-align img,
    .center-align iframe {
        max-width: 200px;
        max-height: 500px;
        width: 100%;
    }
</style>
<body>
<div class="container mt-4">
    <a href="/home" class="btn btn-secondary mb-3">Back to movies</a>
    <h1 class="mb-3">${movies.title}</h1>

    <p>Posted by: ${movies.user.userName}</p>
    <p>Network: ${movies.network}</p>
    <blockquote class="des-style">Description: ${movies.description}</blockquote>
    <div class="center-align">
        <img src="${movies.pictureUrl}" alt="${movies.title} Picture"/>
        <iframe src="https://www.youtube.com/embed/${movies.videoTrailerUrl}" frameborder="0" allowfullscreen style="max-width: 600px; height: 250px; width: 100%;"></iframe>
    </div>
    <c:if test="${movies.user.equals(user)}">
        <div class="d-flex justify-content-end">
            <a href="/movies/${movies.id}/edit" class="btn btn-primary me-2">Edit</a>
            <form:form action="/movies/${movies.id}/delete" method="delete" class="d-inline">
                <button type="submit" class="btn btn-danger">Delete</button>
            </form:form>
        </div>
    </c:if>

    <table class="table table-striped mt-4">
        <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Date</th>
            <th>Time</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ratings}" var="rating">
            <tr>
                <td>${rating.user.userName}</td>
                <td>${rating.score}</td>
                <td><fmt:formatDate value="${rating.createdAt}" pattern="yyyy-MM-dd" /></td>
                <td><fmt:formatDate value="${rating.createdAt}" pattern="HH:mm:ss" /></td>


            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form action="/movies/${movies.id}/rate" method="post" class="mt-4 d-flex align-items-center">
        <label for="score" class="form-label me-2">Leave a Rating:</label>
        <select name="score" id="score" class="form-select me-2" style="width: 70px;">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select>
        <button type="submit" class="btn btn-primary">Rate!</button>
    </form>

    <h4 class="review-h">Reviews</h4>
    <div class="review-section">
        <c:forEach items="${notes}" var="note">
            <div class="review-user">${note.user.userName}</div>
            <div class="review-note">${note.note}</div>
            <div class="review-note text-end pe-2">
                <em><fmt:formatDate value="${note.createdAt}" pattern="yyyy-MM-dd" /></em>
            </div>
        </c:forEach>
    </div>

    <form action="/movies/${movies.id}/note" method="post">
        <div class="form-group mt-4">
            <label for="note">Leave a Review:</label>
            <textarea name="note" id="note" class="form-control" rows="3" style="width: 500px;"></textarea>
        </div>
        <button type="submit" class="btn mt-2 btn-primary">Add Review</button>
    </form>
</div>
</body>
</html>
