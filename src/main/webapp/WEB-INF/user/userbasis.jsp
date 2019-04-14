<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

Студент регистрируется на сдачу предметов.
<form method="post" action="${pageContext.request.contextPath}/registrate-for-exam">
    <%--<input type="text" name="examId"><br/>--%>

        <select class="custom-select" name="examId" required>
            <option value="">Choose exam...</option>
            <c:forEach var="exam" items="${exams}">
                <option value="${exam.id}">${exam.examName}</option>
            </c:forEach>
        </select>


    <input class="button" type="submit" value="reg for exam">
</form>

<br>
<br>
Студент выбирает специальность в университете.
<form method="post" action="${pageContext.request.contextPath}/introductory-campaign/apply-for-admission">

        <select class="custom-select" name="idSpeciality" required>
            <option value="">Choose speciality...</option>--%>
        <c:forEach var="speciality" items="${specialities}">
            <option value="${speciality.id}">${speciality.nameSpeciality}</option>
        </c:forEach>

        </select>
        <input class="button" type="submit" value="application">
</form>



<%--<jsp:include page="enrolledlist.jsp"/>--%>

<a href="${pageContext.request.contextPath}/introductory-campaign/logout">Logout</a>
<a href="${pageContext.request.contextPath}/introductory-campaign/home">home</a>
<BR><BR><BR>
Формируются рейтинговые списки поступивших
<a href="${pageContext.request.contextPath}/introductory-campaign/list-of-enrolled">/list-of-enrolled</a>
</body>
</html>








<%--<select class="custom-select" name="examId" required>--%>
<%--<option value="">Choose exam...</option>--%>
<%--<option value="1">Math</option>--%>
<%--<option value="2">Physics</option>--%>
<%--<option value="3">English</option>--%>
<%--</select>--%>



<%--todo<input type="number" hidden nameSpeciality="id" value="${user.id}" />--%>
<%--<input type="text" name="idSpeciality"><br/>--%>

<%--<select class="custom-select" name="idSpeciality" required>--%>
<%--<option value="">Choose speciality...</option>--%>
<%--<option value="1">1</option>--%>
<%--<option value="2">2</option>--%>
<%--<option value="3">3</option>--%>
<%--<option value="4">4</option>--%>
<%--<option value="5">5</option>--%>
<%--</select>--%>