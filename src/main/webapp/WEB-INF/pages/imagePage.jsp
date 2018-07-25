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
            <a href="/image/delete/${image.id}"><span class="glyphicon glyphicon-remove"/></a>
        </div>
        <div class="col-md-4">
            <div>
                ${image.description}
            </div>
            <c:if test="${state eq 'liked'}">
                <a href="/image/unlike/${image.id}"><span class="glyphicon glyphicon-heart"/></a>
            </c:if>
            <c:if test="${state eq 'unliked'}">
                <a href="/image/like/${image.id}"><span class="glyphicon glyphicon-heart-empty"/></a>
            </c:if>
            <a href="/image/${image.id}/likesList">
                ${fn:length(image.likes)}
            </a>

        <c:forEach items="${image.comments}" var="comment">
            <div style="border: solid; border-width: 1px; margin: 2px; border-color: #8b8787;">
                    ${comment.text}
                <br>
                <small style="">
                    ${comment.user.login} ${comment.createdOn}
                </small>
            </div>
        </c:forEach>
        <div>
            <form class="form" method="post" action="/image/comment">
                <textarea class="form-control" placeholder="Comment here" name="text"></textarea>

                <input type="text" value="${image.id}" name="id" hidden="true"/>
                <input class="form-control btn btn-success" type="submit" value="Comment" />
            </form>
        </div>
        </div>
    </div>
</body>
</html>
