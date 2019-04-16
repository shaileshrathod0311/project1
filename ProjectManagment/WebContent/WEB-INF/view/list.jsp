<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list of employee</title>
<style type="text/css">
  <%@include file="CSS/list.css" %> 
</style>

</head>
<body>
<a href="newEmp" class="add">Create new Employee</a><br><br>
<a href="searchEmp" >Search Employee</a>
<a href="logOut" class="logout">Logout</a>
<hr>
<center><span style="color: white;"><h1><i>All details of Employee</i></h1></span></center>
<table>
<thead>
<tr>
<th>EMP_NAME</th>
<th>EMP_ID</th>
<th>EMP-PASSWORD</th>
<th>EMP-EMAILID</th>
<th>EMP-ROLE</th>
<th>STATUS</th>
<th>EMPMOBILE</th>
<th>ACTION</th>
</tr>
<c:forEach var="emp" items="${requestScope.listEmp}">
 
 <tr>
  <td><c:out value = "${emp.empName}" /></td>
  <td><c:out value = "${emp.empID}" /></td>
  <td><c:out value = "${emp.empPassword}" /></td>
  <td><c:out value = "${emp.empEMailID}" /></td>
  <td><c:out value = "${emp.empRole}" /></td>
  <td><c:out value = "${emp.status}" /></td>
  <td><c:out value = "${emp.empMobile}" /></td>
  
  <td><a href="UpdateEmp?empID=<c:out value ='${emp.empID}'/>">Update</a>

<a href="delete?empID=<c:out value ='${emp.empID}'/>">Delete</a></td>
  </tr>
  </c:forEach>
</thead>
</table>

</body>
</html>