package sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DatabaseDAO extends BaseDAO {

	public static DatabaseDAO instance() {
		return new DatabaseDAO();
	}

	public List<String> getTables() throws Exception {
		String sql = "SHOW tables";
		return getList(sql, new ResultSetExtractor() {

			
			public Object extract(ResultSet rs) throws SQLException {
				return rs.getString(1);
			}
		});
	}

	public List<ColDesc> getColumns(String table) throws Exception {
		String sql = "DESC " + table;
		return getList(sql, new ResultSetExtractor() {

			
			public Object extract(ResultSet rs) throws SQLException {
				ColDesc col = new ColDesc();
				col.setField(rs.getString(1));
				col.setType(rs.getString(2));
				col.setKey(rs.getString(4));
				return col;
			}
		});
	}

	public ColDesc load(final int id) throws Exception {
		String sql = "SELECT * FROM table WHERE id=?";
		return (ColDesc) getRow(sql, new PreparedStatementSetter() {
			public void prepare(PreparedStatement ps) throws SQLException {
				ps.setLong(1, id);
			}
		}, new ResultSetExtractor() {
			public Object extract(ResultSet rs) throws SQLException {
				ColDesc row = new ColDesc();
				row.setField(rs.getString(2));
				return row;
			}
		});
	}
}
