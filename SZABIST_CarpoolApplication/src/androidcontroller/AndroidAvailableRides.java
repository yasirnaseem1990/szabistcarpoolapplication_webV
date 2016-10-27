package androidcontroller;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import androidModel.Test;
import androidModel.TestParent;
import dao.impl.PostRideDAOImpl;
import domain.PostRide;

/**
 * Servlet implementation class AndroidAvailableRides
 */
public class AndroidAvailableRides extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONObject json = new JSONObject();
	PostRideDAOImpl dao = new PostRideDAOImpl();
	
	public AndroidAvailableRides(){
		super();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("Android Available Rides Controller Invoke");
		
		Test test = new Test();
		test.setName("Yasir");
//		PostRide postRide = new PostRide();
//		TestParent parent = new TestParent();
//		parent.setTest(test);
//		ArrayList<PostRide> ulist = new ArrayList<PostRide>() ;
//		ulist.add(postRide);
		PostRideDAOImpl daoImpl = new PostRideDAOImpl();
		String jo = null;
		try {
			jo = (new Gson().toJson(daoImpl.queryAll()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonObject j = new JsonObject();
		j.addProperty("list", jo);
		String json = j.toString();
		System.out.println("This is Json :"+json);
		System.out.println("LIST IN JSON : "+jo);
		
		//Sending List to Android
//		Type type = (Type) new TypeToken<PostRide>(){}.getType();
	
//		ArrayList<PostRide> list = new Gson().fromJson(jo, type);
//		for(int i=0;i<list.size();i++){
//			PostRide postRide2 = list.get(i);
//			System.out.println("Source Location :"+postRide2.getSourcelocation());
//			
//		}
		//ob.put("o", json);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(""+jo);
		
	}

	

}
