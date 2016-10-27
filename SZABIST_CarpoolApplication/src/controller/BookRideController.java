package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.PassengerBookDAOImpl;
import domain.PassengerBook;
import domain.PostRide;


public class BookRideController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Book a Ride Controller Invoke");
		String brcUrl = (String) request.getAttribute("url");
		String tempId = request.getParameter("rideId");
		System.out.println("TEMP ID INSIDE BOOK RIDE CONTROLLER :"+tempId);
		Object session = request.getSession().getAttribute("UserEmail");
		PostRide postRide = new PostRide();
		System.out.println("POST RIDE ID :"+postRide.getPostrideId());
		System.out.println("Getting Session if is there a Session exits :"+session);
		if(session!=null){
			String path = brcUrl+"?rideId="+tempId;
			System.out.println("Going to Modal to take some Passenger Information");
			
			request.getRequestDispatcher(FrontController.ViewResolver(brcUrl, 1)+"?rideId="+tempId).forward(request, response);
		}
		else{
			System.out.println("Your Are Not Allow to Access this page. Please Register Yourself Firsts");
			request.getRequestDispatcher("/WEB-INF/public/login.jsp").forward(request, response);
		}	
	}
}
