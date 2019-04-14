<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>

    <meta charset="utf-8">
    <title>Introductory campaign</title>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/image/book22px.png">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/libs/slick/slick.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/libs/slick/slick-theme.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/libs/animate.min.css" type="text/css">
    <meta name="keywords" content="">
    <meta name="description" content="Introductory campaign">
    <meta name="viewport" content="width=device-width" />
</head>

<body>
<section class="page5">
    <a name="form"></a>
    <div class="form-cont">
        <div class="form-cont-items">
            <%--<div class="form-item form-text-left wow zoomInLeft" data-wow-delay="1s">--%>
                <%--<h3>Student account:</h3>--%>
                <%--<ul class="should-do">--%>
                    <%--<li>stud</li>--%>
                    <%--<li>123</li>--%>
                <%--</ul>--%>
                <%--<h3>Admin account:</h3>--%>
                <%--<ul class="should-do">--%>
                    <%--<li>admin</li>--%>
                    <%--<li>111</li>--%>
                <%--</ul>--%>
            <%--</div>--%>

            <div class="form-item" id="popupform">
                <h2 class="form-title wow bounce">sign in to your account</h2>
                <div class="contee wow flipInY" data-wow-delay="0.5s">

                    <c:if test="${param.dataInvalid == true}">
                        <p style="color: orange">Invalid input. Check your input data is correct, please.</p>
                    </c:if>
                    <c:if test="${param.userExist == false}">
                        <p style="color: darkred">No such user exist in database.</p>
                    </c:if>


                    <form class="form" method="post" id="form-feedback" action="${pageContext.request.contextPath}/introductory-campaign/login">
                        <input id="login" type="text" name="email" placeholder="email" required/>

                        <input id="password" type="password" name="password" placeholder="password" required/>

                        <div class="form-btn-wrap"><input class="button" type="submit" value="log in"></div>

                        <!--<p class="conf-p">Оформляя запрос, вы соглашаетесь с политикой конфиденциальности и даете
                                                    согласие на обработку персональных данных.</p> -->
                        <p class="conf-p">By making a request, you agree to the privacy policy and give
                            consent to the processing of personal data.</p>
                    </form>
                    <a href="${pageContext.request.contextPath}/introductory-campaign/home">На головну</a>
                </div>
            </div>



            <%--<div class="form-item form-text-right wow zoomInRight" data-wow-delay="2s">--%>
                <%--<div class="inform"></div>--%>
            <%--</div>--%>
        </div>
    </div>
</section>

<!-- SCRIPTS -->
<script src="${pageContext.request.contextPath}/libs/jquery-1.11.2.min.js"></script>

<script type="${pageContext.request.contextPath}/text/javascript" src="../libs/jquery.mask.js"></script>


<script src="${pageContext.request.contextPath}/libs/wow.min.js"></script>
<script>
    new WOW().init();
</script>
<!-- SCRIPTS -->
</body>
</html>









<%--<html>--%>
<%--<head>--%>
    <%--<title>email page</title>--%>

<%--</head>--%>
<%--<body>--%>

<%--<h1>email</h1>--%>
<%--<br/>--%>


<%--<c:if test="${param.dataInvalid == true}">--%>
    <%--<p>Invalid input. Check your input data is correct, please.</p>--%>
<%--</c:if>--%>
<%--<c:if test="${param.userExist == false}">--%>
    <%--<p>No such user exist in database.</p>--%>
<%--</c:if>--%>



<%--<form method="post" action="${pageContext.request.contextPath}/introductory-campaign/login">--%>

    <%--<input type="text" name="email"><br/>--%>
    <%--<input type="password" name="password"><br/><br/>--%>
    <%--<input class="button" type="submit" value="Войти">--%>

<%--</form>--%>
<%--<br/>--%>
<%--<a href="${pageContext.request.contextPath}/introductory-campaign/home">На головну</a>--%>

<%--</body>--%>
<%--</html>--%>