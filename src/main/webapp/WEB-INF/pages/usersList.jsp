<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="/resources/css/page.css"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>
  <c:forEach var="searchUser" items="${users}">
    <div class="container-fluid">
      <div class="row">
        <a href="/user/${searchUser.id}">
        <div class="col-md-2"><img class="img-circle" src="data:image/jpeg;base64,${searchUser.avatar}"
                                 title="change avatar" height="100" width="100"  hspace="20" vspace="20">
        </div>
        <div class="col-md-1 ">
          <h4 style="margin-top: 50px">${searchUser.login}</h4></div>
          </a>
        </div>
    </div>
  </c:forEach>
</body>
</html>
