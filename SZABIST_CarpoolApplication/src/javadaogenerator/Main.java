package javadaogenerator;

import java.io.File;
import java.util.List;

import sql.DatabaseDAO;



public class Main {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.setProperty("db.user", "root");
		System.setProperty("db.pass", "");
		System.setProperty("db.url", "jdbc:mysql://localhost:3306/carpool_db");
		Configuration.test = true;
		System.out.println(System.getProperties());
		DatabaseDAO dao = new DatabaseDAO();
		List<String> tables = dao.getTables();
		for (String table : tables) {
			if (DAOHelper.tableContainPK(table)) {
				// we generate DAO classes only for tables which contain PK
				System.out.println("Here is the path:"+Configuration.getPath());
				new File(Configuration.getPath() + "/dao/").delete();
				new File(Configuration.getPath() + "/dao/").mkdir();
				DAOInterfaceClassesGenerator.generate(table);

				new File(Configuration.getPath() + "/domain").delete();
				new File(Configuration.getPath() + "/domain").mkdir();
				DomainClassesGenerator.generate(table);
				new File(Configuration.getPath() + "/dao/impl").delete();
				new File(Configuration.getPath() + "/dao/impl").mkdir();
				DAOClassesGenerator.generate(table);
			}
		}
		DAOFactoryClassesGenerator.generate();
		System.out.println("done");
	}

}
