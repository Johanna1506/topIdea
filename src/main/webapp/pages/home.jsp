<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <title>Top Ideas</title>
</head>
<body>
    <header>
        <h1>Top Idea, top ou flop ?</h1>

    </header>
    <a href="newidea">Soumettre Idée</a>
    <div class="sample-section-wrap">
        <div class="wrapper">
            <div class="header">
                <h1>Tops, les 3 idées les mieux notées</h1>
            </div>
            <c:forEach items="${buzz}" var="idea" varStatus="variableStatus">
                <figure class="featured-image-${idea.id}">
                    <img src="${idea.image}" alt="photo top">
                </figure>
                <article class="article article-${idea.id}">
                    <h2>${idea.title}</h2>
                    <p>${idea.description}</p>
                </article>
                <div class="number-${idea.id}">${idea.id}</div>
            </c:forEach>
        </div>
        <hr/>
        <div class="brains">
            <h2>Brains</h2>
            <p>Les 3 utilisateurs ayant posté le plus d'idées</p>
            <div class="cards-list">
                <c:forEach items="${brains}" var="user" varStatus="variableStatus" end="2">
                    <div class="card 1">
                        <div class="card_image">
                            <img src="https://i.redd.it/b3esnz5ra34y.jpg" />
                        </div>
                        <div class="card_title title-white">
                            <h3>${user.id}</h3>
                            <p>${user.username}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <hr/>
        <div class="wrapper">
            <div class="header">
                <h1>Tops, les 3 idées les plus votées</h1>
            </div>
            <c:forEach items="${buzz}" var="idea" varStatus="variableStatus">
                <figure class="featured-image-${idea.id}">
                    <img src="${idea.image}" alt="photo top">
                </figure>
                <article class="article article-${idea.id}">
                    <h2>${idea.title}</h2>
                    <p>${idea.description}</p>
                </article>
                <div class="number-${idea.id}">${idea.id}</div>
            </c:forEach>
        </div>
    </div>

</body>
</html>