<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>

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
			}"></div>


        <div class="logo-div">
            <p class="exc wow zoomInLeft"><fmt:message key="label.introductory" /></p>
            <p class="wow zoomInRight"><fmt:message key="label.campaign" /></p>
        </div>

    </div>
    <br><br><br><br><br><br><br><br><br><br><br><br>


    <h1 class="some-text wow bounceInDown" data-wow-delay="1s">
        <fmt:message key="label.go.through.exams" /> &nbsp;
    </h1>
    <br>
    <a href="${pageContext.request.contextPath}/introductory-campaign/reg-me">
    <%--<a href="${pageContext.request.contextPath}/jsp/registration.jsp">--%>
        <button class="sign-up wow bounceInUp" data-wow-delay="1.5s"><fmt:message key="label.sign.up" /></button>
    </a>


</section>

<section class="page2">
    <a name="about"></a>
    <h2 class="about-title wow slideInDown"><fmt:message key="label.list.of.specialties" /></h2>
    <img src="${pageContext.request.contextPath}/image/line-gray.jpg" class="line-gray">


    <div class="about-cont">
        <div class="abouts">
            <div class="about-item wow slideInUp" data-wow-delay="0.5s">
                <ul>
                    <c:forEach var="speciality" items="${specialities}">
                        <li>${speciality.nameSpeciality}</li>
                    </c:forEach>
                    <%--<li>121 Software Engineering</li>--%>
                    <%--<li>122 Computer Science</li>--%>
                    <%--<li>124 System Analysis</li>--%>
                    <%--<li>101 Ecology</li>--%>
                </ul>
            </div>
        </div>
    </div>


</section>

<section class="page3">
    <a name="best"></a>
    <hr>
    <h2 class="why-title wow slideInDown"><fmt:message key="label.to.do" /></h2>
    <img src="${pageContext.request.contextPath}/image/line-gray.jpg" class="line-why">
    <br>
    <div class="why_container">
        <div class="whyes">
            <div class="why_item wow zoomInLeft" data-wow-delay="1s">
                <a href="#" class="container-img animated infinite pulse"><img class="why-images"
                                                                               src="${pageContext.request.contextPath}/image/why/44.png"
                                                                               alt=""/></a>
                <p class="svg-title"><fmt:message key="label.registrate.for.exams" /></p>
            </div>

            <div class="why_item wow zoomInLeft" data-wow-delay="2s">
                <a href="#" class="container-img animated infinite pulse"><img class="why-images"
                                                                               src="${pageContext.request.contextPath}/image/why/33.png"
                                                                               alt=""/></a>
                <p class="svg-title"><fmt:message key="label.choose.speciality" /></p>
            </div>

            <div class="why_item wow zoomInRight" data-wow-delay="3s">
                <a href="#" class="container-img animated infinite pulse"><img class="why-images"
                                                                               src="${pageContext.request.contextPath}/image/why/66.png"
                                                                               alt=""/></a>

                <p class="svg-title"><fmt:message key="label.wait.for.result" /></p>
            </div>
        </div>
    </div>

</section>


<section class="page3-4">
    <a name="team"></a>
    <!-- <hr> -->
    <h2 class="person-title wow slideInDown"><fmt:message key="label.service.roles" /></h2>
    <img src="${pageContext.request.contextPath}/image/line-gray.jpg" class="line-why">
    <div class="person-cont">

        <div class="person-slider wow zoomIn" data-wow-delay="0.7s">

            <div class="person-item" data-wow-delay="0.5s">
                <img src="${pageContext.request.contextPath}/image/person/p3.png" class="person-item-img">
                <p class="person-item-p"><strong><fmt:message key="label.admin" /></strong> - <fmt:message key="label.admin.do"/>.</p>
            </div>
            <div class="person-item" data-wow-delay="1.5s">
                <img src="${pageContext.request.contextPath}/image/person/p1.png" class="person-item-img">
                <p class="person-item-p"><strong><fmt:message key="label.guest" /></strong> - <fmt:message key="label.guest.do"/>.</p>
            </div>
            <div class="person-item" data-wow-delay="1.5s">
                <img src="${pageContext.request.contextPath}/image/person/p2.png" class="person-item-img">
                <p class="person-item-p"><strong><fmt:message key="label.student" /></strong> - <fmt:message key="label.student.do"/>.</p>
            </div>

        </div>

    </div>

</section>


<hr>
<footer class="clearfix">
    <div class="footerBlock">
        <p class="footerSlogan">
            &#169; <fmt:message key="label.introductory" /> <fmt:message key="label.campaign" />
            <fmt:message key="label.since" />
        </p>
        <div class="share">
            <button class="shareBtn"><img class="shareIcon"
                                          src="${pageContext.request.contextPath}/image/icons/005-facebook.png"/>
            </button>
            <button class="shareBtn"><img class="shareIcon"
                                          src="${pageContext.request.contextPath}/image/icons/004-vk.png"/></button>
            <button class="shareBtn"><img class="shareIcon"
                                          src="${pageContext.request.contextPath}/image/icons/002-twitter.png"/>
            </button>
            <button class="shareBtn"><img class="shareIcon"
                                          src="${pageContext.request.contextPath}/image/icons/001-google-plus.png"/>
            </button>
            <button class="shareBtn"><img class="shareIcon"
                                          src="${pageContext.request.contextPath}/image/icons/003-youtube.png"/>
            </button>
        </div>
        <div class="copyright"><fmt:message key="label.subscribe" /></div>
    </div>
</footer>


<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/slick/slick.min.js"></script>


<!-- SCRIPTS -->
<script src="${pageContext.request.contextPath}/libs/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/libs/wow.min.js"></script>
<script>
    new WOW().init();
</script>
<script src="${pageContext.request.contextPath}/libs/jquery.mb.YTPlayer.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $(".player").mb_YTPlayer();
    });
</script>
<script src="${pageContext.request.contextPath}/js/menu.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/libs/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/libs/slick/slick.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myscript.js"></script>
<script src="${pageContext.request.contextPath}/js/menu.js"></script>
<!-- SCRIPTS -->

