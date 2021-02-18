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
<c:forEach items="${tops}" var="tops" varStatus="variableStatus">
    <tr>
    <%--    <td>${article.code}</td>
        <td>${article.nom}</td>
        <td>${article.prix}</td>--%>
    </tr>
</c:forEach>

<h2>Brains</h2>
<p>Les 3 utilisateurs ayant postés le plus d'idées</p>
<c:forEach items="${brains}" var="brain" varStatus="variableStatus">
    <tr>
            <%--    <td>${article.code}</td>
                <td>${article.nom}</td>
                <td>${article.prix}</td>--%>
    </tr>
</c:forEach>

<h2>Buzz</h2>
<p>Les 3 idées ayant obtenu le plus de vote</p>
<c:forEach items="${buzz}" var="buzz" varStatus="variableStatus">
    <tr>
            <%--    <td>${article.code}</td>
                <td>${article.nom}</td>
                <td>${article.prix}</td>--%>
    </tr>
</c:forEach>

<a href="formIdea.jsp">Soumettre Idée</a>
</body>
</html>