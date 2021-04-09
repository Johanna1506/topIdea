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
    <h1>Toutes les idées</h1>
</header>
<div class="band">
    <c:forEach items="${ideas}" var="idea" varStatus="variableStatus">
        <div class="item-1">
            <div class="thumb" style="background-image: url(${idea.image});"></div>
            <article>
                <h1>${idea.title}</h1>
                <span>${idea.description}</span>
            </article>
        </div>
    </c:forEach>
    </div>
</div>
</body>
</html>
