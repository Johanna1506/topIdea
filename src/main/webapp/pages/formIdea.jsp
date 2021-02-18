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
</head>
<body>
    <h1>Soumettre une nouvelle idée</h1>
    <form method="post" action="newidea">
        <label for="title">Titre de l'idée :</label>
        <input type="text" name="title"/>

        <label for="description">Description de votre idée</label>
        <input type="text" name="description"/>

        <label for="category">Selectionner une categorie</label>
        <select name="category">
            <c:forEach items="${categories}" var="category" varStatus="variableStatus">
                <option value=${category.name}>${category.name}</option>
            </c:forEach>
        </select>

        <input type="submit" value="Soumettre" />

    </form>
</body>
</html>
