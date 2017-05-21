package adiitya.elemental.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.LRUMap;

public class DataCache<K, T> {

	@SuppressWarnings("rawtypes")
	private LRUMap cacheMap;
	private long liveTime;
	
	@SuppressWarnings("rawtypes")
	public DataCache(long timeToLive, int maxItems) {
		
		this.liveTime = timeToLive;
		cacheMap = new LRUMap(maxItems);
		
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
	
	@SuppressWarnings("unchecked")
	public void put(K key, T value) {
		
		synchronized (cacheMap) {
			
			System.out.println("Caching " + value + " with key " + key);
			cacheMap.put(key, new CacheObject(value));
		}
	}
	
	@SuppressWarnings("unchecked")
	public T get(K key) {
		
		synchronized (cacheMap) {
			
			CacheObject o = (DataCache<K, T>.CacheObject) cacheMap.get(key);

			if (o != null)
				o.lastAccessed = System.currentTimeMillis();
			
			return o == null ? (T) null : o.value;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void update() {
		
		List<K> keys = null;
		
		synchronized (cacheMap) {
			
			MapIterator i = cacheMap.mapIterator();
			
			keys = new ArrayList<K>((cacheMap.size() / 2) + 1);
			K key = null;
			CacheObject o = null;
			
			while (i.hasNext()) {
				
				key = (K) i.next();
				o = (CacheObject) i.getValue();
				
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
	
	protected class CacheObject {
		
		public long lastAccessed = System.currentTimeMillis();
		public T value;
		
		public CacheObject(T value) {
			
			this.value = value;
		}
	}
}
