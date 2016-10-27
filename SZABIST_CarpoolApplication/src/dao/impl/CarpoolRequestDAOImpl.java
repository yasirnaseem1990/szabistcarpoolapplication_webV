package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import sql.BaseDAO;
import sql.ConnectionFactory;
import sql.PreparedStatementSetter;
import sql.ResultSetExtractor;
import dao.CarpoolRequestDAO;
import domain.CarpoolRequest;


public  class CarpoolRequestDAOImpl extends BaseDAO implements CarpoolRequestDAO{
	public static final sql.DAOCache cache = new sql.DAOCache();
	private Statement stmt;
	private Connection connection;
	public static int fkPassengerId;
	public sql.DAOCache getCache() {
		return cache;
	}
	public CarpoolRequestDAOImpl(){
		connection = ConnectionFactory.getNormalConnection();
	}

	protected void clearCacheOnInsert(CarpoolRequest data){}

	public CarpoolRequest load(final Long id) throws Exception{
		String sql = "SELECT * FROM carpool_requests WHERE id=?";
		return (CarpoolRequest) getRow(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		}, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			CarpoolRequest row  = new CarpoolRequest();
				row.setRequestsId(rs.getLong("RequestsId"));
				row.setFkpassengerId(rs.getLong("fk_PassengerID"));
				row.setFkpostRideId(rs.getLong("fk_Post_Ride_ID"));
				return row;
			}
	});
	}
	
	public List<CarpoolRequest> queryAllbyID(final long Id)throws Exception{
		String sql = "SELECT * FROM carpool_requests WHERE RequestsId=?";
		return (List) getRow(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, Id);
			}
		}, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			CarpoolRequest row  = new CarpoolRequest();
				row.setRequestsId(rs.getLong("RequestsId"));
				row.setFkpassengerId(rs.getLong("fk_PassengerID"));
				row.setFkpostRideId(rs.getLong("fk_Post_Ride_ID"));
				return row;
			}
	});
	}

	public int delete(final Long id) throws Exception{
		cache.clear(id);
		String sql = "DELETE FROM carpool_requests WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		});
	}

	public int update(final CarpoolRequest data) throws Exception{
		cache.clear(data.getFkpostRideId());
		String sql = "UPDATE carpool_requests SET fk_PassengerID = ?, fk_Post_Ride_ID = ? WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, data.getFkpassengerId());
				ps.setLong(2, data.getFkpostRideId());
				ps.setLong(3, data.getRequestsId());
			}
	});
	}

	public ResultSetExtractor getDefaultExtractor() throws Exception{
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			CarpoolRequest row  = new CarpoolRequest();
				row.setRequestsId(rs.getLong("RequestsId"));
				row.setFkpassengerId(rs.getLong("fk_PassengerID"));
				row.setFkpostRideId(rs.getLong("fk_Post_Ride_ID"));
				return row;
			}
	};
	}

	public long insert(final CarpoolRequest data) throws Exception{
		clearCacheOnInsert(data);
		String sql = "INSERT INTO carpool_requests ( fk_PassengerID, fk_Post_Ride_ID) VALUES (?, ? )";
		long id = executeInsert(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, data.getFkpassengerId());
				ps.setLong(2, data.getFkpostRideId());
			}
		});
		data.setRequestsId(id);
		return id;
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
	

	 public ResultSetExtractor getListResultSetExtractor(){
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				CarpoolRequest row = new CarpoolRequest();
				row.setRequestsId(rs.getLong("RequestsId"));
				row.setFkpassengerId(rs.getLong("fk_PassengerID"));
				row.setFkpostRideId(rs.getLong("fk_Post_Ride_ID"));
				return row;
			}
	};
	}
	 

	public List<CarpoolRequest> queryByRequestsId(Long RequestsId)throws Exception{
		String sql = "SELECT * FROM carpool_requests WHERE RequestsId='"+RequestsId+"'";
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
	
	
	public List<CarpoolRequest> queryByUserId(Long UserId)throws Exception{
		String sql = "Select * from carpool_requests where fk_Post_Ride_ID = (Select PostRideId from post_ride where fk_User_Id = '"+UserId+"')";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				CarpoolRequest row = new CarpoolRequest();
				row.setRequestsId(rs.getLong("RequestsId"));
				System.out.println("Inside CarpoolRequest Getting Request ID :"+rs.getLong("RequestsId"));
				row.setFkpassengerId(rs.getLong("fk_PassengerID"));
				fkPassengerId = (int) rs.getLong("fk_PassengerID");
				System.out.println("Inside CarpoolRequest Getting Passenger ID :"+rs.getLong("fk_PassengerID"));
				row.setFkpostRideId(rs.getLong("fk_Post_Ride_ID"));
				System.out.println("Inside CarpoolRequests Getting POST RIDE ID :"+rs.getLong("fk_Post_Ride_ID"));
				return row;
			}
	});
	}
	public List<CarpoolRequest> queryByFkPassengerID(Long fkPassengerID)throws Exception{
		String sql = "SELECT * FROM carpool_requests WHERE fk_PassengerID='"+fkPassengerID+"'";
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
	public List<CarpoolRequest> queryByFkPostRideID(Long fkPostRideID)throws Exception{
		String sql = "SELECT * FROM carpool_requests WHERE fk_Post_Ride_ID='"+fkPostRideID+"'";
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
	
	public boolean insertRequest(CarpoolRequest carpoolRequest){
		boolean flag = false;
		String sql = "INSERT INTO carpool_requests(fk_PassengerID,fk_Post_Ride_ID) VALUES ('"+carpoolRequest.getFkpassengerId()+"', '"+carpoolRequest.getFkpostRideId()+"')";
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Query executed");
	
		return flag;
	}
	
        public  List<CarpoolRequest> requestForUser(int Uid){
			
        	/*
        	          user -- > offer -----> request
                                         /        	
        	                            / 
        	          driver -->  sees /
        	 
        	 At this point @ 23:41 I am looking at code and the db
        	 and it feels like i am standing in a broken house built with so much care
        	 and yet carelessly.
        	 I cant process the idea of it shattering down.
        	 yet another paradox.
        	 
        	 I am at the threshold of the realm where my mind blows up. 23.59
        	 
        	 Looking for tools to help this building. 00.48
        	 
        	 
        	 “What else is belief but direction?”  ― Mohsin Hamid, Moth Smoke
        	 
        	 
        	 
        	*/
        	Statement stmt = null;
        	Connection con = ConnectionFactory.getNormalConnection();
        	ResultSet rs = null;
        	
        	//Lets builld a query.
        	
        	String sql = "SELECT " ;
        	
        	
        	
        	
        	
        	
        	
        	return null;
        	
        }
	}