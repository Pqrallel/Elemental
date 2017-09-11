package adiitya.elemental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DataCache<K, T> {

	private HashMap<String, CachableItem> cacheMap;
	private long liveTime;
	
	public DataCache(long timeToLive, int maxItems) {
		
		this.liveTime = timeToLive;
		cacheMap = new HashMap<String, CachableItem>(maxItems);
		
		if (timeToLive > 0) {
			
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					
					while (true) {
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
						
						update();
					}
				}
			});
			
			thread.setDaemon(true);
			thread.start();
		}
	}
	
	public boolean containsKey(K key) {
		
		synchronized (cacheMap) {
			
			return cacheMap.containsKey(key);
		}
	}
	
	public void put(String key, String value) {
		
		synchronized (cacheMap) {
			
			System.out.println("Caching " + value + " with key " + key);
			cacheMap.put(key, new CachableItem(value));
		}
	}
	
	public String get(String key) {
		
		synchronized (cacheMap) {
			
			CachableItem o = (DataCache<K, T>.CachableItem) cacheMap.get(key);

			if (o != null)
				o.lastAccessed = System.currentTimeMillis();
			
			return o == null ? (String) null : o.value;
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	public void update() {
		
		List<K> keys = null;
		
		synchronized (cacheMap) {
			
			Iterator<String> i = cacheMap.keySet().iterator();
			
			keys = new ArrayList<K>((cacheMap.size() / 2) + 1);
			K key = null;
			CachableItem o = null;
			
			while (i.hasNext()) {
				
				key = (K) i.next();
				o = new CachableItem(i.next());
				
				if (o != null && System.currentTimeMillis() > (liveTime + o.lastAccessed))
					keys.add(key);
			}
		}
		
		for (K key : keys) {
			
			synchronized (cacheMap) {
				
				cacheMap.remove(key);
			}
			
			Thread.yield();
		}
	}
	
	protected class CachableItem {
		
		public long lastAccessed = System.currentTimeMillis();
		public String value;
		
		public CachableItem(String value) {
			
			this.value = value;
		}
	}
}
