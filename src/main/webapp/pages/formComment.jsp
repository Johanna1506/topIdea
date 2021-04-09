<%--
  Created by IntelliJ IDEA.
  User: johannajato
  Date: 16/02/2021
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Commenter</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
    <div class="form-box">
        <h1>Commenter: ${idea.title}</h1>
        <form method="post" action="comment?id=${idea.id}">
            <div>
                <input type="text" name="text" required/>
                <label for="text">Votre commentaire</label>
            </div>
            <input type="submit" value="Soumettre" />
        </form>
    </div>

</body>
</html>
