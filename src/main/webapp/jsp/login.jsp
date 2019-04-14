<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>email page</title>

</head>
<body>

        <h1>email</h1>
        <br/>


        <c:if test="${param.dataInvalid == true}">
            <p>Invalid input. Check your input data is correct, please.</p>
        </c:if>
        <c:if test="${param.userExist == false}">
            <p>No such user exist in database.</p>
        </c:if>



        <form method="post" action="${pageContext.request.contextPath}/login">

            <input type="text" name="email"><br/>
            <input type="password" name="password"><br/><br/>
            <input class="button" type="submit" value="Войти">

        </form>
        <br/>
        <a href="${pageContext.request.contextPath}/home">На головну</a>

</body>
</html>