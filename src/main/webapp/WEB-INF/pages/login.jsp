<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
  <title>InstClone</title>
</head>

<%@include file="navbar.jsp" %>
<body style="background: #8b8787">
<div class="container">
  <div class="col-lg-4"></div>
  <div class="col-lg-4">
    <div class="jumbotron login-form" >
      <h2 class="text-center">Login</h2>
      <form action="login" method='POST'>
        <div class=" form-group">
          <c:if test="${param.error ne null}">
            <div class="error-message">Invalid username or password</div>
          </c:if>
          <label for='username'>User:</label>
          <div>
            <input type='text' class="form-control" id="username" name='username' value=''>
          </div>
        </div>
        <div class="form-group">
          <label for='password'>Password:</label>
          <div>
            <input type='password' class="form-control" id='password' name='password'/>
          </div>
        </div>
        <div>
          <input name="submit" class="btn btn-success form-control" type="submit" value="Log in"/>
        </div>
      </form>
    </div>
  </div>
  <div class="col-lg-4"></div>
</div>
</body>
</html>