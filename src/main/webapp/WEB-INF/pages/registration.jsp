<html>
<head>
  <title>Sign up</title>
</head>
<body>
<div class="center">
  <div class="container">
    <h3>Sign Up</h3>
    <form method="POST" action="registration" encType="multipart/form-data">
      <table>
      <tr>
        <td><label for="email">E-mail</label></td>
        <td><input type="text" id="email" name="email" required></td>
      </tr>
      <tr>
        <td><label for="password">Password</label></td>
        <td><input type="text" id="password" name="password" required></td>
      </tr>
      <td>Gender:</td>
        <td><input type="radio" name="gender" value="m">Male</td>
        <td><input type="radio" name="gender" value="f">Female</td>
      </tr>
      <tr>
        <td><label for="avatar">Choose avatar:</label></td>
        <td><input type="file" name="avatar" id="avatar" accept="image/*"/></td>
      </tr>
      <tr>
        <td><input type="submit" name="createAccount" value="Sign up"></td>
      </tr>
    </form>
  </div>
</div>
</body>
</html>