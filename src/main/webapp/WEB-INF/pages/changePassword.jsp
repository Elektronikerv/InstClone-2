<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="/resources/css/page.css"/>
</head>
<html>
<head>
  <title>Change password</title>
  <script>
    function passwordsEqual() {
      var newPassword = document.getElementById("newPassword").value;
      var confirmedPassword = document.getElementById("confirmedPassword").value;
      var errorMessage = document.getElementById("passwordEqualErrorMessage");
      if(newPassword == confirmedPassword) {
        errorMessage.hidden = true;
        return true;
      }
      errorMessage.hidden = false;
      return false;
    }
    function validForm() {
      var submit_button = document.getElementById("submit");
      if(passwordsEqual() && validLength())
        submit_button.disabled = false;
      else
        submit_button.disabled = true;
    }
    function validLength() {
      var newPassword = document.getElementById("newPassword").value;
      var lengthErrorMessage = document.getElementById("lengthErrorMessage");
      if(newPassword.length < 6 || newPassword.length > 32) {
        lengthErrorMessage.hidden = false;
        return false;
      }
      lengthErrorMessage.hidden = true;
      return true;
    }
  </script>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
  <form action="/user/changePassword" method="post">
    <h3 class="text-center">Change password</h3>

    <div class="form-group">
      <label for="newPassword">New password</label>
      <input class="form-control" type="password" id="newPassword" name="newPassword" oninput="validForm()" />
      <small id="lengthErrorMessage" class="text-danger" hidden="true">
        Length must be 6-32
      </small>
    </div>
    <div class="form-group">
      <label for="confirmedPassword">Confirmed password</label>
      <input class="form-control" type="password" id="confirmedPassword" oninput="validForm()" />
      <small id="passwordEqualErrorMessage" class="text-danger" hidden="true">
        Passwords must be equal
      </small>
    </div>
    <div class="col-lg-offset-5 col-lg-2">
      <input id="submit" class="btn btn-success btn-md form-control"
             disabled="true" type="submit" value="Change password">
    </div>
  </form>
</div>
</body>
</html>