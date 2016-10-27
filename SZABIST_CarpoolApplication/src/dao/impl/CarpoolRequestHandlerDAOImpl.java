package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.CarpoolRequest;
import domain.CarpoolRequestHandler;
import sql.BaseDAO;
import sql.ConnectionFactory;
import sql.ResultSetExtractor;

public class CarpoolRequestHandlerDAOImpl extends BaseDAO{


	public static ArrayList<Object> theListReturner( int thePID){    // PassengerID goes here

		ArrayList<Object> pessDetails = new ArrayList<Object>();


		Statement stmt = null;
		Connection connection = null;
		ResultSet rs = null;
		connection = ConnectionFactory.getNormalConnection();

//		String name = null;
//		String sourceLocation = null;
//		int fkBKDId = 0; 

		String sql = " select u.Name,u.Mobile_No, p.Source_Location, p.fk_Booked_UserId from user u, passenger_book p where u.UserId=p.fk_Booked_UserId AND PassengerId =" + thePID+";";
//		String sql = "select u.Name, p.Source_Location, p.fk_Booked_UserId,RequestsId from user u, passenger_book p, carpool_requests c where u.UserId=p.fk_Booked_UserId AND PassengerId" + thePID+";";
		try {
			stmt = connection.createStatement(); 
		} 
		catch (SQLException e) 
		{ 
			System.out.println("Statement Not Created: "+ e);
		}
		try {
			rs = stmt.executeQuery(sql); 
		} catch (SQLException e) 
		{ 
			System.out.println("Statement Not Executed: "+ e);
		}
		CarpoolRequestHandler carpoolRequestHandler = new CarpoolRequestHandler();
		try {
			while (rs.next()) {
				carpoolRequestHandler.setName(rs.getString("Name"));
				carpoolRequestHandler.setSourcelocation(rs.getString("Source_Location"));
				carpoolRequestHandler.setFk_booked_userid(rs.getInt("fk_Booked_UserId"));
				carpoolRequestHandler.setMobileno(rs.getString("Mobile_No"));
//				carpoolRequestHandler.setRequestsid(rs.getInt("RequestsId"));
//				name = rs.getString("Name");
//				sourceLocation = rs.getString("Source_Location");
//				fkBKDId = rs.getInt("fk_Booked_UserId");
			}
			pessDetails.add(carpoolRequestHandler);
//			pessDetails.add(name);
//			pessDetails.add(sourceLocation);
//			pessDetails.add(fkBKDId);

		} catch (SQLException e)
		{ 

			System.out.println("Could Not Get t1he POST_ID:: " + e); 

		}

		return pessDetails;
	}
	
	
	public List<CarpoolRequest> queryAll()throws Exception{
		String sql = "SELECT * FROM carpool_requests";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				CarpoolRequest row = new CarpoolRequest();
				row.setRequestsId(rs.getLong("RequestsId"));
				row.setFkpassengerId(rs.getLong("fk_PassengerID"));
				row.setFkpostRideId(rs.getLong("fk_Post_Ride_ID"));
				return row;
			}
	});
	}
}
