<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="commons/head.jsp"%>
</head>
<body>
<h1>Top Idea</h1>
<h2>Flop ou Top ?</h2>

<h2>Tops</h2>
<p>Les 3 idées les mieux notées par la communauté Top Idea</p>
<ul>
    <c:forEach items="${tops}" var="idea" varStatus="variableStatus">
        <li>${idea.title}</li>
    </c:forEach>
</ul>

<h2>Brains</h2>
<p>Les 3 utilisateurs ayant posté le plus d'idées</p>
<ul>
    <c:forEach items="${brains}" var="user" varStatus="variableStatus">
        <li>${user.username}</li>
    </c:forEach>
</ul>

<h2>Buzz</h2>
<p>Les 3 idées ayant obtenu le plus de vote</p>
<ul>
    <c:forEach items="${buzz}" var="idea" varStatus="variableStatus">
        <li>${idea.title}</li>
    </c:forEach>
</ul>


<a href="">Soumettre Idée</a>
</body>
</html>