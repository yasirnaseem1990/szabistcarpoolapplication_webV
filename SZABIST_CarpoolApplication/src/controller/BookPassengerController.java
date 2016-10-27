package controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import com.sun.mail.smtp.SMTPTransport;

import dao.PassengerBookDAO;
import dao.impl.CarpoolRequestDAOImpl;
import dao.impl.PassengerBookDAOImpl;
import dao.impl.PostRideDAOImpl;
import dao.impl.UserDAOImpl;
import domain.CarpoolRequest;
import domain.PassengerBook;


public class BookPassengerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SMTPTransport t;
	public static long pId;
	long carpoolrequestId;
	long fk_ridepostId;
	String pickupLocation,otherComments;
	long bookeduserId = UserDAOImpl.userId;
	PostRideDAOImpl postDAO = new PostRideDAOImpl();
	public BookPassengerController(){
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Book Passenger Controller Invoke");
		
		fk_ridepostId =Integer.parseInt(request.getParameter("rideId"));
		pickupLocation = request.getParameter("picklocation");
		System.out.println("Pick Up Location :"+pickupLocation);
		otherComments = request.getParameter("oc");
		System.out.println("Other Comments :"+otherComments);
//		bookeduserId = (Long) session.getAttribute("UserId");
		System.out.println("Inside Add Passenger Method Getting Booked User ID :"+bookeduserId);
		
		addPassengerInfo(pickupLocation, otherComments, bookeduserId, request, response);
		addResquest(pId, fk_ridepostId, request, response);
		Properties props = System.getProperties();
		props.put("mail.smtps.host","smtp.mailgun.org");
		props.put("mail.smtps.auth","true");
		Session session = Session.getInstance(props, null);
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress("ttwyf67@gmail.com", "Yasir Naseem"));
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		try {
			String tempVar;
			tempVar = postDAO.getuserEmail();
			System.out.println("Inside Mail Send Process :"+tempVar);
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(tempVar, false));
		} catch (AddressException e) {
			
			e.printStackTrace();
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		try {
			msg.setSubject("Carpool Request");
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		try {
			msg.setText("This Man wants to share a ride with you");
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		try {
			msg.setSentDate(new Date());
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}

		try {
			t = (SMTPTransport)session.getTransport("smtps");
		} catch (NoSuchProviderException e1) {
			
			e1.printStackTrace();
		}
		try {
			t.connect("smtp.mailgun.com", "postmaster@sandbox06c893295b2b439fa0142eccb98caa1c.mailgun.org",
					"f5dbcafa5b556d17a1be1f2e1708a252");
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		try {
			t.sendMessage(msg, msg.getAllRecipients());
		} catch (SendFailedException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		System.out.println("Response: " + t.getLastServerResponse());
		try {
			t.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}	
		
		
//		addResquest(fkRideId, pId, request, response);
	}
	
	public void addPassengerInfo(String puLocation,String othercomments,long bookedId,HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Inside Add Passenger Information Method");
//		HttpSession session = null;
//		bookeduserId = (Long) session.getAttribute("UserId");
//		System.out.println("Inside Add Passenger Method Getting Booked User ID :"+bookeduserId);
		PassengerBook passengerbook = new PassengerBook();
		passengerbook.setSourceLocation(puLocation);
		passengerbook.setOtherComment(othercomments);
		passengerbook.setFkBookedUserId(bookeduserId);
		
		PassengerBookDAOImpl dao = new PassengerBookDAOImpl(); 
		try {
			pId  = dao.insert(passengerbook);
			System.out.println("This is Passenger ID :"+pId);
			System.out.println("Passenger Information Insert Successfully");
			req.getRequestDispatcher("WEB-INF/private/user.profile.jsp").forward(req, resp);
//			req.getServletContext().getRequestDispatcher("/CarpoolRequestsController").forward(req, resp);
		} catch (Exception e) {
		System.out.println("Passenger Information Insert Failed :"+e);
			e.printStackTrace();
		}
	}
	public void addResquest(long fk_passengerId,long fk_ridepostId,HttpServletRequest req,HttpServletResponse resp){
		CarpoolRequest carpool = new CarpoolRequest();
		carpool.setFkpassengerId(fk_passengerId);
		carpool.setFkpostRideId(fk_ridepostId);
		
		CarpoolRequestDAOImpl carpoolDao = new CarpoolRequestDAOImpl();
		try {
			carpoolrequestId = carpoolDao.insert(carpool);
			System.out.println("This is CarpoolRequest ID :"+carpoolrequestId);
			System.out.println("Carpools Request Insert Successfully");
		} catch (Exception e) {
			System.out.println("Carpools Request Insert Failed :"+e);
			e.printStackTrace();
		}
	}
}
