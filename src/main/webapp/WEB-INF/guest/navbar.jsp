<%--
  Created by IntelliJ IDEA.
  User: Stas
  Date: 13/04/19
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<ul class="topnav" id="myTopnav">
    <li id="log-li"><a href="#top" class="activeMenuItem" id="log"><img
            src="${pageContext.request.contextPath}/image/book35x35_rev.png"></a></li>
    <li><a href="#about">Universities programs</a></li>
    <li><a href="#best">Required to do</a></li>
    <li><a href="#team">Service role</a></li>
    <!-- 				      <li><a href="#wins" >s</a></li> -->


    <li class="contact-us"><a href="${pageContext.request.contextPath}/jsp/login.jsp">Sign in</a></li>
    <li class="my-nav-soc-li">
        <a href="#"><img class="soc-icon" src="${pageContext.request.contextPath}/image/locale/eng.png"></a>
        <a href="#"><img class="soc-icon" src="${pageContext.request.contextPath}/image/locale/ukr.png"></a>
    </li>

    <li class="icon"><a href="javascript:void(0);" style="font-size:15px; margin: 0px; padding: 0px; padding-top: 8px;"
                        onclick="myFunction()">
        <img style="width: 37px; color: white;" src="${pageContext.request.contextPath}/image/share/menu-white.png">
        <!-- &#9776; --></a></li>
</ul>
