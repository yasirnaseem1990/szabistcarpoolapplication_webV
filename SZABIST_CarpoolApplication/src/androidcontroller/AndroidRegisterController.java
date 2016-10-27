package androidcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.impl.UserDAOImpl;
import domain.User;

/**
 * Servlet implementation class AndroidRegisterController
 */
public class AndroidRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONObject jsonObject = new JSONObject();
	String uname,useremail,pwd,cnicNo,mobileNo,sem,dept,uniregno;
//	int fkId = 3;
	String rating="good";
	String vifikey;
	long vifistatus = 1;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Android Register Controller Invoke");
		String from_Android = request.getHeader("from_Android");
		uname = request.getHeader("UserName");
		useremail = request.getHeader("UserEmail");
		pwd = request.getHeader("UserPassword");
		cnicNo = request.getHeader("UserCNIC");
		mobileNo = request.getHeader("UserMobile");
		 uniregno= request.getHeader("UserUniRegistrationNo");
		sem = request.getHeader("UserCurrentSemester");
		dept = request.getHeader("UserDepartment");
		
		
		User user = new User();
		user.setName(uname);
		user.setEmail(useremail);
		user.setPassword(pwd);
//		user.setFkRoleId(fkId);
		user.setCnicno(cnicNo);
		user.setMobileno(mobileNo);
		user.setUniversityregno(uniregno);
		user.setSemester(sem);
		user.setDepartment(dept);
		user.setRating(rating);
		user.setVerificationKey(vifikey);
		user.setVerificationStatu(vifistatus);
		UserDAOImpl daoimpl = new UserDAOImpl();
		try {
			long registerUserId = daoimpl.insert(user);
			if(registerUserId != 0){
				jsonObject.put("info", "success");
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(jsonObject.toJSONString());
			}
			else{
				jsonObject.put("info", "fail");
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(jsonObject.toJSONString());
			}
			System.out.println("No Of User Registered :"+registerUserId);
			
		} catch (Exception e) {
			System.out.println("User Is Not Registered :"+e);
			e.printStackTrace();
		}
		
	}
	
	

}
