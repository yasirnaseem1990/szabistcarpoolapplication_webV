package dao;

import sql.DAOProxy;
import dao.impl.BridgeTableDAOImpl;
import dao.impl.DiscussionDAOImpl;
import dao.impl.PassengerBookDAOImpl;
import dao.impl.PostRideDAOImpl;
import dao.impl.RideStatuDAOImpl;
import dao.impl.RoleDAOImpl;
import dao.impl.UrlDAOImpl;
import dao.impl.UserDAOImpl;



public class DAOFactory{
	public static BridgeTableDAO getBridgeTableDAO(){
		BridgeTableDAOImpl dao =  new BridgeTableDAOImpl();
		Class[] interfacesArray = new Class[] { BridgeTableDAO.class };
		return (BridgeTableDAO) java.lang.reflect.Proxy.newProxyInstance(dao.getClass().getClassLoader(), interfacesArray, new DAOProxy(dao));
	}
	public static DiscussionDAO getDiscussionDAO(){
		DiscussionDAOImpl dao =  new DiscussionDAOImpl();
		Class[] interfacesArray = new Class[] { DiscussionDAO.class };
		return (DiscussionDAO) java.lang.reflect.Proxy.newProxyInstance(dao.getClass().getClassLoader(), interfacesArray, new DAOProxy(dao));
	}
	public static PassengerBookDAO getPassengerBookDAO(){
		PassengerBookDAOImpl dao =  new PassengerBookDAOImpl();
		Class[] interfacesArray = new Class[] { PassengerBookDAO.class };
		return (PassengerBookDAO) java.lang.reflect.Proxy.newProxyInstance(dao.getClass().getClassLoader(), interfacesArray, new DAOProxy(dao));
	}
	public static PostRideDAO getPostRideDAO(){
		PostRideDAOImpl dao =  new PostRideDAOImpl();
		Class[] interfacesArray = new Class[] { PostRideDAO.class };
		return (PostRideDAO) java.lang.reflect.Proxy.newProxyInstance(dao.getClass().getClassLoader(), interfacesArray, new DAOProxy(dao));
	}
	public static RideStatuDAO getRideStatuDAO(){
		RideStatuDAOImpl dao =  new RideStatuDAOImpl();
		Class[] interfacesArray = new Class[] { RideStatuDAO.class };
		return (RideStatuDAO) java.lang.reflect.Proxy.newProxyInstance(dao.getClass().getClassLoader(), interfacesArray, new DAOProxy(dao));
	}
	public static RoleDAO getRoleDAO(){
		RoleDAOImpl dao =  new RoleDAOImpl();
		Class[] interfacesArray = new Class[] { RoleDAO.class };
		return (RoleDAO) java.lang.reflect.Proxy.newProxyInstance(dao.getClass().getClassLoader(), interfacesArray, new DAOProxy(dao));
	}
	public static UrlDAO getUrlDAO(){
		UrlDAOImpl dao =  new UrlDAOImpl();
		Class[] interfacesArray = new Class[] { UrlDAO.class };
		return (UrlDAO) java.lang.reflect.Proxy.newProxyInstance(dao.getClass().getClassLoader(), interfacesArray, new DAOProxy(dao));
	}
	public static UserDAO getUserDAO(){
		UserDAOImpl dao =  new UserDAOImpl();
		Class[] interfacesArray = new Class[] { UserDAO.class };
		return (UserDAO) java.lang.reflect.Proxy.newProxyInstance(dao.getClass().getClassLoader(), interfacesArray, new DAOProxy(dao));
	}
}