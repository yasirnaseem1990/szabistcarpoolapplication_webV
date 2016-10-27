package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public FrontController() {
        super();
     
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getRequestURI();
		System.out.println("In FrontController" +url);
		
		if(url.endsWith("/")){
			request.getRequestDispatcher(ViewResolver(url, 2)).forward(request, response);
		}
		else if(url.contains("home")){
			request.getRequestDispatcher("WEB-INF/public/index.jsp").forward(request, response);
		}
		else if(url.contains("login")){
			request.setAttribute("url", url);
			request.getRequestDispatcher(ViewResolver(url, 2)).forward(request, response);
		}
		else if(url.contains("user")){
			request.setAttribute("url", url);
			request.getRequestDispatcher("/UserController").forward(request, response);
		}
		else if(url.contains("register")){
			request.setAttribute("url", url);
			request.getRequestDispatcher(ViewResolver(url, 2)).forward(request, response);
//			request.getRequestDispatcher("/RegisterController").forward(request, response);
		}
	else if(url.contains("offerride")){
		Object session = request.getSession().getAttribute("UserEmail");
		if(session!=null){
			System.out.println("Going to Modal to take some Passenger Information");
			request.getRequestDispatcher(ViewResolver(url, 1)).forward(request, response);
		}
		else{
			System.out.println("Your Are Not Allow to Access this page. Please Register Yourself Firsts");
			request.getRequestDispatcher("/WEB-INF/public/login.jsp").forward(request, response);
		}	
			
		}
	else if(url.contains("carpoolrequests")){
		Object session = request.getSession().getAttribute("UserEmail");
		if(session!=null){
			System.out.println("Going to Given URL ");
			request.setAttribute("Url", url);
			request.getRequestDispatcher("/CarpoolRequestsController").forward(request, response);
		}
		else{
			System.out.println("Your Are Not Allow to Access this page.");
		}
	}
	
	else if(url.contains("view/allride")){
		request.getRequestDispatcher(ViewResolver(url, 2)).forward(request, response);
	}
	else if(url.contains("test")){
		request.getRequestDispatcher(ViewResolver(url, 2)).forward(request, response);
	}
	else if(url.contains("ride/discussion")){
		request.getRequestDispatcher(ViewResolver(url, 1)).forward(request, response);
	}
	else if(url.contains("bookpassenger")){
		request.setAttribute("url", url);
		request.getRequestDispatcher("/BookRideController").forward(request, response);
	}
	else if(url.contains("acceptrequest")){
		request.setAttribute("url", url);
		request.getRequestDispatcher("/RequestsHandleController").forward(request, response);
	}
		else{
			System.out.println("URL IS INCORRECT");
		}
	}

	
	
	public static String  ViewResolver(String url, int CASE)
	 {
	  System.out.println("**************************************************************************************************");
	  String forward = null;
	  System.out.println("Initial URL: " + url);
	  String p[] = url.split("/");
	  for(int i =0 ; i <p.length;i++){
		  System.out.println("p ["+i+"] = " +p[i]);
	  }
	  int len = p.length;
	  System.out.println("url length :" + len);
	  if(CASE == 2){
		 switch(len){
		 
		 case 2:
			 forward ="/WEB-INF/public/index.jsp";
			 break;
		 case 3:
			 forward ="/WEB-INF/public/" +p[2]+".jsp";
			 break;
		 case 4:
			 forward ="/WEB-INF/public/"+p[2]+"."+p[3]+".jsp";
		
		 }
		
	  }
	  if(CASE == 1){
		  switch(len){
		  case 2:
			  forward = "/WEB-INF/public/index.jsp";
			  break;
		  case 3:
			  forward ="/WEB-INF/private/" +p[2]+".jsp";
			  break;
		  case 4:
			  forward ="/WEB-INF/private/" +p[2]+"."+p[3]+".jsp";
		  }
	  }
	  
//	  else
//	  {
//	   System.out.println("Invalid Url");
//	  }
	  System.out.println("**************************************************************************************************");
	  return forward;
	 }//end method
	
}
