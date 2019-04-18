<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="label.enrolled.list" /></title>

    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/image/book22px.png">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/libs/slick/slick.css"/>
    <%--<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>--%>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/libs/slick/slick-theme.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sidebar.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/enrolled-list.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/libs/animate.min.css">

    <meta name="keywords" content="">
    <meta name="description" content="Introductory campaign">
    <meta name="viewport" content="width=device-width"/>
</head>
<body>

<jsp:include page="navbar.jsp"/>


<jsp:include page="sidebar.jsp"/>

<div class="table-container">
<table>
    <tr>
        <th><fmt:message key="label.id" /></th>
        <th><fmt:message key="label.placeholder.firstname" /></th>
        <th><fmt:message key="label.placeholder.lastname" /></th>
        <th><fmt:message key="label.placeholder.email" /></th>
        <th><fmt:message key="label.rating" /></th>
    </tr>

    <c:forEach var="student" items="${enrolledStudents}">
        <tr>
            <td>${student.id}</td>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>${student.email}</td>
            <td><fmt:formatNumber value="${student.rating}" maxFractionDigits="3" /></td>
        </tr>
    </c:forEach>
</table>

</div>



<script type="text/javascript" src="${pageContext.request.contextPath}/js/menu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myscript.js"></script>
</body>
</html>