<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">InstClone</a>
    </div>
    <ul class="nav navbar-nav">
      <li>
        <form style="margin-left: 400px;margin-top: 3px;"
              class="form-inline" action="/search">
          <div class="form-group">
            <input class="form-control" type="text" name="searchUserLogin"/>
            <input class="btn btn-info" type="submit" value="Search"/>
          </div>
        </form>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <c:if test="${empty currentUser}">
        <li><a href="/registration"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
      </c:if>
      <c:if test="${!empty currentUser}">
        <li>
          <a href="/logout"><span class="glyphicon glyphicon-log-out"></span>Log out</a>
        </li>
      </c:if>
    </ul>
  </div>
</nav>