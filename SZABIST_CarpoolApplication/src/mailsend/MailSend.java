//package mailsend;
//import java.io.UnsupportedEncodingException;
//import java.util.Date;
//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//import com.sun.mail.smtp.SMTPTransport;
//
//
//
//
//public class MailSend{
//	
//	
//	static String  name ="some text testing";
//	public static void main(String args[]) throws AddressException, MessagingException, UnsupportedEncodingException{
//		
//		Properties props = System.getProperties();
//        props.put("mail.smtps.host","smtp.mailgun.org");
//        props.put("mail.smtps.auth","true");
//        Session session = Session.getInstance(props, null);
//        Message msg = new MimeMessage(session);
//        msg.setFrom(new InternetAddress("ttwyf67@gmail.com", "Yasir Naseem"));
//        msg.setRecipients(Message.RecipientType.TO,
//        InternetAddress.parse("ttwyf67@hotmail.com", false));
//        msg.setSubject("Hello");
//        msg.setText(name);
//        msg.setSentDate(new Date());
//        SMTPTransport t =(SMTPTransport)session.getTransport("smtps");
//        t.connect("smtp.mailgun.com", "postmaster@sandbox06c893295b2b439fa0142eccb98caa1c.mailgun.org",
//        		"f5dbcafa5b556d17a1be1f2e1708a252");
//        t.sendMessage(msg, msg.getAllRecipients());
//        System.out.println("Response: " + t.getLastServerResponse());
//        t.close();	
//	}
//}