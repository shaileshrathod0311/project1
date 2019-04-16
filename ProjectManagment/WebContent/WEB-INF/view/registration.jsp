<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!Doctype html>
<html>
<head>
<title>registration form</title>
<link rel="stylesheet" type="text/css" href="regiform.css">
</head>
<body>
<div class="main">
<fieldset class="field">
<h1><b><i>Sign Up</i></b></h1>
<div class="info">
<label>Enter Name :</label><br>
 <input type="text" placeholder="Enter Name" required><br><br>
 <label>Enter Email ID :</label><br>
 <input type="email" placeholder="abc123@gmail.com" required><br><br>
 <label>Password :</label><br>
 <input type="password" placeholder="Enter password" required><br><br>
 <label>Confirm Password :</label><br>
 <input type="password" placeholder="Enter confirm password" required ><br><br>
 
 <input type="submit"  class="acc" value="Create Account">
 <input type="button" class="clear" value="Clear Form">
</div>
</fieldset>
</div>
</body>
</html>