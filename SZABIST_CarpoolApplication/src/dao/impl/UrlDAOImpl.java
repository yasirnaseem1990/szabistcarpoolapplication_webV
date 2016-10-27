package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import sql.BaseDAO;
import sql.PreparedStatementSetter;
import sql.ResultSetExtractor;
import dao.UrlDAO;
import domain.Url;


public  class UrlDAOImpl extends BaseDAO implements UrlDAO{
	public static int url_id_for_Bridge;
	public static final sql.DAOCache cache = new sql.DAOCache();

	public sql.DAOCache getCache() {
		return cache;
	}

	protected void clearCacheOnInsert(Url data){}

	public Url load(final Long id) throws Exception{
		String sql = "SELECT * FROM url WHERE id=?";
		return (Url) getRow(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		}, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			Url row  = new Url();
				row.setUrlId(rs.getLong("UrlId"));
				row.setUrlScheme(rs.getString("Url_Scheme"));
				return row;
			}
	});
	}

	public int delete(final Long id) throws Exception{
		cache.clear(id);
		String sql = "DELETE FROM url WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		});
	}

	public int update(final Url data) throws Exception{
		cache.clear(data.getUrlId());
		String sql = "UPDATE url SET Url_Scheme = ? WHERE id=?";
		return executeUpdate(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setString(1, data.getUrlScheme());
				ps.setLong(2, data.getUrlId());
			}
	});
	}

	public ResultSetExtractor getDefaultExtractor() throws Exception{
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
			Url row  = new Url();
				row.setUrlId(rs.getLong("UrlId"));
				row.setUrlScheme(rs.getString("Url_Scheme"));
				return row;
			}
	};
	}

	public long insert(final Url data) throws Exception{
		clearCacheOnInsert(data);
		String sql = "INSERT INTO url ( Url_Scheme) VALUES (? )";
		long id = executeInsert(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setString(1, data.getUrlScheme());
			}
		});
		data.setUrlId(id);
		return id;
	}

	public List<Url> queryAll()throws Exception{
		String sql = "SELECT * FROM url";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				Url row = new Url();
				row.setUrlId(rs.getLong("UrlId"));
				row.setUrlScheme(rs.getString("Url_Scheme"));
				return row;
			}
	});
	}

	 public ResultSetExtractor getListResultSetExtractor(){
		return new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				Url row = new Url();
				row.setUrlId(rs.getLong("UrlId"));
				row.setUrlScheme(rs.getString("Url_Scheme"));
				return row;
			}
	};
	}

	public List<Url> queryByUrlId(Long UrlId)throws Exception{
		String sql = "SELECT * FROM url WHERE UrlId='"+UrlId+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				Url row = new Url();
				row.setUrlId(rs.getLong("UrlId"));
				row.setUrlScheme(rs.getString("Url_Scheme"));
				return row;
			}
	});
	}
	public List<Url> queryByUrlScheme(String UrlScheme)throws Exception{
		String sql = "SELECT * FROM url WHERE Url_Scheme='"+UrlScheme+"'";
		return (List) getList(sql, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				Url row = new Url();
				row.setUrlId(rs.getLong("UrlId"));
				System.out.println("This is UrlID From QueryByUrlScheme Method :"+rs.getLong("UrlId"));
				url_id_for_Bridge = (int) rs.getLong("UrlId");
				System.out.println("URL ID FROM URLDAOIMPL :"+url_id_for_Bridge);
				row.setUrlScheme(rs.getString("Url_Scheme"));
				return row;
			}
	});
	}

	}