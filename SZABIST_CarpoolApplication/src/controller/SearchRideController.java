package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.PostRideDAOImpl;
import domain.PostRide;


public class SearchRideController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String srcAddress,destinationAddress,date;
	PostRide searchRide;
	PostRideDAOImpl dao = new PostRideDAOImpl();
	public ArrayList<PostRide> post = new ArrayList<PostRide>();
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("@@@@@@@@@ Search RideController Invoke @@@@@@@@@");
		String searchrideUrl = request.getRequestURI();
		System.out.println("Url Get From Search RideController :"+searchrideUrl);
		srcAddress = request.getParameter("origininput");
		destinationAddress = request.getParameter("destinationinput");
		date = request.getParameter("date");
		
		searchRide(srcAddress, destinationAddress, date, request, response);
	}

	public void searchRide(String sAddress,String dAddress,String dt,HttpServletRequest req,HttpServletResponse rep){
		
		System.out.println("@@@@@@@@@ Inside Search Ride Method @@@@@@@@@");
		PostRide pr = new PostRide();
		pr.setSourcelocation(sAddress);
		pr.setDestinationlocation(dAddress);
		pr.setDate(dt);
		
		
		
		try {
			searchRide = dao.loadsearchRide(pr);
			post.add(searchRide);
//			boolean flag = dao.verifysearchRid(pr);
//			System.out.println("Now Flag Holding All Ride Search Results :"+flag);
			if(searchRide != null){
				System.out.println("This is Source Address :"+searchRide.getSourcelocation());
				System.out.println("This is Destination Address :"+searchRide.getDestinationlocation());
				System.out.println("This is Date :"+searchRide.getDate());
				req.setAttribute("SearchResult", post);
				req.getRequestDispatcher("/WEB-INF/public/search.ride.jsp").forward(req, rep);
			}
			else{
				System.out.println("Search Ride Failed");
			}
			System.out.println("Set the Rides Search Result in setAttribute");
			
			System.out.println("Search Ride Successfull");
			
		} catch (Exception e) {
		System.out.println("Search Ride Failed Some thing went Wrong "+e);
		}
		
	}
	
}
