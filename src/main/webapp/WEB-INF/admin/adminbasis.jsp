<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN THE BASIS</title>
</head>
<body>

<h1>Hello ADMIN!</h1>


Администратор выставляет оценки за предметы.
<form method="post" action="${pageContext.request.contextPath}/set-grade">
    <%--ID student:<input type="text" name="idStudent"><br/>--%>

    ID student:
    <select class="custom-select" name="idStudent" required>
        <option value="">Choose student...</option>--%>
        <c:forEach var="student" items="${students}">
            <option value="${student.id}">${student.firstName} ${student.lastName}</option>
        </c:forEach>

    </select>


    <%--ID subject:<input type="text" name="idSubject"><br/>--%>
        ID subject:
        <select class="custom-select" name="idSubject" required>
            <option value="">Choose exam...</option>
            <c:forEach var="exam" items="${exams}">
                <option value="${exam.id}">${exam.examName}</option>
            </c:forEach>
        </select>

    examScore:

        <input type="text" name="examScore"><br/>


    <input class="button" type="submit" value="put a mark">
</form>

<a href="${pageContext.request.contextPath}/introductory-campaign/logout">Logout</a>
<a href="${pageContext.request.contextPath}/introductory-campaign/home">home</a>


<BR><BR><BR>

Формируются рейтинговые списки поступивших
<a href="${pageContext.request.contextPath}/introductory-campaign/list-of-enrolled">/list-of-enrolled</a>

</body>
</html>