<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NewEmployee</title>
<link rel="stylesheet" href="/ProjectManagment/newemployee.css" type="text/css">
<style type="text/css">
  <%@include file="CSS/newemployee.css" %>
</style>

</head>
<body>
<form action="addEmp" method="post">
<center><h1><i>NEW EMPLOYEE</i></h1></center><hr>
<div class="main">
<fieldset class="field">
<center><h2><b><i>Add New Employee</i></b></h2></center>
<div class="info">
<label>Employee Name :</label><br>
 <input type="text" name="name" placeholder="Enter Name" required><br><br>
 <label>Employee ID :</label><br>
 <input type="text" name="id" placeholder="Enter ID" required><br><br>
 <label>Email ID :</label><br>
 <input type="email" name="email" placeholder="abc123@gmail.com" required><br><br>
 <label>Password :</label><br>
 <input type="password" name="pass" placeholder="Enter password" required><br><br>
 <label>Confirm Password :</label><br>
 <input type="password" name="cp" placeholder="Enter confirm password" required ><br><br>
 <!-- <lable>Status :</label><br>
 <input type="text" name="status" placeholder="Enter Status" required><br><br> -->
 <lable>Mobile :</label><br>
 <input type="text" name="mob" placeholder="Enter Contact" required><br><br>
 <label>Employee Role :</label><br>
 <input type="text" name="role" placeholder="Enter Role" required><br><br>
 <div class="button">
 <button type="submit" class="acc">Create Account</button>
 <button type="reset" class="clear">Clear Form</button>
</div>
</fieldset>
</div>
</form>
</body>
</html>