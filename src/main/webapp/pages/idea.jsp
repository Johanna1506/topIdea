<%--
  Created by IntelliJ IDEA.
  User: johannajato
  Date: 09/04/2021
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${idea.title}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ideas.css" />
</head>
<body>
  <h1>${idea.title}</h1>
  <article>
      <div class="thumb" style="background-image: url(${idea.image});"></div>
    <p>${idea.description}</p>
  </article>

  <a href="home" class="home">Retour à l'accueil</a>
  <a href="ideas" class="back">Toutes les idées</a>
</body>
</html>
