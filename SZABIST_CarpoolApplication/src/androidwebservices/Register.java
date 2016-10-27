package androidwebservices;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.impl.UserDAOImpl;
import domain.User;

//Path: http://localhost/<appln-folder-name>/register
@Path("/register")
public class Register {
//	static int fkId = 3;
	static String rating="good";
	static String vifikey = "3da373eb15d965b866be3d3e51c0e1b9";
	static long vifistatus = 1;
	// HTTP Get Method
		@GET 
		// Path: http://localhost/<appln-folder-name>/register/doregister
		@Path("/doregister")  
		// Produces JSON as response
		@Produces(MediaType.APPLICATION_JSON)
		public String doregister(@QueryParam("name") String username, @QueryParam("email") 
		String uemail, @QueryParam("cnic") String ucnic, @QueryParam("mobileno") String umobileno,
		@QueryParam("password") String upassword, @QueryParam("universityregno") String uniregno,
		@QueryParam("semester") String usemester,@QueryParam("department") String department,
		@QueryParam("rating") String rating){
			String response = "";
			addUser(username, uemail, ucnic, upassword, uniregno, usemester, department, rating, umobileno, vifikey, vifistatus);
			response = Utitlity.constructJSON("register", true);
			return response;
		}
		
		
		public static void addUser(String un,String uemail,String upwd,String cnicno,String usemester,String umobileno,String uregno,String udept,
				String rate,String verifykey,long verifystatus){
			User user = new User();
			user.setName(un);
			user.setEmail(uemail);
			user.setPassword(upwd);
			user.setCnicno(cnicno);
			user.setMobileno(umobileno);
			user.setUniversityregno(uregno);
			user.setSemester(usemester);
			user.setDepartment(udept);
			user.setRating(rate);
			user.setVerificationKey(verifykey);
			user.setVerificationStatu(verifystatus);
			UserDAOImpl daoimpl = new UserDAOImpl();

			try {
				long registerUserId = daoimpl.insert(user);
				System.out.println("No Of User Registered :"+registerUserId);
//				req.getRequestDispatcher("/WEB-INF/public/test.jsp").forward(req, resp);
			} catch (Exception e) {
				System.out.println("User Is Not Registered :"+e);
				e.printStackTrace();
			}

		}
}
