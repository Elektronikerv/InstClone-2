<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
  <title>Sign up</title>
</head>

<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">InstClone</a>
    </div>
  </div>
</nav>
<div class="center">
  <div class="container">
    <h3 class="text-center">Sign Up</h3>
    <form method="POST" action="registration" encType="multipart/form-data">

      <div class="form-group">
          <label for="email">E-mail</label>
          <input class="form-control" type="text" id="email" name="email" required>
        </div>
      <div class="form-group">

          <label for="password">Password</label>
          <input type="password" class="form-control" id="password" name="password" required>
      </div>
      <div class="form-group">
        <label for="gender">Gender:</label>
          <input type="radio" id="gender" name="gender" value="m">Male
          <input type="radio" name="gender" value="f">Female
      </div>
      <div class="form-group">
          <label for="avatar">Choose avatar:</label>
          <input type="file" class="" name="avatar" id="avatar" accept="image/*"/>
        </div>
      <div class="form-group">
          <input class="btn btn-success form-control" type="submit" name="createAccount" value="Sign up">
        </div>

    </form>
  </div>
</div>
</body>
</html>