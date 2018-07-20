<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/resources/css/page.css"/>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">InstClone</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <form class="navbar-form n-form">
        <div class="form-group">
          <input  type="text" name="searchUserLogin" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Search</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <c:if test="${!empty currentUser}">
          <li><a href="/image/add"><span class="glyphicon glyphicon-plus"></span></a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
              Profile<span class="caret"></span>
            </a>
          <ul class="dropdown-menu">
            <li><a href="/user/update">Edit profile</a></li>
            <li><a href="/user/changePassword">Change password</a></li>
          </ul>
          <li>
            <a href="/logout"><span class="glyphicon glyphicon-log-out"></span>Log out</a>
          </li>
          </li>
        </c:if>
        <c:if test="${empty currentUser}">
          <li>
            <a href="/registration"><span class="glyphicon glyphicon-user"></span>Sign up</a>
          </li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>

<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>