<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>eChotro | Login</title>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css" type="text/css">
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top div-nav">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <h2>eChotro</h2>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
              </div><!-- /.container-fluid -->
    </nav>

  <div class="col-md-6 col-sm-6 div-about">
    <h1> About </h1>
    <br>
    "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat."
    <br><br>
    <a href="about.html" class="btn btn-default"  role="button">READ MORE </a>
  </div>
  <div class="col-md-6 col-sm-6 div-signin">
    <h1> Login </h1>
    <form class="form-signin" action="LoginController" method="post">
    ${msg}
      <center>
      <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email" required autofocus>
      <input type="hidden" name="action" value="login">
      <input type="password" id="inputPassword" class="form-control" name="password" placeholder="*************" required><br>
      <input type="submit" class="btn btn-primary btn-Loginform" value="LOGIN">
      
      <a href="${pageContext.request.contextPath}/register" class="btn btn-primary btn-Loginform " role="button">REGISTER</a>
      
    </center>
    </form>
  </div>

  </body>
</html>
