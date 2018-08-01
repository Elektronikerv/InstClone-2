<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/imagePage.css"/>
    <title>InstClone</title>
</head>
<body>
<%@include file="navbar.jsp"%>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-7">
                <img src="data:image/jpeg;base64,${image.content}" class="image"/>
            </div>
            <div class="col-md-4">
                <div>
                   <b>${image.user.login}</b>
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
                    <div class="comment">
                        ${comment.text}
                        <br>
                        <small>
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
            <c:if test="${currentUser.id eq image.user.id}">
                <div class="col-md-1">
                    <a href="/image/delete/${image.id}"><span class="glyphicon glyphicon-remove"/></a>
                </div>
            </c:if>
        </div>
    </div>
</body>
</html>
