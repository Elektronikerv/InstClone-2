<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="/resources/css/page.css"/>
  <title>InstClone | ${user.login}</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container-fluid">
<div>
  <div class="row">
    <div class="col-md-2">
        <img class="img-circle" src="data:image/jpeg;base64,${user.avatar}"
         title="change avatar" height="150" width="150"  hspace="20" vspace="20">
    </div>
    <div class="row" style="margin-left: 50px; margin-top: 75px">
      <div class="col-md-2">
      <h2>${user.login}</h2>
        </div>
      <div class="col-md-4" style="margin-top: 20px">
        <h4>
          Photos: ${fn:length(user.images)}
          Followers: <a href="/user/list/${user.id}/followers">${fn:length(user.followers)}</a>
          Following: <a href="/user/list/${user.id}/following">${fn:length(user.following)}</a>
        </h4>
      </div>
    </div>
  </div>
</div>
  <div>
    <a href="/user/update">Edit profile</a>
  </div>
<c:if test="${currentUser.id eq user.id}">
  <form action="/addImage" class="form-inline" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <input type="file"  name="newImage" id="newImage" accept="image/*"/>
      <input class="btn btn-default" type="submit" value="add"/>
    </div>
  </form>
</c:if>

<c:if test="${currentUser.id ne user.id}">
  <br/>
  <form action="/user/${type}/${user.id}">
    <input class="btn btn-info" type="submit" value="${type}"/>
  </form>
</c:if>
  <c:forEach items="${user.images}" var="image">
    <a href="/image/${image.id}">
      <img src="data:image/jpeg;base64,${image.content}" height="300" width="300"/>
    </a>
  </c:forEach>
  </div>
</body>
</html>