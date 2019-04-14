<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

  <meta charset="utf-8">
  <title>Registration</title>
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
    <div class="form-cont-items">
      <div class="form-item form-text-left wow zoomInLeft" data-wow-delay="1s">
        <h3>Strong password contains:</h3>
        <ul class="must-do">
          <li>A-Z</li>
          <li>a-z</li>
          <li>0-9</li>
          <li>special symbols.</li>
          <li>...</li>
          <li>turn your imagination on!</li>
        </ul>


      </div>

      <div class="form-item" id="popupform">
        <h2 class="form-title wow bounce">sign up for free</h2>
        <div class="contee wow flipInY" data-wow-delay="0.5s">

          <c:if test="${param.dataInvalid == true}">
            <p style="color: orange">Invalid input. Check your input data is correct, please.</p>
          </c:if>
          <c:if test="${param.success == true}">
            <p style="color: green">Your account was successfully registered!</p>
          </c:if>

          <form class="form" method="post" action="${pageContext.request.contextPath}/introductory-campaign/registration">

            <input id="login" type="text" name="email" placeholder="email" required/>

            <input id="password" type="password" name="password" placeholder="password" required/>

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


            <div class="form-btn-wrap"><input class="button" type="submit" value="register me!"></div>


            <!--                         <p class="conf-p">Оформляя запрос, вы соглашаетесь с политикой конфиденциальности и даете
                                        согласие на обработку персональных данных.</p> -->
            <p class="conf-p">By making a request, you agree to the privacy policy and give
              consent to the processing of personal data.</p>
          </form>


          <br/>
          <a href="${pageContext.request.contextPath}/introductory-campaign/home">На головну</a>

        </div>
      </div>


      <div class="form-item form-text-right wow zoomInRight" data-wow-delay="2s">
        <h3>Required to do</h3>
        <ul class="should-do">

          <li>registrate for exams</li>
          <li>choose speciality</li>
          <li>wait for result</li>
        </ul>

        <div class="inform"></div>
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