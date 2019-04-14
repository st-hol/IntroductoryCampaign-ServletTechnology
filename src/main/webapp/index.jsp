<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/image/book22px.png">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/libs/slick/slick.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/libs/slick/slick-theme.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/libs/animate.min.css">
        <meta name="keywords" content="">
        <meta name="description" content="Introductory campaign">
        <meta name="viewport" content="width=device-width" />
    </head>
    <body>

    <ul class="topnav" id="myTopnav">
        <li id="log-li"><a href="#top" class="activeMenuItem" id="log"><img src="${pageContext.request.contextPath}/image/book35x35_rev.png"></a></li>
        <li><a href="#about">Universities programs</a></li>
        <li><a href="#best" >Required to do</a></li>
        <li><a href="#team" >Service role</a></li>
        <!-- 				      <li><a href="#wins" >s</a></li> -->


        <li class="contact-us"><a href="${pageContext.request.contextPath}/login.jsp" >Sign in</a></li>
        <li class="my-nav-soc-li">
            <a href="#"><img class="soc-icon" src="${pageContext.request.contextPath}/image/locale/eng.png"></a>
            <a href="#"><img class="soc-icon" src="${pageContext.request.contextPath}/image/locale/ukr.png"></a>
        </li>

        <li class="icon"><a href="javascript:void(0);" style="font-size:15px; margin: 0px; padding: 0px; padding-top: 8px;" onclick="myFunction()">
            <img style="width: 37px; color: white;" src="${pageContext.request.contextPath}/image/share/menu-white.png"><!-- &#9776; --></a></li>
    </ul>


    <section class="page1">
        <a name="top"></a>
        <div class="wraper">
            <div id="bgndVideo" class="player"
                 data-property="{
				videoURL: 'https://www.youtube.com/watch?v=kkOhi5TCuoM',
				containment: '.page1',
				autoPlay:true,
				mute:true,
				startAt:0,
				opacity:1
			}" ></div>


            <div class="logo-div">
                <p class="exc wow zoomInLeft">Introductory</p>
                <p class="wow zoomInRight">Campaign</p>
            </div>

        </div>
        <br><br><br><br><br><br><br><br><br><br><br><br>


        <h1 class="some-text wow bounceInDown" data-wow-delay="1s">
            go through the exams and enter the desired university! &nbsp;
        </h1>
        <br>
        <a href="${pageContext.request.contextPath}/registration.jsp"><button class="sign-up wow bounceInUp" data-wow-delay="1.5s">Sign up!</button></a>


    </section>

    <section class="page2">
        <a name="about"></a>
        <h2 class="about-title wow slideInDown">list of specialties</h2>
        <img src="${pageContext.request.contextPath}/image/line-gray.jpg" class="line-gray">


        <div class="about-cont">
            <div class="abouts">
                <div class="about-item wow slideInUp" data-wow-delay="0.5s" >
                    <ul>
                        <li>121 Software Engineering</li>
                        <li>122 Computer Science</li>
                        <li>124 System Analysis</li>
                        <li>101 Ecology</li>
                    </ul>
                </div>
            </div>
        </div>



    </section>

    <section class="page3">
        <a name="best"></a>
        <hr>
        <h2 class="why-title wow slideInDown">Required to do</h2>
        <img src="${pageContext.request.contextPath}/image/line-gray.jpg" class="line-why">
        <br>
        <div class="why_container">
            <div class="whyes">
                <div class="why_item wow zoomInLeft" data-wow-delay="1s">
                    <a href="#" class="container-img animated infinite pulse"><img class="why-images" src="${pageContext.request.contextPath}/image/why/44.png" alt=""/></a>
                    <p class="svg-title">registrate for exams</p>
                </div>

                <div class="why_item wow zoomInLeft" data-wow-delay="2s">
                    <a href="#" class="container-img animated infinite pulse"><img class="why-images" src="${pageContext.request.contextPath}/image/why/33.png" alt=""/></a>
                    <p class="svg-title">choose speciality</p>
                </div>

                <div class="why_item wow zoomInRight" data-wow-delay="3s">
                    <a href="#" class="container-img animated infinite pulse" ><img class="why-images" src="${pageContext.request.contextPath}/image/why/66.png" alt=""/></a>

                    <p class="svg-title">wait for result</p>
                </div>
            </div>
        </div>

    </section>


    <section class="page3-4">
        <a name="team"></a>
        <!-- <hr> -->
        <h2 class="person-title wow slideInDown">Service roles</h2>
        <img src="${pageContext.request.contextPath}/image/line-gray.jpg" class="line-why">
        <div class="person-cont">

            <div class="one-time-slider wow zoomIn" data-wow-delay="0.7s">

                <div class="person-item wow fadeInUp" data-wow-delay="0.5s">
                    <img src="${pageContext.request.contextPath}/image/person/p3.png" class="person-item-img">
                    <p class="person-item-p"><strong>ADMIN</strong> - puts grades for items.</p>
                </div>
                <div class="person-item wow fadeInUp" data-wow-delay="1.5s">
                    <img src="${pageContext.request.contextPath}/image/person/p1.png" class="person-item-img">
                    <p class="person-item-p"><strong>GUEST</strong> - not authorized user.</p>
                </div>
                <div class="person-item wow fadeInUp" data-wow-delay="1.5s">
                    <img src="${pageContext.request.contextPath}/image/person/p2.png" class="person-item-img">
                    <p class="person-item-p"><strong>STUDENT</strong> - registers for exams.</p>
                </div>

            </div>

        </div>

    </section>


    <hr>
    <footer class="clearfix">
        <div class="footerBlock">
            <p class="footerSlogan">
                &#169; Introductory Campaign
                since 2019
            </p>
            <div class="share">
                <button class="shareBtn"><img class="shareIcon" src="${pageContext.request.contextPath}/image/icons/005-facebook.png"/></button>
                <button class="shareBtn"><img class="shareIcon" src="${pageContext.request.contextPath}/image/icons/004-vk.png"/></button>
                <button class="shareBtn"><img class="shareIcon" src="${pageContext.request.contextPath}/image/icons/002-twitter.png"/></button>
                <button class="shareBtn"><img class="shareIcon" src="${pageContext.request.contextPath}/image/icons/001-google-plus.png"/></button>
                <button class="shareBtn"><img class="shareIcon" src="${pageContext.request.contextPath}/image/icons/003-youtube.png"/></button>
            </div>
            <div class="copyright">subscribe us!</div>
        </div>
    </footer>





    <!-- SCRIPTS -->
    <script src="${pageContext.request.contextPath}/libs/jquery-1.11.2.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/libs/jquery.mask.js"></script>


    <script src="${pageContext.request.contextPath}/libs/wow.min.js"></script>
    <script>
        new WOW().init();
    </script>

    <script src="${pageContext.request.contextPath}/libs/jquery.mb.YTPlayer.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $(".player").mb_YTPlayer();
        });
    </script>



    <script src="${pageContext.request.contextPath}/js/menu.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/libs/jquery-migrate-1.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/libs/slick/slick.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/myscript.js"></script>
    <!-- SCRIPTS -->

    </body>
</html>



<%--<jsp:include page="WEB-INF/guest/header.jsp"/>--%>
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