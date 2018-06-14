
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InstClone</title>
</head>
<body>
  <h3>Sign in</h3>
  <form action="login" method="post">
    <table>
      <tr>
        <td><label for="username">Email</label></td>
        <td><input type="text" name="username" id="username"/></td>
      </tr>
      <tr>
        <td><label for="password">Password</label></td>
        <td><input type="password" name="password" id="password"/></td>
      </tr>
      <tr>
        <td><input type="submit" value="Log in"></td>
      </tr>
      <tr>
        <td><a href="/registration">Sign up</a></td>
      </tr>
    </table>
  </form>
</body>
</html>
