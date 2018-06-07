<html>
<head>
  <title>Sign up</title>
</head>
<body>
<div class="center">
  <div class="container">
    <h3>Sign Up</h3>
    <form method="POST" action="registration" encType="multipart/form-data">
      <%--Login--%>
      <%--<input type="text" name="login" required>--%>
      <label for="gender">Gender</label>
        <input type="text" id="gender" name="gender" required>
      <label for="password">Password</label>
      <input type="text" id="password" name="password" required>
      <label for="email">E-mail</label>
        <input type="text" id="email" name="email" required>
      Choose avatar:
      <br>
      <input type="file" name="avatar" accept="image/*"/>
      <input type="submit" name="createAccount" value="Create">
    </form>
  </div>
</div>
</body>
</html>