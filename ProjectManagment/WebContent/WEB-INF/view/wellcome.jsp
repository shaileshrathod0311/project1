<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WellCome Page</title>
<link rel="stylesheet" href="/ProjectManagment/wellcome.css" type="text/css">
<style type="text/css">
  <%@include file="CSS/wellcome.css" %>
  <%@include file="CSS/details.css" %>
</style>
</head>
<body>
<div class="container">
<form class="form">
<center><h2><b><i>Employee Details</i></b></h2></center>
<center><label>Employee Name :</label></center><br>
 <input type="text" name="name" placeholder="Enter Name" required><br><br>
 <center><label>Employee ID :</label></center><br>
 <input type="text" name="id" placeholder="Enter ID" required><br><br>
<center> <label>Email ID :</label></center><br>
 <center><input type="email" name="email" placeholder="abc123@gmail.com" required><br><br>
 <center><label>Password :</label></center><br>
 <input type="password" name="pass" placeholder="Enter password" required><br><br>
 <center><label>Mobile :</label></center><br>
 <input type="text" name="mob" placeholder="Enter Contact" required><br><br>
 <center><label>Employee Role :</label></center></center><br>
 <input type="text" name="role" placeholder="Enter Role" required>
</form>
</div>
</body>
</html>