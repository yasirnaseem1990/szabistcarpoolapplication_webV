package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import sql.BaseDAO;
import sql.PreparedStatementSetter;
import sql.ResultSetExtractor;
import dao.RideStatuDAO;
import domain.RideStatu;


public  class RideStatuDAOImpl extends BaseDAO implements RideStatuDAO{
	public static final sql.DAOCache cache = new sql.DAOCache();

	public sql.DAOCache getCache() {
		return cache;
	}

	protected void clearCacheOnInsert(RideStatu data){}

	public RideStatu load(final Long id) throws Exception{
		String sql = "SELECT * FROM ride_status WHERE id=?";
		return (RideStatu) getRow(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		}, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			RideStatu row  = new RideStatu();
				row.setRideStatusId(rs.getLong("RideStatus_Id"));
				row.setRideStatu(rs.getLong("Ride_Status"));
				row.setFkRidePostId(rs.getLong("fk_RidePost_Id"));
				row.setFkPassengerId(rs.getLong("fk_Passenger_Id"));
				return row;
			}
	});
	}

	public int delete(final Long id) throws Exception{
		cache.clear(id);
		String sql = "DELETE FROM ride_status WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		});
	}

	public int update(final RideStatu data) throws Exception{
		cache.clear(data.getRideStatu());
		String sql = "UPDATE ride_status SET Ride_Status = ?, fk_RidePost_Id = ?, fk_Passenger_Id = ? WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, data.getRideStatu());
				ps.setLong(2, data.getFkRidePostId());
				ps.setLong(3, data.getFkPassengerId());
				ps.setLong(4, data.getRideStatusId());
			}
	});
	}

	public ResultSetExtractor getDefaultExtractor() throws Exception{
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			RideStatu row  = new RideStatu();
				row.setRideStatusId(rs.getLong("RideStatus_Id"));
				row.setRideStatu(rs.getLong("Ride_Status"));
				row.setFkRidePostId(rs.getLong("fk_RidePost_Id"));
				row.setFkPassengerId(rs.getLong("fk_Passenger_Id"));
				return row;
			}
	};
	}

	public long insert(final RideStatu data) throws Exception{
		clearCacheOnInsert(data);
		String sql = "INSERT INTO ride_status ( Ride_Status, fk_RidePost_Id, fk_Passenger_Id) VALUES (?, ?, ? )";
		long id = executeInsert(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, data.getRideStatu());
				ps.setLong(2, data.getFkRidePostId());
				ps.setLong(3, data.getFkPassengerId());
			}
		});
		data.setRideStatusId(id);
		return id;
	}

	public List<RideStatu> queryAll()throws Exception{
		String sql = "SELECT * FROM ride_status";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				RideStatu row = new RideStatu();
				row.setRideStatusId(rs.getLong("RideStatus_Id"));
				row.setRideStatu(rs.getLong("Ride_Status"));
				row.setFkRidePostId(rs.getLong("fk_RidePost_Id"));
				row.setFkPassengerId(rs.getLong("fk_Passenger_Id"));
				return row;
			}
	});
	}

	 public ResultSetExtractor getListResultSetExtractor(){
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				RideStatu row = new RideStatu();
				row.setRideStatusId(rs.getLong("RideStatus_Id"));
				row.setRideStatu(rs.getLong("Ride_Status"));
				row.setFkRidePostId(rs.getLong("fk_RidePost_Id"));
				row.setFkPassengerId(rs.getLong("fk_Passenger_Id"));
				return row;
			}
	};
	}

	public List<RideStatu> queryByRideStatusId(Long RideStatusId)throws Exception{
		String sql = "SELECT * FROM ride_status WHERE RideStatus_Id='"+RideStatusId+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				RideStatu row = new RideStatu();
				row.setRideStatusId(rs.getLong("RideStatus_Id"));
				row.setRideStatu(rs.getLong("Ride_Status"));
				row.setFkRidePostId(rs.getLong("fk_RidePost_Id"));
				row.setFkPassengerId(rs.getLong("fk_Passenger_Id"));
				return row;
			}
	});
	}
	public List<RideStatu> queryByRideStatu(Long RideStatu)throws Exception{
		String sql = "SELECT * FROM ride_status WHERE Ride_Status='"+RideStatu+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				RideStatu row = new RideStatu();
				row.setRideStatusId(rs.getLong("RideStatus_Id"));
				row.setRideStatu(rs.getLong("Ride_Status"));
				row.setFkRidePostId(rs.getLong("fk_RidePost_Id"));
				row.setFkPassengerId(rs.getLong("fk_Passenger_Id"));
				return row;
			}
	});
	}
	public List<RideStatu> queryByFkRidePostId(Long fkRidePostId)throws Exception{
		String sql = "SELECT * FROM ride_status WHERE fk_RidePost_Id='"+fkRidePostId+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				RideStatu row = new RideStatu();
				row.setRideStatusId(rs.getLong("RideStatus_Id"));
				row.setRideStatu(rs.getLong("Ride_Status"));
				row.setFkRidePostId(rs.getLong("fk_RidePost_Id"));
				row.setFkPassengerId(rs.getLong("fk_Passenger_Id"));
				return row;
			}
	});
	}
	public List<RideStatu> queryByFkPassengerId(Long fkPassengerId)throws Exception{
		String sql = "SELECT * FROM ride_status WHERE fk_Passenger_Id='"+fkPassengerId+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				RideStatu row = new RideStatu();
				row.setRideStatusId(rs.getLong("RideStatus_Id"));
				row.setRideStatu(rs.getLong("Ride_Status"));
				row.setFkRidePostId(rs.getLong("fk_RidePost_Id"));
				row.setFkPassengerId(rs.getLong("fk_Passenger_Id"));
				return row;
			}
	});
	}

	}