<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
  <title>Sign up</title>
</head>

<body>
<%@ include file="navbar.jsp"%>
<div class="center">
  <div class="container">
    <h3 class="text-center">Sign Up</h3>
    <form method="POST" action="registration" encType="multipart/form-data">

      <div class="form-group">
          <label for="login">Login</label>
          <input class="form-control" type="text" id="login" name="login"
                 pattern=".{4,32}" title="4-32 characters" required>
          <c:if test="${uniqueError eq true}">
            <small class="error-message">This login is already exists</small>
          </c:if>
      </div>

        <div class="form-group">
            <label for="firstName">First name</label>
            <input class="form-control" type="text" id="firstName" name="firstName" required>
        </div>

        <div class="form-group">
            <label for="lastName">Last name</label>
            <input class="form-control" type="text" id="lastName" name="lastName" required>
        </div>
      <div class="form-group">
          <label for="password">Password</label>
          <input type="password" class="form-control" id="password" name="password" pattern=".{6,32}"
                 title="6-32 characters" required>
      </div>
      <div class="form-group">
        <label for="gender">Gender:</label>
          <input type="radio" id="gender" name="gender" value="m" required>Male
          <input type="radio" name="gender" value="f">Female
      </div>
      <div class="form-group">
          <label for="avatar">Choose avatar:</label>
          <input type="file" class="" name="avatar" id="avatar" accept="image/*"/>
        </div>
      <div class="form-group">
          <input class="btn btn-success form-control" type="submit" name="createAccount" value="Sign up">
        </div>
    </form>
  </div>
</div>
</body>
</html>