<%--
  Created by IntelliJ IDEA.
  User: johannajato
  Date: 18/02/2021
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validation</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
    <div class="form-box">
        <h1>Votre vote a bien été pris en compte</h1>
        <a href="idea?id=${idea.id}">Retour à l'idée</a>
        <a href="comment?id=${idea.id}">Commenter cette idée</a>
    </div>

</body>
</html>
