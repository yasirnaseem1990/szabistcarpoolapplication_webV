package sql;

import java.util.HashMap;
import java.util.List;

public class DAOCache {
	
	public DAOCache() {
		DAOProxy.daoCacheList.add(this);
	}

	private HashMap<Long, java.util.List<String>> map = new HashMap<Long, java.util.List<String>>();

	public synchronized void put(Long id, List<String> list) {
		map.put(id, list);
	}

	public synchronized void clear(Long id) {
		if(map.get(id)==null){
			return;
		}
		for (String str : map.get(id)) {
			DAOProxy.cache.remove(str);
		}
		map.remove(id);
	}
	
	public synchronized void clearAll() {
		map.clear();
	}

	public synchronized List<String> get(Long id) {
		return map.get(id);
	}

}
