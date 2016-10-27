package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.PostRideDAOImpl;
import dao.impl.UserDAOImpl;
import domain.PostRide;


public class OfferRideController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	long uId = UserDAOImpl.userId;
	public static long fk_Ride_Id;
   String ridetitle,ridedescp,startlocation,endlocation,date,rent,tSeats,aSeats,cName,cModel;
    public OfferRideController() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("@@@@@@@@@ OfferRide Controller Invoke @@@@@@@@@");
		String offerRideUrl = (String) request.getAttribute("url");
		System.out.println("Url Get From PostRide Controller :"+offerRideUrl);
	    System.out.println("USER ID Through Session :"+UserController.session.getAttribute("UserId")); 
		ridetitle = request.getParameter("rideTitle");
		System.out.println("Ride Title :"+ridetitle);
		ridedescp = request.getParameter("description");
		System.out.println("Ride Description :"+ridedescp);
		startlocation = request.getParameter("origininput");
		System.out.println("Source Address :"+startlocation);
		endlocation = request.getParameter("destinationinput");
		System.out.println("Destination Address :"+endlocation);
		date = request.getParameter("date");
		rent = request.getParameter("fair");
		tSeats = request.getParameter("totalseats");
		aSeats = request.getParameter("availableseats");
		cName = request.getParameter("carname");
		cModel = request.getParameter("carmodel");
		addPostRide(ridetitle, ridedescp, startlocation, endlocation, date, rent, tSeats, aSeats, cName, cModel, uId,request,response);
	}
	
	
	
	
	public void addPostRide(String rt,String rd,String sl,String el,String dt,String rn,String ts,String as,
			String cn,String cm,long userid,HttpServletRequest req, HttpServletResponse resp){
		
		PostRide postride = new PostRide();
		postride.setPostridetitle(ridetitle);
		postride.setPostridedescription(ridedescp);
		postride.setSourcelocation(startlocation);
		postride.setDestinationlocation(endlocation);
		postride.setDate(date);
		postride.setFair(rent);
		postride.setTotalseat(tSeats);
		postride.setAvailableseat(aSeats);
		postride.setCarname(cName);
		postride.setCarmodel(cModel);
		postride.setFkUserId(uId);
		System.out.println("Inside AddPost Ride Method Inserting FK_USER_ID :"+uId);
		
		PostRideDAOImpl postridedaoimpl = new PostRideDAOImpl();
		try {
			fk_Ride_Id = postridedaoimpl.insert(postride);
//			UserController.session.setAttribute("SourceLocation", postride.getSourcelocation());
			System.out.println("Rides Post Successfully ID is "+fk_Ride_Id);
			req.getRequestDispatcher("WEB-INF/private/user.profile.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("Rides Post Failed :"+e);
			e.printStackTrace();
		}
	}

}
