<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<ul class="topnav" id="myTopnav">
    <li id="log-li"><a href="#top" class="activeMenuItem" id="log"><img
            src="${pageContext.request.contextPath}/image/book35x35_rev.png"></a></li>
    <li><a href="#about">Universities programs</a></li>
    <li><a href="#best">Required to do</a></li>
    <li><a href="#team">Service role</a></li>

    <li class="contact-us">
        <a href="${pageContext.request.contextPath}/introductory-campaign/personal-cabinet">
        <c:out value="[${sessionScope.role}] cabinet"/>
        </a>
    </li>
    <li class="contact-us">
        <a href="${pageContext.request.contextPath}/introductory-campaign/logout">Logout</a>
    </li>



    <li class="my-nav-soc-li">
        <a href="#"><img class="soc-icon" src="${pageContext.request.contextPath}/image/locale/eng.png"></a>
        <a href="#"><img class="soc-icon" src="${pageContext.request.contextPath}/image/locale/ukr.png"></a>
    </li>

    <li class="icon"><a href="javascript:void(0);" style="font-size:15px; margin: 0px; padding: 0px; padding-top: 8px;"
                        onclick="myFunction()">
        <img style="width: 37px; color: white;" src="${pageContext.request.contextPath}/image/share/menu-white.png"></a></li>
</ul>







<%--<% if(request.getParameter("submit1") != null) { %>--%>
<%--<jsp:forward page="adminbasis.jsp"></jsp:forward>--%>
<%--<%   return;   } %>--%>
<%--<form action="index.jsp">--%>
<%--<input type="submit" name="submit1" value="Create Vendor Account">--%>
<%--</form>--%>
