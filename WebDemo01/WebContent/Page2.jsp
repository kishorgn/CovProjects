<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page2</title>
</head>
<body>
	<h2>Welcome</h2>
	<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	try{
		
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/covalense";
	String username = "root";
	String password = "root";
	Class.forName(driver);
	con = DriverManager.getConnection(url, username, password);
	stmt = con.createStatement();
	rs = stmt.executeQuery("SELECT * FROM employee");
	%>
	<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>DeptNo</th>
	</tr>
	<%
	while(rs.next()){
		%>
		<tr>
			<td><%= rs.getInt(1) %> </td>
			<td><%= rs.getString(2) %></td>
			<td><%= rs.getInt(3) %></td>
		</tr>
		<%
	}
	%>
	</table>
	<%
	}
	finally{
		rs.close();
		stmt.close();
		con.close();
	}
	%>
	
</body>
</html>