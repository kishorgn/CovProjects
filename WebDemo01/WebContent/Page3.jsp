<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>newemployee</title>
</head>
<body>

	<%
		if (request.getMethod().equalsIgnoreCase("GET")) {
			// send a form to the user
			%>
			<form method="post">
				ID : <input type="text" name="id"><br><br>
				Name : <input type="text" name="name"><br><br>
				DeptNo : <input type="text" name="deptno"><br><br>
				<input type="submit" value="Save">
				<input type="reset" value="Cancel">
			</form>
			<%
		}
		if (request.getMethod().equalsIgnoreCase("POST")) {
			// Obtain requ.params store into DB and present a link back to the same
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try{
				
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/covalense";
			String username = "root";
			String password = "root";
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			String sql = "INSERT INTO employee VALUES(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, deptno);
			if(1 == pstmt.executeUpdate()){
				%>
				Inserted successfully
				<%
			}
			else{
				%>
				Failed to insert
				<%
			}
			%>
			<br><br>
			<a href="Page3.jsp">Insert another Employee</a>
			<%
			}
			finally{
				pstmt.close();
				con.close();
			}
		}
	%>

</body>
</html>