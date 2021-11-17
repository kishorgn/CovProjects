<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page1</title>
</head>
<body>


	<h2>Welcome to JSP</h2>
	Learning JSP is fun.<br>
	<%
	for(int c = 0 ; c < 10 ; c++){
		if(c % 2 == 0){
			%>
			<font color=green>
			<%
		}
		else{
			%>
			<font color=red>
			<%
		}
		%>
		<%= c %>
		</font>
		<br>
		<%
	}
	%>
	Today : <%= getDay() %>
	<%!
	String getDay(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		return sdf.format(date);
	}
	%>
</body>
</html>