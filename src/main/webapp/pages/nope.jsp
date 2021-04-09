<%--
  Created by IntelliJ IDEA.
  User: johannajato
  Date: 19/03/2021
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nope !</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
    <div class="form-box">
        <h1>Impossible de faire ca...</h1>
        <p>${message}</p>
        <a href="/TopIdea-1.0-SNAPSHOT/home">Retour à l'accueil</a>
    </div>
</body>
</html>
