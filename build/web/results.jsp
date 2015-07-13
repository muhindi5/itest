<%-- 
    Document   : results
    Created on : Jul 12, 2015, 12:43:46 PM
    Author     : kelli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iTest Results</title>
        <link href="style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <%@include  file="header.jsp" %>
        <div class="test-block">
            <form>
                
                <c:set var="counter" value="0" scope="page"/>
                <c:forEach items="${questions}" var="current">
                    <c:set var="counter"  value="${counter + 1}" scope="page"/>
                <div class="q_sec">
                    <strong>${current.question}</strong>
                    <div id="q-spacer"></div>
                    
                    
                    <!--for each option of this question.
                    output each option and set the selected one-->
                    <input type="radio" name="option${counter}" value="A" disabled="true" >&nbsp;&nbsp;${current.option1}&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="option${counter}" value="B" disabled="true" >&nbsp;&nbsp;${current.option2}&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="option${counter}" value="C" disabled="true" >&nbsp;&nbsp;${current.option3}&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="option${counter}" value="D" disabled="true">&nbsp;&nbsp;${current.option4}&nbsp;&nbsp;&nbsp;&nbsp;
                    <!--<input type="radio" name="option${counter}" value="E">&nbsp;&nbsp;${current.option5}&nbsp;&nbsp;&nbsp;&nbsp;-->
                    
                    <!--marking status goes here-->
                    <%--<c:out value="${results[counter-1].answerStatus}"></c:out>--%>
                    <c:choose>
                        <c:when test="${results[counter-1].answerStatus==true}">
                                    <div id="mark-correct">correct</div>
                        </c:when>
                        <c:otherwise>
                                    <div id="mark-wrong">wrong</div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:forEach>
            </form>
        </div>
        <div class="results-section">
            <div id="head-band">Summary</div>
            <table id="summary">
                <tr>
                    <td>Questions Answered</td><td ><strong>${summary.totalQuestions} </strong></td>
                </tr>
                <tr><td>Wrong Answers</td><td><strong>${summary.wrongScoreCount}</strong></td></tr>
                <tr><td>Correct Answers</td><td><strong>${summary.correctScoreCount}</strong></td></tr>
            </table>
        </div>
    </body>
</html>
