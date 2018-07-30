
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="/resources/css/page.css"/>
  <link rel="stylesheet" href="/resources/css/mainPage.css">
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container">
  <div class="row">
    <div class="col-md-7 col-md-offset-2">
      <c:if test="${fn:length(images) eq 0}">
        <h1 class="text-center">Follow someone with photos</h1>
      </c:if>
      <c:forEach items="${images}" var="image">
        <div class="row">
          <div class="col-md-1">
          <a href="/user/${image.user.id}">
            <img src="data:image/jpeg;base64,${image.user.avatar}" class="img-circle avatar-main"/>
          </a>
        </div>
        <div class="col-md-1 login">
          <h4>${image.user.login}</h4>
        </div>
        <div class="col-md-12">
          <a href="/image/${image.id}">
            <img src="data:image/jpeg;base64,${image.content}" class="image-main"/>
          </a>
        </div>
        <div class="col-md-12">
          <div class="desc">
            <b>${image.user.login} </b>
            ${image.description}
          </div>
        </div>
      </div>
  </c:forEach>
      </div>
    <div class="col-md-2"></div>
  </div>
</div>
</body>
</html>