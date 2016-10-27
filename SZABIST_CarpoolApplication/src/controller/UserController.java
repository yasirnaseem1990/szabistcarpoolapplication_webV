package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BridgeTableDAO;
import dao.impl.BridgeTableDAOImpl;
import dao.impl.UrlDAOImpl;
import dao.impl.UserDAOImpl;
import domain.User;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static HttpSession session;
	boolean islogout;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
//		response.setHeader("Cache-Control","no-cache");
		System.out.println("@@@@@@@@@ UserController Invoke @@@@@@@@@");
		String userControllerUrl = (String) request.getAttribute("url");
		System.out.println("Url Get From UserController :"+userControllerUrl);
		String useremail =null, pass = null;
		useremail = request.getParameter("email");
		System.out.println("User Email :"+useremail);
		pass = request.getParameter("password");
		System.out.println("User Password :"+pass);
		// end outer if	
		Login(useremail, pass,request,response);
	}//End Service
	
	boolean checkLoginCase(String ue,String p)
	{
		boolean flag  = ( ue == null && p == null) ? true : false;
		System.out.println("LOGIN CHECK ? ? ? : " + flag);
		return flag;
	}
	
	public void Login(String uemail,String upassword, HttpServletRequest req, HttpServletResponse resp){
//		resp.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		System.out.println("@@@@@@@@@ Login Method Invoke @@@@@@@@@");
		User user = new User();
		user.setEmail(uemail);
		user.setPassword(upassword);
		UserDAOImpl daoimpl = new UserDAOImpl();
		try {
			boolean flag = daoimpl.AuthenticateUser(user);
			System.out.println("@@@@@@@@@ Login Successfull @@@@@@@@@ :"+flag);
			if(flag){
				session = req.getSession();
				System.out.println("THIS IS USERID INSIDE LOGIN METHOD :"+UserDAOImpl.userId);
				long tempUserId = UserDAOImpl.userId;
				System.out.println("Printing UserID for Showing UserProfile :"+tempUserId);
				session.setAttribute("UserId", UserDAOImpl.userId);
				session.setAttribute("UserName", UserDAOImpl.userName);
				session.setAttribute("UserEmail", uemail);
				req.setAttribute("UserProfile", daoimpl.queryByUserId(tempUserId));
				String url = FrontController.ViewResolver("/WEB-INF/user/profile", 1);
				System.out.println("@@@@@@@@@ Resolved Url Is @@@@@@@@@ "+url);
//				UrlDAOImpl urldaoimpl = new UrlDAOImpl();
//				urldaoimpl.queryByUrlScheme(url);
//				System.out.println("This Is The Id Of User :"+UserDAOImpl.usr_fid_for_login);
//				System.out.println("This Is The Id Of Url :"+UrlDAOImpl.url_id_for_Bridge);
//				BridgeTableDAO bridgeDao = new BridgeTableDAOImpl();
//				boolean brigdeflag  = bridgeDao.checkPermission(UserDAOImpl.usr_fid_for_login, UrlDAOImpl.url_id_for_Bridge);
//				if(brigdeflag){
//					System.out.println(" @@@@@@@@@ Lets Go Permission Is Checked @@@@@@@@@");
////					req.getRequestDispatcher(url).forward(req, resp);
//				}
				req.getRequestDispatcher(url).forward(req, resp);
			}
		} catch (Exception e) {
			System.out.println("Error In UserController Permission "+e);
			e.printStackTrace();
		}
	}

}
