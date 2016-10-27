package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sql.BaseDAO;
import sql.ConnectionFactory;
import sql.PreparedStatementSetter;
import sql.ResultSetExtractor;
import dao.PassengerBookDAO;
import domain.PassengerBook;
import domain.User;

public  class PassengerBookDAOImpl extends BaseDAO implements PassengerBookDAO{
	public static final sql.DAOCache cache = new sql.DAOCache();
	public static long pID;
	public sql.DAOCache getCache() {
		return cache;
	}

	protected void clearCacheOnInsert(PassengerBook data){}

	public PassengerBook load(final Long id) throws Exception{
		System.out.println("Inside Passenger Book Load Method");
		String sql = "SELECT * FROM passenger_book WHERE id=?";
		return (PassengerBook) getRow(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		}, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			PassengerBook row  = new PassengerBook();
				row.setPassengerId(rs.getLong("PassengerId"));
				pID = rs.getLong("PasengerId");
				System.out.println("This is Booked Passenger ID :"+pID);
				row.setSourceLocation(rs.getString("Source_Location"));
				row.setOtherComment(rs.getString("Other_Comments"));
				row.setFkBookedUserId(rs.getLong("fk_Booked_UserId"));
				return row;
			}
	});
	}

	public int delete(final Long id) throws Exception{
		cache.clear(id);
		String sql = "DELETE FROM passenger_book WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		});
	}

	public int update(final PassengerBook data) throws Exception{
		cache.clear(data.getPassengerId());
		String sql = "UPDATE passenger_book SET Source_Location = ?, Other_Comments = ?, fk_Booked_UserId = ? WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setString(1, data.getSourceLocation());
				ps.setString(2, data.getOtherComment());
				ps.setLong(3, data.getFkBookedUserId());
				ps.setLong(4, data.getPassengerId());
			}
	});
	}

	public ResultSetExtractor getDefaultExtractor() throws Exception{
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			PassengerBook row  = new PassengerBook();
				row.setPassengerId(rs.getLong("PassengerId"));
				row.setSourceLocation(rs.getString("Source_Location"));
				row.setOtherComment(rs.getString("Other_Comments"));
				row.setFkBookedUserId(rs.getLong("fk_Booked_UserId"));
				return row;
			}
	};
	}

	public long insert(final PassengerBook data) throws Exception{
		clearCacheOnInsert(data);
		String sql = "INSERT INTO passenger_book ( Source_Location, Other_Comments, fk_Booked_UserId) VALUES (?, ?, ? )";
		long id = executeInsert(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setString(1, data.getSourceLocation());
				ps.setString(2, data.getOtherComment());
				ps.setLong(3, data.getFkBookedUserId());
			}
		});
		data.setPassengerId(id);
		return id;
		
	}

	public List<PassengerBook> queryAll()throws Exception{
		String sql = "SELECT * FROM passenger_book";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PassengerBook row = new PassengerBook();
				row.setPassengerId(rs.getLong("PassengerId"));
				row.setSourceLocation(rs.getString("Source_Location"));
				row.setOtherComment(rs.getString("Other_Comments"));
				row.setFkBookedUserId(rs.getLong("fk_Booked_UserId"));
				return row;
			}
	});
	}

	 public ResultSetExtractor getListResultSetExtractor(){
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PassengerBook row = new PassengerBook();
				row.setPassengerId(rs.getLong("PassengerId"));
				row.setSourceLocation(rs.getString("Source_Location"));
				row.setOtherComment(rs.getString("Other_Comments"));
				row.setFkBookedUserId(rs.getLong("fk_Booked_UserId"));
				return row;
			}
	};
	}

	public List<PassengerBook> queryByPassengerId(Long PassengerId)throws Exception{
		String sql = "SELECT * FROM passenger_book WHERE PassengerId='"+PassengerId+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PassengerBook row = new PassengerBook();
				row.setPassengerId(rs.getLong("PassengerId"));
				row.setSourceLocation(rs.getString("Source_Location"));
				row.setOtherComment(rs.getString("Other_Comments"));
				row.setFkBookedUserId(rs.getLong("fk_Booked_UserId"));
				return row;
			}
	});
	}
	public List<PassengerBook> queryBySourceLocation(String SourceLocation)throws Exception{
		String sql = "SELECT * FROM passenger_book WHERE Source_Location='"+SourceLocation+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PassengerBook row = new PassengerBook();
				row.setPassengerId(rs.getLong("PassengerId"));
				row.setSourceLocation(rs.getString("Source_Location"));
				row.setOtherComment(rs.getString("Other_Comments"));
				row.setFkBookedUserId(rs.getLong("fk_Booked_UserId"));
				return row;
			}
	});
	}
	public List<PassengerBook> queryByOtherComment(String OtherComment)throws Exception{
		String sql = "SELECT * FROM passenger_book WHERE Other_Comments='"+OtherComment+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PassengerBook row = new PassengerBook();
				row.setPassengerId(rs.getLong("PassengerId"));
				row.setSourceLocation(rs.getString("Source_Location"));
				row.setOtherComment(rs.getString("Other_Comments"));
				row.setFkBookedUserId(rs.getLong("fk_Booked_UserId"));
				return row;
			}
	});
	}
	public List<PassengerBook> queryByFkBookedUserId(Long fkBookedUserId)throws Exception{
		String sql = "SELECT * FROM passenger_book WHERE fk_Booked_UserId='"+fkBookedUserId+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				PassengerBook row = new PassengerBook();
				row.setPassengerId(rs.getLong("PassengerId"));
				row.setSourceLocation(rs.getString("Source_Location"));
				row.setOtherComment(rs.getString("Other_Comments"));
				row.setFkBookedUserId(rs.getLong("fk_Booked_UserId"));
				return row;
			}
	});
	}
	
	
	public User queryAll1(int pID)throws Exception{
		User user = new User();
		String query = "Select Email,Mobile_No From user WHERE UserId = (Select fk_Booked_UserId From passenger_book WHERE PassengerId = (Select fk_PassengerID FROM carpool_requests WHERE RequestsId = "+pID+"))";
//		String sql = "Select passenger_book.PassengerId, user.Email,user.Mobile_No FROM user,passenger_book WHERE "+pID+" = user.UserId ";
//		passenger_book.fk_Booked_UserId
		Connection con = ConnectionFactory.getNormalConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		if (rs.next()) {
			
			user.setEmail(rs.getString("Email"));
			user.setMobileno(rs.getString("Mobile_No"));
			
		}
		
			System.out.println("This is user "+user.getEmail());
			System.out.println("This is user "+user.getMobileno());
		
		return user;
				

	}
	}