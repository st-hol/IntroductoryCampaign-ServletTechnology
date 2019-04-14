<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Stas
  Date: 14/04/19
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Index</title>

    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/image/book22px.png">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/libs/slick/slick.css"/>
    <%--<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>--%>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/libs/slick/slick-theme.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/libs/animate.min.css">
    <meta name="keywords" content="">
    <meta name="description" content="Introductory campaign">
    <meta name="viewport" content="width=device-width"/>
</head>
<body>

<jsp:include page="navbar.jsp"/>
<br><br><br><br><br>
<h1>Hello USER!</h1>
<BR><BR><BR>

Формируются рейтинговые списки поступивших
<a href="${pageContext.request.contextPath}/introductory-campaign/list-of-enrolled">/list-of-enrolled</a>

<c:forEach var="student" items="${enrolledStudents}">
    <option value="${student.id}"></option>
</c:forEach>



<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
        <th>rating</th>
    </tr>

    <c:forEach var="student" items="${enrolledStudents}">
        <tr>
            <td>${student.id}</td>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>${student.email}</td>
            <td>${student.rating}</td>
        </tr>
    </c:forEach>
</table>




<style>
    table {
        font-family: 'Helvetica Neue Cyr Light', sans-serif;
        font-size: 14px;
        border-radius: 10px;
        border-spacing: 0;
        text-align: center;
    }
    th {
        background: #BCEBDD;
        color: white;
        text-shadow: 0 1px 1px #2D2020;
        padding: 10px 20px;
    }
    th, td {
        border-style: solid;
        border-width: 0 1px 1px 0;
        border-color: white;
    }
    th:first-child, td:first-child {
        text-align: left;
    }
    th:first-child {
        border-top-left-radius: 10px;
    }
    th:last-child {
        border-top-right-radius: 10px;
        border-right: none;
    }
    td {
        padding: 10px 20px;
        background: #F8E391;
    }
    tr:last-child td:first-child {
        border-radius: 0 0 0 10px;
    }
    tr:last-child td:last-child {
        border-radius: 0 0 10px 0;
    }
    tr td:last-child {
        border-right: none;
    }

</style>

<a href="${pageContext.request.contextPath}/introductory-campaign/logout">Logout</a>
<a href="${pageContext.request.contextPath}/introductory-campaign/home">home</a>
<BR><BR><BR>
Формируются рейтинговые списки поступивших
<a href="${pageContext.request.contextPath}/introductory-campaign/list-of-enrolled">/list-of-enrolled</a>
</body>
</html>