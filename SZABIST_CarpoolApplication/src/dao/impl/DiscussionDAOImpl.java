package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import sql.BaseDAO;
import sql.PreparedStatementSetter;
import sql.ResultSetExtractor;
import dao.DiscussionDAO;
import domain.Discussion;


public  class DiscussionDAOImpl extends BaseDAO implements DiscussionDAO{
	public static final sql.DAOCache cache = new sql.DAOCache();

	public sql.DAOCache getCache() {
		return cache;
	}

	protected void clearCacheOnInsert(Discussion data){}

	public Discussion load(final Long id) throws Exception{
		String sql = "SELECT * FROM discussion WHERE id=?";
		return (Discussion) getRow(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		}, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			Discussion row  = new Discussion();
				row.setDiscussionId(rs.getLong("DiscussionId"));
				row.setMessageFromFk(rs.getLong("Message_From_fk"));
				row.setMessageToFk(rs.getLong("Message_To_fk"));
				row.setDateTime(new Date(rs.getTimestamp("DateTime").getTime()));
				row.setText(rs.getString("Text"));
				row.setPostRideIdFk(rs.getLong("PostRideId_fk"));
				return row;
			}
	});
	}

	public int delete(final Long id) throws Exception{
		cache.clear(id);
		String sql = "DELETE FROM discussion WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		});
	}

	public int update(final Discussion data) throws Exception{
		cache.clear(data.getDiscussionId());
		String sql = "UPDATE discussion SET Message_From_fk = ?, Message_To_fk = ?, DateTime = ?, Text = ?, PostRideId_fk = ? WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, data.getMessageFromFk());
				ps.setLong(2, data.getMessageToFk());
				ps.setTimestamp(3, new java.sql.Timestamp(data.getDateTime().getTime()));
				ps.setString(4, data.getText());
				ps.setLong(5, data.getPostRideIdFk());
				ps.setLong(6, data.getDiscussionId());
			}
	});
	}

	public ResultSetExtractor getDefaultExtractor() throws Exception{
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			Discussion row  = new Discussion();
				row.setDiscussionId(rs.getLong("DiscussionId"));
				row.setMessageFromFk(rs.getLong("Message_From_fk"));
				row.setMessageToFk(rs.getLong("Message_To_fk"));
				row.setDateTime(new Date(rs.getTimestamp("DateTime").getTime()));
				row.setText(rs.getString("Text"));
				row.setPostRideIdFk(rs.getLong("PostRideId_fk"));
				return row;
			}
	};
	}

	public long insert(final Discussion data) throws Exception{
		clearCacheOnInsert(data);
		String sql = "INSERT INTO discussion ( Message_From_fk, Message_To_fk, DateTime, Text, PostRideId_fk) VALUES (?, ?, ?, ?, ? )";
		long id = executeInsert(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, data.getMessageFromFk());
				ps.setLong(2, data.getMessageToFk());
				ps.setTimestamp(3, new java.sql.Timestamp(data.getDateTime().getTime()));
				ps.setString(4, data.getText());
				ps.setLong(5, data.getPostRideIdFk());
			}
		});
		data.setDiscussionId(id);
		return id;
	}

	public List<Discussion> queryAll()throws Exception{
		String sql = "SELECT * FROM discussion";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				Discussion row = new Discussion();
				row.setDiscussionId(rs.getLong("DiscussionId"));
				row.setMessageFromFk(rs.getLong("Message_From_fk"));
				row.setMessageToFk(rs.getLong("Message_To_fk"));
				row.setDateTime(new Date(rs.getTimestamp("DateTime").getTime()));
				row.setText(rs.getString("Text"));
				row.setPostRideIdFk(rs.getLong("PostRideId_fk"));
				return row;
			}
	});
	}

	 public ResultSetExtractor getListResultSetExtractor(){
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				Discussion row = new Discussion();
				row.setDiscussionId(rs.getLong("DiscussionId"));
				row.setMessageFromFk(rs.getLong("Message_From_fk"));
				row.setMessageToFk(rs.getLong("Message_To_fk"));
				row.setDateTime(new Date(rs.getTimestamp("DateTime").getTime()));
				row.setText(rs.getString("Text"));
				row.setPostRideIdFk(rs.getLong("PostRideId_fk"));
				return row;
			}
	};
	}

	public List<Discussion> queryByDiscussionId(Long DiscussionId)throws Exception{
		String sql = "SELECT * FROM discussion WHERE DiscussionId='"+DiscussionId+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				Discussion row = new Discussion();
				row.setDiscussionId(rs.getLong("DiscussionId"));
				row.setMessageFromFk(rs.getLong("Message_From_fk"));
				row.setMessageToFk(rs.getLong("Message_To_fk"));
				row.setDateTime(new Date(rs.getTimestamp("DateTime").getTime()));
				row.setText(rs.getString("Text"));
				row.setPostRideIdFk(rs.getLong("PostRideId_fk"));
				return row;
			}
	});
	}
	public List<Discussion> queryByMessageFromFk(Long MessageFromFk)throws Exception{
		String sql = "SELECT * FROM discussion WHERE Message_From_fk='"+MessageFromFk+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				Discussion row = new Discussion();
				row.setDiscussionId(rs.getLong("DiscussionId"));
				row.setMessageFromFk(rs.getLong("Message_From_fk"));
				row.setMessageToFk(rs.getLong("Message_To_fk"));
				row.setDateTime(new Date(rs.getTimestamp("DateTime").getTime()));
				row.setText(rs.getString("Text"));
				row.setPostRideIdFk(rs.getLong("PostRideId_fk"));
				return row;
			}
	});
	}
	public List<Discussion> queryByMessageToFk(Long MessageToFk)throws Exception{
		String sql = "SELECT * FROM discussion WHERE Message_To_fk='"+MessageToFk+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				Discussion row = new Discussion();
				row.setDiscussionId(rs.getLong("DiscussionId"));
				row.setMessageFromFk(rs.getLong("Message_From_fk"));
				row.setMessageToFk(rs.getLong("Message_To_fk"));
				row.setDateTime(new Date(rs.getTimestamp("DateTime").getTime()));
				row.setText(rs.getString("Text"));
				row.setPostRideIdFk(rs.getLong("PostRideId_fk"));
				return row;
			}
	});
	}
	public List<Discussion> queryByDateTime(Date DateTime)throws Exception{
		String sql = "SELECT * FROM discussion WHERE DateTime='"+DateTime+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				Discussion row = new Discussion();
				row.setDiscussionId(rs.getLong("DiscussionId"));
				row.setMessageFromFk(rs.getLong("Message_From_fk"));
				row.setMessageToFk(rs.getLong("Message_To_fk"));
				row.setDateTime(new Date(rs.getTimestamp("DateTime").getTime()));
				row.setText(rs.getString("Text"));
				row.setPostRideIdFk(rs.getLong("PostRideId_fk"));
				return row;
			}
	});
	}
	public List<Discussion> queryByText(String Text)throws Exception{
		String sql = "SELECT * FROM discussion WHERE Text='"+Text+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				Discussion row = new Discussion();
				row.setDiscussionId(rs.getLong("DiscussionId"));
				row.setMessageFromFk(rs.getLong("Message_From_fk"));
				row.setMessageToFk(rs.getLong("Message_To_fk"));
				row.setDateTime(new Date(rs.getTimestamp("DateTime").getTime()));
				row.setText(rs.getString("Text"));
				row.setPostRideIdFk(rs.getLong("PostRideId_fk"));
				return row;
			}
	});
	}
	public List<Discussion> queryByPostRideIdFk(Long PostRideIdFk)throws Exception{
		String sql = "SELECT * FROM discussion WHERE PostRideId_fk='"+PostRideIdFk+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				Discussion row = new Discussion();
				row.setDiscussionId(rs.getLong("DiscussionId"));
				row.setMessageFromFk(rs.getLong("Message_From_fk"));
				row.setMessageToFk(rs.getLong("Message_To_fk"));
				row.setDateTime(new Date(rs.getTimestamp("DateTime").getTime()));
				row.setText(rs.getString("Text"));
				row.setPostRideIdFk(rs.getLong("PostRideId_fk"));
				return row;
			}
	});
	}


	}