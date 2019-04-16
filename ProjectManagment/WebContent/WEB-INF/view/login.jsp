<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style type="text/css">
  <%@include file="CSS/loginp.css" %>
</style>
</head>
<body>
<form action="loginchek" method="post">
<div class="login-box">
<h1>Login</h1>
<div class="textbox">
<i class="fa fa-user-o" aria-hidden="true"></i>

<input type="text" placeholder="Username" name="uname" value="">
</div>

<div class="textbox">
<i class="fa fa-unlock-alt" aria-hidden="true"></i>

<input type="password" placeholder="password" name="psw" value="">
</div>

<input class="btn" type="submit" name="" value="Sign">
</div>
</form>
</body>
</html>