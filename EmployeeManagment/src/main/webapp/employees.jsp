<%@ page  import = "java.util.* , com.employee.model.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
<h4>Welcome <%= session.getAttribute("email") %></h4><hr>
<a href="addEmployee.jsp">Add New Employee</a><hr>
<table border=1>
<tr>
<th>Employee Id</th>
<th>Name</th>
<th>Age</th>
<th>Email</th>
<th>Phone Number</th>
<th>Salary</th>
<th>Update</th>
<th>Delete</th>
</tr>
<%  List<Employee> empList=(List<Employee>) request.getAttribute("empList");
for(Employee emp: empList) {
 %>
<tr>
<td><%= emp.getEmpId() %></td>
<td><%= emp.getName() %></td>
<td><%= emp.getAge() %></td>
<td><%= emp.getEmail() %></td>
<td><%= emp.getPhone_number() %></td>
<td><%= emp.getSalary() %></td>
<td><a href="updateEmp.jsp?id=<%= emp.getEmpId() %>">Update</a></td>
<td><a href="delete?id=<%= emp.getEmpId()%>">Delete</a></td>
</tr>
<%  }%>

</table>
</body>
</html>