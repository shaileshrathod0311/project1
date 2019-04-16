<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update Employee</title>
</head>
<body>
<form action="update" method="post">
<center><h1><i>Update EMPLOYEE</i></h1></center><hr>
<div class="main">
<fieldset class="field">
<div class="info">
<label>Employee Name :</label><br>
 <input type="text" name="name" placeholder="Enter Name" required value="<c:out value="${emp.empName}" />"><br><br>
 <label>Employee ID :</label><br>
 <input type="text" name="id" placeholder="Enter ID" required value="<c:out value="${emp.empID}"/>"><br><br>
 <label>Email ID :</label><br>
 <input type="email" name="email" placeholder="abc123@gmail.com" required value="<c:out value="${emp.empEMailID}"/>"><br><br>
 <label>Password :</label><br>
 <input type="password" name="pass" placeholder="Enter password" required value="<c:out value="${emp.empPassword}"/>"><br><br>
 <label>Employee Status :</label><br>
 <input type="text" name="status" placeholder="Enter status" required value="<c:out value="${emp.status}"/>"><br><br>
 <label>Mobile :</label><br>
 <input type="text" name="mob" placeholder="Enter Contact" required value="<c:out value="${emp.empMobile}"/>"><br><br>
 <label>Employee Role :</label><br>
  <input type="text" name="role" placeholder="Enter Role" required value="<c:out value="${emp.empRole}"/>"><br><br>
 <div class="button">
 <button type="submit" class="acc">Update Account</button>
 <button type="reset" class="clear">Clear Form</button>
</div>
</fieldset>
</div>
</form>
</body>
</html>