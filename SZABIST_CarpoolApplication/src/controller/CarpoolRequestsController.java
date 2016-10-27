package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarpoolRequestDAO;
import dao.impl.CarpoolRequestDAOImpl;
import dao.impl.CarpoolRequestHandlerDAOImpl;
import domain.CarpoolRequest;


public class CarpoolRequestsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CarpoolRequestDAO dao;
	private int fkpassengerId;
	public CarpoolRequestsController(){
		dao = new CarpoolRequestDAOImpl();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Captain aboard the vessel.
		System.out.println("Carpool Requests Controller Invoke");
     	String carpoolrequestUrl = (String) request.getAttribute("Url");
    	System.out.println("Url Get In CarpoolRequests Controller :"+carpoolrequestUrl);
    	long  UserId =  (Integer) request.getSession(false).getAttribute("UserId");    // This is I need.
	    System.out.println("This is User ID Inside CarpoolRequests Controller :"+UserId);
	
	try {
//		CarpoolRequest row = new CarpoolRequest();
        dao.queryByUserId(UserId);
//		row.getFkpassengerId();
		fkpassengerId = CarpoolRequestDAOImpl.fkPassengerId;
		System.out.println("Inside CarpoolRequest Controller Getting Fk_Passenger ID :"+fkpassengerId);
		request.setAttribute("CarpoolRequests", CarpoolRequestHandlerDAOImpl.theListReturner(fkpassengerId));
//		request.setAttribute("CarpoolRequests", dao.queryByUserId(UserId));
		System.out.println("Carpool Requests Load Successfully");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	request.getRequestDispatcher(FrontController.ViewResolver(carpoolrequestUrl, 1)).forward(request, response);
	
	}
	
	
}
