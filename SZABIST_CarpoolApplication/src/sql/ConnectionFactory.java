package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javadaogenerator.Configuration;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;


public class ConnectionFactory {

	private static MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
	
	private static List<Connection> free = new ArrayList<Connection>();
	
	static {		
		ds.setUser(Configuration.getUser());
		ds.setPassword(Configuration.getPassword());
		ds.setUrl(Configuration.getUrl());		
		ds.setCharacterEncoding("utf8");
	}
	
	public static Connection getNormalConnection(){
		 String dbUrl = "jdbc:mysql://localhost:3306/carpool_db";
		 String dbUsr = "root";
		 String dbPass = "";
		 
		 Connection con = null;
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Found Successfully");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException ::"+e);
			e.printStackTrace();
		}
		 try {
			con = DriverManager.getConnection (dbUrl,dbUsr,dbPass);
			System.out.println("Connection is Successfully Inside Normal_Connection Method :"+con);
		} catch (SQLException e) {
			System.out.println("Connection is not Established - M ::::: :"+e);
			e.printStackTrace();
		}
		return con;
		
	}

//	public static synchronized Connection getConnection() throws SQLException {
//		if(free.size()==0){
//			System.out.println("running");
//			return ds.getConnection();	
//		}
//		Connection c = free.get(0);
//		while(c.isClosed()){
//			if(free.size()>1){
//				free.remove(0);
//				if(free.size()>1){
//					c = free.get(0);
//				}else{
//					return ds.getConnection();
//				}				
//			}else{
//				return ds.getConnection();
//			}
//		}
//		free.remove(0);
//		return c;
//	}

	public static synchronized void dispose(Connection c){
		free.add(c);
	}
}
