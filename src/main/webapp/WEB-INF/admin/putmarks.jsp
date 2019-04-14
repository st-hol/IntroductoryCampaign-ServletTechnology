<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Stas
  Date: 14/04/19
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



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
