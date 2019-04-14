<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER</title>

</head>
<body>

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

    <%--<select class="custom-select" name="examId" required>--%>
        <%--<option value="">Choose exam...</option>--%>
        <%--<option value="1">Math</option>--%>
        <%--<option value="2">Physics</option>--%>
        <%--<option value="3">English</option>--%>
    <%--</select>--%>

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



<a href="${pageContext.request.contextPath}/introductory-campaign/logout">Logout</a>
<a href="${pageContext.request.contextPath}/introductory-campaign/home">home</a>
<BR><BR><BR>
Формируются рейтинговые списки поступивших
<a href="${pageContext.request.contextPath}/introductory-campaign/list-of-enrolled">/list-of-enrolled</a>
</body>
</html>








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