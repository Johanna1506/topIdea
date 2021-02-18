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
    <title>Soumettre une idée</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
    <div class="form-box">
        <h1>Soumettre une nouvelle idée</h1>
        <form method="post" action="newidea">
            <div>
                <input type="text" name="title" required/>
                <label for="title">Titre</label>
            </div>

            <div>
                <input type="text" name="description" required/>
                <label for="description">Description</label>
            </div>

            <div>
                <select name="category">
                    <c:forEach items="${categories}" var="category" varStatus="variableStatus">
                        <option value=${category.name}>${category.name}</option>
                    </c:forEach>
                </select>
                <label for="category">Selectionner une categorie</label>
            </div>
            <input type="submit" value="Soumettre" />
        </form>

    </div>

</body>
</html>
