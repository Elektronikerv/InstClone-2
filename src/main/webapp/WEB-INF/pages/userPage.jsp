<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <div class="col-md-2"><img class="img-circle" src="data:image/jpeg;base64,${user.avatar}"
         title="change avatar" height="150" width="150"  hspace="20" vspace="20">
  </div>
    <div class="col-md-1 col-offset-3 name">
    <h2>${user.login}</h2></div>
  </div>
</div>

<form action="/addImage" class="form-inline" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <input type="file"  name="newImage" id="newImage" accept="image/*"/>
    <input class="btn btn-default" type="submit" value="add"/>
  </div>
</form>

  <c:forEach items="${user.images}" var="image">
    <img src="data:image/jpeg;base64,${image.content}" height="300" width="300"/>
  </c:forEach>
  </div>
</body>
</html>