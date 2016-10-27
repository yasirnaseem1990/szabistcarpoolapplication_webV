package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("WEB-INF/public/links.jsp").include(request, response);
		response.setHeader("Cache-Control","no-cache");
		HttpSession session = request.getSession();
		System.out.println("SESSION GET IN LOGOUT SERVLET :"+session);
		session.removeAttribute("UserEmail");
		session.invalidate();
		
		System.out.println("AFTER INVALIDATING SESSION :"+session);
		out.print("You are successfully logged out!");

		out.close();
		
	}



}
