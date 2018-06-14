<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>InstClone | ${user.email}</title>
</head>
<body>


<table>
  <tr>
      <img class="img-circle" src="data:image/jpeg;base64,${user.avatar}" title="change avatar" height="150" width="150"  hspace="20" vspace="20">
    </a></td>
    <td><h2>${user.email}</h2></td>
  </tr>
</table>
<form action="/addImage" method="post" enctype="multipart/form-data">
  <input type="file" name="newImage" id="newImage" accept="image/*"/>
  <input type="submit" value="add"/>
</form>

  <c:forEach items="${user.images}" var="image">
    <img class="img-circle" src="data:image/jpeg;base64,${image.content}" height="300" width="300"/>
  </c:forEach>
</body>
</html>