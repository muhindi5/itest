<%-- 
    Document   : index
    Created on : Jul 9, 2015, 11:02:26 PM
    Author     : kelli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iTest Demo</title>
        <link href="style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <%@include  file="header.jsp" %>
        <div class="test-block">
            <strong>Instructions</strong><br><hr><br>
            <ol style="padding: 20px;">
                <li> Number of questions in test: <strong>20</strong></li>
            <li>Time alloted for test: <strong>10 minutes.</strong></li>
            <li>Each question carries 1 mark.</li>
            <li>Test will be submitted automatically after expiry of allocated time.</li>
            <li>The page should not be refreshed.</li>
            </ol>
            <div id="spacer"></div>
        <a id="btn" href="tester1?rType=start">start test</a>
        </div>
    </body>
</html>
