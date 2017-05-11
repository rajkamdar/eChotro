<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>eChotro | Register</title>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css" type="text/css">
   </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top div-nav">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <h2><a href="index.jsp" class="navHeader">eChotro</a></h2>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
              </div><!-- /.container-fluid -->
    </nav>

    <div class="col-md-6 col-sm-6 divReg">
      <br>
      <h1 id="h1Reg"> eChotro </h1>
      <hr>
      <h3 id="h3Reg"> R E G I S T E R </h3>
    </div>

    <div class="col-md-6 col-sm-6 divReg">
${ msg}
      <form action="UserController" method="post">
        <center><br>
        <input type="text" id="inputName" class="form-control" name="name" placeholder="Full Name" required  autofocus>
        <input type="email" id="inpute" class="form-control" name="email" placeholder="Email" required  >
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
        <input type="text" id="inputCity" class="form-control" name="city" placeholder="City" required>
        <input type="text" id="inputCollege" class="form-control" name="college" placeholder="College" required>
        <input type="text" id="inputDegree" class="form-control" name="degree" placeholder="Degree" required><br>
        <input type="submit" class="btn btn-primary btn-Registerform" value="REGISTER">
		<input type="hidden" name="action" value="addUser">
      </center>
      </form>
    </div>
  </body>
</html>
