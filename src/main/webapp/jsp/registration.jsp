<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>registration page</title>

</head>
<body>

<h1>registration</h1><br/>
<form method="post" action="${pageContext.request.contextPath}/registration">

  <c:if test="${param.dataInvalid == true}">
    <p>Invalid input. Check your input data is correct, please.</p>
  </c:if>
  <input type="text" name="email" required><br/>
  <input type="password" name="password" required><br/><br/>

  <div>
    <%--id--%>
    <select class="custom-select" name="role" required>
      <option value="">Choose role...</option>
      <option value="ADMIN">ADMIN</option>
      <option value="USER">USER</option>
    </select>
  </div>

  <input type="text" name="firstName"><br/>
  <input type="text" name="lastName"><br/>

  <input class="button" type="submit" value="register me!">
</form>

<br/>
<a href="${pageContext.request.contextPath}/home">На головну</a>

</body>
</html>