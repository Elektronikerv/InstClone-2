<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="/resources/css/page.css" />
  <title>InstClone | ${user.login}</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container-fluid">
  <div class="row">
    <div class="col-md-2">
        <img class="img-circle" src="data:image/jpeg;base64,${user.avatar}"
         title="avatar">
    </div>
    <div  style="margin-top: 50px">
      <div class="col-md-2">
      <h2>${user.login}</h2>
        </div>
      <div class="col-md-offset-1 col-md-3 text-center" style="margin-top: 20px">
        <h4>
          Photos: ${fn:length(user.images)}
          Followers: <a href="/user/list/${user.id}/followers">${fn:length(user.followers)}</a>
          Following: <a href="/user/list/${user.id}/following">${fn:length(user.following)}</a>
        </h4>
        <c:if test="${currentUser.id ne user.id}">
          <form action="/user/${type}/${user.id}">
            <input class="btn btn-info form-control" type="submit" value="${type}"/>
          </form>
        </c:if>
      </div>
    </div>
  </div>
  </div>

  <c:forEach items="${user.images}" var="image">
    <a href="/image/${image.id}">
      <img class="image-page" src="data:image/jpeg;base64,${image.content}" style=""/>
    </a>
  </c:forEach>
</body>
</html>