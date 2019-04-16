<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>

<html lang="${cookie['lang'].value}">
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

<c:choose>
    <c:when test="${sessionScope.role == 'ADMIN'}">
        <jsp:include page="../WEB-INF/admin/navbar.jsp"/>
    </c:when>
    <c:when test="${sessionScope.role == 'USER'}">
        <jsp:include page="../WEB-INF/user/navbar.jsp"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="../WEB-INF/guest/navbar.jsp"/>
    </c:otherwise>
</c:choose>


<jsp:include page="../WEB-INF/common/landing.jsp"/>


</body>
</html>





<%--<jsp:include page="WEB-INF/guest/navbar.jsp"/>--%>
<%--&lt;%&ndash;<style>&ndash;%&gt;--%>
<%--&lt;%&ndash;<%@include file='css/style.css' %>&ndash;%&gt;--%>
<%--&lt;%&ndash;</style>&ndash;%&gt;--%>

<%--<h2>--%>
<%--Hello! <br/>--%>
<%--<i>time: <%= getFormattedDate() %></i>--%>
<%--</h2>--%>

<%--<br/>--%>
<%--<a href="${pageContext.request.contextPath}/login.jsp">Please log in</a>--%>
<%--<br>--%>
<%--<a href="${pageContext.request.contextPath}/registration.jsp">reg</a>--%>
<%--<br>--%>

<%--<a href="${pageContext.request.contextPath}/introductory-campaign/show-all-exams">show</a>--%>