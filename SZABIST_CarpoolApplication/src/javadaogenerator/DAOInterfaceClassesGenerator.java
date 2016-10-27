package javadaogenerator;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;

import sql.ColDesc;
import sql.DatabaseDAO;


public class DAOInterfaceClassesGenerator {

	public static void generate(String table) throws Exception {
		String cnt = "package com.phpdao.dao;\n\n";
		cnt += "import java.util.List;\n";
		cnt += "import java.util.Date;\n";
		cnt += "import com.phpdao.domain." + DAOHelper.tableToDomainClass(table) + ";\n";
		cnt += "public interface " + DAOHelper.tableToDAOClass(table) + "{\n";
		cnt = generateLoadMethod(table, cnt);
		cnt += "\n";
		cnt = generateDeleteMethod(table, cnt);
		cnt += "\n";
		cnt = generateUpdateMethod(table, cnt);
		cnt += "\n";

		cnt = generateInsertMethod(table, cnt);
		cnt += "\n\n";
		cnt = generateQueryAll(table, cnt);
		cnt += "\n\n";
		cnt = generateAdditionalMethods(table, cnt);
		cnt += "\n";
		cnt = generateQueryByField(table, cnt);
		cnt += "\n";
		cnt += "\t}";
		String path = Configuration.getPath() + "/dao/" + DAOHelper.tableToDAOClass(table) + ".java";
		new File(path).delete();
		FileUtil.createFile(path, cnt);
	}

	public static String generateLoadMethod(String table, String cnt) throws Exception {
		List<ColDesc> cols = DatabaseDAO.instance().getColumns(table);
		cnt += "\t" + DAOHelper.tableToDomainClass(table) + " load(final " + DAOHelper.getPKType(table) + " id) throws Exception;\n";
		return cnt;
	}

	public static String generateDeleteMethod(String table, String cnt) throws Exception {
		cnt += "\tpublic int delete(final " + DAOHelper.getPKType(table) + " id) throws Exception;\n";
		return cnt;
	}

	public static String generateUpdateMethod(String table, String cnt) throws Exception {
		List<ColDesc> cols = DatabaseDAO.instance().getColumns(table);
		cnt += "\tpublic int update(final " + DAOHelper.tableToDomainClass(table) + " data) throws Exception;\n";
		return cnt;
	}

	public static String generateInsertMethod(String table, String cnt) throws Exception {
		List<ColDesc> cols = DatabaseDAO.instance().getColumns(table);
		cnt += "\tpublic long insert(final " + DAOHelper.tableToDomainClass(table) + " data) throws Exception;\n";
		return cnt;
	}

	public static String generateQueryAll(String table, String cnt) throws Exception {
		List<ColDesc> cols = DatabaseDAO.instance().getColumns(table);
		cnt += "\tpublic List<" + DAOHelper.tableToDomainClass(table) + "> queryAll()throws Exception;\n";
		return cnt;
	}

	public static String generateQueryByField(String table, String cnt) throws Exception {
		List<ColDesc> cols = DatabaseDAO.instance().getColumns(table);
		for (ColDesc col2 : cols) {
			cnt += "\tpublic List<" + DAOHelper.tableToDomainClass(table) + "> queryBy" + DAOHelper.columntToFieldWithFistUpper(col2.getField()) + "(" + DAOHelper.getTypeWithFirstLetterUpper(col2.getType()) + " " + DAOHelper.columntToField(col2.getField()) + ")throws Exception;\n";

		}
		return cnt;
	}

	public static String generateAdditionalMethods(String table, String cnt) throws Exception {
		Properties prop = DAOFactoryClassesGenerator.getDAOFactoryProperties();
		String className = prop.getProperty(DAOHelper.tableToDAOClass(table));
		if (className != null) {
			Class clazz = DAOFactoryClassesGenerator.class.forName(className);
			Method[] methods = clazz.getMethods();
			for (Method m : methods) {
				boolean methodFromSuperClass = false;
				for (Method omethod : Object.class.getMethods()) {
					if (m.equals(omethod)) {
						methodFromSuperClass = true;
						break;
					}
				}
				String daoClassName = "com.phpdao.dao.impl." + DAOHelper.tableToDAOClass(table) + "Impl";
				Class daoclazz = DAOFactoryClassesGenerator.class.forName(daoClassName);
				for (Method omethod : daoclazz.getMethods()) {
					if (m.equals(omethod)) {
						methodFromSuperClass = true;
						break;
					}
				}
				if (!methodFromSuperClass) {
					String params = "";
					int i = 1;
					for (Class param : m.getParameterTypes()) {
						if (i > 1) {
							params += ", ";
						}
						params += param.getName() + " param" + i;
						i++;
					}

					cnt += "\t" + m.getReturnType().getName() + " " + m.getName() + "(" + params + ") throws Exception;\n\n";
				}
			}
		}
		return cnt;
	}
}
