<%-- 
    Document   : resetpassword
    Created on : 26-May-2021, 12:41:16 am
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="images/android-icon-72x72.png">
    <style>
             body {
             background-image: url('images/loginbg.png');
             background-repeat: no-repeat;
             background-attachment: fixed;
             background-size: 100% 110%;
        
             }
        </style>
    <title>Signin</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/sign-in/">

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.0/examples/sign-in/signin.css" rel="stylesheet">
  </head>

  <body class="text-center">
      <form class="form-signin" action="../views/login.jsp" method="GET">
        <img class="mb-4" src="images/dpocket.png" alt="" width="150" height="80">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <input type="email" name="email" class="form-control" placeholder="Email address" required autofocus>
      <input type="password" name="pwd" class="form-control" placeholder="Password" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      <div class="row">
          <a href="pages/forget.html" class="text-dark">Forgotten password</a>
       <a href="pages/registration.html" class="text-dark" style="padding-left: 100px ">Sign Up</a>
      </div>
     
      
      <p class="mt-5 mb-3 text-muted">&copy; 2021-2022</p>
       
    </form>
     
  </body>
</html>

