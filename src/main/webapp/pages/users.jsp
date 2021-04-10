<%--
  Created by IntelliJ IDEA.
  User: johannajato
  Date: 07/04/2021
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/users.css" />
    <title>Top Ideas</title>
</head>
<body>
<div class="band">
    <h1>Administrateurs</h1>
    <div class="cards-list">
        <c:forEach items="${admins}" var="admin" varStatus="variableStatus">
            <div class="card 1">
                <div class="card_image">
                    <img src="https://i.redd.it/b3esnz5ra34y.jpg" />
                </div>
                <div class="card_title title-white">
                    <h3>${admin.id}</h3>
                    <p><a href="user?id=${user.id}">${admin.username}</a></p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<div class="band">
    <h1>Utilisateurs</h1>
    <div class="cards-list">
        <c:forEach items="${users}" var="user" varStatus="variableStatus">
            <div class="card 1">
                <div class="card_image">
                    <img src="https://i.redd.it/b3esnz5ra34y.jpg" />
                </div>
                <div class="card_title title-white">
                    <h3>${user.id}</h3>
                    <p><a href="user?id=${user.id}">${user.username}</a></p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
    <a href="/TopIdea-1.0-SNAPSHOT/home" class="home">Retour à l'accueil</a>
</body>
</html>
