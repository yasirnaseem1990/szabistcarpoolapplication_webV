package javadaogenerator;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import sql.DatabaseDAO;


public class DAOFactoryClassesGenerator {

	public static void generate() throws Exception {
		String cnt = "package com.phpdao.dao;\n\n";
		cnt += "import com.phpdao.dao.impl.*;\n\n";
		cnt += "import com.phpdao.sql.DAOProxy;\n\n";
		
		cnt += "public class DAOFactory{\n";
		Properties prop = getDAOFactoryProperties();
		List<String> tables = new DatabaseDAO().getTables();
		for (String table : tables) {
			if (DAOHelper.tableContainPK(table)) {
				String clazz = prop.getProperty(DAOHelper.tableToDAOClass(table));
				if (clazz == null) {
					clazz = DAOHelper.tableToDAOClass(table) + "Impl";
				}

				cnt += "\tpublic static " + DAOHelper.tableToDAOClass(table) + " get" + DAOHelper.tableToDAOClass(table) + "(){\n";
				cnt += "\t\t" + clazz + " dao =  new " + clazz + "();\n";
				cnt += "\t\tClass[] interfacesArray = new Class[] { " + DAOHelper.tableToDAOClass(table) + ".class };\n";
				cnt += "\t\treturn (" + DAOHelper.tableToDAOClass(table) + ") java.lang.reflect.Proxy.newProxyInstance(dao.getClass().getClassLoader(), interfacesArray, new DAOProxy(dao));\n";
				//cnt += "\t\treturn new " + clazz + "();\n";
				cnt += "\t}\n";
			}
		}
		cnt += "}";
		String path = Configuration.getPath() + "/dao/DAOFactory.java";
		new File(path).delete();
		FileUtil.createFile(path, cnt);
	}

	public static Properties getDAOFactoryProperties() throws Exception {
		Properties p = new Properties();
//		String path = System.getProperty("user.dir")+ "\\src\\main\\java\\com\\phpdao\\javadaogenerator\\daofactory.properties";
String path = "/Users/Yasir/workspace/SZABIST_CarpoolApplication/src/javadaogenerator/daofactory.properties";
System.out.println(path);
		p.load(new FileInputStream(path));
		return p;
	}
}
