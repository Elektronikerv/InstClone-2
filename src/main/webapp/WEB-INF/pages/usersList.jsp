<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="/resources/css/usersList.css"/>
  <link rel="stylesheet" href="/resources/css/page.css"/>
  <title>InstClone</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
  <c:if test="${fn:length(users) eq 0}">
    <h3 class="text-center">No users found</h3>
  </c:if>
    <div class="container">
      <c:forEach var="searchUser" items="${users}">
        <div class="row">
          <a href="/user/${searchUser.id}">
            <div class="col-md-1">
              <img class="img-circle img-small" src="data:image/jpeg;base64,${searchUser.avatar}"/>
            </div>
            <div class="col-md-1">
              <h4 class="user-login">${searchUser.login}</h4>
            </div>
          </a>
          <div class="col-md-8"></div>
        </div>
      </c:forEach>
    </div>
</body>
</html>
