package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String testUrl = request.getRequestURI();
		System.out.println("@@@@@@@@@ Url Get From TestServlet  :"+testUrl);
		String Id = request.getParameter("pinNo");
		System.out.println("This is id :" + Id);
		System.out.println("@@@@@@@@@ Random No Get In TestServlet :"+RegisterController.randNo);
		if(RegisterController.randNo.equals(Id)){
			System.out.println("@@@@@@@@@ Your Email Is Verified Pin Code Is Match Thank You @@@@@@@@@");
			request.getRequestDispatcher("/WEB-INF/public/login.jsp").forward(request, response);
		}
		else{
			System.out.println("Code Is Incorrect");
		}
//		RegisterController.addUser(RegisterController.uname, RegisterController.useremail,
//				RegisterController.pwd, RegisterController.sem, 
//				RegisterController.mobileNo, RegisterController.uniregno, RegisterController.dept,
//				RegisterController.rating, RegisterController.vifikey, RegisterController.vifistatus, request, response);
		
	}

}
