<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.covelanse.dao.StudentJdbcDAO"%>
<%@page import="com.covelanse.beans.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>editstudent</title>
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	Student student = new StudentJdbcDAO().find(id);
	String dob = new SimpleDateFormat("dd-MM-yyyy").format(student.getDob());
	%>
	<h2>Edit Student</h2>
	<form method="post">
		ID : <input type="text" name="id" value="<%= student.getId() %>" readonly="readonly"><br><br>
		Name : <input type="text" name="name" value="<%= student.getName() %>"><br><br>
		Date of Birth : <input type="text" name="dob" value="<%= dob %>"><br><br>
		Email : <input type="text" name="email" value="<%= student.getEmail() %>"><br><br>
		Mobile : <input type="text" name="mobile" value="<%= student.getMobile() %>"><br><br>
		<input type="submit" value="Register"><br><br>
		<input type="reset" value="Cancel"> 
	</form>
	<%
		if(request.getMethod().equalsIgnoreCase("post")){
			id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			dob = request.getParameter("dob");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			student = new Student(id, name, dob, email, mobile);
			StudentJdbcDAO studentJdbcDAO = new StudentJdbcDAO();
			if(studentJdbcDAO.edit(student)){
				studentJdbcDAO.save();
			}
			else{
				studentJdbcDAO.undo();
			}
			response.sendRedirect("Page4.jsp");
			
		}
	%>
	
</body>

</html>