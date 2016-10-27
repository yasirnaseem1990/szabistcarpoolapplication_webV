package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.impl.UserDAOImpl;
import domain.User;

/**
 * Servlet implementation class AndroidLoginController
 */
public class AndroidLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
String uemail,upwd;
JSONObject json = new JSONObject();
	
//	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
//	
//	uemail = request.getParameter("u");
//	upwd = request.getParameter("p");
//	androidLoginCheck(uemail, upwd, request, response);
//	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		boolean from_android = request.getHeader("from_android") != null ? true:false;
		if(from_android){
			uemail = request.getHeader("userEmail");
			System.out.println("Value get From Mobile :"+uemail);
			upwd = request.getHeader("userPass");
		}
		
		
		User user = new User();
		user.setEmail(uemail);
		user.setPassword(upwd);
		UserDAOImpl daoimpl = new UserDAOImpl();
		try {
			boolean flag = daoimpl.AuthenticateUser(user);
			if(flag){
				json.put("info", "success");
//				json.put("name", user.getName());
//				json.put("email", user.getEmail());
//				json.put("id", user.getUserId());
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json.toJSONString());
			}
			else{
				json.put("info", "fail");
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json.toJSONString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	

}
