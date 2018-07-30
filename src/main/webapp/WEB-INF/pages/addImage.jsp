<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new image</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container">
  <h3 class="text-center">Add image</h3>
<form action="/image/add" class="form" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <textarea class="form-control" placeholder="Description..." name="description"></textarea>
    <label for="newImage">Choose image</label>
    <div class="form-group">
      <input  type="file"  name="newImage" id="newImage" accept="image/*" required/>
    </div>
      <input class="btn btn-success form-control" type="submit" value="add"/>
  </div>
</form>
</div>
</body>
</html>
