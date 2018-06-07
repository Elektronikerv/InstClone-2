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

</body>
</html>