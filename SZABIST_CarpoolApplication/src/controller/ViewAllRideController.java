package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostRideDAO;
import dao.impl.PostRideDAOImpl;
import domain.PostRide;
import domain.Url;


public class ViewAllRideController extends HttpServlet {
//	public static final String lIST_ALLRIDES = "/WEB-INF/public/view.allride.jsp";
	String foward ="";
	PostRideDAO dao;
//	private static ArrayList<PostRide> loadRides;
	private static final long serialVersionUID = 1L;

	public  ViewAllRideController() {
		dao = new PostRideDAOImpl();
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
//			foward = lIST_ALLRIDES;
			try {
			System.out.println("Trying to Load Post Rides :"+dao.queryAll());
				request.setAttribute("AllRides", dao.queryAll());
				System.out.println("Rides are Loaded");
			} catch (Exception e) {
				System.out.println("Rides are not Loaded :"+e);
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/public/view.allride.jsp").forward(request, response);
			
		
	}
}
