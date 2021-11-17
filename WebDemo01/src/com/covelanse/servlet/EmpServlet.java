package com.covelanse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServlet
 */
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/covalense";
		String username = "root";
		String password = "root";
		
		Connection con = null;
		Statement stmt = null; 
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			String sql = "SELECT * FROM employee";
			rs = stmt.executeQuery(sql);
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>Name</th>");
			out.println("<th>DeptNo</th>");
			out.println("</tr>");
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getInt(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getInt(3)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
