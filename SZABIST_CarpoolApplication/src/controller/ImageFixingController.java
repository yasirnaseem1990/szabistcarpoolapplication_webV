package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.UserDAOImpl;
import domain.User;

/**
 * Servlet implementation class ImageFixingController
 */
public class ImageFixingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Blob blob;
       UserDAOImpl daoImpl = new UserDAOImpl();
    
    public ImageFixingController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kese = request.getParameter("action");
		int pId = Integer.parseInt(request.getParameter("userId"));
		System.out.println("Thsi IS PID "+pId);
		if(kese.equals("userimage")){
			User user = new User();
			
				System.out.println(pId);
				user = daoImpl.getpicturebyId(pId);
				System.out.println("Object Value of Product "+user);
				blob = user.getUserpicture();
				System.out.println("This is Blob Value "+blob);
			
		}
		else{
			System.out.println("Some thing is went Wrong IN ImageFixing Controller");
		}
		try {
			response.setContentType("image/jpeg");
			response.setContentLength((int) blob.length());
			InputStream is = blob.getBinaryStream();
			OutputStream os = response.getOutputStream();
			byte buf[] = new byte[(int) blob.length()];
			is.read(buf);
			os.write(buf);
			os.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
