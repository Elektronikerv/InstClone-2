<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/page.css"/>
</head>
<body>
<%@include file="navbar.jsp"%>
    <div class="container">
        <div class="col-md-8">
            <img src="data:image/jpeg;base64,${image.content}" height="700" width="700"/>
        </div>
        <div class="col-md-4">
            <h4>Comments will be soon</h4>
            <br>
            <c:if test="${state eq 'liked'}">
                <a href="/image/unlike/${image.id}"><span class="glyphicon glyphicon-heart"/></a>
            </c:if>
            <c:if test="${state eq 'unliked'}">
                <a href="/image/like/${image.id}"><span class="glyphicon glyphicon-heart-empty"/></a>
            </c:if>
            ${fn:length(image.likes)}
        </div>
    </div>
</body>
</html>
