<%-- 
    Document   : tester
    Created on : Jul 10, 2015, 2:21:35 PM
    Author     : kelli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iTest Demo</title>
        <link href="style.css" type="text/css" rel="stylesheet"/>
        <script>
var seconds = 30;
function minutesPassed() {
    var minutes = Math.round((seconds - 30)/60);
    var remainingSeconds = seconds % 60;
    if (remainingSeconds < 10) {
        remainingSeconds = "0" + remainingSeconds;  
    }
    document.getElementById('timer-lbl').innerHTML = minutes + ":" + remainingSeconds;
    if (seconds == 0) {
        clearInterval(countdownTimer);
        document.getElementById('timer-lbl').innerHTML = "Your time is up";
    } else {
        seconds--;
    }
}
 
var countdownTimer = setInterval('minutesPassed()', 1000);
</script>
    </head>
    <body>
        <%@include  file="header.jsp" %>
        <div class="test-block">
            <form action="processor" method="POST">
                
                <c:set var="counter" value="0" scope="page"/>
                <c:forEach items="${questions}" var="current">
                    <c:set var="counter"  value="${counter + 1}" scope="page"/>
                <div class="q_sec">
                    <strong>${current.question}</strong>
                    <div id="q-spacer"></div>
                    <input type="radio" name="option${counter}" value="A">&nbsp;&nbsp;${current.option1}&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="option${counter}" value="B">&nbsp;&nbsp;${current.option2}&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="option${counter}" value="C">&nbsp;&nbsp;${current.option3}&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="option${counter}" value="D">&nbsp;&nbsp;${current.option4}&nbsp;&nbsp;&nbsp;&nbsp;
                    <!--<input type="radio" name="option${counter}" value="E">&nbsp;&nbsp;${current.option5}&nbsp;&nbsp;&nbsp;&nbsp;-->
                </div>
            </c:forEach>
                <input type="submit" value="Submit Exam"/>
            </form>
        </div>
        <div class="timer-sec">
            <div id="head-band">Instructions</div>
            <ol id="timer-sec">
                <li> Number of questions in test: <strong>5</strong></li>
            <li>Time alloted for test: <strong>2 minutes.</strong></li>
            <li>Each question carries 1 mark.</li>
            <li>Test will be submitted automatically after expiry of allocated time.</li>
            <li>The page should not be refreshed.</li>
            </ol>
            <label id="timer-lbl"></label>
        </div>
    </body>
</html>
