
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="/resources/css/page.css"/>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container">
  <div class="row">
  <c:if test="${fn:length(images) eq 0}">
    <h1 class="text-center">Follow someone</h1>
  </c:if>
  <c:forEach items="${images}" var="image">
    <div class="col-md-1">
      <a href="/user/${image.user.id}">
        <img src="data:image/jpeg;base64,${image.user.avatar}" height="50" width="50" class="img-circle"/>
      </a>
    </div>
    <div class="col-md-1">
        <h4>${image.user.login}</h4>
    </div>
    <div class="col-md-12">
      <a href="/image/${image.id}">
        <img src="data:image/jpeg;base64,${image.content}" height="700" width="700"/>
      </a>
    </div>
    <div class="col-md-12">
      <div>
          ${image.description}
      </div>
      <br/>
      <br/>
    </div>
  </c:forEach>
</div>
</div>
</body>
</html>
