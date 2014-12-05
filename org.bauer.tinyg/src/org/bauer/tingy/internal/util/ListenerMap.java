package org.bauer.tingy.internal.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ListenerMap<T, O> {
	private Map<O, Collection<T>> listeners = new HashMap<O, Collection<T>>();
	
	public synchronized void add(T listener, O[]triggers) {
		for (O trigger : triggers){
			Collection<T> items = listeners.get(trigger);
			if (items == null) {
				items = new HashSet<T>();
				listeners.put(trigger, items);
			}
			items.add(listener);
		}
		
	}
	
	public synchronized void remove(T listener) {
		for (Map.Entry<O, Collection<T>> entry : listeners.entrySet()) {
			entry.getValue().remove(listener);
		}
	}
	
	public Collection<T> getListeners(O trigger) {
		Collection<T> items = listeners.get(trigger);
		if (items == null) {
			items = Collections.emptySet();
		}
		return items;
	}
	
	public synchronized void clear( ){
		listeners.clear();
	}
}
