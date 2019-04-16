<%--
  Created by IntelliJ IDEA.
  User: Stas
  Date: 15/04/19
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/introductory-campaign/home">
    <svg height="0.8em" width="0.8em" viewBox="0 0 2 1" preserveAspectRatio="none">
        <polyline
                fill="none"
                stroke="#777777"
                stroke-width="0.1"
                points="0.9,0.1 0.1,0.5 0.9,0.9"
        />
    </svg> Home
</a>
<div class="background-wrapper">
    <h1 id="visual">404</h1>
</div>

<p>The page you’re looking for does not exist.</p>



<style>
    @import url("https://fonts.googleapis.com/css?family=Eczar:800");
    @import url("https://fonts.googleapis.com/css?family=Poppins:600");
    body {
        font-family: "Poppins";
        height: 100vh;
        background: #121212;
        padding: 1em;
        overflow: hidden;
    }

    .background-wrapper {
        position: relative;
        width: 100%;
        height: 100%;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
    }
    .background-wrapper h1 {
        position: absolute;
        top: 50%;
        left: 50%;
        -webkit-transform: translate(-50%, -50%) rotate(-45deg);
        transform: translate(-50%, -50%) rotate(-45deg);
        font-family: "Eczar";
        font-size: 60vmax;
        color: #282828;
        letter-spacing: 0.025em;
        margin: 0;
        transition: 750ms ease-in-out;
    }

    a {
        border: 2px solid #555;
        padding: 0.5em 0.8em;
        position: fixed;
        z-index: 1;
        color: #555;
        text-decoration: none;
        display: flex;
        align-items: center;
        transition: 150ms;
    }
    a svg > polyline {
        transition: 150ms;
    }
    a:hover {
        color: #333;
        background: #dadada;
        border-color: transparent;
    }
    a:hover svg > polyline {
        stroke: #000;
    }
    a:hover + .background-wrapper > h1 {
        color: #dadada;
    }

    p {
        color: #dadada;
        font-size: calc(1em + 3vmin);
        position: fixed;
        bottom: 1rem;
        right: 1.5rem;
        margin: 0;
        text-align: right;
        text-shadow: -1px -1px 0 #121212, 1px 1px 0 #121212, -1px 1px 0 #121212, 1px -1px 0 #121212;
    }
    @media screen and (min-width: 340px) {
        p {
            width: 70%;
        }
    }
    @media screen and (min-width: 560px) {
        p {
            width: 50%;
        }
    }
    @media screen and (min-width: 940px) {
        p {
            width: 30%;
        }
    }
    @media screen and (min-width: 1300px) {
        p {
            width: 25%;
        }
    }

</style>

<script>
    const visual = document.getElementById("visual")
    const events = ['resize', 'load']

    events.forEach(function(e){
        window.addEventListener(e, function(){
            const width = window.innerWidth
            const height = window.innerHeight
            const ratio = 45 / (width / height)
            visual.style.transform = "translate(-50%, -50%) rotate(-" + ratio + "deg)"
        });
    });

</script>
</body>
</html>