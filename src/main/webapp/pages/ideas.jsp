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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <title>Top Ideas</title>
</head>
<body>
    <h1>Toutes les idées</h1>
    <c:forEach items="${ideas}" var="idea" varStatus="variableStatus">
        <article>
            <h2>${idea.title}</h2>
            <p>${idea.description}</p>
            <p>${idea.date}</p>
            <c:if test="${idea.image}">
                <img src="${idea.image}" />
            </c:if>
            <p>${idea.author}</p>
            <p>${idea.category}</p>
        </article>

    </c:forEach>
</body>
</html>
