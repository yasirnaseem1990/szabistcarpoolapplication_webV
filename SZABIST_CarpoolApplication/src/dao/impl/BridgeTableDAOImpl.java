package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import sql.BaseDAO;
import sql.ConnectionFactory;
import sql.PreparedStatementSetter;
import sql.ResultSetExtractor;

import java.sql.Connection;
import java.sql.Statement;

import dao.BridgeTableDAO;
import domain.BridgeTable;


public  class BridgeTableDAOImpl extends BaseDAO implements BridgeTableDAO{
	public static final sql.DAOCache cache = new sql.DAOCache();
	Connection conn;
	private Statement stmt;
	ResultSet rs;
	public sql.DAOCache getCache() {
		return cache;
	}

	protected void clearCacheOnInsert(BridgeTable data){}

	public BridgeTable load(final Long id) throws Exception{
		String sql = "SELECT * FROM bridge_table WHERE id=?";
		return (BridgeTable) getRow(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		}, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			BridgeTable row  = new BridgeTable();
				row.setBridgeId(rs.getLong("BridgeId"));
				row.setFkRoleId(rs.getLong("fk_Role_Id"));
				row.setFkUrlID(rs.getLong("fk_Url_ID"));
				return row;
			}
	});
	}

	public int delete(final Long id) throws Exception{
		cache.clear(id);
		String sql = "DELETE FROM bridge_table WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		});
	}

	public int update(final BridgeTable data) throws Exception{
		cache.clear(data.getFkUrlID());
		String sql = "UPDATE bridge_table SET fk_Role_Id = ?, fk_Url_ID = ? WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, data.getFkRoleId());
				ps.setLong(2, data.getFkUrlID());
				ps.setLong(3, data.getBridgeId());
			}
	});
	}

	public ResultSetExtractor getDefaultExtractor() throws Exception{
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			BridgeTable row  = new BridgeTable();
				row.setBridgeId(rs.getLong("BridgeId"));
				row.setFkRoleId(rs.getLong("fk_Role_Id"));
				row.setFkUrlID(rs.getLong("fk_Url_ID"));
				return row;
			}
	};
	}

	public long insert(final BridgeTable data) throws Exception{
		clearCacheOnInsert(data);
		String sql = "INSERT INTO bridge_table ( fk_Role_Id, fk_Url_ID) VALUES (?, ? )";
		long id = executeInsert(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, data.getFkRoleId());
				ps.setLong(2, data.getFkUrlID());
			}
		});
		data.setBridgeId(id);
		return id;
	}

	public List<BridgeTable> queryAll()throws Exception{
		String sql = "SELECT * FROM bridge_table";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				BridgeTable row = new BridgeTable();
				row.setBridgeId(rs.getLong("BridgeId"));
				row.setFkRoleId(rs.getLong("fk_Role_Id"));
				row.setFkUrlID(rs.getLong("fk_Url_ID"));
				return row;
			}
	});
	}

	 public ResultSetExtractor getListResultSetExtractor(){
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				BridgeTable row = new BridgeTable();
				row.setBridgeId(rs.getLong("BridgeId"));
				row.setFkRoleId(rs.getLong("fk_Role_Id"));
				row.setFkUrlID(rs.getLong("fk_Url_ID"));
				return row;
			}
	};
	}

	public List<BridgeTable> queryByBridgeId(Long BridgeId)throws Exception{
		String sql = "SELECT * FROM bridge_table WHERE BridgeId='"+BridgeId+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				BridgeTable row = new BridgeTable();
				row.setBridgeId(rs.getLong("BridgeId"));
				row.setFkRoleId(rs.getLong("fk_Role_Id"));
				row.setFkUrlID(rs.getLong("fk_Url_ID"));
				return row;
			}
	});
	}
	public List<BridgeTable> queryByFkRoleId(Long fkRoleId)throws Exception{
		String sql = "SELECT * FROM bridge_table WHERE fk_Role_Id='"+fkRoleId+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				BridgeTable row = new BridgeTable();
				row.setBridgeId(rs.getLong("BridgeId"));
				row.setFkRoleId(rs.getLong("fk_Role_Id"));
				row.setFkUrlID(rs.getLong("fk_Url_ID"));
				return row;
			}
	});
	}
	public List<BridgeTable> queryByFkUrlID(Long fkUrlID)throws Exception{
		String sql = "SELECT * FROM bridge_table WHERE fk_Url_ID='"+fkUrlID+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				BridgeTable row = new BridgeTable();
				row.setBridgeId(rs.getLong("BridgeId"));
				row.setFkRoleId(rs.getLong("fk_Role_Id"));
				row.setFkUrlID(rs.getLong("fk_Url_ID"));
				return row;
			}
	});
	}

	public boolean checkPermission(int uid, int urid) {
		boolean flag = false;
		long userId = 0;// UserId In Bridge Table
		long urlId = 0; // UrlId In Bridge Table
		conn =  ConnectionFactory.getNormalConnection();
		String sql = "SELECT * FROM bridge_table WHERE fk_Role_Id="+uid+" and fk_Url_ID="+urid+";";
		System.out.println(" @@@@@@@@@ Inside CheckPermission Method Printing Query @@@@@@@@@:"+sql);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("Query is not executed"+e);
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				userId = rs.getLong("fk_Role_Id");
				urlId = rs.getLong("fk_Url_ID");
				System.out.println("This Is UserId From Bridge Table: "+userId+" This Is UrlId From Brigde Table: "+urlId);
			}
		} catch (SQLException e) {
		System.out.println("Result in not extracted "+e);
			e.printStackTrace();
		}
		if(uid == userId && urid == urlId){
			flag = true;
		}
		return flag;
	}

	}