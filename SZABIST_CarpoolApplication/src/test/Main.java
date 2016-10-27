package test;

import dao.impl.CarpoolRequestDAOImpl;
import dao.impl.PassengerBookDAOImpl;
import dao.impl.PostRideDAOImpl;

public class Main {

	public static void main(String[] args) {
		String tempVar;
		PassengerBookDAOImpl dao = new PassengerBookDAOImpl();
		CarpoolRequestDAOImpl carpoolRequestDAOImpl = new CarpoolRequestDAOImpl();
		try {
			
			carpoolRequestDAOImpl.queryByUserId((long) 22);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}
