package sql;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;


public class DAOProxy implements java.lang.reflect.InvocationHandler {

	public static boolean test = false;

	public static final WeakHashMap<String, Object> cache = new WeakHashMap<String, Object>();

	private static final HashMap<String, Long> map = new HashMap<String, Long>();

	public static final ArrayList<String> cachedMethods = new ArrayList<String>();

	public static final ArrayList<DAOCache> daoCacheList = new ArrayList<DAOCache>();

	static {
		//cachedMethods.add(UserDAO.class.getCanonicalName().toString() + ".load");
		//cachedMethods.add(WallDAO.class.getCanonicalName().toString() + ".getUserWall");
		//cachedMethods.add(FileDAO.class.getCanonicalName().toString() + ".queryByToken");
	}

	static {
		//map.put(DirectoryDAO.class.getCanonicalName().toString(), 0l);
	}

	private Object dao;

	public DAOProxy(Object dao) {
		this.dao = dao;
	}

	public Object invoke(Object object, Method method, Object[] args) throws Throwable {
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				Object obj = args[i];
				if (obj instanceof String) {
					args[i] = BaseDAO.escape((String) args[i]);
				}
			}
		}
		String clazz;
		if (dao.getClass().getSuperclass().getInterfaces().length == 0 && dao.getClass().getInterfaces().length == 0) {
			clazz = dao.getClass().getSuperclass().getSuperclass().getInterfaces()[0].getCanonicalName().toString();
		} else if (dao.getClass().getInterfaces().length == 0) {
			clazz = dao.getClass().getSuperclass().getInterfaces()[0].getCanonicalName().toString();
		} else {
			clazz = dao.getClass().getInterfaces()[0].getCanonicalName().toString();
		}
		String actualMethod = clazz + "." + method.getName();
		if (cachedMethods.contains(actualMethod)) {
			return cache(actualMethod, object, method, args);

		}
		Date d1 = new Date();
		Object res = method.invoke(dao, args);
		Date d2 = new Date();
		long time = (d2.getTime() - d1.getTime());

		map.put(clazz, map.get(clazz) + time);
		if (time >= 200) {
			System.out.println(clazz + "." + method.getName() + " : " + time);
		}
		return res;
	}

	public synchronized Object cache(String actualMethod, Object object, Method method, Object[] args) throws Exception {
		String cacheId = actualMethod;
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				cacheId += "." + args[i];
			}
		}
		Object ret = cache.get(cacheId);
		if (ret != null) {
			//System.out.println("biore z cache " + cacheId);
			return ret;
		}
		Object res = method.invoke(dao, args);
		if (res == null) {
			return null;
		}
		if (res instanceof List) {
			cache.put(cacheId, res);
			for (Object o : (List<Object>) res) {
				Long id = Long.parseLong(BeanUtils.getProperty(o, "id"));
				DAOCache daoCache = (DAOCache) PropertyUtils.getProperty(dao, "cache");
				if (daoCache.get(id) == null) {
					daoCache.put(id, new ArrayList());
				}
				daoCache.get(id).add(cacheId);
			}
		} else {
			cache.put(cacheId, res);
			Long id = Long.parseLong(BeanUtils.getProperty(res, "id"));
			DAOCache daoCache = (DAOCache) PropertyUtils.getProperty(dao, "cache");
			if (daoCache.get(id) == null) {
				daoCache.put(id, new ArrayList());
			}
			daoCache.get(id).add(cacheId);
		}

		if (!ClearCacheThread.isStarted && !test) {
			new ClearCacheThread().start();
			ClearCacheThread.isStarted = true;
		}
		return res;
	}

	public static HashMap<String, Long> getMap() {
		return map;
	}

	public static synchronized void clearCache() {
		cache.clear();
	}

}

class ClearCacheThread extends Thread {

	public static boolean isStarted = false;

	public void run() {
		while (true) {
			try {
				sleep(1000 * 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println("usuwam cache, size " + DAOProxy.cache.size());
			DAOProxy.clearCache();
			for (DAOCache cache : DAOProxy.daoCacheList) {
				cache.clearAll();
			}
		}
	}
}
