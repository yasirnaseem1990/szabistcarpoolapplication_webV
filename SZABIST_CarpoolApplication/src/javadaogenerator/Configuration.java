package javadaogenerator;


public class Configuration {

	//private static final Properties props = new Properties();;

	//private static boolean loaded;
	public static boolean test;

	public static String getUser() {
		return getProperty("db.user");
	}

	public static String getPassword() {
		return getProperty("db.pass");
	}

	public static String getUrl() {
		return getProperty("db.url");
	}

	public static String getPath() {
		return System.getProperty("user.dir")+ "/src/";
	}

	public static synchronized String getProperty(String key) {
		return System.getProperty(key);
	}
}
