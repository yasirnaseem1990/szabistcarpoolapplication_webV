package javadaogenerator;

import java.util.List;

import sql.ColDesc;
import sql.DatabaseDAO;


public class DAOHelper {
	public static boolean tableContainPK(String table) throws Exception {
		List<ColDesc> cols = new DatabaseDAO().getColumns(table);
		for (ColDesc col : cols) {
			if (col.getKey().equals("PRI")) {
				return true;
			}
		}
		return false;
	}

	public static String getPKType(String table) throws Exception {
		List<ColDesc> cols = new DatabaseDAO().getColumns(table);
		for (ColDesc col : cols) {
			if (col.getKey().equals("PRI")) {
				return getType(col.getType());
			}
		}
		return null;
	}

	public static String getPKName(String table) throws Exception {
		List<ColDesc> cols = new DatabaseDAO().getColumns(table);
		for (ColDesc col : cols) {
			if (col.getKey().equals("PRI")) {
				return col.getField();
			}
		}
		return null;
	}

	public static String getPKTypeWithFirstLetterUpper(String table) throws Exception {
		List<ColDesc> cols = new DatabaseDAO().getColumns(table);
		for (ColDesc col : cols) {
			if (col.getKey().equals("PRI")) {
				String str = getType(col.getType());
				str = str.substring(0, 1).toUpperCase() + str.substring(1);
				return str;
			}
		}
		return null;
	}

	public static String tableToDomainClass(String table) {
		String ret = table.substring(0, 1).toUpperCase() + table.substring(1);
		for (int i = 0; i < ret.length(); i++) {
			if (ret.charAt(i) == '_') {
				ret = ret.substring(0, i) + ret.substring(i + 1, i + 2).toUpperCase() + ret.substring(i + 2);
				i = 0;
			}
		}
		if (ret.charAt(ret.length() - 1) == 's') {
			ret = ret.substring(0, ret.length() - 1);
		}
		return ret;
	}

	public static String tableToDAOClass(String table) {
		String ret = table.substring(0, 1).toUpperCase() + table.substring(1);
		for (int i = 0; i < ret.length(); i++) {
			if (ret.charAt(i) == '_') {
				ret = ret.substring(0, i) + ret.substring(i + 1, i + 2).toUpperCase() + ret.substring(i + 2);
				i = 0;
			}
		}
		if (ret.charAt(ret.length() - 1) == 's') {
			ret = ret.substring(0, ret.length() - 1);
		}
		return ret + "DAO";
	}

	public static String columntToField(String columnType) {
		String ret = columnType;
		for (int i = 0; i < ret.length(); i++) {
			if (ret.charAt(i) == '_') {
				ret = ret.substring(0, i ) + ret.substring(i + 1, i + 2).toUpperCase() + ret.substring(i + 2);
				i = 0;
			}
		}
		if (ret.charAt(ret.length() - 1) == 's') {
			ret = ret.substring(0, ret.length() - 1);
		}
		return ret;
	}

	public static String columntToFieldWithFistUpper(String columnType) {
		String ret = columnType;
		for (int i = 0; i < ret.length(); i++) {
			if (ret.charAt(i) == '_') {
				ret = ret.substring(0, i ) + ret.substring(i + 1, i + 2).toUpperCase() + ret.substring(i + 2);
				i = 0;
			}
		}
		if (ret.charAt(ret.length() - 1) == 's') {
			ret = ret.substring(0, ret.length() - 1);
		}
		return ret.substring(0, 1).toUpperCase() + ret.substring(1);
	}

	public static String getType(String columnType) {
		if (columnType.toLowerCase().startsWith("int")) {
			return "Long";
		}
		if (columnType.toLowerCase().startsWith("tinyint")) {
			return "Long";
		}
		if (columnType.toLowerCase().startsWith("bigint")) {
			return "Long";
		}
		if (columnType.toLowerCase().startsWith("date")) {
			return "java.util.Date";
		}
		return "String";
	}

	public static String getTypeWithFirstLetterUpper(String columnType) {
		if (columnType.toLowerCase().startsWith("int")) {
			return "Long";
		}
		if (columnType.toLowerCase().startsWith("tinyint")) {
			return "Long";
		}
		if (columnType.toLowerCase().startsWith("bigint")) {
			return "Long";
		}
		if (columnType.toLowerCase().startsWith("date")) {
			return "Date";
		}
		return "String";
	}
}
