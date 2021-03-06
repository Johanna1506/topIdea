<%--
  Created by IntelliJ IDEA.
  User: johannajato
  Date: 09/04/2021
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${user.username}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/idea.css" />
</head>
<body>
    <div class="blog-card spring-fever" style="background: url(${idea.image}) center;">
      <div class="title-content">
          <h3>${user.username}</h3>
      </div>
      <div class="utility-info">
          <ul class="utility-list">
              <c:if test="${false==admin}">
                  <c:choose>
                      <c:when test="${false==active}">
                          <li>
                              <a href="update?id=${user.id}&action=activate">
                                  Activer
                              </a>
                          </li>
                      </c:when>
                      <c:when test="${true==active}">
                          <li>
                              <a href="update?id=${user.id}&action=deactivate">
                                  Desactiver
                              </a>
                          </li>
                      </c:when>
                  </c:choose>
                  <li>
                      <a href="update?id=${user.id}&action=suppress">
                          Supprimer
                      </a>
                  </li>
              </c:if>
          </ul>
      </div>
      <div class="gradient-overlay"></div>
      <div class="color-overlay"></div>
    </div>
    <a href="/TopIdea-1.0-SNAPSHOT/home" class="home">Retour à l'accueil <span class="licon icon-arr icon-black"></span></a>
    <a href="dashboard" class="back">Dashboard<span class="licon icon-arr icon-black"></span></a>

</body>
</html>
