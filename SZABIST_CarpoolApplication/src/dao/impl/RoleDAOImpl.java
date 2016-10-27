package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import sql.BaseDAO;
import sql.PreparedStatementSetter;
import sql.ResultSetExtractor;
import dao.RoleDAO;
import domain.Role;

public  class RoleDAOImpl extends BaseDAO implements RoleDAO{
	public static final sql.DAOCache cache = new sql.DAOCache();

	public sql.DAOCache getCache() {
		return cache;
	}

	protected void clearCacheOnInsert(Role data){}

	public Role load(final Long id) throws Exception{
		String sql = "SELECT * FROM role WHERE id=?";
		return (Role) getRow(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		}, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			Role row  = new Role();
				row.setRoleId(rs.getLong("RoleId"));
				row.setRoleName(rs.getString("RoleName"));
				return row;
			}
	});
	}

	public int delete(final Long id) throws Exception{
		cache.clear(id);
		String sql = "DELETE FROM role WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		});
	}

	public int update(final Role data) throws Exception{
		cache.clear(data.getRoleId());
		String sql = "UPDATE role SET RoleName = ? WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setString(1, data.getRoleName());
				ps.setLong(2, data.getRoleId());
			}
	});
	}

	public ResultSetExtractor getDefaultExtractor() throws Exception{
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			Role row  = new Role();
				row.setRoleId(rs.getLong("RoleId"));
				row.setRoleName(rs.getString("RoleName"));
				return row;
			}
	};
	}

	public long insert(final Role data) throws Exception{
		clearCacheOnInsert(data);
		String sql = "INSERT INTO role ( RoleName) VALUES (? )";
		long id = executeInsert(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setString(1, data.getRoleName());
			}
		});
		data.setRoleId(id);
		return id;
	}

	public List<Role> queryAll()throws Exception{
		String sql = "SELECT * FROM role";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				Role row = new Role();
				row.setRoleId(rs.getLong("RoleId"));
				row.setRoleName(rs.getString("RoleName"));
				return row;
			}
	});
	}

	 public ResultSetExtractor getListResultSetExtractor(){
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				Role row = new Role();
				row.setRoleId(rs.getLong("RoleId"));
				row.setRoleName(rs.getString("RoleName"));
				return row;
			}
	};
	}

	public List<Role> queryByRoleId(Long RoleId)throws Exception{
		String sql = "SELECT * FROM role WHERE RoleId='"+RoleId+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				Role row = new Role();
				row.setRoleId(rs.getLong("RoleId"));
				row.setRoleName(rs.getString("RoleName"));
				return row;
			}
	});
	}
	public List<Role> queryByRoleName(String RoleName)throws Exception{
		String sql = "SELECT * FROM role WHERE RoleName='"+RoleName+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				Role row = new Role();
				row.setRoleId(rs.getLong("RoleId"));
				row.setRoleName(rs.getString("RoleName"));
				return row;
			}
	});
	}

	}