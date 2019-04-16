<%--
  Created by IntelliJ IDEA.
  User: Stas
  Date: 15/04/19
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>


<aside class="sidebar">
    <nav class="nav">
        <ul>
            <li class="active"><a href="#">${sessionScope.role}:</a></li>
            <li><a href="${pageContext.request.contextPath}/introductory-campaign/reg-exam"><fmt:message key="label.reg.for.exams"/></a></li>
            <li><a href="${pageContext.request.contextPath}/introductory-campaign/apply-admission"><fmt:message key="label.apply.adm"/></a></li>
            <li><a href="${pageContext.request.contextPath}/introductory-campaign/list-of-enrolled"><fmt:message key="label.enrolled.list"/></a></li>
            <li><a href="${pageContext.request.contextPath}/introductory-campaign/home"><fmt:message key="label.to.main"/></a></li>
            <li><a href="${pageContext.request.contextPath}/introductory-campaign/logout"><fmt:message key="label.logout"/></a></li>
        </ul>
    </nav>
</aside>

<style>

    .sidebar {
        top: 82px;
        position: fixed;
        width: 25%;
        height: 100vh;
        background: orange;
        font-size: 0.45em;
    }

    .nav {
        position: relative;
        /*margin: 0 15%;*/
        text-align: right;
        top: 30%;
        -webkit-transform: translateY(-50%);
        transform: translateY(-50%);
        font-weight: bold;
    }

    .nav ul {
        list-style: none;
    }
    .nav ul li {
        position: relative;
        margin: 3.2em 0;
    }
    .nav ul li a {
        font-size: 14px;

        line-height: 200%;
        /*line-height: 5em;*/
        text-transform: uppercase;
        text-decoration: none;
        letter-spacing: 0.4em;
        color: rgba(255, 255, 255, 0.35);
        display: block;
        transition: all ease-out 300ms;
    }
    .nav ul li.active a {
        color: white;
        text-shadow: #2D2020 2px 2px 5px;
    }
    .nav ul li:not(.active)::after {
        opacity: 0.2;
    }
    .nav ul li:not(.active):hover a {
        color: rgba(255, 255, 255, 0.75);
    }
    .nav ul li::after {
        content: '';
        position: absolute;
        width: 100%;
        height: 0.2em;
        background: black;
        left: 0;
        bottom: 0;
        background-image: linear-gradient(to right, darkorange, lightyellow);
    }

</style>


