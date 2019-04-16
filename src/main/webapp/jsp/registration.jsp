<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>


<html>
<head>
  <meta charset="utf-8">
  <title><fmt:message key="label.reg" /></title>
  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/image/book22px.png">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/libs/slick/slick.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/libs/slick/slick-theme.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
  <%--<link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css" />" />--%>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/libs/animate.min.css">
  <meta name="keywords" content="">
  <meta name="description" content="Introductory campaign">
  <meta name="viewport" content="width=device-width" />
</head>
<body>


<section class="page5">
  <a name="form"></a>
  <div class="form-cont">


      <div class="form-item" id="popupform">
        <h2 class="form-title wow bounce"><fmt:message key="label.reg.free" /></h2>
        <div class="contee wow flipInY" data-wow-delay="0.5s">

          <c:if test="${param.dataInvalid == true}">
            <p style="color: orange"><fmt:message key="label.invalid.input" /></p>
          </c:if>
          <c:if test="${param.success == true}">
            <p style="color: green"><fmt:message key="label.reg.success" /></p>
          </c:if>

          <form class="reg-form" method="post" action="${pageContext.request.contextPath}/introductory-campaign/registration">

            <input id="login" type="text" name="email" placeholder="<fmt:message key="label.placeholder.email" />" required/>

            <input id="password" type="password" name="password" placeholder="<fmt:message key="label.placeholder.password" />" required/>

            <div>
              <%--id--%>
              <select class="soflow-color" name="role" required>
                <option value=""><fmt:message key="label.choose.role" /></option>
                <option value="ADMIN"><fmt:message key="label.admin" /></option>
                <option value="USER"><fmt:message key="label.student" /></option>
              </select>
            </div>

            <input type="text" name="firstName" placeholder="<fmt:message key="label.placeholder.firstname" />" required><br/>
            <input type="text" name="lastName" placeholder="<fmt:message key="label.placeholder.lastname" />" required> <br/>


            <div class="form-btn-wrap"><input class="button" type="submit" value="<fmt:message key="label.sign.up" />"></div>


            <p class="conf-p"><fmt:message key="label.confid" /></p>
          </form>


          <br/>
          <a href="${pageContext.request.contextPath}/introductory-campaign/home"><fmt:message key="label.to.main" /></a>

        </div>

    </div>
  </div>
</section>

<!-- SCRIPTS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/libs/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/libs/jquery.mask.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/libs/wow.min.js"></script>
<script>
  new WOW().init();
</script>
<!-- SCRIPTS -->















<style>

  .reg-form{
    width: auto;
    max-width: 130%;
  }

  select.soflow-color {
    outline: none;
    -webkit-appearance: button;
    -webkit-border-radius: 2px;
    -webkit-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.1);
    -webkit-padding-end: 20px;
    -webkit-padding-start: 2px;
    -webkit-user-select: none;
    background-image: url(http://i62.tinypic.com/15xvbd5.png), -webkit-linear-gradient(#FAFAFA, #F4F4F4 40%, #E5E5E5);
    background-position: 97% center;
    background-repeat: no-repeat;
    border: 1px solid #AAA;
    color: #555;
    font-size: inherit;
    margin: 20px;
    overflow: hidden;
    padding: 5px 10px;
    text-overflow: ellipsis;
    white-space: nowrap;
    width: 300px;
  }

  select.soflow-color {

    color: #fff;
    background-image: url(http://i62.tinypic.com/15xvbd5.png), -webkit-linear-gradient(orange, orange 30%, orange);
    background-color: orange;
    -webkit-border-radius: 20px;
    -moz-border-radius: 20px;
    border-radius: 20px;
    padding-left: 15px;
  }
</style>
</body>
</html>






<%--<html>--%>
<%--<head>--%>
  <%--<title>registration page</title>--%>

<%--</head>--%>
<%--<body>--%>

<%--<h1>registration</h1><br/>--%>
<%--<form method="post" action="${pageContext.request.contextPath}/registration">--%>

  <%--<c:if test="${param.dataInvalid == true}">--%>
    <%--<p>Invalid input. Check your input data is correct, please.</p>--%>
  <%--</c:if>--%>
  <%--<input type="text" name="email" required><br/>--%>
  <%--<input type="password" name="password" required><br/><br/>--%>

  <%--<div>--%>
    <%--&lt;%&ndash;id&ndash;%&gt;--%>
    <%--<select class="custom-select" name="role" required>--%>
      <%--<option value="">Choose role...</option>--%>
      <%--<option value="ADMIN">ADMIN</option>--%>
      <%--<option value="USER">USER</option>--%>
    <%--</select>--%>
  <%--</div>--%>

  <%--<input type="text" name="firstName"><br/>--%>
  <%--<input type="text" name="lastName"><br/>--%>

  <%--<input class="button" type="submit" value="register me!">--%>
<%--</form>--%>

<%--<br/>--%>
<%--<a href="${pageContext.request.contextPath}/home">На головну</a>--%>

<%--</body>--%>
<%--</html>--%>