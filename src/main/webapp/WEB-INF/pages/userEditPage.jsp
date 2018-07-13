<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="/resources/css/page.css"/>
  <title>InstClone | ${currentUser.login}</title>
</head>
<body>
  <%@include file="navbar.jsp"%>
  <div class="center">
    <div class="container">
      <h3 class="text-center">Sign Up</h3>
      <form method="POST" action="/user/update" encType="multipart/form-data">

        <div class="form-group">
          <label for="login">Login</label>
          <input class="form-control" type="text" id="login" name="login" value="${currentUser.login}" required>
        </div>
        <div class="form-group">
          <label for="firstName">First name</label>
          <input class="form-control" type="text" id="firstName" name="firstName" value="${currentUser.firstName}" required>
        </div>
        <div class="form-group">
          <label for="lastName">Last name</label>
          <input class="form-control" type="text" id="lastName" name="lastName" value="${currentUser.lastName}" required>
        </div>
        <div class="form-group">
          <label for="avatar">Choose new avatar:</label>
            <input type="file" class="" name="avatar" id="avatar" accept="image/*"/>
        </div>
        <div class="form-group">
          <input class="btn btn-success form-control" type="submit" name="update" value="Update">
        </div>
      </form>
    </div>
  </div>
</body>
</html>
