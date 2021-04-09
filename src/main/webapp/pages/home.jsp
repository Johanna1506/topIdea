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
    <a href="auth/newidea">Soumettre Idée</a>
    <a href="ideas">Toutes les Idées</a>
    <div class="sample-section-wrap">
        <div class="wrapper">
            <div class="header">
                <h1>Tops, les 3 idées les mieux notées</h1>
            </div>
            <c:set var="count" value="1" scope="page" />
            <c:forEach items="${tops}" var="idea" varStatus="variableStatus" end="2">
                <figure class="featured-image-${count}">
                    <img src="${idea.image}" alt="photo top">
                </figure>
                <article class="article article-${count} />">
                    <h2>${idea.title}</h2>
                    <p>${idea.description}</p>

                    <div>
                        <a href="vote?id=${idea.id}&vote=TOP">
                            <svg viewBox="0 0 512 512" >

                                <path d="M53.333,224C23.936,224,0,247.936,0,277.333V448c0,29.397,23.936,53.333,53.333,53.333h64
                            c12.011,0,23.061-4.053,32-10.795V224H53.333z"/>

                                <path d="M512,304c0-12.821-5.077-24.768-13.888-33.579c9.963-10.901,15.04-25.515,13.653-40.725
                            c-2.496-27.115-26.923-48.363-55.637-48.363H324.352c6.528-19.819,16.981-56.149,16.981-85.333c0-46.272-39.317-85.333-64-85.333
                            c-22.165,0-37.995,12.48-38.677,12.992c-2.517,2.027-3.989,5.099-3.989,8.341v72.341l-61.44,133.099l-2.56,1.301v228.651
                            C188.032,475.584,210.005,480,224,480h195.819c23.232,0,43.563-15.659,48.341-37.269c2.453-11.115,1.024-22.315-3.861-32.043
                            c15.765-7.936,26.368-24.171,26.368-42.688c0-7.552-1.728-14.784-5.013-21.333C501.419,338.731,512,322.496,512,304z"/>
                            </svg>
                        </a>
                        <a href="vote?id=${idea.id}&vote=FLOP">
                            <svg viewBox="0 0 512 512" >

                                <path d="M53.333,224C23.936,224,0,247.936,0,277.333V448c0,29.397,23.936,53.333,53.333,53.333h64
                            c12.011,0,23.061-4.053,32-10.795V224H53.333z"/>

                                <path d="M512,304c0-12.821-5.077-24.768-13.888-33.579c9.963-10.901,15.04-25.515,13.653-40.725
                            c-2.496-27.115-26.923-48.363-55.637-48.363H324.352c6.528-19.819,16.981-56.149,16.981-85.333c0-46.272-39.317-85.333-64-85.333
                            c-22.165,0-37.995,12.48-38.677,12.992c-2.517,2.027-3.989,5.099-3.989,8.341v72.341l-61.44,133.099l-2.56,1.301v228.651
                            C188.032,475.584,210.005,480,224,480h195.819c23.232,0,43.563-15.659,48.341-37.269c2.453-11.115,1.024-22.315-3.861-32.043
                            c15.765-7.936,26.368-24.171,26.368-42.688c0-7.552-1.728-14.784-5.013-21.333C501.419,338.731,512,322.496,512,304z"/>
                            </svg>
                        </a>
                    </div>
                </article>
                <div class="number-${count}">${count}</div>
                <c:set var="count" value="${count + 1}" scope="page"/>
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
                <h1>Buzz, les 3 idées qui ont le plus de votes</h1>
            </div>
            <c:set var="countBuzz" value="1" scope="page" />
            <c:forEach items="${buzz}" var="idea" varStatus="variableStatus" end="2">
                <figure class="featured-image-${countBuzz}">
                    <img src="${idea.image}" alt="photo top">
                </figure>
                <article class="article article-${countBuzz}">
                    <h2>${idea.title}</h2>
                    <p>${idea.description}</p>
                    <div>
                        <a href="vote?id=${idea.id}&vote=TOP">
                            <svg viewBox="0 0 512 512" >

                                <path d="M53.333,224C23.936,224,0,247.936,0,277.333V448c0,29.397,23.936,53.333,53.333,53.333h64
                            c12.011,0,23.061-4.053,32-10.795V224H53.333z"/>

                                <path d="M512,304c0-12.821-5.077-24.768-13.888-33.579c9.963-10.901,15.04-25.515,13.653-40.725
                            c-2.496-27.115-26.923-48.363-55.637-48.363H324.352c6.528-19.819,16.981-56.149,16.981-85.333c0-46.272-39.317-85.333-64-85.333
                            c-22.165,0-37.995,12.48-38.677,12.992c-2.517,2.027-3.989,5.099-3.989,8.341v72.341l-61.44,133.099l-2.56,1.301v228.651
                            C188.032,475.584,210.005,480,224,480h195.819c23.232,0,43.563-15.659,48.341-37.269c2.453-11.115,1.024-22.315-3.861-32.043
                            c15.765-7.936,26.368-24.171,26.368-42.688c0-7.552-1.728-14.784-5.013-21.333C501.419,338.731,512,322.496,512,304z"/>
                            </svg>
                        </a>
                        <a href="vote?id=${idea.id}&vote=FLOP">
                            <svg viewBox="0 0 512 512" >

                                <path d="M53.333,224C23.936,224,0,247.936,0,277.333V448c0,29.397,23.936,53.333,53.333,53.333h64
                            c12.011,0,23.061-4.053,32-10.795V224H53.333z"/>

                                <path d="M512,304c0-12.821-5.077-24.768-13.888-33.579c9.963-10.901,15.04-25.515,13.653-40.725
                            c-2.496-27.115-26.923-48.363-55.637-48.363H324.352c6.528-19.819,16.981-56.149,16.981-85.333c0-46.272-39.317-85.333-64-85.333
                            c-22.165,0-37.995,12.48-38.677,12.992c-2.517,2.027-3.989,5.099-3.989,8.341v72.341l-61.44,133.099l-2.56,1.301v228.651
                            C188.032,475.584,210.005,480,224,480h195.819c23.232,0,43.563-15.659,48.341-37.269c2.453-11.115,1.024-22.315-3.861-32.043
                            c15.765-7.936,26.368-24.171,26.368-42.688c0-7.552-1.728-14.784-5.013-21.333C501.419,338.731,512,322.496,512,304z"/>
                            </svg>
                        </a>
                    </div>

                </article>
                <div class="number-${idea.id}">${idea.id}</div>
                <c:set var="countBuzz" value="${countBuzz + 1}" scope="page"/>
            </c:forEach>
        </div>
    </div>

</body>
</html>