package javadaogenerator;

import java.io.File;
import java.util.List;

import sql.ColDesc;
import sql.DatabaseDAO;



public class DomainClassesGenerator {

	public static void generate(String table) throws Exception {
		String cnt = "package com.phpdao.domain;\n\n";
		cnt += "public class " + DAOHelper.tableToDomainClass(table) + " implements java.io.Serializable{\n";
		List<ColDesc> cols = DatabaseDAO.instance().getColumns(table);

		// generate properties
		for (ColDesc col : cols) {
			cnt += "\tprivate " + DAOHelper.getType(col.getType()) + " " + DAOHelper.columntToField(col.getField()) + ";\n";
		}
		cnt += "\n";
		// generate getters
		for (ColDesc col : cols) {
			cnt += "\tpublic " + DAOHelper.getType(col.getType()) + " get" + DAOHelper.tableToDomainClass(col.getField()) + "(){\n";
			cnt += "\t\treturn this." + DAOHelper.columntToField(col.getField()) + ";\n";
			cnt += "\t}\n\n";
		}
		cnt += "\n";

		// generate properties;
		for (ColDesc col : cols) {
			cnt += "\tpublic void set" + DAOHelper.tableToDomainClass(col.getField()) + "(" + DAOHelper.getType(col.getType()) + " " + DAOHelper.columntToField(col.getField()) + "){\n";
			cnt += "\t\tthis." + DAOHelper.columntToField(col.getField()) + " = " + DAOHelper.columntToField(col.getField()) + ";\n";
			cnt += "\t}\n\n";
		}

		cnt += "}";
		String path = Configuration.getPath() + "/domain/" + DAOHelper.tableToDomainClass(table) + ".java";
		new File(path).delete();
		FileUtil.createFile(path, cnt);
	}
}
