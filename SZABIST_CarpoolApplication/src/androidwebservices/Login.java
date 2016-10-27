package androidwebservices;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import controller.FrontController;
import dao.BridgeTableDAO;
import dao.impl.BridgeTableDAOImpl;
import dao.impl.UrlDAOImpl;
import dao.impl.UserDAOImpl;
import domain.User;



//Path: http://localhost/<appln-folder-name>/login
@Path("/login")
public class Login {
	// HTTP Get Method
		@GET 
		// Path: http://localhost/<appln-folder-name>/login/dologin
		@Path("/dologin")
		// Produces JSON as response
		@Produces(MediaType.APPLICATION_JSON) 
		// Query parameters are parameters: http://localhost/<appln-folder-name>/login/dologin?username=abc&password=xyz
		public String doLogin(@QueryParam("email") String email, @QueryParam("password") String pwd){
			String response = "";
			if(loginCheck(email, pwd)){
				response = Utitlity.constructJSON("login",true);
			}else{
				response = Utitlity.constructJSON("login", false, "Incorrect Email or Password");
			}
		return response;		
		}
		
		public boolean loginCheck(String uemail,String upassword){
			boolean flag = false;
			System.out.println("@@@@@@@@@ Login Method Invoke @@@@@@@@@");
			User user = new User();
			user.setEmail(uemail);
			user.setPassword(upassword);
			UserDAOImpl daoimpl = new UserDAOImpl();
			try {
				 flag = daoimpl.AuthenticateUser(user);
				System.out.println("@@@@@@@@@ Login Successfull @@@@@@@@@ :"+flag);
				
			} catch (Exception e) {
				System.out.println("Error In UserController Permission "+e);
				e.printStackTrace();
			}
			return flag;
		}
}
