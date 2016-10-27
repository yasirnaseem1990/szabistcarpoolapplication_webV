package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import controller.UserController;
import sql.BaseDAO;
import sql.ConnectionFactory;
import sql.PreparedStatementSetter;
import sql.ResultSetExtractor;
import dao.PostRideDAO;
import domain.PostRide;


public  class PostRideDAOImpl extends BaseDAO implements PostRideDAO{
	private Statement stmt;
	ResultSet rs;
	private Connection connection;
	public static final sql.DAOCache cache = new sql.DAOCache();
	public static long postRideId;
	public sql.DAOCache getCache() {
		return cache;
	}

	protected void clearCacheOnInsert(PostRide data){}

	public PostRide load(final Long id) throws Exception{
		String sql = "SELECT * FROM post_ride WHERE id=?";
		return (PostRide) getRow(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		}, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			PostRide row  = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	});
	}

	public int delete(final Long id) throws Exception{
		cache.clear(id);
		String sql = "DELETE FROM post_ride WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		});
	}

	public int update(final PostRide data) throws Exception{
		cache.clear(data.getPostrideId());
		String sql = "UPDATE post_ride SET PostRide_Title = ?, PostRide_Description = ?, Source_Location = ?, Destination_Location = ?, Date = ?, Fair = ?, Total_Seats = ?, Available_Seats = ?, Car_Name = ?, Car_Model = ?, fk_User_Id = ? WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setString(1, data.getPostridetitle());
				ps.setString(2, data.getPostridedescription());
				ps.setString(3, data.getSourcelocation());
				ps.setString(4, data.getDestinationlocation());
				ps.setString(5, data.getDate());
				ps.setString(6, data.getFair());
				ps.setString(7, data.getTotalseat());
				ps.setString(8, data.getAvailableseat());
				ps.setString(9, data.getCarname());
				ps.setString(10, data.getCarmodel());
				ps.setLong(11, data.getFkUserId());
//				ps.setLong(12, data.getFkCarpoolRequestsID());
				ps.setLong(13, data.getPostrideId());
			}
	});
	}

	public ResultSetExtractor getDefaultExtractor() throws Exception{
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			PostRide row  = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	};
	}

	public long insert(final PostRide data) throws Exception{
		clearCacheOnInsert(data);
		System.out.println("Inside Insert Method In PostRideDAOImpl :"+UserController.session.getAttribute("UserId"));
		String sql = "INSERT INTO post_ride ( PostRide_Title, PostRide_Description, Source_Location, Destination_Location, Date, Fair, Total_Seats, Available_Seats, Car_Name, Car_Model, fk_User_Id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		long id = executeInsert(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setString(1, data.getPostridetitle());
				ps.setString(2, data.getPostridedescription());
				ps.setString(3, data.getSourcelocation());
				ps.setString(4, data.getDestinationlocation());
				ps.setString(5, data.getDate());
				ps.setString(6, data.getFair());
				ps.setString(7, data.getTotalseat());
				ps.setString(8, data.getAvailableseat());
				ps.setString(9, data.getCarname());
				ps.setString(10, data.getCarmodel());
				ps.setLong(11, data.getFkUserId());
//				ps.setLong(12, data.getFkCarpoolRequestsID());
			}
		});
		data.setPostrideId(id);
		return id;
	}

	public List<PostRide> queryAll()throws Exception{
		String sql = "SELECT * FROM post_ride";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PostRide row = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	});
	}

	 public ResultSetExtractor getListResultSetExtractor(){
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PostRide row = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	};
	}

	public List<PostRide> queryByPostRideId(Long PostRideId)throws Exception{
		String sql = "SELECT * FROM post_ride WHERE PostRideId='"+PostRideId+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PostRide row = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	});
	}
	public List<PostRide> queryByPostRideTitle(String PostRideTitle)throws Exception{
		String sql = "SELECT * FROM post_ride WHERE PostRide_Title='"+PostRideTitle+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PostRide row = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	});
	}
	public List<PostRide> queryByPostRideDescription(String PostRideDescription)throws Exception{
		String sql = "SELECT * FROM post_ride WHERE PostRide_Description='"+PostRideDescription+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PostRide row = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	});
	}
	public List<PostRide> queryBySourceLocation(String SourceLocation)throws Exception{
		String sql = "SELECT * FROM post_ride WHERE Source_Location='"+SourceLocation+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PostRide row = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	});
	}
	public List<PostRide> queryByDestinationLocation(String DestinationLocation)throws Exception{
		String sql = "SELECT * FROM post_ride WHERE Destination_Location='"+DestinationLocation+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PostRide row = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	});
	}
	public List<PostRide> queryByDate(Date Date)throws Exception{
		String sql = "SELECT * FROM post_ride WHERE Date='"+Date+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PostRide row = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	});
	}
	public List<PostRide> queryByFair(String Fair)throws Exception{
		String sql = "SELECT * FROM post_ride WHERE Fair='"+Fair+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PostRide row = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	});
	}
	public List<PostRide> queryByTotalSeat(String TotalSeat)throws Exception{
		String sql = "SELECT * FROM post_ride WHERE Total_Seats='"+TotalSeat+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PostRide row = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	});
	}
	public List<PostRide> queryByAvailableSeat(String AvailableSeat)throws Exception{
		String sql = "SELECT * FROM post_ride WHERE Available_Seats='"+AvailableSeat+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PostRide row = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	});
	}
	public List<PostRide> queryByCarName(String CarName)throws Exception{
		String sql = "SELECT * FROM post_ride WHERE Car_Name='"+CarName+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PostRide row = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	});
	}
	public List<PostRide> queryByCarModel(String CarModel)throws Exception{
		String sql = "SELECT * FROM post_ride WHERE Car_Model='"+CarModel+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PostRide row = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	});
	}
	public List<PostRide> queryByFkUserId(Long fkUserId)throws Exception{
		String sql = "SELECT * FROM post_ride WHERE fk_User_Id='"+fkUserId+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PostRide row = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	});
	}
	
	public List<PostRide> queryByFkCarpoolRequestsID(Long fkCarpoolRequestsID)throws Exception{
		String sql = "SELECT * FROM post_ride WHERE fk_CarpoolRequestsID='"+fkCarpoolRequestsID+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PostRide row = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
				row.setPostridetitle(rs.getString("PostRide_Title"));
				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
				row.setFair(rs.getString("Fair"));
				row.setTotalseat(rs.getString("Total_Seats"));
				row.setAvailableseat(rs.getString("Available_Seats"));
				row.setCarname(rs.getString("Car_Name"));
				row.setCarmodel(rs.getString("Car_Model"));
				row.setFkUserId(rs.getLong("fk_User_Id"));
//				row.setFkCarpoolRequestsID(rs.getLong("fk_CarpoolRequestsID"));
				return row;
			}
	});
	}
	
	
	public List<PostRide> searchRide(PostRide post)throws Exception{
		
		String sql ="SELECT * FROM post_ride WHERE Source_Location =? and Destination_Location = ? and Date = ?";
		System.out.println("Inside searchRide Method Printint Queury :"+sql);
//		String sql = "SELECT * FROM post_ride WHERE Date='"+Date+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PostRide row = new PostRide();
//				row.setPostrideId(rs.getLong("PostRideId"));
//				row.setPostridetitle(rs.getString("PostRide_Title"));
//				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
//				row.setFair(rs.getString("Fair"));
//				row.setTotalseat(rs.getString("Total_Seats"));
//				row.setAvailableseat(rs.getString("Available_Seats"));
//				row.setCarname(rs.getString("Car_Name"));
//				row.setCarmodel(rs.getString("Car_Model"));
//				row.setFkUserId(rs.getLong("fk_User_Id"));
				return row;
			}
	});
	}
	
	//Load Search Rides
	public PostRide loadsearchRide(final PostRide postride) throws Exception{
		String sql ="SELECT * FROM post_ride WHERE Source_Location =? and Destination_Location = ? and Date = ?";
		System.out.println("Inside searchRide Method Printint Queury :"+sql);
		return (PostRide) getRow(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setString(1, postride.getSourcelocation());
				ps.setString(2, postride.getDestinationlocation());
				ps.setString(3, postride.getDate());
			}
		}, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			PostRide row  = new PostRide();
				row.setPostrideId(rs.getLong("PostRideId"));
//				row.setPostridetitle(rs.getString("PostRide_Title"));
//				row.setPostridedescription(rs.getString("PostRide_Description"));
				row.setSourcelocation(rs.getString("Source_Location"));
				row.setDestinationlocation(rs.getString("Destination_Location"));
				row.setDate(rs.getString("Date"));
//				row.setFair(rs.getString("Fair"));
//				row.setTotalseat(rs.getString("Total_Seats"));
//				row.setAvailableseat(rs.getString("Available_Seats"));
//				row.setCarname(rs.getString("Car_Name"));
//				row.setCarmodel(rs.getString("Car_Model"));
//				row.setFkUserId(rs.getLong("fk_User_Id"));
				return row;
			}
	});
	}// End of Load Search Ride Method
	
	//Verify Search Ride 
	public boolean verifysearchRid(PostRide postride){
		System.out.println("Verifying PostRide using Source_Location :"+postride.getSourcelocation()+" "
		+ "and Destination_Location :"+postride.getDestinationlocation()+" and Date :"+postride.getDate());
		boolean flag = false;
		PostRide post;
		try {
			post = loadsearchRide(postride);
			if(post!=null){
				flag = true;
				System.out.println("Ride is Search And Loaded");
			}
			else{
				flag = false;
				System.out.println("Ride Search & Load is Failed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}//End of verify Search Ride Method
	
	
	public String getuserEmail(){
		connection = ConnectionFactory.getNormalConnection();
		String userEmail = null,userName = null;
	    int rideId;
		String query = "SELECT carpool_db.user.Name, carpool_db.user.Email, carpool_db.post_ride.PostRideId FROM carpool_db.user INNER JOIN carpool_db.post_ride ON carpool_db.user.UserId = carpool_db.post_ride.fk_User_Id;";
		try {
			stmt = connection.createStatement();
			System.out.println("Query Printing Inside getuserEmail :"+query);
			rs = stmt.executeQuery(query);
			while(rs.next()){
				userName = rs.getString("Name");
				System.out.println("Inside getuserEmail Method :UserName :"+userName);
				userEmail = rs.getString("Email");
				System.out.println("Inside getuserEmail Method :UserEmail :"+userEmail);
				rideId = rs.getInt("PostRideId");
				System.out.println("Inside getuserEmail Method :RideID :"+rideId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userEmail;
		
	}

	}