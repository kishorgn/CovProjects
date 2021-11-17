<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.covelanse.beans.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.covelanse.dao.StudentJdbcDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>students</title>
</head>
<body>
	<h2>Welcome to Student Management</h2>
	<%
	StudentJdbcDAO studentJdbcDAO = new StudentJdbcDAO();
	List<Student> students = studentJdbcDAO.findAll();
	%>
	<h3>Students</h3>
	<table border="1">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Date of Birth</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Edit | Delete</th>
	</tr>
	<%
	for(Student student : students){
		String dob = new SimpleDateFormat("dd-MM-yyyy").format(student.getDob());
		%>
		<tr>
			<td><%= student.getId() %></td>
			<td><%= student.getName() %></td>
			<td><%= dob %></td>
			<td><%= student.getEmail() %></td>
			<td><%= student.getMobile() %></td>
			<td>
				<a href="EditStudent.jsp?id=<%=student.getId()%>">Edit</a> | 
				<a href="delStudent?id=<%=student.getId()%>">Delete</a>
			</td>
		</tr>
		<%
	}
	%>
	</table>
	<br><br><br>
	<h3>Add new student</h3>
	<form method="post">
		ID : <input type="text" name="id"><br><br>
		Name : <input type="text" name="name"><br><br>
		Date of Birth : <input type="text" name="dob"><br><br>
		Email : <input type="text" name="email"><br><br>
		Mobile : <input type="text" name="mobile"><br><br>
		<input type="submit" value="Register"><br><br>
		<input type="reset" value="Cancel">
	</form>
	
	<%
	if(request.getMethod().equalsIgnoreCase("POST")){
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		Student student = new Student(id, name, dob, email, mobile);
		StudentJdbcDAO studentJdbcDAO2 = new StudentJdbcDAO();
		if(studentJdbcDAO2.save(student)){
			studentJdbcDAO2.save();
			%>
			Student saved successfully.<br><br>
			<%
		}
		else{
			%>
			Failed to save student.<br><br>
			<%
			studentJdbcDAO2.undo();
		}
		response.sendRedirect("Page4.jsp");
	}
	%>

</body>
</html>