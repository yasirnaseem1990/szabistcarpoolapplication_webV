package javadaogenerator;

import java.sql.Connection;

import org.apache.commons.lang.StringEscapeUtils;

import sql.ConnectionFactory;
import sql.DAOProxy;


public class Main2 {
	
	static{
		DAOProxy.test=true;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(StringEscapeUtils.unescapeHtml("&lt;div&gt;"));
		System.setProperty("db.pass", "root");
		System.setProperty("db.user", "");
		System.setProperty("db.url", "jdbc:mysql://localhost:3306/carpool_db");
		//List l = DAOFactory.getUserDAO().queryByUser("'aaa' or 1", "bbb");
		//System.out.println(l.size());
		/*String where = "aaa' or '1=1";
		String sql = "SELECT * FROM `message` WHERE title='"+where+"'";
		System.out.println(sql);
		System.out.println(StringEscapeUtils.escapeSql(sql));
		Wall w = new Wall();
		w.setAutorId(1l);
		w.setDateAdded(new Date());
		w.setMessage("aaa'bbb");
		w.setUserId(2l);
		w.setDone(1l);
		w.setParentId(0l);
		DAOFactory.getWallDAO().insert(w);
		w = DAOFactory.getWallDAO().load(w.getId());
		System.out.println(w.getMessage());*/
		Connection c1 = ConnectionFactory.getNormalConnection();
		
		/*DAOFactory.getDirectoryDAO().getUserDir(1, "aaa");
		DAOFactory.getFileDAO().getUserFiles(2);
		DAOFactory.getWallDAO().getUserWall(1, 0, 122);
		DAOFactory.getUserDAO().queryByUser("aaa", "aaa");
		DAOFactory.getUserDAO().addDownloadSize(100, 1);
		DAOFactory.getGroupUserDAO().isUserInGroup(1, 1);
		DAOFactory.getFriendDAO().getFriends(1);
		DAOFactory.getFriendDAO().getInvitations(1);
		DAOFactory.getFriendDAO().getFriend(1, 2);*/
	}
}
