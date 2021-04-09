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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ideas.css" />
    <title>Top Ideas</title>
</head>
<body>
    <header>
        <h1>Utilisateurs</h1>
    </header>
    <div class="band">
        <c:forEach items="${users}" var="user" varStatus="variableStatus">
            <a href="user?id=${user.id}" class="card">
                <div class="thumb" style="background-image: url(${idea.image});"></div>
                <article>
                    <h1>${user.username}</h1>
                </article>
            </a>
        </c:forEach>
    </div>
    <a href="/TopIdea-1.0-SNAPSHOT/home" class="home">Retour à l'accueil</a>
</body>
</html>
