package controller;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import sql.ConnectionFactory;

import com.sun.mail.smtp.SMTPTransport;


@MultipartConfig(maxFileSize = 16177215) // upload file up to 16MB
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	static String  name ="some text testing";
	Connection conn;
	public static String randNo;
	SMTPTransport t;
	public static String uname,useremail,pwd,cnicNo,mobileNo,sem,dept,uniregno,userpicture;
//	static int fkId = 3;
	static String rating="good";
	static String vifikey;
	static long vifistatus = 1;
	StringBuffer stringBuffer = new StringBuffer();
	public RegisterController(){
		conn = ConnectionFactory.getNormalConnection();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("@@@@@@@@@ RegisterController Invoke @@@@@@@@@");
		String registerUrl = request.getRequestURI();
		System.out.println("Url Get From RegisterController :" +registerUrl);
		uname = request.getParameter("name");
		pwd = request.getParameter("password");
		useremail = request.getParameter("email");
		cnicNo = request.getParameter("cnic");
		mobileNo = request.getParameter("mobileno");
		sem = request.getParameter("semester");
		dept = request.getParameter("department");
		uniregno = request.getParameter("universityregno");

		
		InputStream inputStream = null;

		// obtains the upload file part in this multipart request
		Part filePart = request.getPart("userPicture");
		System.out.println("FILE PART :"+filePart);
		if (filePart != null) {
			// debug messages
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());

			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
		}
		else{
			System.out.println("Some thing went Wrong Image is not Uploaded");
		}

		String message = null; // message will be sent back to client
		
		
		try {
			String sql = "INSERT INTO user ( Name, Email, CNIC_No, Mobile_No, Password, University_Reg_No, Semester, Department, Rating,Verification_key, Verification_status,UserPicture) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
			System.out.println("Printing Query :"+sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, useremail);
			ps.setString(3, cnicNo);
			ps.setString(4, mobileNo);
			ps.setString(5, pwd);
			ps.setString(6, uniregno);
			ps.setString(7, sem);
			ps.setString(8, dept);
			ps.setString(9, rating);
//			ps.setLong(10, data.getFkRoleId());
			ps.setString(10, vifikey);
			ps.setLong(11, vifistatus);
			if (inputStream != null) {
				// fetches input stream of the upload file for the blob column
				ps.setBlob(12, inputStream);
			}

			// sends the statement to the database server
			int row = ps.executeUpdate();
			if (row > 0) {
				message = "Image is uploaded successfully into the Database";
			}
//			ps.setBlob(12, data.getUserPicture());
		} catch (SQLException e2) {
			message = "ERROR: " + e2.getMessage();
			e2.printStackTrace();
		}

		
		
		String data = useremail;
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(data.getBytes());
			byte[] messageDigestMD5 = messageDigest.digest();

			for (byte bytes : messageDigestMD5) {
				stringBuffer.append(String.format("%02x", bytes & 0xff));
			}
			vifikey = stringBuffer.toString();
			System.out.println("data:" + data);
			System.out.println("Hash Code of Given Data:" + stringBuffer.toString());
		} catch (NoSuchAlgorithmException exception) {
			
			exception.printStackTrace();
		}
		
		randNo=Integer.toString(randomNumber());
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
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(useremail, false));
		} catch (AddressException e) {
			
			e.printStackTrace();
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		try {
			msg.setSubject("Secuirty No To Verify Your Email");
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		try {
			msg.setText("This is Your Secret No Enter This No to Activate Your Email:"+randNo);
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
		request.getRequestDispatcher("/WEB-INF/public/test.jsp").forward(request, response);
	}




	public int randomNumber(){
		Random rand = new Random();
		int no =rand.nextInt(1000);
		System.out.println("This is Random No generated :"+no);
		return no;
	}
}
