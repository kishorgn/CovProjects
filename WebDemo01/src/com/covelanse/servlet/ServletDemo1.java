package com.covelanse.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo1
 */
public class ServletDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>home</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Welcome to Servlet Programming</h2>");
		String name = req.getParameter("na");
		String email = req.getParameter("em");
		out.println("Name : "+name+"<br>");
		out.println("Email : "+email+"<br>");
		out.println("</body>");
		out.println("</html>");
		
		
		out.close();
	}

}
