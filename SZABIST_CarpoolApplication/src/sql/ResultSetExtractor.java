package sql;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetExtractor {
	Object extract(ResultSet rs) throws SQLException ;
}
