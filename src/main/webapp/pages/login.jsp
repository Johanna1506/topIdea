<%--
  Created by IntelliJ IDEA.
  User: johannajato
  Date: 19/03/2021
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<div class="form-box">
    <h1>Connectez-vous</h1>
    <form method="POST" action="j_security_check">
        <div>
            <input type="text" name="j_username" id="login" required/>
            <label for="login">Nom d'utilisateur</label>
        </div>

        <div>
            <input type="password" name="j_password" id="pwd" required/>
            <label for="pwd">Mot de passe</label>
        </div>

        <input type="submit" value="Connexion" />
    </form>
    <a href="/TopIdea-1.0-SNAPSHOT/home">Retour à l'accueil</a>
</div>
</body>
</html>
