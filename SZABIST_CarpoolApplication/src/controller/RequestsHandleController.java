package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

import dao.impl.PassengerBookDAOImpl;
import domain.User;
import sql.ConnectionFactory;

public class RequestsHandleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SMTPTransport t;
	User u;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RequestsHandleController Invoke");
		String email = (String) request.getSession(false).getAttribute("UserEmail");
		System.out.println("This is Email :"+email);
		System.out.println(request.getSession(false).getAttribute("UserEmail"));
		int requestID = Integer.parseInt(request.getParameter("requestsId"));
		System.out.println("This Is Passenger ID :"+requestID);
		updateSeats(requestID);
		PassengerBookDAOImpl dao = new PassengerBookDAOImpl();
		request.getRequestDispatcher("WEB-INF/public/index.jsp").forward(request, response);
//		try {
//			u = dao.queryAll1(requestID);
//			u.getEmail();
//			u.getMobileno();
//			u.getUserid();
//			System.out.println();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Properties props = System.getProperties();
//		props.put("mail.smtps.host","smtp.mailgun.org");
//		props.put("mail.smtps.auth","true");
//		Session session = Session.getInstance(props, null);
//		Message msg = new MimeMessage(session);
//		try {
//			msg.setFrom(new InternetAddress(email, "Yasir Naseem"));
//		} catch (MessagingException e) {
//			
//			e.printStackTrace();
//		}
//		try {
//			msg.setRecipients(Message.RecipientType.TO,
//					InternetAddress.parse(u.getEmail(), false));
//		} catch (AddressException e) {
//			
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			
//			e.printStackTrace();
//		}
//		try {
//			msg.setSubject("Ride Confirmation");
//		} catch (MessagingException e) {
//			
//			e.printStackTrace();
//		}
//		try {
//			msg.setText("Your Ride is Booked from Driver "+email+ "Now You Can Ride With Hitler "+u.getName()+"\n Courtesy of: Hacking Team");
//		} catch (MessagingException e) {
//			
//			e.printStackTrace();
//		}
//		try {
//			msg.setSentDate(new Date());
//		} catch (MessagingException e) {
//			
//			e.printStackTrace();
//		}
//
//		try {
//			t = (SMTPTransport)session.getTransport("smtps");
//		} catch (NoSuchProviderException e1) {
//			
//			e1.printStackTrace();
//		}
//		try {
//			t.connect("smtp.mailgun.com", "postmaster@sandbox06c893295b2b439fa0142eccb98caa1c.mailgun.org",
//					"f5dbcafa5b556d17a1be1f2e1708a252");
//		} catch (MessagingException e) {
//			
//			e.printStackTrace();
//		}
//		try {
//			t.sendMessage(msg, msg.getAllRecipients());
//		} catch (SendFailedException e) {
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Response: " + t.getLastServerResponse());
//		try {
//			t.close();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}	
	}
 
	
	   static void updateSeats(int reqId) {
		  /*
		      Task: Update seats when the request is accepted.
		      Okay Lets update seats!!
		      Attempt = 2
              Attempt remarks  =                   first attempt didnt work cuz ::
                                                   Statement Not Executed:
	                                               java.sql.SQLException:
                                                   Can not issue data manipulation statements with executeQuery().		                      
		                                           (How the fuck I update it then??) 
		   
		                   ---------------- The Paradox -------------------------
		    user ---- sees ---- offers
		    user ---- reqs ---- offer 
		            /    |
		           /     |
 		     accepts ----|------------> post_ride ---> AvailableSeats = AvailableSeats --;
 		      |          |
 		      |          | 
 		    driver ---- sees
		   
		   
		   */
		   
		    int POST_ID = 0;                     //This fucker.! 
		  
		                                         // getting shitty variables to get work done
		                                         // Hate them
		    Statement stmt = null;
		    Connection connection = null;
		    ResultSet rs = null;
		    connection = ConnectionFactory.getNormalConnection();
		   
		    // Blah Blah Blah
		    
		    String sql = "SELECT fk_Post_Ride_ID FROM carpool_requests WHERE RequestsId ="+reqId+";";
		    
		    // Fucking try catch.
		    try { stmt = connection.createStatement(); } catch (SQLException e) { System.out.println("Statement Not Created: "+ e); }
		    try { rs = stmt.executeQuery(sql); } catch (SQLException e) { System.out.println("Statement Not Executed: "+ e); }
		    try {	while (rs.next()) {
			  
			 POST_ID = rs.getInt("fk_Post_Ride_ID");
			  // got you sonovabitch1
		         } } catch (SQLException e) { System.out.println("Could Not Get t1he POST_ID:: " + e); }
		 
		    System.out.println("This is the POST_ID For uppdating available seats: " + POST_ID);
		    System.out.println("NOW UPDATEING THE SEATS");
		   
		 /*   
		     Now lets go ahead.
		     lemme check if i can update the seats somehow. it souldnt be impossible.
		     to web ...
		     i shoo
		     okay i got this query UPDATE table SET field = field - 1 WHERE id = $number
		     should work. lets try it in mySql first.
		     Yeah It works.....
		   */
		     int i = 0;
		    
		     // Trying executeUpdate() -- > Success
		    String sql1 = "UPDATE post_ride SET Available_Seats = Available_Seats - 1 WHERE PostRideId = " + POST_ID + " ;";
		    //Copy pasting this shit.
		    try { stmt = connection.createStatement(); } catch (SQLException e) { System.out.println("Statement Not Created: "+ e); }
		    try { i = stmt.executeUpdate(sql1);  } catch (SQLException e) { System.out.println("Statement Not Executed: "+ e); }
            System.out.println("@@@@@@@@Seats updated@@@@@@@@@@@@");
            System.out.println("@@@@@ RETURNING TO NORMAL");
            //Lets run it.
            // Done
	}
}
