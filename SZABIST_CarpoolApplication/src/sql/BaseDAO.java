package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;

public class BaseDAO {

	protected List getList(String sql, PreparedStatementSetter pss, ResultSetExtractor rse) throws Exception {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			c = ConnectionFactory.getNormalConnection();
			System.out.println("CONNECTION GET");
			ps = c.prepareStatement(sql);
			if (pss != null) {
				pss.prepare(ps);
			}
			rs = ps.executeQuery();
			List list = new ArrayList();
			while (rs.next()) {
				list.add(rse.extract(rs));
			}
			return list;
		} catch (Exception e) {			
			throw e;
		}finally{
			if (rs != null) {
				rs.close();
				rs=null;
			}
			if (ps != null) {
				ps.close();
				ps=null;
			}
			if (c != null) {
				ConnectionFactory.dispose(c);
			}
		}
	}

	protected List getList(String sql, ResultSetExtractor rse) throws Exception {
		return getList(sql, null, rse);
	}

	protected Object getRow(String sql, PreparedStatementSetter pss, ResultSetExtractor rse) throws Exception {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			c = ConnectionFactory.getNormalConnection();
			System.out.println("CONNECTION GET");
			ps = c.prepareStatement(sql);
			if (pss != null) {
				pss.prepare(ps);
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				return rse.extract(rs);
			}
			return null;
		} catch (Exception e) {
			throw e;
		}finally{
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (c != null) {
				ConnectionFactory.dispose(c);
			}
		}
	}
	
	protected Long getLong(String sql, PreparedStatementSetter pss) throws Exception {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			c = ConnectionFactory.getNormalConnection();
			System.out.println("CONNECTION GET");
			ps = c.prepareStatement(sql);
			if (pss != null) {
				pss.prepare(ps);
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getLong(1);
			}
			return null;
		} catch (Exception e) {
			throw e;
		}finally{
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (c != null) {
				ConnectionFactory.dispose(c);
			}
		}
	}

	protected int executeUpdate(String sql, PreparedStatementSetter pss) throws Exception {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionFactory.getNormalConnection();
			System.out.println("CONNECTION GET");
			ps = c.prepareStatement(sql);
			if (pss != null) {
				pss.prepare(ps);
			}
			return ps.executeUpdate();
		} catch (Exception e) {			
			throw e;
		}finally{
			if (ps != null) {
				ps.close();
			}
			if (c != null) {
				ConnectionFactory.dispose(c);
			}
		}		
	}

	protected long executeInsert(String sql, PreparedStatementSetter pss) throws Exception {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionFactory.getNormalConnection();
			System.out.println("CONNECTION GET FROM EXECTUE_INSERT :"+c);
			ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			if (pss != null) {
				pss.prepare(ps);
			}

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (Exception e) {
			throw e;
		}finally{
			if (ps != null) {
				ps.getUpdateCount();
				System.out.println("Inside ExecuteInsert Method Class BaseDAO :"+ps.getUpdateCount());
				ps.close();
			}
			if (c != null) {
				ConnectionFactory.dispose(c);
//				c.commit();
//				c.rollback();
				c.close();
				
			}
		}
	}
	public static String escape(String str){
		return StringEscapeUtils.escapeSql(str);
	}
}
