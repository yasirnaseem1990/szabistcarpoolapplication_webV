package javadaogenerator;

import java.io.File;
import java.util.List;
import java.util.Properties;

import sql.ColDesc;
import sql.DatabaseDAO;



public class DAOClassesGenerator {

	public static void generate(String table) throws Exception {
		String cnt = "package com.phpdao.dao.impl;\n\n";
		cnt += "import java.sql.PreparedStatement;\n";
		cnt += "import java.sql.ResultSet;\n";
		cnt += "import java.sql.SQLException;\n";
		cnt += "import java.util.List;\n";
		cnt += "import java.util.Date;\n";
		cnt += "import com.phpdao.domain." + DAOHelper.tableToDomainClass(table) + ";\n";
		cnt += "import com.phpdao.dao." + DAOHelper.tableToDomainClass(table) + "DAO;\n";
		cnt += "import com.phpdao.sql.BaseDAO;\n";
		cnt += "import com.phpdao.sql.PreparedStatementSetter;\n";
		cnt += "import com.phpdao.sql.ResultSetExtractor;\n\n";
		Properties prop = DAOFactoryClassesGenerator.getDAOFactoryProperties();
		String className = prop.getProperty(DAOHelper.tableToDAOClass(table));
		String abstractStr = "";
		if (className != null) {
			abstractStr = "abstract";
		}
		cnt += "public " + abstractStr + " class " + DAOHelper.tableToDAOClass(table) + "Impl extends BaseDAO implements " + DAOHelper.tableToDAOClass(table) + "{\n";
		cnt+="\tpublic static final com.phpdao.sql.DAOCache cache = new com.phpdao.sql.DAOCache();\n\n";
		cnt+="\tpublic com.phpdao.sql.DAOCache getCache() {\n"+
			"\t\treturn cache;\n"+
			"\t}\n\n";
		cnt +="\tprotected void clearCacheOnInsert(" + DAOHelper.tableToDomainClass(table) + " data){}\n\n";
		cnt = generateLoadMethod(table, cnt);
		cnt += "\n";
		cnt = generateDeleteMethod(table, cnt);
		cnt += "\n";
		cnt = generateUpdateMethod(table, cnt);
		cnt += "\n";
		cnt = generateExtractorMethod(table, cnt);
		cnt += "\n";
		cnt = generateInsertMethod(table, cnt);
		cnt += "\n";
		cnt = generateQueryAll(table, cnt);
		cnt += "\n";
		cnt = getListResultSetExtractor(cnt, table);
		cnt += "\n";
		cnt = generateQueryByField(table, cnt);
		cnt += "\n";
		cnt += "\t}";
		String path = Configuration.getPath() + "/dao/impl/" + DAOHelper.tableToDAOClass(table) + "Impl.java";
		new File(path).delete();
		FileUtil.createFile(path, cnt);
	}

	public static String generateLoadMethod(String table, String cnt) throws Exception {
		List<ColDesc> cols = DatabaseDAO.instance().getColumns(table);
		cnt += "\tpublic " + DAOHelper.tableToDomainClass(table) + " load(final " + DAOHelper.getPKType(table) + " id) throws Exception{\n";
		cnt += "\t\tString sql = \"SELECT * FROM " + table + " WHERE id=?\";\n";
		cnt += "\t\treturn (" + DAOHelper.tableToDomainClass(table) + ") getRow(sql, new PreparedStatementSetter() {\n";
		cnt += "\t\t\tpublic void prepare(PreparedStatement ps) throws SQLException {\n";

		cnt += "\t\t\t\tps.set" + DAOHelper.getPKTypeWithFirstLetterUpper(table) + "(1, id);\n";
		cnt += "\t\t\t}\n";
		cnt += "\t\t}, new ResultSetExtractor() {\n";
		cnt += "\t\t\tpublic Object extract(ResultSet rs) throws SQLException {\n";
		cnt += "\t\t\t" + DAOHelper.tableToDomainClass(table) + " row  = new " + DAOHelper.tableToDomainClass(table) + "();\n";
		for (ColDesc col : cols) {
			if (col.getType().startsWith("date")) {
				cnt += "\t\t\t\trow.set" + DAOHelper.tableToDomainClass(col.getField()) + "(new Date(rs.getTimestamp(\"" + col.getField() + "\").getTime()));\n";
			} else {
				cnt += "\t\t\t\trow.set" + DAOHelper.tableToDomainClass(col.getField()) + "(rs.get" + DAOHelper.getTypeWithFirstLetterUpper(col.getType()) + "(\"" + col.getField() + "\"));\n";
			}
			// cnt +=
			// "\t\t\t\trow.set"+DAOHelper.tableToDomainClass(col.getField())+"(rs.get"+DAOHelper.getTypeWithFirstLetterUpper(col.getType())+"(\""+col.getField()+"\"));\n";
		}
		cnt += "\t\t\t\treturn row;\n";
		cnt += "\t\t\t}\n";
		cnt += "\t});\n";
		cnt += "\t}\n";
		return cnt;
	}

	public static String generateExtractorMethod(String table, String cnt) throws Exception {
		List<ColDesc> cols = DatabaseDAO.instance().getColumns(table);
		cnt += "\tpublic ResultSetExtractor getDefaultExtractor() throws Exception{\n";
		cnt += "\t\treturn new ResultSetExtractor() {\n";
		cnt += "\t\t\tpublic Object extract(ResultSet rs) throws SQLException {\n";
		cnt += "\t\t\t" + DAOHelper.tableToDomainClass(table) + " row  = new " + DAOHelper.tableToDomainClass(table) + "();\n";
		for (ColDesc col : cols) {
			if (col.getType().startsWith("date")) {
				cnt += "\t\t\t\trow.set" + DAOHelper.tableToDomainClass(col.getField()) + "(new Date(rs.getTimestamp(\"" + col.getField() + "\").getTime()));\n";
			} else {
				cnt += "\t\t\t\trow.set" + DAOHelper.tableToDomainClass(col.getField()) + "(rs.get" + DAOHelper.getTypeWithFirstLetterUpper(col.getType()) + "(\"" + col.getField() + "\"));\n";
			}
			// cnt +=
			// "\t\t\t\trow.set"+DAOHelper.tableToDomainClass(col.getField())+"(rs.get"+DAOHelper.getTypeWithFirstLetterUpper(col.getType())+"(\""+col.getField()+"\"));\n";
		}
		cnt += "\t\t\t\treturn row;\n";
		cnt += "\t\t\t}\n";
		cnt += "\t};\n";
		cnt += "\t}\n";
		return cnt;
	}

	public static String generateDeleteMethod(String table, String cnt) throws Exception {
		cnt += "\tpublic int delete(final " + DAOHelper.getPKType(table) + " id) throws Exception{\n";
		cnt += "\t\tcache.clear(id);\n";
		cnt += "\t\tString sql = \"DELETE FROM " + table + " WHERE id=?\";\n";
		cnt += "\t\treturn executeUpdate(sql, new PreparedStatementSetter() {\n";
		cnt += "\t\t\tpublic void prepare(PreparedStatement ps) throws SQLException {\n";
		cnt += "\t\t\t\tps.set" + DAOHelper.getPKTypeWithFirstLetterUpper(table) + "(1, id);\n";
		cnt += "\t\t\t}\n";
		cnt += "\t\t});\n";
		cnt += "\t}\n";
		return cnt;
	}

	public static String generateUpdateMethod(String table, String cnt) throws Exception {
		List<ColDesc> cols = DatabaseDAO.instance().getColumns(table);
		cnt += "\tpublic int update(final " + DAOHelper.tableToDomainClass(table) + " data) throws Exception{\n";
		cnt += "\t\tcache.clear(data.getId());\n";
		cnt += "\t\tString sql = \"UPDATE " + table + " SET ";
		int j = 0;
		for (ColDesc col : cols) {
			if (DAOHelper.getPKName(table).equals(col.getField())) {
				continue;
			}
			if (j > 0) {
				cnt += ", ";
			}
			cnt += col.getField() + " = ?";
			j++;
		}
		cnt += " WHERE id=?\";\n";
		cnt += "\t\treturn executeUpdate(sql, new PreparedStatementSetter() {\n";
		cnt += "\t\t\tpublic void prepare(PreparedStatement ps) throws SQLException {\n";
		int i = 0;
		int z = 1;
		for (ColDesc col : cols) {
			if (DAOHelper.getPKName(table).equals(col.getField())) {
				continue;
			}
			if (col.getType().startsWith("date")) {
				cnt += "\t\t\t\tps.setTimestamp(" + (z++) + ", new java.sql.Timestamp(data.get" + DAOHelper.tableToDomainClass(col.getField()) + "().getTime()));\n";
			} else {
				cnt += "\t\t\t\tps.set" + DAOHelper.getTypeWithFirstLetterUpper(col.getType()) + "(" + (z++) + ", data.get" + DAOHelper.tableToDomainClass(col.getField()) + "());\n";
			}
			i++;
		}
		cnt += "\t\t\t\tps.set" + DAOHelper.getPKTypeWithFirstLetterUpper(table) + "(" + (z++) + ", data.get" + DAOHelper.tableToDomainClass(DAOHelper.getPKName(table)) + "());\n";
		cnt += "\t\t\t}\n";
		cnt += "\t});\n";
		cnt += "\t}\n";
		return cnt;
	}

	public static String getListResultSetExtractor(String cnt, String table) throws Exception {
		List<ColDesc> cols = DatabaseDAO.instance().getColumns(table);
		cnt += "\t public ResultSetExtractor getListResultSetExtractor(){\n";
		cnt += "\t\treturn new ResultSetExtractor() {\n";
		cnt += "\t\t\tpublic Object extract(ResultSet rs) throws SQLException {\n";
		cnt += "\t\t\t\t" + DAOHelper.tableToDomainClass(table) + " row = new " + DAOHelper.tableToDomainClass(table) + "();\n";
		for (ColDesc col : cols) {
			if (col.getType().startsWith("date")) {
				cnt += "\t\t\t\trow.set" + DAOHelper.tableToDomainClass(col.getField()) + "(new Date(rs.getTimestamp(\"" + col.getField() + "\").getTime()));\n";
			} else {
				cnt += "\t\t\t\trow.set" + DAOHelper.tableToDomainClass(col.getField()) + "(rs.get" + DAOHelper.getTypeWithFirstLetterUpper(col.getType()) + "(\"" + col.getField() + "\"));\n";
			}
		}
		cnt += "\t\t\t\treturn row;\n";
		cnt += "\t\t\t}\n";
		cnt += "\t};\n";
		cnt += "\t}\n";
		return cnt;
	}

	public static String generateInsertMethod(String table, String cnt) throws Exception {
		List<ColDesc> cols = DatabaseDAO.instance().getColumns(table);
		cnt += "\tpublic long insert(final " + DAOHelper.tableToDomainClass(table) + " data) throws Exception{\n";
		cnt += "\t\tclearCacheOnInsert(data);\n";
		cnt += "\t\tString sql = \"INSERT INTO " + table + " ( ";
		int j = 0;
		for (ColDesc col : cols) {
			if (DAOHelper.getPKName(table).equals(col.getField())) {
				continue;
			}
			if (j > 0) {
				cnt += ", ";
			}
			cnt += col.getField();
			j++;
		}
		cnt += ") VALUES (";
		j = 0;
		for (ColDesc col : cols) {
			if (DAOHelper.getPKName(table).equals(col.getField())) {
				continue;
			}
			if (j > 0) {
				cnt += ", ";
			}
			cnt += "?";
			j++;
		}
		cnt += " )\";\n";
		cnt += "\t\tlong id = executeInsert(sql, new PreparedStatementSetter() {\n";
		cnt += "\t\t\tpublic void prepare(PreparedStatement ps) throws SQLException {\n";
		int i = 0;
		int z = 1;
		for (ColDesc col : cols) {
			if (DAOHelper.getPKName(table).equals(col.getField())) {
				continue;
			}
			if (col.getType().startsWith("date")) {
				cnt += "\t\t\t\tps.setTimestamp(" + (z++) + ", new java.sql.Timestamp(data.get" + DAOHelper.tableToDomainClass(col.getField()) + "().getTime()));\n";
			} else {
				cnt += "\t\t\t\tps.set" + DAOHelper.getTypeWithFirstLetterUpper(col.getType()) + "(" + (z++) + ", data.get" + DAOHelper.tableToDomainClass(col.getField()) + "());\n";
			}
			// cnt +=
			// "\t\t\t\tps.set"+DAOHelper.getTypeWithFirstLetterUpper(col.getType())+"("+(z++)+", data.get"+DAOHelper.tableToDomainClass(col.getField())+"());\n";
			i++;
		}
		// cnt +=
		// "\t\t\t\tps.set"+DAOHelper.getPKTypeWithFirstLetterUpper(table)+"("+(z++)+", data.get"+DAOHelper.tableToDomainClass(DAOHelper.getPKName(table))+"());\n";
		cnt += "\t\t\t}\n";
		cnt += "\t\t});\n";
		cnt += "\t\tdata.set" + DAOHelper.tableToDomainClass(DAOHelper.getPKName(table)) + "(id);\n";
		cnt += "\t\treturn id;\n";
		cnt += "\t}\n";
		return cnt;
	}

	public static String generateQueryAll(String table, String cnt) throws Exception {
		List<ColDesc> cols = DatabaseDAO.instance().getColumns(table);
		cnt += "\tpublic List<" + DAOHelper.tableToDomainClass(table) + "> queryAll()throws Exception{\n";
		cnt += "\t\tString sql = \"SELECT * FROM " + table + "\";\n";
		cnt += "\t\treturn (List) getList(sql, new ResultSetExtractor() {\n";
		cnt += "\t\t\tpublic Object extract(ResultSet rs) throws SQLException {\n";
		cnt += "\t\t\t\t" + DAOHelper.tableToDomainClass(table) + " row = new " + DAOHelper.tableToDomainClass(table) + "();\n";
		for (ColDesc col : cols) {
			// cnt +=
			// "\t\t\t\trow.set"+DAOHelper.tableToDomainClass(col.getField())+"(rs.get"+DAOHelper.getTypeWithFirstLetterUpper(col.getType())+"(\""+col.getField()+"\"));\n";
			if (col.getType().startsWith("date")) {
				cnt += "\t\t\t\trow.set" + DAOHelper.tableToDomainClass(col.getField()) + "(new Date(rs.getTimestamp(\"" + col.getField() + "\").getTime()));\n";
			} else {
				cnt += "\t\t\t\trow.set" + DAOHelper.tableToDomainClass(col.getField()) + "(rs.get" + DAOHelper.getTypeWithFirstLetterUpper(col.getType()) + "(\"" + col.getField() + "\"));\n";
			}
		}
		cnt += "\t\t\t\treturn row;\n";
		cnt += "\t\t\t}\n";
		cnt += "\t});\n";
		cnt += "\t}\n";
		return cnt;
	}

	public static String generateQueryByField(String table, String cnt) throws Exception {
		List<ColDesc> cols = DatabaseDAO.instance().getColumns(table);
		for (ColDesc col2 : cols) {
			cnt += "\tpublic List<" + DAOHelper.tableToDomainClass(table) + "> queryBy" + DAOHelper.columntToFieldWithFistUpper(col2.getField()) + "(" + DAOHelper.getTypeWithFirstLetterUpper(col2.getType()) + " " + DAOHelper.columntToField(col2.getField()) + ")throws Exception{\n";
			cnt += "\t\tString sql = \"SELECT * FROM " + table + " WHERE " + col2.getField() + "='\"+" + DAOHelper.columntToField(col2.getField()) + "+\"'\";\n";
			cnt += "\t\treturn (List) getList(sql, new ResultSetExtractor() {\n";
			cnt += "\t\t\tpublic Object extract(ResultSet rs) throws SQLException {\n";
			cnt += "\t\t\t\t" + DAOHelper.tableToDomainClass(table) + " row = new " + DAOHelper.tableToDomainClass(table) + "();\n";
			for (ColDesc col : cols) {
				// cnt +=
				// "\t\t\t\trow.set"+DAOHelper.tableToDomainClass(col.getField())+"(rs.get"+DAOHelper.getTypeWithFirstLetterUpper(col.getType())+"(\""+col.getField()+"\"));\n";
				if (col.getType().startsWith("date")) {
					cnt += "\t\t\t\trow.set" + DAOHelper.tableToDomainClass(col.getField()) + "(new Date(rs.getTimestamp(\"" + col.getField() + "\").getTime()));\n";
				} else {
					cnt += "\t\t\t\trow.set" + DAOHelper.tableToDomainClass(col.getField()) + "(rs.get" + DAOHelper.getTypeWithFirstLetterUpper(col.getType()) + "(\"" + col.getField() + "\"));\n";
				}
			}
			cnt += "\t\t\t\treturn row;\n";
			cnt += "\t\t\t}\n";
			cnt += "\t});\n";
			cnt += "\t}\n";
		}
		return cnt;
	}

	public static String updateByField(String table, String cnt) throws Exception {
		List<ColDesc> cols = DatabaseDAO.instance().getColumns(table);
		for (ColDesc col2 : cols) {
			cnt += "\tpublic void updateBy" + DAOHelper.columntToFieldWithFistUpper(col2.getField()) + "(" + DAOHelper.getTypeWithFirstLetterUpper(col2.getType()) + " " + DAOHelper.columntToField(col2.getField()) + ", long id)throws Exception{\n";
			cnt += "\t\tString sql = \"UPDATE " + table + " SET " + col2.getField() + "='\"+" + DAOHelper.columntToField(col2.getField()) + "+\"' WHERE id=id\";\n";

			cnt += "\t}\n";
		}
		return cnt;
	}
}
