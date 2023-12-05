<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ninja Gold Game</title>
    <style>
        .container {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }
        .container .activity {
            text-align: center;
            margin: 0 10px;
        }
        .container .activity form {
            margin-top: 10px;
        }
        textarea {
            width: 100%;
            height: 100px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<h2>Your Gold: <input type="text" name="gold" value="50" readonly></h2>

<div class="container">
    <div class="activity">
        <div>Farm (earns 10-20 gold)</div>
        <form action="/gold/find" method="POST">
            <input type="hidden" name="building" value="farm" />
            <button type="submit">Find Gold!</button>
        </form>
    </div>
    <div class="activity">
        <div>Cave (earns 5-10 gold)</div>
        <form action="/gold/find" method="POST">
            <input type="hidden" name="building" value="cave" />
            <button type="submit">Find Gold!</button>
        </form>
    </div>
    <div class="activity">
        <div>House (earns 2-5 gold)</div>
        <form action="/gold/find" method="POST">
            <input type="hidden" name="building" value="house" />
            <button type="submit">Find Gold!</button>
        </form>
    </div>
    <div class="activity">
        <div>Quest (earns/takes 0-50 gold)</div>
        <form action="/gold/find" method="POST">
            <input type="hidden" name="building" value="quest" />
            <button type="submit">Find Gold!</button>
        </form>
    </div>
</div>

<h3>Activities:</h3>
<textarea readonly>
        <%-- Activities will be appended here by the server-side logic --%>
    <% ArrayList<String> activities = (ArrayList<String>)session.getAttribute("activities");
        if(activities != null){
            for(String activity : activities){
                out.println(activity);
            }
        }
    %>
    </textarea>
</body>
</html>
