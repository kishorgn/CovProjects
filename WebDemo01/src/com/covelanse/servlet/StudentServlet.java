package com.covelanse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.covelanse.beans.Student;
import com.covelanse.dao.StudentJdbcDAO;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			StudentJdbcDAO studentJdbcDAO = new StudentJdbcDAO();
			List<Student> students = studentJdbcDAO.findAll();
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>Name</th>");
			out.println("<th>DateOfBirth</th>");
			out.println("<th>Email</th>");
			out.println("<th>Mobile</th>");
			out.println("</tr>");
			for(Student student : students) {
				out.println("<tr>");
				out.println("<td>"+student.getId()+"</td>");
				out.println("<td>"+student.getName()+"</td>");
				String strDob = new SimpleDateFormat("dd-MM-yyyy").format(student.getDob());
				out.println("<td>"+strDob+"</td>");
				out.println("<td>"+student.getEmail()+"</td>");
				out.println("<td>"+student.getMobile()+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
